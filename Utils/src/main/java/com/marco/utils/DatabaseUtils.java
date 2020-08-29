package com.marco.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.postgresql.ds.PGSimpleDataSource;

import com.marco.utils.enums.DbType;
import com.mysql.cj.jdbc.MysqlDataSource;

/**
 * This class provides helpful method to create JDBC connections.
 * It works with MYSQL and POSTGRES.
 * It is a singleton, so you need to initialize this class first
 * 
 * @author Marco
 *
 */
public class DatabaseUtils {
	private static Logger logger = Logger.getLogger(DatabaseUtils.class);
	private static DatabaseUtils instance;
	private String url;
	private int port;
	private String database;
	private String user;
	private String password;
	private DbType dbType;

	private static int COUNT_OPEN_DB_CONNECTION = 0;

	private DatabaseUtils(String url, int port, String database, String user, String password, DbType dbType) {
		this.url = url;
		this.port = port;
		this.user = user;
		this.password = password;
		this.database = database;
		this.dbType = dbType;
	}

	/**
	 * Initialize the singleton
	 * 
	 * @param url
	 * @param port
	 * @param dataBase
	 * @param user
	 * @param password
	 * @param dbType
	 */
	public static synchronized void initialize(String url, int port, String dataBase, String user, String password, DbType dbType) {
		if (instance == null) {
			instance = new DatabaseUtils(url, port, dataBase, user, password, dbType);
		}
	}

	/**
	 * Returns the instance
	 * 
	 * @return
	 * @throws MarcoException
	 */
	public static synchronized DatabaseUtils getInstance() throws MarcoException {
		if (instance == null) {
			throw new MarcoException("Database Utils not initialised, kindly call the initialize method first");
		}
		return instance;
	}

	/**
	 * Utility function in order to close the SQL objects
	 * 
	 * @param cn
	 * @param st
	 * @param rs
	 */
	public static synchronized void closeSqlObjects(Connection cn, Statement st, ResultSet rs) {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (cn != null) {
			try {
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (COUNT_OPEN_DB_CONNECTION < 1) {
				logger.warn("No DB connection to close");
				return;
			}
			COUNT_OPEN_DB_CONNECTION--;
			logger.debug("Closed 1 DB connection");
			logger.debug(String.format("There are %d DB open connections", COUNT_OPEN_DB_CONNECTION));
		}
	}

	/**
	 * It returns a connection to the database server without selecting the database
	 * 
	 * @return
	 * @throws MarcoException
	 */
	public Connection createDbConnectionNoDb() throws MarcoException {
		switch (dbType) {
		case MYSQL:
			return createMySqlDbConnection(null);
		case POSTGRES:
			return createPostgresDbConnection(null);
		default:
			throw new MarcoException("Database not managed");
		}
	}

	/**
	 * It creates the connection to the mysql database
	 * 
	 * @param database
	 * @return
	 * @throws MarcoException
	 */
	private synchronized Connection createMySqlDbConnection(String database) throws MarcoException {
		try {

			MysqlDataSource ds = new MysqlDataSource();
			ds.setUser(user);
			ds.setPassword(password);
			ds.setPort(port);
			if (database != null) {
				ds.setDatabaseName(database);
			}
			ds.setServerName(url);

			Connection cn = ds.getConnection();
			COUNT_OPEN_DB_CONNECTION++;
			logger.debug("Opened 1 DB connection");
			logger.debug(String.format("There are %s DB open connections", COUNT_OPEN_DB_CONNECTION));
			return cn;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MarcoException(e);
		}
	}

	/**
	 * It creates the connection to the postgres database
	 * @param database
	 * @return
	 * @throws MarcoException
	 */
	private synchronized Connection createPostgresDbConnection(String database) throws MarcoException {
		try {

			PGSimpleDataSource ds = new PGSimpleDataSource();

			ds.setUser(user);
			ds.setPassword(password);
			ds.setPortNumber(port);
			if (database != null) {
				ds.setDatabaseName(database);
			}
			ds.setServerName(url);

			Connection cn = ds.getConnection();
			COUNT_OPEN_DB_CONNECTION++;
			logger.debug("Opened 1 DB connection");
			logger.debug(String.format("There are %d DB open connections", COUNT_OPEN_DB_CONNECTION));
			return cn;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MarcoException(e);
		}
	}

	/**
	 * Returns the JDBC connection to the database. The database is the one set when
	 * this singleton was initialized
	 * 
	 * @param url
	 * @param port
	 * @param database
	 * @param user
	 * @param password
	 * @return
	 * @throws MarcoException
	 */
	public synchronized Connection createDbConnection() throws MarcoException {
		switch (dbType) {
		case MYSQL:
			return createMySqlDbConnection(database);
		case POSTGRES:
			return createPostgresDbConnection(database);
		default:
			throw new MarcoException("Database not managed");
		}
	}

}
