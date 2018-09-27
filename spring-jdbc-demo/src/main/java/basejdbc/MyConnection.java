package basejdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Mirana on 16/1/4.
 */
public class MyConnection{

    private String user;
    private String password;
    private String dbms;
    private String serverName = "localhost";
    private String portNumber = "3306";
    private String dbName ;

    public MyConnection(String user,String password,String dbms,String dbName){
        this.user = user;
        this.password = password;
        this.dbms = dbms;
        this.dbName = dbName;
    }
    public Connection getConnection() throws SQLException {
        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user",this.user);
        connectionProps.put("password",this.password);
        if(this.dbms.equals("mysql")){
            conn = DriverManager.getConnection("jdbc:"+this.dbms+"://"+this.serverName+":"+this.portNumber+"/",connectionProps);
        }else if (this.dbms.equals("derby")){
            conn = DriverManager.getConnection("jdbc:"+this.dbms+":"+this.dbName+";create=true",connectionProps);
        }
        System.out.println("Connected to database");
        return  conn;
    }

    public void releaseConnection(Connection conn) throws SQLException {
        if(conn!=null){
            conn.close();
        }

    }
}
