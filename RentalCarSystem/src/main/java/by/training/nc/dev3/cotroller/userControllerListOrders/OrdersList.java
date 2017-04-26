package by.training.nc.dev3.cotroller.userControllerListOrders;

import by.training.nc.dev3.dao.OrderDaoImpl;
import by.training.nc.dev3.dao.StatusDaoImpl;
import by.training.nc.dev3.model.OrderStatus;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "Orders", urlPatterns =
        {
                "/Orders"
        })
public class OrdersList extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException
    {
        String forward;
        String action = request.getParameter("action");
        OrderDaoImpl orderDao = new OrderDaoImpl();
        StatusDaoImpl statusDao = new StatusDaoImpl();
        Map<Enum ,Integer> map = statusDao.getAll();
        request.setAttribute("statuses",map);

        if (action.equalsIgnoreCase("processing")){
            setRequestOrdersByStatus(map.get(OrderStatus.PROCESS),orderDao,request);
            Processing processing = new Processing();
            processing.doGet(request,response);
        }else if (action.equalsIgnoreCase("accepting")){
            setRequestOrdersByStatus(map.get(OrderStatus.ACCEPTED),orderDao,request);
            Accepting accepting = new Accepting();
            accepting.doGet(request,response);
        }else if (action.equalsIgnoreCase("rejecting")){
            setRequestOrdersByStatus(map.get(OrderStatus.REJECTED),orderDao,request);
            Rejecting rejecting = new Rejecting();
            rejecting.doGet(request,response);
        }else if (action.equalsIgnoreCase("renting")){
            setRequestOrdersByStatus(map.get(OrderStatus.RENTED),orderDao,request);
            Renting renting = new Renting();
            renting.doGet(request,response);
        }else if(action.equalsIgnoreCase("damaging")){
            setRequestOrdersByStatus(map.get(OrderStatus.REPAIRED),orderDao,request);
            Damaged damaged = new Damaged();
            damaged.doGet(request,response);
        }else if (action.equalsIgnoreCase("closed")){
            setRequestOrdersByStatus(map.get(OrderStatus.CLOSED),orderDao,request);
            Closing closing = new Closing();
            closing.doGet(request,response);
        }

        RequestDispatcher dispatcher=getServletContext().getRequestDispatcher( "/WEB-INF/orders/ordersList.jsp" );
        //request.setAttribute("orders", orderDao.getAllBYCondition((Integer) request.getSession().getAttribute("currentUserId")));
        // request.setAttribute("cars", orderDao.getAllBYCondition("WHERE User_idUser = " + request.getSession().getAttribute("currentUserId")));
        // System.out.println(orderDao.getAllBYCondition((Integer) request.getSession().getAttribute("currentUserId")));
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

    private void setRequestOrdersByStatus(int id , OrderDaoImpl orderDao , HttpServletRequest request){
        request.setAttribute("orders", orderDao.getAllBYCondition((Integer) request.getSession().getAttribute("currentUserId"),id));

    }
}
