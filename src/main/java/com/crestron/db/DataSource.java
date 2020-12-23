package com.crestron.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.crestron.constants.Constants;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


public class DataSource {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(DataSource.class.getName());
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;
    
    
    static {
    	config.setDriverClassName(Constants.DB_CONNECTION_DRIVER);
        config.setJdbcUrl(Constants.DB_CONNECTION_URL);
        config.setUsername(Constants.DB_CONNECTION_USERNAME);
        config.setPassword(Constants.DB_CONNECTION_PASSWORD);
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        ds = new HikariDataSource( config );
    }

    private DataSource() {}

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}