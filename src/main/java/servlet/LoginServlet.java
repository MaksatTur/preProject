package servlet;

import service.UserServiceImpl;
import service.UserService;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = UserServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("user") != null) {
            User user = ((User) session.getAttribute("user"));
            if (user.getRole().equals("admin")) {
                resp.sendRedirect("/admin");
            } else {
                resp.sendRedirect("/user");
            }
        } else {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = userService.login(login, password);
        if (user != null) {
            req.getSession().setAttribute("user", user);
            if (user.getRole().equals("admin")) {
                resp.sendRedirect(req.getContextPath() + "/admin");
            } else if (user.getRole().equals("user")) {
                resp.sendRedirect(req.getContextPath() + "/user");
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }
}
