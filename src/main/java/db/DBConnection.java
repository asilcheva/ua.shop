package db;

import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Log4j2
public class DBConnection {
    static String url = "jdbc:postgresql://192.168.31.190:5432/reader";
    static String user = "reader";
    static String password = "j/QR9eH~/t)bQHM/";

    public static Connection getDBConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
        return connection;
    }

    public List<String> getSmartphonesfromDB() throws SQLException {
        List<String> list = new ArrayList<>();
        PreparedStatement statement = getDBConnection().prepareStatement("SELECT NAME FROM SMARTPHONES;");
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            list.add(set.getString(1));
        }
        return list;
    }
}
