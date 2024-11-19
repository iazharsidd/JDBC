import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class insertData
{
    private static final String db_URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String username = "root";
    private static final String password = "Azhar@2000";
    private static Connection conn;
    private static Statement st;
    public static void main(String[] args) {
        try {
            conn = DriverManager.getConnection(db_URL, username, password);
            if (conn != null) System.out.println("DATABASE Connected....");
            else System.out.println("COnnection failed....:/");
            st = conn.createStatement();
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the model number: ");
            int model = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter the name: ");
            String name = sc.nextLine();
            System.out.print("Enter the Color: ");
            String color = sc.nextLine();
            String query = "insert into cars (model, name, color) values('"+model+"','"+name+"','"+color+"')";
            int r = st.executeUpdate(query);
            if (r > 0) System.out.println("Data inserted...");
        } catch (Exception e) {
            System.out.println("Data insertion failed...:/");
            e.printStackTrace();
        }
    }
}
