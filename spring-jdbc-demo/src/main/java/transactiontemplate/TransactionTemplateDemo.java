package transactiontemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

/**
 * Created by Mirana on 16/1/10.
 */
public class TransactionTemplateDemo {
    private static String sql1 = "insert into user (user_name,user_pwd) values('hzj','123qwe')";
    public static void main(String[] args) {
        //初始化spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring-jdbc.xml");
        //获取DataSource
        DataSource dataSource = (DataSource) context.getBean("dataSource");
        //TransactionManager
        DataSourceTransactionManager dstm = new DataSourceTransactionManager(dataSource);
        final JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //tm注入模板
        final TransactionTemplate tt = new TransactionTemplate(dstm);
        tt.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        tt.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        tt.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try{
                    jdbcTemplate.execute(sql1);
                    throw new Exception("test");
                }catch (Exception e){
                    transactionStatus.setRollbackOnly();
                }
            }
        });
        System.out.println("finish ...");
    }
}
