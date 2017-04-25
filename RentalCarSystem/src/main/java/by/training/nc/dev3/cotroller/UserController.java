package by.training.nc.dev3.cotroller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.training.nc.dev3.dao.OrderDaoImpl;
import by.training.nc.dev3.model.Order;
import by.training.nc.dev3.model.OrderStatus;

@WebServlet(name = "UserController", urlPatterns =
        {
                "/UserController"
        })

public class UserController extends HttpServlet {

    private static String INSERT_OR_EDIT = "/WEB-INF/editOrder/editOrder.jsp";
    private static String LIST_USER = "/WEB-INF/profile/profile.jsp";

    /*public UserController() {
        super();
        dao = new UserDao();
    }*/

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward;
        String action = request.getParameter("action");
        OrderDaoImpl orderDao = new OrderDaoImpl();

        if (action.equalsIgnoreCase("delete")){
            int idOrder = Integer.parseInt(request.getParameter("idOrder"));
            orderDao.delete(idOrder);
            response.sendRedirect("/Profile");
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            System.out.println(request.getParameter("idOrder"));
            int idOrder = Integer.parseInt(request.getParameter("idOrder"));
            Order order = orderDao.getByPK(idOrder);
            request.setAttribute("order", order);
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderDaoImpl orderDao = new OrderDaoImpl();
        int idOrder = Integer.parseInt(request.getParameter("idOrder"));
        Order order = orderDao.getByPK(idOrder);
        order.setStatus(OrderStatus.valueOf(request.getParameter("firstName")));
        if (OrderStatus.PROCESS == OrderStatus.valueOf(request.getParameter("firstName"))){

        }
        orderDao.update(order);

        /*User user = new User();
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        try {
            Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("dob"));
            user.setDob(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setEmail(request.getParameter("email"));
        String userid = request.getParameter("userid");
        if(userid == null || userid.isEmpty())
        {
            dao.addUser(user);
        }
        else
        {
            user.setUserid(Integer.parseInt(userid));
            dao.updateUser(user);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("users", dao.getAllUsers());
        view.forward(request, response);*/
    }
}