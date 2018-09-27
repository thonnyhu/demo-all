package datasourceproxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import java.sql.*;

/**
 * Created by Mirana on 16/1/6.
 * TransactionAwareDataSourceProxy 只是将原有数据源封装成为具有spring事务级别的数据源,用于解决遗留系统问题
 */
public class DataSourceProxy {
    private static String sql1 = "insert into user (user_name,user_pwd) values('hzj','123qwe')";
    private static String sql2 = "insert into user (user_name,user_pwd) values('hzj2','123qwe')";
    public static void main(String[] args) throws SQLException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-jdbc.xml");
        TransactionAwareDataSourceProxy proxy = (TransactionAwareDataSourceProxy) applicationContext.getBean("dataSourceProxy");
            Connection conn = proxy.getConnection();
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql1);
//            CallableStatement callableStatement = conn.prepareCall(sql2);
//            PreparedStatement preparedStatement = conn.prepareStatement(sql2);
            throw new SQLException("test");
//            preparedStatement.execute();
//            conn.prepareStatement(sql2).execute();

    }
}
