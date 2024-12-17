import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class pSdelete {
     private static final String db_URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String username = "root";
    private static final String password = "Azhar@2000";
    private static Connection conn;
    private static PreparedStatement st;
    public static void main(String[] args) {
         try {
            conn = DriverManager.getConnection(db_URL, username, password);
            if (conn != null) System.out.println("Database Connected :)");
            else System.out.println("Connection Failed :/");
            String query = " delete From cars where model = ?";
            st = conn.prepareStatement(query);
            st.setInt(1, 200);
            int i = st.executeUpdate();
            if (i > 0) System.out.println("Data Deleted  :)");
        } catch (Exception e) {
            System.out.println("Something went Wrong :/");
            e.printStackTrace();
        }
    }
}
