package basejdbc;

import java.sql.SQLException;

/**
 * Created by Mirana on 16/1/4.
 */
public class JdbcDemo {
    public static void main(String[] args) {
        MyConnection conn = new MyConnection("root","123qwe","mysql",null);
        try {
            conn.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
