package ru.kpfu.itis.jdbc;

import ru.kpfu.itis.exceptions.DbException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionProvider {

    private static ConnectionProvider _instance;

    public static ConnectionProvider get_instance() throws DbException {
        if(_instance == null) {
            _instance = new ConnectionProvider();
        }
        return _instance;
    }

    private Connection connection;

    private ConnectionProvider() throws DbException {
        Properties properties = new Properties();
        try {
            properties.load(ConnectionProvider.class.getResourceAsStream("/db.properties"));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        try {Class.forName("org.postgresql.Driver").newInstance();
            connection = DriverManager.getConnection(
                    properties.getProperty("db.url"),
                    properties.getProperty("db.username"),
                    properties.getProperty("db.password")
            );
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new DbException("Can't connect to DB",e);
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
