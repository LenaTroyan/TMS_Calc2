package by.tms.calculator.dao;

import by.tms.calculator.entity.User;

import java.sql.*;
import java.util.Optional;

public class UserDao {
    private static final String DATABASE = "jdbc:mysql://localhost:3306/calculator_database";
    private static final String USER = "root";
    private static final String PASSWORD = "05121977Mt!";


    public void CreateUser(User user) throws SQLException {
        String name = user.getName();
        String username = user.getUsername();
        String password = user.getPassword();
        final String sql = "INSERT INTO users (username,login,password) VALUES (?,?,?)";

        try (Connection connection = DriverManager.getConnection(DATABASE, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, username);
            statement.setString(3, password);
            try {
                statement.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static Optional<User> findUser(String log) {
        final String sql = " SELECT * FROM USERS WHERE login=?";
        try (
            Connection connection = DriverManager.getConnection(DATABASE, USER, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, log);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    User user = new User(resultSet.getString("username"), log, resultSet.getString("password"));
                    return Optional.of(user);
                }
            }  catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Optional.empty();
    }
    public static int getID(User user) {
        String username = user.getUsername();
        int id = 0;
        final String sql = " SELECT ID FROM USERS WHERE login=?";
        try (
            Connection connection = DriverManager.getConnection(DATABASE, USER, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, username);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    id = resultSet.getInt("ID");
                    return id;
                }
            } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }
}


