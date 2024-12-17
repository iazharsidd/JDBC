import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class updateData {
    private static final String db_URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String username = "root";
    private static final String password = "Azhar@2000";
    private static Connection conn;
    private static Statement st;
    public static void main(String[] args) {
        try {
            conn = DriverManager.getConnection(db_URL, username, password);
            if (conn != null) System.out.println("Database Connected.....:)");
            else System.out.println("Database connection faile.....:/");
            st = conn.createStatement();
            String query ="update cars set color = 'White' where color = 'Black';" ;
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Database Updation failed...:/");
        }
    }    
}
