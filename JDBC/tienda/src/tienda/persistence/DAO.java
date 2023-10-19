package tienda.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO {

    protected Connection connection = null;
    protected ResultSet resultSet = null;
    protected Statement statement = null;

    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "tienda";
    private final String DRIVER = "com.mysql.jdbc.Driver";

    protected void connect() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(DRIVER);
            String urlDb = "jdbc:mysql://localhost:3306/" + DATABASE + "?useSSL=false";
            connection = DriverManager.getConnection(urlDb, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }

    protected void disconnect() throws SQLException {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    protected void insertUpdateDelete(String sql) throws SQLException {
        try {
            connect();
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException | ClassNotFoundException ex) {
            connection.rollback();
        } finally {
            disconnect();
        }
    }
    
    protected void getData(String sql) throws Exception {
        try {
            connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (ClassNotFoundException | SQLException e) {
            throw e; 
        }
    }

}
