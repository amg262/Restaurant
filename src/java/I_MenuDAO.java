
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
    
    public abstract void openLocalDBConn() throws DataAccessException;
    public abstract List<Menu> retrieveAllMenuItems() throws DataAccessException;
    public abstract List<Menu> retrieveEntrees() throws DataAccessException;
    public abstract List<Menu> retrieveSides() throws DataAccessException;
    public abstract List<Menu> retrieveDrinks() throws DataAccessException;
}
