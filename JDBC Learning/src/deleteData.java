import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class deleteData {
    private static final String db_URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String username = "root";
    private static final String password = "Azhar@2000";
    private static Connection conn;
    private static Statement st;    
    public static void main(String[] args) {
        try {
            conn = DriverManager.getConnection(db_URL, username, password);
            if (conn != null) System.out.println("Database Connected :)");
            else System.out.println("Connection Failed :/");
            st = conn.createStatement();
            String query = " delete From cars where model = null";
            int i = st.executeUpdate(query);
            if (i > 0) System.out.println("Data Deleted  :)");
        } catch (Exception e) {
            System.out.println("Something went Wrong :/");
            e.printStackTrace();
        }
    }
}
