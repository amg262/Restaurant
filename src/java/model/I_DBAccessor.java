package model;


import java.sql.SQLException;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author agunn1
 */
public interface I_DBAccessor {
    
    /**
     *
     * @param driverClassName
     * @param url
     * @param username
     * @param password
     * @throws IllegalArgumentException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public abstract void openConnection(String driverClassName, String url, String username, String password)
            throws IllegalArgumentException, ClassNotFoundException, SQLException;
    
    /**
     *
     * @throws SQLException
     */
    public abstract void closeConnection() throws SQLException;

    /**
     *
     * @param sqlString
     * @param closeConnection
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public abstract List retrieveRecords(String sqlString, boolean closeConnection)
            throws SQLException, Exception;
    
}


