import java.sql.*;

public class JDBCDemo {
    public static void main(String args[]) {
        Connection con = null;
        try {
            // 2. load and register driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 3. create connection
            String url = "jdbc:mysql://localhost:3307/myskillset_jdbc";
            String user = "root";
            String password = "root";
            con = DriverManager.getConnection(url, user, password);

            // static query creation and execution
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("select * from customer");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            }

            statement.close();

            // dynamic query
            String sql = "select * from customer where id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, 1);
            ResultSet rs2 = preparedStatement.executeQuery();

            while(rs2.next()) {
                System.out.println(rs2.getInt(1) + " " + rs2.getString(2));
            }
        } catch (Exception e) {
            System.out.println("Error occured : " + e);
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("error while closing the connection...");
            }
        }
    }
}
