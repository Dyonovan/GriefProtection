package com.dyonovan.griefprotection.lib;

import com.dyonovan.griefprotection.handlers.ConfigHandler;

import java.sql.*;

public class MySql {

    private Connection _connection;
    public PreparedStatement _ps;
    public ResultSet _rs;

    public boolean connectDB() {

        String url = String.format("jdbc:mysql://%s:%d/%s",
                ConfigHandler.dbHost,
                ConfigHandler.dbPort,
                ConfigHandler.dbName);

        try {
            if (_connection != null && !_connection.isClosed())
                return true;

            _connection = DriverManager.getConnection(url, ConfigHandler.dbUser, ConfigHandler.dbPass);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            //TODO - return specific message ie wrong user/pass/db
            return false;
        }

    }

    public void cleanUp() {
        try {
            if (_rs != null)
                _rs.close();
            if (_ps != null)
                _ps.close();
            if (_connection != null)
                _connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
