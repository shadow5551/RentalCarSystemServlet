package by.training.nc.dev3.filter;



import by.training.nc.dev3.validation.ValidationLoginService;

import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;


@WebFilter("/Login")
public class    LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("LOGIN");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        if (httpRequest.getMethod().equals("POST")) {
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            if (ValidationLoginService.validate(login, password)) {
                chain.doFilter(request, response);
            } else {
                request.setAttribute("error", "Invalid Credentials");
                request.getRequestDispatcher("/WEB-INF/login/login.jsp").forward(request, response);
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
