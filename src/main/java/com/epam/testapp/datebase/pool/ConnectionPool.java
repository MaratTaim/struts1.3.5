package com.epam.testapp.datebase.pool;

/**
 * Marat Taim 15.07.2017
 */
import com.epam.testapp.util.Const;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@Component
public class ConnectionPool {
    private static ConnectionPool instance;
    private final ResourceBundle resource = ResourceBundle.getBundle("connection");
    private int maxConn = Integer.parseInt(resource.getString("max.conn"));
    private BlockingQueue<Connection> freeConnections = new ArrayBlockingQueue<Connection>(maxConn);
    private final String URL = resource.getString("url");
    private final String C_USER = resource.getString("user");
    private final String C_PASSWORD = resource.getString("password");
    private final String DRIVER = "oracle.jdbc.OracleDriver";

    private ConnectionPool() {
    }

    public synchronized Connection getConnection() {
        Connection con;
        if (!freeConnections.isEmpty()) {
            con = freeConnections.poll();
            try {
                if (con.isClosed()) {
                    con = getConnection();
                }
            } catch (Exception e) {
                con = getConnection();
            }
        } else {
            con = newConnection();
        }
        return con;
    }

    private Connection newConnection() {
        Connection con = null;
        try {
            Locale.setDefault(Locale.ENGLISH);
//            it's need for loading driver, don't work without it
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, C_USER, C_PASSWORD);

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(Const.C_CREATE_CONN);
            e.printStackTrace();
        }
        return con;
    }

    public synchronized void freeConnection(Connection con) {
        if ((con != null) && (freeConnections.size() <= maxConn)) {
            freeConnections.add(con);
        }
    }

    public synchronized void release() {
        Iterator allConnections = freeConnections.iterator();
        while (allConnections.hasNext()) {
            Connection con = (Connection) allConnections.next();
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(Const.C_CLOSE_CONN);
            }
        }
        freeConnections.clear();
    }
}
