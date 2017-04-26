package by.training.nc.dev3.dao;


import by.training.nc.dev3.exception.CustomGenericException;
import by.training.nc.dev3.model.Car;
import by.training.nc.dev3.model.Order;
import by.training.nc.dev3.model.OrderStatus;
import by.training.nc.dev3.model.User;
import com.sun.xml.internal.ws.api.message.Packet;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class OrderDaoImpl extends AbstractDao<Order, Integer>{

    @Override
    public String getConditionQueryForAllOrders() {
        return " WHERE Orders.User_id = ? AND Status_id = ?";
    }

    @Override
    public String getConditionQueryForOrder() {
        return " WHERE Orders.id = ?";
    }

    @Override
    public String getSelectQuery() {
        return "SELECT Orders.id,Orders.startDate,Orders.endDate,Orders.clarification," +
                "Orders.price,Orders.repairPrice,Cars.pricePerDay,Cars.countOfCars,Brands.brand,Brands.model,Statuses.status FROM Orders " +
                "INNER JOIN Cars ON Orders.Car_id = Cars.id " +
                "INNER JOIN Brands ON Cars.Brand_id = Brands.id " +
                "INNER JOIN Statuses ON Orders.Status_id = Statuses.id";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO Orders (startDate, endDate, clarification, price,repairPrice,User_id,Car_id,Status_id) \n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE Orders SET Orders.startDate= ?, Orders.endDate= ?, Orders.clarification= ?, " +
                "Orders.price= ?, Orders.repairPrice = ? , Status_id = ?  WHERE id = ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM Orders WHERE Orders.id= ?;";
    }


    @Override
    protected List<Order> parseResultSet(ResultSet rs) throws CustomGenericException {
        LinkedList<Order> result = new LinkedList<>();
        try {
            while (rs.next()) {
                Order order = new Order();
                Car car = new Car();
                order.setId(rs.getInt("id"));
                order.setBeginDate(rs.getDate("startDate"));
                order.setRefundDate(rs.getDate("endDate"));
                order.setClarification(rs.getString("clarification"));
                order.setPrice(rs.getInt("price"));
                order.setRepairPrice(rs.getInt("repairPrice"));
                car.setCountOfCars(rs.getInt("countOfCars"));
                car.setModel(rs.getString("model"));
                car.setBrand(rs.getString("brand"));
                order.setCar(car);
                order.setStatus(OrderStatus.valueOf(rs.getString("status")));
                result.add(order);
            }
        } catch (Exception e) {
            throw new CustomGenericException(e);
        }
        return result;
    }


    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Order object) throws CustomGenericException {
        try {
            statement.setDate(1, (Date) object.getBeginDate());
            statement.setDate(2, (Date) object.getRefundDate());
            statement.setString(3, object.getClarification());
            statement.setInt(4, object.getPrice());
            statement.setInt(5,object.getRepairPrice());
            statement.setInt(6,object.getUser().getId());
            statement.setInt(7,object.getCar().getId());
            statement.setString(8,object.getStatus().toString());
            System.out.println(statement);
        } catch (Exception e) {
            throw new CustomGenericException(e);
        }
    }


    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Order object) throws CustomGenericException {
        try {
            statement.setDate(1, (Date) object.getBeginDate());
            statement.setDate(2, (Date) object.getRefundDate());
            statement.setString(3, object.getClarification());
            statement.setInt(4, object.getPrice());
            statement.setInt(5,object.getRepairPrice());
            /*statement.setInt(6,object.getUser().getId());
            statement.setInt(7,object.getCar().getId());*/
            statement.setString(8,object.getStatus().toString());
            statement.setInt(5, object.getId());
        } catch (Exception e) {
            throw new CustomGenericException(e);
        }
    }
}
