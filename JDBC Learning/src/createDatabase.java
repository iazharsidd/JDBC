import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class createDatabase 
{
    private static final String db_URL = "jdbc:mysql://localhost:3306/";
    private static final String username = "root";
    private static final String password = "Azhar@2000";
    private static Connection conn;
    private static Statement st;//use to fire query

    public static void main(String[] args) {
        try {
            conn = DriverManager.getConnection(db_URL, username, password);
            if (conn != null) System.out.println("Connection Successful....");
            else System.out.println("Connection Failed :/");
            st = conn.createStatement();
            String query = "CREATE DATABASE IF NOT EXISTS JDBC";
            st.executeUpdate(query);
            System.out.println("Database Created");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Database Creation failed...:/");
        }
    }
}
