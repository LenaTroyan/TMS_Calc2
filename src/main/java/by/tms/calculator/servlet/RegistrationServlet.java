package by.tms.calculator.servlet;

import by.tms.calculator.dao.UserDao;
import by.tms.calculator.entity.User;
import by.tms.calculator.service.RegistrationService;

import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private final RegistrationService registrationService = new RegistrationService();
    private final UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/reg.jsp").forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Optional<User> userByUsername = UserDao.findUser(username);
        if (userByUsername.isEmpty()) {
            registrationService.createUser(new User(name, username, password));
            resp.sendRedirect("/");
            return;
        } else {
            req.setAttribute("message", "User already exist");
        }
        getServletContext().getRequestDispatcher("/reg.jsp").forward(req, resp);
    }
}
