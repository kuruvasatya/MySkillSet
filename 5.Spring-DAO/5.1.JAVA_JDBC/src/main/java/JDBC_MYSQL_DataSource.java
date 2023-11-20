import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_MYSQL_DataSource {
    private static final String url = "jdbc:mysql://localhost:3307/myskillset_jdbc";
    private static final String user = "root";
    private static final String password = "root";

    public static void main(String[] args) throws SQLException {
        final String sql = "select * from customer";

        // Basic Data Source (Generic not coupled with any specific DB)
        BasicDataSource bds = new BasicDataSource();
        bds.setUrl(url);
        bds.setUsername(user);
        bds.setPassword(password);
        bds.setMaxTotal(1);
        bds.setMaxIdle(1);

        // MySQL implementation of DataSource
        MysqlDataSource ds = new MysqlDataSource();
        ds.setURL(url);
        ds.setUser(user);
        ds.setPassword(password);


        Connection con = bds.getConnection();

        System.out.println(con.hashCode());

        Statement stmnt = con.createStatement();
        ResultSet rs = stmnt.executeQuery(sql);
        rs.next();
        System.out.println(rs.getInt(1) + " " + rs.getString(2));
        stmnt.close();
        con.close();
    }
}
