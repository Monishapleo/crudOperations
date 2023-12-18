import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseUtils {
    private static final String DRIVER_PATH="com.mysql.cj.jdbc.Driver";

    private static final String JDBC_URL ="jdbc:mysql://localhost:3306/cruduserdb?user=root&password=Pigpork@2123";

    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "Pigpork@2123";

    public DataBaseUtils() {
        try{
            Class.forName(DRIVER_PATH);

        }catch(Exception e){
            throw new RuntimeException("Something went wrong",e);

        }
    }
    public Connection getConnection() throws SQLException {
        //Connecting to DB
        return DriverManager.getConnection(JDBC_URL);
    }
}
