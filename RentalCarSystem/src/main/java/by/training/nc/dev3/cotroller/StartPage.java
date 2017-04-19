package by.training.nc.dev3.cotroller;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dima on 19.4.17.
 */
@WebServlet(name = "Main", urlPatterns =
        {
                "/Main"
        })
public class StartPage extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException
    {
        RequestDispatcher dispatcher=getServletContext().getRequestDispatcher( "/WEB-INF/helloPage/startPage.jsp" );
        dispatcher.forward( request, response );
    }
}
