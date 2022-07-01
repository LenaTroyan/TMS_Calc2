package by.tms.calculator.service;

import by.tms.calculator.dao.UserDao;
import by.tms.calculator.entity.User;

import java.sql.SQLException;

public class RegistrationService {
    private final UserDao userDao = new UserDao();
    public void createUser(User user) throws SQLException {
        if(userDao.findUser(user.getUsername()).isEmpty()){
            userDao.CreateUser(user);
        }
    }
}
