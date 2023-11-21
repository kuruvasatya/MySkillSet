
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HikariCP_Test {
    private static final String url = "jdbc:mysql://localhost:3307/myskillset_jdbc";
    private static final String user = "root";
    private static final String password = "root";

    public static void main(String args[]) throws SQLException {
        final String sql = "select * from customer";

        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(url);
        ds.setUsername(user);
        ds.setPassword(password);

        Connection con = ds.getConnection();

        Statement stmnt = con.createStatement();
        ResultSet rs = stmnt.executeQuery(sql);
        rs.next();
        System.out.println(rs.getInt(1) + " " + rs.getString(2));
        stmnt.close();
        con.close();
    }
}
