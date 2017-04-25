package by.training.nc.dev3.dao;


import by.training.nc.dev3.exception.CustomGenericException;
import by.training.nc.dev3.model.Order;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class OrderDaoImpl extends AbstractDao<Order, Integer>{

    @Override
    public String getSelectQuery() {
        return "SELECT Orders.idOrder,Orders.startDate,Orders.endDate,Orders.clarification," +
                "Orders.price,Orders.repairPrice,Cars.pricePerDay,Brands.brand,Brands.model FROM Orders " +
                "INNER JOIN Cars ON Orders.Car_idCar = Cars.idCar INNER JOIN Brands " +
                "ON Cars.Brand_idBrand = Brands.idBrand Where Orders.User_idUser = ? ";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO Orders (startDate, endDate, clarification, price,repairPrice,User_idUser,Car_idCar,Status_idStatus) \n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE Orders SET  Status_idStatus = ? WHERE idOrder = ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM Orders WHERE idOrder= ?;";
    }


    @Override
    protected List<Order> parseResultSet(ResultSet rs) throws CustomGenericException {
        LinkedList<Order> result = new LinkedList<>();
        try {
            while (rs.next()) {
                Order order = new Order();
                order.setBeginDate(rs.getDate("startDate"));
                order.setRefundDate(rs.getDate("endDate"));
                order.setClarification(rs.getString("clarification"));
                order.setPrice(rs.getInt("price"));
                order.setRepairPrice(rs.getInt("repairPrice"));
                order.setIdUser(rs.getInt("User_idUser"));
                order.setIdCar(rs.getInt("Car_idCar"));
                order.setIdStatus(rs.getInt("Status_idStatus"));
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
            statement.setInt(6,object.getIdUser());
            statement.setInt(7,object.getIdCar());
            statement.setInt(8,object.getIdStatus());
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
            statement.setInt(6,object.getIdUser());
            statement.setInt(7,object.getIdCar());
            statement.setInt(8,object.getIdStatus());
            statement.setInt(5, object.getId());
        } catch (Exception e) {
            throw new CustomGenericException(e);
        }
    }
}
