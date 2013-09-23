
import java.sql.SQLException;
import java.util.ArrayList;
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
public class MenuDAO implements I_MenuDAO {

    private static final String RETRIEVE_ALL_MENU_ITEMS =
            "SELECT name"
            + ", menu_item.desc, menu_item.price"
            + "from menu_item;";
    
    private static final String RETRIEVE_MENU_ITEMS_BY_CATEGORY_ID =
            "select menu_item.menu_item_id\n" +
            ", menu_item.name" +
            ", menu_item.desc" +
            ", menu_item.price" +
            ", category.category_id" +
            ", category.type\n" +
            "from menu_item join category on menu_item.category_id = category.category_id" +
            "where category.category_id = ";
    
    
    private I_DBAccessor db;
            
    
    public MenuDAO() {}
    
    public MenuDAO(I_DBAccessor db){
        this.db = db;
    }
            
    @Override
    public void openLocalDBConn() throws DataAccessException {
        try {
            db.openConnection(
                    "com.mysql.jdbc.Driver",
                    "jdbc:mysql://localhost:3306/menu",
                    "root", "root"); 
        } catch (IllegalArgumentException iae){
            throw new DataAccessException (iae.getMessage(), iae);
        } catch (ClassNotFoundException cnfe){
            throw new DataAccessException (cnfe.getMessage(), cnfe);
        } catch (SQLException sqle){
            throw new DataAccessException (sqle.getMessage(), sqle);
        }
    }
    

    @Override
    public Menu retrieveMenuItemById(String id) throws DataAccessException {
        this.openLocalDBConn();
        
        List<Map> rawData = new ArrayList<>();
        //List
        
        
        return null;
    }

    @Override
    public List<Menu> retrieveAllMenuItems() throws DataAccessException {
        this.openLocalDBConn();
        
        List<Map> rawData = new ArrayList<>();
        List<Menu> records = new ArrayList<>();
        
        try {
            rawData = db.retrieveRecords(RETRIEVE_ALL_MENU_ITEMS, true);
        } catch (SQLException sqle){
            throw new DataAccessException (sqle.getMessage(), sqle);
        } catch (Exception e){
            throw new DataAccessException (e.getMessage(), e);
        }
        
        Menu menu = null;
        
        for (Map map : rawData){
            menu = new Menu();
            
            String menu_item_id = map.get("menu_item_id").toString();
            menu.setMenuItemId(new Integer(menu_item_id));
            
            String category_id = map.get("category.category_id").toString();
            menu.setCategoryId(new Integer(category_id));
            
            
            String name = map.get("name").toString();
            menu.setName(name);
            
            String desc = map.get("desc").toString();
            menu.setDesc(desc);
            
            String price = map.get("price").toString();
            menu.setPrice(new Double (price));
            
            
            String type = map.get("category.type").toString();
            menu.setType(type);
            
            records.add(menu);
        }
        
        return records;
    }
 
    
    public static void main(String[] args) throws DataAccessException {
        I_MenuDAO dao = new MenuDAO(new DBGenericAccessor());
        
        dao.openLocalDBConn();
        
        List<Menu> records = dao.retrieveAllMenuItems();
        System.out.println("Menu Records: \n");
        for (Menu m : records){
            System.out.println(m);
        }
    }
}
