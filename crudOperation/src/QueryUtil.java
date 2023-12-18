//This class contains all queries for CRUD operation
public class QueryUtil {
    public static String insertUserQuery(){
        return " INSERT INTO USER_INFO (ID,USERNAME,EMAIL) VALUES(?,?,?) ";
    }
    public static String getAllUsers(){
        return "SELECT * FROM USER_INFO";
    }
   public static String selectUserByID(int id){
        return "SELECT * FROM USER_INFO WHERE ID=?";
    }

    public static String deleteById(int id){
        return "DELETE FROM USER_INFO WHERE ID = "+id;
    }

    public static String updateQuery(int id){
        return "UPDATE USER_INFO SET ID=?, USERNAME=?, EMAIL=? WHERE ID = "+id;
    }

}
