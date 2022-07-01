package by.tms.calculator.service;

import by.tms.calculator.dao.OperationDao;

public class CalcService {
    OperationDao operationDao = new OperationDao();

    public double calc(String num1, String operations, String num2, String username) {
        double v = Double.parseDouble(num1);
        double b = Double.parseDouble(num2);
        double result = Double.parseDouble(null);
        switch (operations) {
            case "add":
                result = v + b;
                break;
            case "sub":
                result = v - b;
                break;
            case "mul":
                result = v * b;
                break;
            case "div":
                result = v / b;
                break;
            default:
        }
        return result;
    }
}


