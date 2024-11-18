import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    private static final String db_URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String username = "root";
    private static final String password = "Azhar@2000";
    private static Connection conn;
    private static Statement st;//use to fire query

    public static void main(String[] args) {
        try {
            conn = DriverManager.getConnection(db_URL, username, password);
            if (conn != null)
                System.out.println("Connection Successful....");
            else
                System.out.println("Connection Failed :/");
            st = conn.createStatement();
            try {
                String query = "create table if not exists cars(model INT AUTO_INCREMENT PRIMARY KEY,name varchar(200),color varchar(10))";
                st.executeUpdate(query);
                System.out.println("Table Created...");
            } catch (SQLException e) {
                if (e.getSQLState().equals("42S01")) {
                    System.out.println("Table Already Exist..");
                }
                else{
                    System.out.println("Error occoured"+e.getMessage());
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {     
            System.out.println("Error in Table creation");
            e.printStackTrace();
        }
    }
}
