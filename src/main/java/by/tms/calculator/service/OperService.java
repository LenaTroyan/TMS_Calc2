package by.tms.calculator.service;

import by.tms.calculator.dao.OperationDao;
import by.tms.calculator.entity.Operation;
import by.tms.calculator.entity.User;

public class OperService {
    private final OperationDao operationDao = new OperationDao();
    public void createOperation (User user, Operation operation){
        operationDao.writeOperation(user,operation);
    }
}
