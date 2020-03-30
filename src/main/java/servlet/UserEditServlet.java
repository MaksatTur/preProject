package servlet;

import service.Service;
import service.UserService;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/admin/edit")
public class UserEditServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = Service.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        User user = userService.getUserById(id);
        if (user != null) {
            req.setAttribute("user", user);
            getServletContext().getRequestDispatcher("/editUserForm.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String idStr = req.getParameter("id");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String dateOfBirthStr = req.getParameter("dateOfBirth");
        String passport = req.getParameter("passport");
        String role = req.getParameter("role");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirthStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        User user = new User(Long.parseLong(idStr), name, surname, date, passport, role, login, password);
        userService.editUser(user);
        resp.sendRedirect("/admin");
    }
}
