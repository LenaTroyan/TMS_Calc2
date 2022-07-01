package by.tms.calculator.dao;

import by.tms.calculator.entity.Operation;
import by.tms.calculator.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OperationDao {
    private final UserDao userdao = new UserDao();
    private static final String DATABASE = "jdbc:mysql://localhost:3306/calculator_database?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "05121977Mt!";

    public void writeOperation(User user, Operation operation) {
        final String sql = "INSERT INTO operations (num1, operation, num2, result, userID) VALUES (?,?,?,?,?)";
        String userId = String.valueOf(userdao.getID(user));
        String num1 = operation.getNum1();
        String num2 = operation.getNum2();
        String action = operation.getOperation();
        String result = operation.getResult();
        try (Connection connection = DriverManager.getConnection(DATABASE, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, num1);
            statement.setString(2, num2);
            statement.setString(3, action);
            statement.setString(4, result);
            statement.setString(5, userId);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Operation> getHistory(User user) {
        List<Operation> operations = new ArrayList<>();
        int userId = userdao.getID(user);
        final String sql = "SELECT num1, operation, num2, result FROM OPERATION WHERE userID = ?";
        try (Connection connection = DriverManager.getConnection(DATABASE, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            statement.setInt(1, userId);
            while (resultSet.next()) {
                operations.add(new Operation(
                        resultSet.getString("num1"),
                        resultSet.getString("num2"),
                        resultSet.getString("operation"),
                        resultSet.getString("result")));
            }
            return operations;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}


