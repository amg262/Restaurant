package dbaccess;


import model.MenuItem;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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

}
