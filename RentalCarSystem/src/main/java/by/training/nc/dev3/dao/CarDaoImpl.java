package by.training.nc.dev3.dao;

import by.training.nc.dev3.exception.CustomGenericException;
import by.training.nc.dev3.model.Car;
import by.training.nc.dev3.model.Order;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dima on 25.4.17.
 */
public class CarDaoImpl extends AbstractDao<Car, Integer>{

    @Override
    public String getConditionQuery() {
        return null;
    }

    @Override
    public String getSelectQuery() {
        return "SELECT Cars.id,Cars.pricePerDay,Brands.brand,Brands.model " +
                "FROM Cars INNER JOIN Brands ON Cars.Brand_id = Brands.id ";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO Brands(brand,model) VALUES (?, ?);"+
        "INSERT INTO Cars (pricePerDay,Brand_idBrand) VALUES (?, LAST_INSERT_ID());";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE Brands  SET brand = ?, model  = ? WHERE id = ? ;" +
        "UPDATE Cars SET pricePerDay = ? WHERE Brand_id = ? ;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM Car WHERE id= ? ;";
    }


    @Override
    protected List<Car> parseResultSet(ResultSet rs) throws CustomGenericException {
        LinkedList<Car> result = new LinkedList<>();
        try {
            while (rs.next()) {
                Car car = new Car();
                car.setBrand(rs.getString("brand"));
                car.setModel(rs.getString("model"));
                car.setPricePerDay(rs.getInt("pricePerDay"));
                car.setCountOfCars(rs.getInt("countOfCars"));
                result.add(car);
            }
        } catch (Exception e) {
            throw new CustomGenericException(e);
        }
        return result;
    }


    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Car object) throws CustomGenericException {
        try {
            statement.setString(1, object.getBrand());
            statement.setString(2, object.getModel());
            statement.setInt(3, object.getPricePerDay());
            System.out.println(statement);
        } catch (Exception e) {
            throw new CustomGenericException(e);
        }
    }


    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Car object) throws CustomGenericException {
        try {
            statement.setString(1, object.getBrand());
            statement.setString(2, object.getModel());
            statement.setInt(3, object.getId());
            statement.setInt(3, object.getPricePerDay());
            statement.setInt(5, object.getId());
        } catch (Exception e) {
            throw new CustomGenericException(e);
        }
    }
}
