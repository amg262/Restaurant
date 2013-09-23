package model;


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
    public abstract List<Menu> retrieveAllMenuItems() throws DataAccessException;
    /**
     *
     * @return
     * @throws DataAccessException
     */
    public abstract List<Menu> retrieveEntrees() throws DataAccessException;
    /**
     *
     * @return
     * @throws DataAccessException
     */
    public abstract List<Menu> retrieveSides() throws DataAccessException;
    /**
     *
     * @return
     * @throws DataAccessException
     */
    public abstract List<Menu> retrieveDrinks() throws DataAccessException;
}
