package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy
 */
public class DBGenericAccessor implements I_DBAccessor {

    private Connection conn;
    
    /**
     *
     */
    public DBGenericAccessor(){}
    
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
    @Override
    public void openConnection(String driverClassName, String url, String username, String password)
            throws IllegalArgumentException, ClassNotFoundException, SQLException {
        
        String msg = "Error in URL";
        if (url == null || url.length() == 0) throw new IllegalArgumentException(msg);
        username = (username == null) ? "" : username;
        password = (password == null) ? "" : password;
        Class.forName(driverClassName);
        
        conn = DriverManager.getConnection(url, username, password);
        
    }

    /**
     *
     * @throws SQLException
     */
    @Override
    public void closeConnection() throws SQLException {
        conn.close();
    }

    /**
     *
     * @param sqlString
     * @param closeConnection
     * @return
     * @throws SQLException
     * @throws Exception
     */
    @Override
    public List retrieveRecords(String sqlString, boolean closeConnection)
            throws SQLException, Exception {
        
        Statement stmnt = null;
        ResultSet rs = null;
        ResultSetMetaData metaData = null;
        List list = new ArrayList();
        Map records = null;
        
        try {
            stmnt = conn.createStatement();
            rs = stmnt.executeQuery(sqlString);
            metaData = rs.getMetaData();
            int fields = metaData.getColumnCount();
            
            while (rs.next()){
                records = new HashMap();
                for (int i=1; i <= fields; i++){
                    try {
                        records.put(metaData.getColumnName(i), rs.getObject(i));
                    } catch (NullPointerException npe){
                        
                    } //end of 2nd catch
                } ///End of for
                list.add(records);
            } // end of while
            
        } catch (SQLException sqle){
            throw sqle;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                stmnt.close();
                if (closeConnection){
                    conn.close();
                } // end of if
            } catch (SQLException sqle2){
                throw sqle2;
            } // end of try
        } // end of finally
        
        return list;
    }
    
}
