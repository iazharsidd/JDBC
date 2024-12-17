import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class preparedStatement {
    private static final String db_URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String username = "root";
    private static final String password = "Azhar@2000";
    private static Connection conn;
    private static PreparedStatement st;

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        try {
            conn = DriverManager.getConnection(db_URL, username, password);
            if (conn != null)
                System.out.println("DATABASE Connected....");
            else
                System.out.println("COnnection failed....:/");
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the model number: ");
            int model = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter the name: ");
            String name = sc.nextLine();
            System.out.print("Enter the Color: ");
            String color = sc.nextLine();
            String query = "insert into cars (model, name, color) values(?,?,?)";
            st = conn.prepareStatement(query);
            st.setInt(1,model);
            st.setString(2, name);
            st.setString(3, color);

            int r = st.executeUpdate();

            if (r > 0)
                System.out.println("Data inserted...");
        } catch (Exception e) {
            System.out.println("Data insertion failed...:/");
            e.printStackTrace();
        }
    }
}
