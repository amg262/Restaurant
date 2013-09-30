package model;


import db.MenuItem;
import db.I_DBAccessor;
import db.DataAccessException;
import db.DBGenericAccessor;
import db.I_MenuDAO;
import db.MenuDAO;
import java.sql.SQLException;
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
    public List<MenuItem> getAllMenuItems() throws DataAccessException{
        return menuDAO.retrieveAllMenuItems();
    }
    
    public MenuItem getMenuItemById(String id) throws DataAccessException{
        return menuDAO.retrieveMenuItemById(id);
    }
    
    public void deleteMenuItem(MenuItem item) throws DataAccessException {
        menuDAO.deleteMenuItem(item);
    }
    
    public void saveMenuItem(MenuItem item) throws DataAccessException{
        menuDAO.saveMenuItem(item);
    }
    

    /**
     *
     * @param args
     * @throws DataAccessException
     */
    public static void main(String[] args) throws DataAccessException, SQLException, Exception {
        MenuService ms = new MenuService();
        MenuItem item = new MenuItem();
//        
//        System.out.println("Menu Items: \n");
//        item.setName("test4");
//        item.setDesc("test4");
//        item.setPrice(3.99);
//        item.setCategoryId(3);
//        
//        ms.saveMenuItem(item);
//        System.out.println(item);
        
//        
//        System.out.println("Menu Items: \n");
//        item = ms.getMenuItemById("8");
//        
//        ms.deleteMenuItem("8");
//        
//        System.out.println(item);
        
    }
}
