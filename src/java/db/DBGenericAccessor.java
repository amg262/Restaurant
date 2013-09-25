package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
     * @return list
     * @throws SQLException
     * @throws Exception
     */
    @Override
    public List retrieveRecords(String sqlString, boolean closeConnection)
            throws SQLException, Exception {
        
        Statement stmnt = null;
        ResultSet resultSet = null;
        ResultSetMetaData metaData = null;
        List list = new ArrayList();
        Map records = null;
        
        //finally will always close connection
        try {
            stmnt = conn.createStatement();
            resultSet = stmnt.executeQuery(sqlString);
            metaData = resultSet.getMetaData();
            int fields = metaData.getColumnCount();
            
            while (resultSet.next()){
                records = new HashMap();
                for (int i=1; i <= fields; i++){
                    try {
                        records.put(metaData.getColumnName(i), resultSet.getObject(i));
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

    /**
     *
     * @param table
     * @param primaryKeyField
     * @param keyValue
     * @param closeConnection
     * @return record
     * @throws SQLException
     * @throws Exception
     */
    @Override
    public Map retrieveRecordByID(String table, String primaryKeyField, Object keyValue, boolean closeConnection)
            throws SQLException, Exception {
        
        Statement stmnt = null;
        ResultSet resultSet = null;
        ResultSetMetaData metaData = null;
        final Map record = new HashMap(); //Final?
        
        //finally will always close connection
        try {
            stmnt = conn.createStatement();
            String sql2;
            
            if (keyValue instanceof String){
                sql2 = "= '" + keyValue + "'";
                
            } else {
                sql2 = "=" + keyValue;
            }
            
            final String sql = "Select * From " + table + " Where " + primaryKeyField + sql2;
            
            resultSet = stmnt.executeQuery(sql);
            metaData = resultSet.getMetaData();
            metaData.getColumnCount();
            final int fields = metaData.getColumnCount();
            
            if (resultSet.next()){
                for (int i=0; i <= fields; i++){
                    record.put(metaData.getColumnName(i), resultSet.getObject(i));
                } //end of for
            } //end of if
            
        } catch (SQLException sqle){
            throw sqle;
        } catch (Exception e){
            throw e;
        } finally {
            
            try {
                stmnt.close();
                if (closeConnection) {
                    conn.close();
                } 
            } catch (SQLException sqle2){
                    throw sqle2;
                } //end of try
            } //end of finally
            
       
        return record;
    }

    /**
     *
     * @param tableName
     * @param colDescriptors
     * @param colValues
     * @param closeConnection
     * @return boolean
     * @throws SQLException
     * @throws Exception
     */
    @Override
    public boolean insertRecord(String tableName, List colDescriptors, List colValues, boolean closeConnection)
            throws SQLException, Exception {
        
        PreparedStatement prepStmnt = null;
        int recordsUpdated = 0;
        
        //finally will always close connection
        try {
            prepStmnt = buildInsertStatement(conn, tableName, colDescriptors);
            
            final Iterator i = colValues.iterator();
            int index = 1;
            
            while (i.hasNext()){
                final Object obj1 = i.next();
                
                if (obj1 instanceof String){
                    prepStmnt.setString(index++, (String)obj1);
                    
                } else if (obj1 instanceof Integer) {
                    prepStmnt.setInt(index++, ((Integer)obj1).intValue());
                    
                } else if (obj1 instanceof Long) {
                    prepStmnt.setLong(index++, ((Long)obj1).longValue());
                    
                } else if (obj1 instanceof Short) {
                    prepStmnt.setShort(index++, ((Short)obj1).shortValue());
                    
                } else if (obj1 instanceof java.sql.Time) {
                    prepStmnt.setTime(index++, ((java.sql.Time)obj1));     
                    
                } else if (obj1 instanceof java.sql.Timestamp) {
                    prepStmnt.setTimestamp(index++, ((java.sql.Timestamp)obj1));
                    
                } else if (obj1 instanceof Double) {
                    prepStmnt.setDouble(index++, ((Double)obj1).doubleValue());
                    
                } else if (obj1 instanceof java.sql.Date) {
                    prepStmnt.setDate(index++, ((java.sql.Date)obj1));
                    
                } else if (obj1 instanceof Boolean) {
                    prepStmnt.setBoolean(index++, ((Boolean)obj1).booleanValue());
                    
                } else if (obj1 instanceof Float) {
                    prepStmnt.setFloat(index++, ((Float)obj1).floatValue());
                }//end of if
                
            } //end of while
            
            recordsUpdated = prepStmnt.executeUpdate();
            
        } catch (SQLException sqle) {
            throw sqle;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                prepStmnt.close();
                if (closeConnection){
                    conn.close();
                } //end of it
                
            } catch (SQLException sqle2){
                throw sqle2;
            }
        }// end of finally
        
        if (recordsUpdated == 1){
            return true;
        } else {
            return false;
        }
    }// end of method

    
    
    /**
     *
     * @param tableName
     * @param colDescriptors
     * @param colValues
     * @param whereField
     * @param whereValue
     * @param closeConnection
     * @return recordsUpdated
     * @throws SQLException
     * @throws Exception
     */
    @Override
    public int updateRecords(String tableName, List colDescriptors, List colValues, String whereField,
            Object whereValue, boolean closeConnection) throws SQLException, Exception {
        
        
        PreparedStatement prepStmnt = null;
        int recordsUpdated = 0;
        
        //finally closes connection
        try{
            prepStmnt = buildUpdateStatement(conn, tableName, colDescriptors, whereField);
            
            final Iterator i = colValues.iterator();
            int index = 1;
            boolean doWhereValueFlag = false;
            
            Object obj1 = null;
            
            while (i.hasNext() || doWhereValueFlag) {
                if(!doWhereValueFlag) {
                    obj1 = i.next();
                }
                
                if (obj1 instanceof String){
                    prepStmnt.setString(index++, (String)obj1);
                    
                } else if (obj1 instanceof Integer) {
                    prepStmnt.setInt(index++, ((Integer)obj1).intValue());
                    
                } else if (obj1 instanceof Long) {
                    prepStmnt.setLong(index++, ((Long)obj1).longValue());
                    
                } else if (obj1 instanceof Short) {
                    prepStmnt.setShort(index++, ((Short)obj1).shortValue());
                    
                } else if (obj1 instanceof java.sql.Time) {
                    prepStmnt.setTime(index++, ((java.sql.Time)obj1));     
                    
                } else if (obj1 instanceof java.sql.Timestamp) {
                    prepStmnt.setTimestamp(index++, ((java.sql.Timestamp)obj1));
                    
                } else if (obj1 instanceof Double) {
                    prepStmnt.setDouble(index++, ((Double)obj1).doubleValue());
                    
                } else if (obj1 instanceof java.sql.Date) {
                    prepStmnt.setDate(index++, ((java.sql.Date)obj1));
                    
                } else if (obj1 instanceof Boolean) {
                    prepStmnt.setBoolean(index++, ((Boolean)obj1).booleanValue());
                    
                } else if (obj1 instanceof Float) {
                    prepStmnt.setFloat(index++, ((Float)obj1).floatValue());
                    
                } else {
                    
                    if (obj1 != null){
                        prepStmnt.setObject(index++, obj1);
                    }//end of if
                }// end of else
                
                if (doWhereValueFlag){
                    break;
                }
                if (!i.hasNext()){
                    doWhereValueFlag = true;
                    obj1 = whereValue;
                }
            } //end of while
            recordsUpdated = prepStmnt.executeUpdate();
            
        } catch (SQLException sqle) {
            throw sqle;
        } catch (Exception e){
            throw e;
        } finally {
            try {
                prepStmnt.close();
                if (closeConnection){
                    conn.close();
                }//end of if
                
            } catch (SQLException sqle2){
                throw sqle2;
            }//end of try     
        }//end of finally
        
        return recordsUpdated;
    }

    
    
    /**
     *
     * @param tableName
     * @param whereField
     * @param whereValue
     * @param closeConnection
     * @return recordsDeleted
     * @throws SQLException
     * @throws Exception
     */
    @Override
    public int deleteRecords(String tableName, String whereField, Object whereValue, boolean closeConnection)
            throws SQLException, Exception {
        
        PreparedStatement prepStmnt = null;
        int recordsDeleted = 0;
        
        //finally will close connection
        try {
            prepStmnt = buildDeleteStatement(conn, tableName, whereField);
            
            //will delete records if null
            if (whereField != null){
                
                if (whereValue instanceof String){
                    prepStmnt.setString(1, (String)whereValue);
                    
                } else if (whereValue instanceof Integer) {
                    prepStmnt.setInt(1, ((Integer)whereValue).intValue());
                    
                } else if (whereValue instanceof Long) {
                    prepStmnt.setLong(1, ((Long)whereValue).longValue());
                    
                } else if (whereValue instanceof Short) {
                    prepStmnt.setShort(1, ((Short)whereValue).shortValue());
                    
                } else if (whereValue instanceof java.sql.Time) {
                    prepStmnt.setTime(1, ((java.sql.Time)whereValue));     
                    
                } else if (whereValue instanceof java.sql.Timestamp) {
                    prepStmnt.setTimestamp(1, ((java.sql.Timestamp)whereValue));
                    
                } else if (whereValue instanceof Double) {
                    prepStmnt.setDouble(1, ((Double)whereValue).doubleValue());
                    
                } else if (whereValue instanceof java.sql.Date) {
                    prepStmnt.setDate(1, ((java.sql.Date)whereValue));
                    
                } else if (whereValue instanceof Boolean) {
                    prepStmnt.setBoolean(1, ((Boolean)whereValue).booleanValue());
                    
                } else if (whereValue instanceof Float) {
                    prepStmnt.setFloat(1, ((Float)whereValue).floatValue());
                    
                } else {
                    
                    if (whereValue != null){
                        prepStmnt.setObject(1, whereValue);
                    }//end of if
                }//end of else
            }//end of if
            
            recordsDeleted = prepStmnt.executeUpdate();
        } catch (SQLException sqle) {
            throw sqle;
        } catch (Exception e){
            throw e;
        } finally {
            try {
                prepStmnt.close();
                if (closeConnection){
                    conn.close();
                }//end of if
                
            } catch (SQLException sqle2){
                throw sqle2;
            }//end of try     
        }//end of finally
        
        return recordsDeleted;
    }

    
    /**
     * 
     * @param conn2
     * @param tableName
     * @param colDescriptors
     * @return
     * @throws SQLException 
     */
    private PreparedStatement buildInsertStatement(Connection conn2, String tableName,
            List colDescriptors) throws SQLException {
        
        StringBuilder sql = new StringBuilder("Insert Into ");
        (sql.append(tableName)).append(" (");
        final Iterator i = colDescriptors.iterator();
        
        while (i.hasNext()){
            (sql.append((String)i.next())).append(", ");
        }//end of while
        
        sql = new StringBuilder( (sql.toString()).substring(0, (sql.toString()).lastIndexOf(", ")) + ") Values (" );
        for (int j=0; j < colDescriptors.size(); j++){
            sql.append("?, ");
        }//end of for
        final String finalSqlStmnt = (sql.toString()).substring(0, (sql.toString()).lastIndexOf(", ")) + ")";
        
        return conn2.prepareStatement(finalSqlStmnt);
    }

    
    
    /**
     * 
     * @param conn2
     * @param tableName
     * @param colDescriptors
     * @param whereField
     * @return
     * @throws SQLException 
     */
    private PreparedStatement buildUpdateStatement(Connection conn2, String tableName, List colDescriptors,
            String whereField) throws SQLException {
        
        StringBuilder sql = new StringBuilder("Update ");
        (sql.append(tableName)).append(" SET ");
        final Iterator i = colDescriptors.iterator();
        
        while (i.hasNext()){
            (sql.append((String)i.next())).append(" = ?, ");
        }//end of while
        
        sql = new StringBuilder((sql.toString()).substring(0, (sql.toString()).lastIndexOf(", ")));
        ((sql.append(" Where ")).append(whereField)).append(" = ?");
        final String finalSqlStmnt = sql.toString();
        
        return conn2.prepareStatement(finalSqlStmnt);
    }

    
    /**
     * 
     * @param conn2
     * @param tableName
     * @param whereField
     * @return
     * @throws SQLException 
     */
    private PreparedStatement buildDeleteStatement(Connection conn2, String tableName,
            String whereField) throws SQLException {
        
        final StringBuilder sql = new StringBuilder("Delete From ");
        sql.append(tableName);
        
        if(whereField != null){
            sql.append(" WHERE ");
            (sql.append(whereField)).append(" = ?");
        }//end of if
        
        final String finalSqlStmnt = sql.toString();
        
        return conn2.prepareStatement(finalSqlStmnt);
    }
    
}
