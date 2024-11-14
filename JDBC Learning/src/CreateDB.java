import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDB 
{
    private static final String db_url = "jdbc:mysql://localhost:3306/newdatabase";
    private static final String username = "root";
    private static final String password = "Azhar@2000";
    private static Connection conn;
    public static void main(String[] args) {
        try {
            conn = DriverManager.getConnection(db_url, username, password);
            if (conn != null) System.out.println("Connection Successfull....");
            else System.out.println("Connection Failed :/");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}