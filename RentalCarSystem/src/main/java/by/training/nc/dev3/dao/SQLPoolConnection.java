package by.training.nc.dev3.dao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;


public class SQLPoolConnection {
        private static InitialContext ic;
        private static DataSource ds;

        public static Connection getConnection() throws SQLException, NamingException {
            ic = new InitialContext();
            ds = (DataSource) ic.lookup("java:/comp/env/jdbc/sakila"); // вместо написать java:/comp/env/jdbc/TestDB
            return ds.getConnection();
        }
}