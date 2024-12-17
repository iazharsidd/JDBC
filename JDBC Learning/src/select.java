import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class select {
     private static final String db_URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String username = "root";
    private static final String password = "Azhar@2000";
    private static Connection conn;
    private static Statement st;
    public static void main(String[] args) 
    {
       try {
        conn = DriverManager.getConnection(db_URL, username, password);
        st = conn.createStatement();
        String query = "Select * from cars";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            System.out.println("Model : "+rs.getInt("model"));
            System.out.println("name : "+rs.getString("name"));
            System.out.println("color: "+rs.getString("color"));
        }
       } catch (Exception e) {
        e.printStackTrace();
       }

        
    }
}
