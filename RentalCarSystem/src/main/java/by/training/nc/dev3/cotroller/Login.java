package by.training.nc.dev3.cotroller;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "Login", urlPatterns =
        {
                "/Login"
        })
public class Login extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException
    {
        System.out.println("LOGIN");
        RequestDispatcher dispatcher=getServletContext().getRequestDispatcher( "/WEB-INF/login/login.jsp" );
        System.out.println(request);
        dispatcher.forward( request, response );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        System.out.println(login+password);
        HttpSession session;
        session = request.getSession();
        response.sendRedirect("/Profile");
    }
}
