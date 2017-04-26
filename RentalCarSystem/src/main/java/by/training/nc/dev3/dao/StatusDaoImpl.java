package by.training.nc.dev3.dao;

import by.training.nc.dev3.exception.CustomGenericException;
import by.training.nc.dev3.model.OrderStatus;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dima on 26.4.17.
 */
public class StatusDaoImpl {

    public Map<Enum ,Integer> getAll(){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        Map<Enum ,Integer> map;
        try {
            connection = SQLPoolConnection.getConnection();
            String sql = "SELECT Statuses.id,Statuses.status FROM Statuses;";
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            map = parseResultSet(rs);
        } catch (SQLException | NamingException e) {
            throw new CustomGenericException(e);
        }
        finally {
            AbstractDao.closeConnection(connection);
            AbstractDao.closeStatement(statement);
            AbstractDao.closeResultSet(rs);
        }
        return map;
    }

    protected Map<Enum ,Integer> parseResultSet(ResultSet rs) throws CustomGenericException {
        Map<Enum, Integer> map = new HashMap<>();
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                Enum status = OrderStatus.valueOf(rs.getString("status"));
                map.put(status,id);
            }
        } catch (Exception e) {
            throw new CustomGenericException(e);
        }
        return map;
    }
}
