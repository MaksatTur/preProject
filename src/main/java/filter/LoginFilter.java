package filter;

import model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession(false);

        String loginURL = request.getContextPath() + "/login";

        String adminURL = request.getContextPath() + "/admin";
        String adminAddURL = request.getContextPath() + "/admin/add";
        String adminDelURL = request.getContextPath() + "/admin/delete";
        String adminEditURL = request.getContextPath() + "/admin/edit";

        String userURL = request.getContextPath() + "/user";

        boolean loggedIn = session != null && session.getAttribute("user") != null;

        boolean loginRequest = request.getRequestURI().equals(loginURL);

        boolean adminRequest = request.getRequestURI().equals(adminURL);
        boolean adminAddRequest = request.getRequestURI().equals(adminAddURL);
        boolean adminDelRequest = request.getRequestURI().equals(adminDelURL);
        boolean adminEditRequest = request.getRequestURI().equals(adminEditURL);

        boolean userRequest = request.getRequestURI().equals(userURL);


        if (loggedIn) {
            String role = ((User) session.getAttribute("user")).getRole();

            if (role.equals("admin")) {
                if (adminRequest || adminAddRequest || adminDelRequest || adminEditRequest || userRequest) {
                    chain.doFilter(request, response);
                    return;
                } else {
                    response.sendRedirect("/admin");
                }
            } else if (role.equals("user")) {
                if (userRequest) {
                    chain.doFilter(request, response);
                    return;
                } else {
                    response.sendRedirect("/user");
                }
            } else {
                response.sendRedirect(loginURL);
            }
        } else if (loginRequest) {
            chain.doFilter(request, response);
        } else {
            response.sendRedirect(loginURL);
        }
    }

    @Override
    public void destroy() {

    }
}
