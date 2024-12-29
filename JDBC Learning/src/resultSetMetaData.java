import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class resultSetMetaData {
    private static final String db_URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String username = "root";
    private static final String password = "Azhar@2000";
    private static Connection conn;
    private static Statement st;
    private static ResultSetMetaData resultSetMetaData;
    public static void main(String[] args) {
        try {
            conn = DriverManager.getConnection(db_URL, username, password);
            st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String query = "Select * from Cars";
            ResultSet res = st.executeQuery(query);
            resultSetMetaData = res.getMetaData();
            System.out.println(resultSetMetaData.getColumnCount()); // gives number of coloumn 
            System.out.println(resultSetMetaData.getColumnTypeName(1));
            System.out.println(resultSetMetaData.getColumnTypeName(2));
            System.out.println(resultSetMetaData.getColumnTypeName(3));
            System.out.println(resultSetMetaData.getTableName(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
