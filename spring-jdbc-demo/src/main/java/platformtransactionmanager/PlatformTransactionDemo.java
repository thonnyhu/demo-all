package platformtransactionmanager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.management.RuntimeErrorException;
import javax.sql.DataSource;

/**
 * Created by Mirana on 16/1/10.
 */
public class PlatformTransactionDemo {
    private static String sql1 = "insert into user (user_name,user_pwd) values('hzj','123qwe')";
    public static void main(String[] args) {
        //初始化spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring-jdbc.xml");
        //获取DataSource
        DataSource dataSource = (DataSource) context.getBean("dataSource");
        //先实例化dataSourceTransactionManager
        DataSourceTransactionManager dstm = new DataSourceTransactionManager();
        dstm.setDataSource(dataSource);
        //初始化jdbcTemplate ,作为sql的执行工具
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //定义spring事务定义对象
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        //获取spring 事务对象
        TransactionStatus transaction = dstm.getTransaction(def);
        try{
            jdbcTemplate.execute(sql1);
            throw new RuntimeException("test");
        }catch (RuntimeException e){
            dstm.rollback(transaction);
        }finally {
            System.out.println("finish ...");
        }

    }
}
