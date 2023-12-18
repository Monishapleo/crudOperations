import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DbService {
    DataBaseUtils dataBaseUtils = new DataBaseUtils();
//INSERTION OF RECORD
    public void insertUser(UserDetails userDetails) throws SQLException {
        try (Connection connection = dataBaseUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(QueryUtil.insertUserQuery());
            preparedStatement.setString(1, String.valueOf(userDetails.getUid()));
            preparedStatement.setString(2, userDetails.getName());
            preparedStatement.setString(3, userDetails.getMailId());
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("Successfully Inserted");
            } else {
                System.out.println("Insertion failed");
            }

        }
    }
//QUERYING ALL THE USERS AND PRINTING THE RESULTS IN HASHMAP
    public void getAllUser() throws SQLException {
        try (Connection connection = dataBaseUtils.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(QueryUtil.getAllUsers())) {
            Map<String, Object> userMap = new HashMap<>();
            while (resultSet.next()){
                userMap.put("id", resultSet.getInt("id"));
                userMap.put("username", resultSet.getString("username"));
                userMap.put("email", resultSet.getString("email"));
                System.out.println(userMap);

            }

        }
    }
//QUERYING USERS BY ID AND RETURNING AS HASH MAP
    public Map<String, Object> getUserById(int id) throws SQLException {
        Map<String, Object> userMap = new HashMap<>();

        try (Connection connection = dataBaseUtils.getConnection();
             Statement statement = connection.createStatement();
             PreparedStatement preparedStatement = connection.prepareStatement(QueryUtil.selectUserByID(id))) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                userMap.put("id", resultSet.getInt("id"));
                userMap.put("username", resultSet.getString("username"));
                userMap.put("email", resultSet.getString("email"));
                System.out.println(userMap);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userMap;
    }
//DELETING THE USER BASED ON ID
    public void deleteUserById(int id) throws SQLException {
        try (Connection connection = dataBaseUtils.getConnection();
             Statement statement = connection.createStatement();){
            int rows=statement.executeUpdate(QueryUtil.deleteById(id));
            if(rows>0){
                System.out.println("Record deleted successfully");
            }
            else {
                System.out.println("Something went wrong");
            }

        }


    }
//UPDATING THE USER BASED ON ID
    public void updateUser(UserDetails userDetails) throws SQLException {
        try(Connection connection = dataBaseUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(QueryUtil.updateQuery(userDetails.getUid()));){
            preparedStatement.setString(1, String.valueOf(userDetails.getUid()));
            preparedStatement.setString(2, userDetails.getName());
            preparedStatement.setString(3, userDetails.getMailId());
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("Successfully Updated");
            } else {
                System.out.println("Modification failed");
            }

        }

    }

}

