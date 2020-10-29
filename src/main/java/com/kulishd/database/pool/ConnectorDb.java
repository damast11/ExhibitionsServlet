package com.kulishd.database.pool;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectorDb {
    private static Logger logger = Logger.getLogger("ConnectorDb");
    private static final String PATH_TO_DATABASE_PROPERTIES = "database";
    private static final String URL = "db.url";
    private static final String USER = "db.user";
    private static final String PASSWORD = "db.password";
    private static volatile DataSource dataSource;

    private static DataSource getDataSource() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(PATH_TO_DATABASE_PROPERTIES);
        if (dataSource == null) {
            synchronized (ConnectorDb.class) {
                if (dataSource == null) {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        BasicDataSource ds = new BasicDataSource();
                        ds.setUrl(resourceBundle.getString(URL));
                        ds.setUsername(resourceBundle.getString(USER));
                        ds.setPassword(resourceBundle.getString(PASSWORD));
                        ds.setMinIdle(5);
                        ds.setMaxIdle(10);
                        ds.setMaxOpenPreparedStatements(100);
                        dataSource = ds;
                    } catch (ClassNotFoundException e) {
                        logger.log(Level.SEVERE ,"SQL Exception in method getDataSource");
                        e.printStackTrace();
                    }
                }
            }
        }
        logger.info("getDataSource returning " + dataSource);
        return dataSource;

    }

    public static Connection getConnection() {
        try {
            logger.info("getDataSource returning connection");
            return getDataSource().getConnection();
        } catch (SQLException e) {
            logger.log(Level.SEVERE ,"SQL Exception in method getConnection");
            throw new RuntimeException(e);
        }
    }

}

