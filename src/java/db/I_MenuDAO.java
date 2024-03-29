/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Andy
 */
public interface I_MenuDAO {
    
    /**
     *
     * @throws DataAccessException
     */
    public abstract void openLocalDBConn() throws DataAccessException;

    /**
     *
     * @return
     * @throws DataAccessException
     */
    public abstract List<MenuItem> retrieveAllMenuItems() throws DataAccessException;
    
    
    /**
     *
     * @param id
     * @return
     * @throws DataAccessException
     */
    public MenuItem retrieveMenuItemById(String id) throws DataAccessException ;
    
    
    /**
     *
     * @param item
     * @throws DataAccessException
     */
    public abstract void saveMenuItem(MenuItem item) throws DataAccessException ;
    
    
    /**
     *
     * @param item
     * @throws DataAccessException
     */
    public abstract void deleteMenuItem(MenuItem item) throws DataAccessException ;
    
    
    
    
}
