package by.training.nc.dev3.dao;import by.training.nc.dev3.exception.CustomGenericException;import by.training.nc.dev3.model.User;import java.sql.PreparedStatement;import java.sql.ResultSet;import java.util.LinkedList;import java.util.List;public class UserDaoImpl extends AbstractDao<User, Integer>{    @Override    public String getConditionQueryForAllOrders() {        return null;    }    @Override    public String getConditionQueryForOrder() {        return null;    }    @Override    public String getSelectQuery() {        return "SELECT id, login, password, balance, numberPassport FROM Users ";    }    @Override    public String getCreateQuery() {        return "INSERT INTO Users (login, password, balance, numberPassport) \n" +                "VALUES (?, ?, ?, ?);";    }    @Override    public String getUpdateQuery() {        return "UPDATE Users \n" +                "SET login = ?, password  = ?, balance = ?, numberPassport = ? \n" +                "WHERE id = ?;";    }    @Override    public String getDeleteQuery() {        return "DELETE FROM Users WHERE id= ?;";    }    @Override    protected List<User> parseResultSet(ResultSet rs) throws CustomGenericException {        LinkedList<User> result = new LinkedList<User>();        try {            while (rs.next()) {                User user = new User();                user.setIdUser(rs.getInt("id"));                user.setLogin(rs.getString("login"));                user.setPassword(rs.getString("password"));                user.setBalance(rs.getInt("balance"));                user.setNumberOfPassport(rs.getString("numberPassport"));                result.add(user);            }        } catch (Exception e) {            throw new CustomGenericException(e);        }        return result;    }    @Override    protected void prepareStatementForInsert(PreparedStatement statement, User object) throws CustomGenericException {        try {            statement.setString(1, object.getLogin());            statement.setString(2, object.getPassword());            statement.setInt(3, object.getBalance());            statement.setString(4, object.getNumberOfPassport());            System.out.println(statement);        } catch (Exception e) {            throw new CustomGenericException(e);        }    }    @Override    protected void prepareStatementForUpdate(PreparedStatement statement, User object) throws CustomGenericException {        try {            statement.setString(1, object.getLogin());            statement.setString(2, object.getPassword());            statement.setInt(3, object.getBalance());            statement.setString(4, object.getNumberOfPassport());            statement.setInt(5, object.getId());        } catch (Exception e) {            throw new CustomGenericException(e);        }    }}