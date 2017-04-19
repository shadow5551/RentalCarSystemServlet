package by.training.nc.dev3.dao;



import by.training.nc.dev3.exception.CustomGenericException;

import javax.naming.NamingException;
import java.sql.*;
import java.util.List;

/**
 * Created by dima on 12.4.17.
 */
public abstract class AbstractDao<T extends Identified<PK>, PK extends Integer> implements GenericDao<T, PK> {

    /**
     * SELECT * FROM [Table]
     */
    public abstract String getSelectQuery();

    /**
     * INSERT INTO [Table] ([column, column, ...]) VALUES (?, ?, ...);
     */
    public abstract String getCreateQuery();

    /**
     * UPDATE [Table] SET [column = ?, column = ?, ...] WHERE id = ?;
     */
    public abstract String getUpdateQuery();

    /**
     * DELETE FROM [Table] WHERE id= ?;
     */
    public abstract String getDeleteQuery();

    /**
     * Разбирает ResultSet и возвращает список объектов соответствующих содержимому ResultSet.
     */
    protected abstract List<T> parseResultSet(ResultSet rs) throws CustomGenericException;

    /**
     * Устанавливает аргументы insert запроса в соответствии со значением полей объекта object.
     */
    protected abstract void prepareStatementForInsert(PreparedStatement statement, T object) throws CustomGenericException;


    /**
     * Устанавливает аргументы update запроса в соответствии со значением полей объекта object.
     */
    protected abstract void prepareStatementForUpdate(PreparedStatement statement, T object) throws CustomGenericException;

    @Override
    public T getByPK(int key) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<T> list;
        try {
            connection = SQLPoolConnection.getConnection();
            String sql = getSelectQuery();
            sql += " WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, key);
            System.out.println(statement);
            rs = statement.executeQuery();
            list = parseResultSet(rs);
        }
        catch (SQLException | NamingException e) {
            throw new CustomGenericException(e);
        }
        finally {
            closeConnection(connection);
            closeStatement(statement);
            closeResultSet(rs);
        }
        if (list == null || list.size() == 0) {
            return null;
        }
        if (list.size() > 1) {
            throw new CustomGenericException("Received more than one record.");
        }
        return list.iterator().next();
    }

    @Override
    public List<T> getAll(){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<T> list;
        try {
            connection = SQLPoolConnection.getConnection();
            String sql = getSelectQuery();
            System.out.println(sql);
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (SQLException | NamingException e) {
            throw new CustomGenericException(e);
        }
        finally {
            closeConnection(connection);
            closeStatement(statement);
            closeResultSet(rs);
        }
        return list;
    }

    @Override
    public List<T> getAllBYCondition(String sqlAdd) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<T> list;
        try {
            connection = SQLPoolConnection.getConnection();
            String sql = getSelectQuery();
            sql += sqlAdd;
            System.out.println(sql);
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (SQLException | NamingException e) {
            throw new CustomGenericException(e);
        }
        finally {
            closeConnection(connection);
            closeStatement(statement);
            closeResultSet(rs);
        }
        return list;
    }

    @Override
    public boolean create(T object) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = SQLPoolConnection.getConnection();
            String sql = getCreateQuery();
            statement = connection.prepareStatement(sql);
            prepareStatementForInsert(statement, object);
            statement.executeUpdate();
        } catch (SQLException | NamingException e) {
            throw new CustomGenericException(e);
        }
        finally {
            closeConnection(connection);
            closeStatement(statement);
        }
        return true;
    }

    @Override
    public void update(T object) throws CustomGenericException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = SQLPoolConnection.getConnection();
            String sql = getUpdateQuery();
            statement = connection.prepareStatement(sql);
            prepareStatementForUpdate(statement, object);
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new CustomGenericException("On update modify more then 1 record: " + count);
            }
        } catch (SQLException | NamingException e) {
            throw new CustomGenericException(e);
        }
        finally {
            closeConnection(connection);
            closeStatement(statement);
        }
    }

    @Override
    public void delete(T object) throws CustomGenericException {
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = SQLPoolConnection.getConnection();
            String sql = getDeleteQuery();
            statement = connection.prepareStatement(sql);
            statement.setObject(1, object.getId());
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new CustomGenericException("On delete modify more then 1 record: " + count);
            }
        } catch (SQLException | NamingException e) {
            throw new CustomGenericException(e);
        }finally {
            closeConnection(connection);
            closeStatement(statement);
        }
    }

    private void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {

            }
        }
    }

    private void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {

            }
        }
    }

    private void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {

            }
        }
    }

}