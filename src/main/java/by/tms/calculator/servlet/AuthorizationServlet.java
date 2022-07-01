package by.tms.calculator.servlet;

import by.tms.calculator.dao.UserDao;
import by.tms.calculator.entity.User;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/authorization")
public class AuthorizationServlet extends HttpServlet {
    private final UserDao userDao = new UserDao();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/auth.jsp").forward(req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Optional<User> byUsername =userDao.findUser(username);
        if (byUsername.isPresent()){
            if(byUsername.isPresent()){
                User user = byUsername.get();
                if(user.getPassword().equals(password)){
                    req.getSession().setAttribute("user",user);
                    resp.sendRedirect("/");
                    return;
                } else {
                    req.setAttribute("message", "Wrong password!");
                }
            }
        } else {
            req.setAttribute("message", "User not found");
        }
        getServletContext().getRequestDispatcher("/auth.jsp").forward(req,resp);
    }
}
