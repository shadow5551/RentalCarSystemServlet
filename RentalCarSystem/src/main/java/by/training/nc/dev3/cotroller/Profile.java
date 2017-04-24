package by.training.nc.dev3.cotroller;



import by.training.nc.dev3.dao.OrderDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dima on 18.4.17.
 */
@WebServlet(name = "Profile", urlPatterns =
        {
                "/Profile"
        })
public class Profile extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException
    {
        OrderDaoImpl orderDao = new OrderDaoImpl();
        RequestDispatcher dispatcher=getServletContext().getRequestDispatcher( "/WEB-INF/profile/profile.jsp" );
        request.setAttribute("orders", orderDao.getAllBYCondition("WHERE User_idUser = " + request.getSession().getAttribute("currentUserId")));
        System.out.println(orderDao.getAllBYCondition("WHERE User_idUser = " + request.getSession().getAttribute("currentUserId")));
        System.out.println(request);
        dispatcher.forward( request, response );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        /*String login = request.getParameter("login");
        String password = request.getParameter("password");
        System.out.println(login+password);
        HttpSession session;
        session = request.getSession();
        session.setAttribute("login", request.getParameter("login"));
        RequestDispatcher dispatcher=getServletContext().getRequestDispatcher( "/WEB-INF/profile/profile.jsp" );
       dispatcher.forward( request, response );*/
    }
}
