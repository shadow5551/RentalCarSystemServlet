package by.training.nc.dev3.cotroller;


import by.training.nc.dev3.validation.ValidationLoginService;

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
        RequestDispatcher dispatcher=getServletContext().getRequestDispatcher( "/WEB-INF/login/login.jsp" );
        dispatcher.forward( request, response );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session;
        session = request.getSession();
        session.setAttribute("currentUserId", ValidationLoginService.getId());
        response.sendRedirect("/Profile");
    }
}
