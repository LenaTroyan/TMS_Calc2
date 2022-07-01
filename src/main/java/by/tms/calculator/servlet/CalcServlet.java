package by.tms.calculator.servlet;

import by.tms.calculator.entity.Operation;
import by.tms.calculator.entity.User;
import by.tms.calculator.service.CalcService;
import by.tms.calculator.service.OperService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOError;
import java.io.IOException;

@WebServlet(urlPatterns = "/calc", name = "CalcServlet")
public class CalcServlet extends HttpServlet {
    CalcService calcService = new CalcService();
    OperService operService = new OperService();
    Operation operation;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/calc.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        String operations = req.getParameter("operation");
        String username = (String) req.getSession().getAttribute("username");
        String message = num1 + operation + num2 + "=";
        String result = String.valueOf(calcService.calc(num1,operations,num2,username));
        operService.createOperation((User)req.getSession().getAttribute("user"),operation);
        req.setAttribute("message", message);
        req.setAttribute("result", result);
        getServletContext().getRequestDispatcher("/calc.jsp").forward(req, resp);
    }
}