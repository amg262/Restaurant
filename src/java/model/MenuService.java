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
public class MenuService {
    
    private I_MenuDAO menuDAO;

    /**
     *
     */
    public MenuService() {
        I_DBAccessor db = new DBGenericAccessor();
        menuDAO = new MenuDAO(db);
    }
    
    /**
     *
     * @return
     * @throws DataAccessException
     */
    public List<Menu> getAllMenuItems() throws DataAccessException{
        return menuDAO.retrieveAllMenuItems();
    }
    
    /**
     *
     * @return
     * @throws DataAccessException
     */
    public List<Menu> getEntrees() throws DataAccessException{
        return menuDAO.retrieveEntrees();
    }
    
    /**
     *
     * @return
     * @throws DataAccessException
     */
    public List<Menu> getSides() throws DataAccessException{
        return menuDAO.retrieveSides();
    }
    
    /**
     *
     * @return
     * @throws DataAccessException
     */
    public List<Menu> getDrinks() throws DataAccessException{
        return menuDAO.retrieveDrinks();
    }
    
    
    /**
     *
     * @param args
     * @throws DataAccessException
     */
    public static void main(String[] args) throws DataAccessException {
        MenuService ms = new MenuService();
        
        System.out.println("Menu Items: \n");
        System.out.println(ms.getAllMenuItems());
        
    }
    
    
    
    
    
}
