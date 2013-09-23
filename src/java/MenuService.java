
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

    public MenuService() {
        I_DBAccessor db = new DBGenericAccessor();
        menuDAO = new MenuDAO(db);
    }
    
    public List<Menu> getAllMenuItems() throws DataAccessException{
        return menuDAO.retrieveAllMenuItems();
    }
    
    
    public static void main(String[] args) throws DataAccessException {
        MenuService ms = new MenuService();
        
        System.out.println("Menu Items: \n");
        System.out.println(ms.getAllMenuItems());
        
    }
    
    
    
    
    
}
