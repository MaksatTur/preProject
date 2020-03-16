package servlet;

import service.UserServiceI;
import model.User;
import service.UserServiceHibernate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/add")
public class UserAddServlet extends HttpServlet {
    private UserServiceI userService;

    @Override
    public void init() throws ServletException {
        super.init();
//        userService = new UserServiceJdbc();
        userService = UserServiceHibernate.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/addUserForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String dateOfBirthStr = req.getParameter("dateOfBirth");
        String passport = req.getParameter("passport");
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirthStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (validateUserData(name, surname, date, passport)) {
            User user = new User(name, surname,
                    date,
                    passport);
            userService.addUser(user);
        }
        resp.sendRedirect("/list");
    }

    private boolean validateUserData(String name, String surname, Date birthDate, String passport) {
        if (name.isEmpty() || name == null || surname.isEmpty() || surname == null || birthDate == null || passport.isEmpty() || passport == null) {
            return false;
        }
        return true;
    }
}
