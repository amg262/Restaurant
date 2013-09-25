package model;


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
            "Select menu_item.menu_item_id, menu_item.name, menu_item.desc, menu_item.price, category.category_id, category.type"
            + " from menu_item join category on menu_item.category_id = category.category_id  "; 
    

    private I_DBAccessor db;
            
    
    /**
     *
     */
    public MenuDAO() {}
    
    /**
     *
     * @param db
     */
    public MenuDAO(I_DBAccessor db){
        this.db = db;
    }
            
    /**
     *
     * @throws DataAccessException
     */
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
    


    /**
     *
     * @return
     * @throws DataAccessException
     */
    @Override
    public List<MenuItem> retrieveAllMenuItems() throws DataAccessException {
        this.openLocalDBConn();
        
        List<Map> rawData = new ArrayList<>();
        List<MenuItem> records = new ArrayList<>();
        
        try {
            rawData = db.retrieveRecords(RETRIEVE_ALL_MENU_ITEMS, true);
        } catch (SQLException sqle){
            throw new DataAccessException (sqle.getMessage(), sqle);
        } catch (Exception e){
            throw new DataAccessException (e.getMessage(), e);
        }
        
        MenuItem menu = null;
        
        for (Map map : rawData){
            menu = new MenuItem();
            
            String menu_item_id = map.get("menu_item_id").toString();
            menu.setMenuItemId(new Integer(menu_item_id));
            
            
            String name = map.get("name").toString();
            menu.setName(name);
            
            String desc = map.get("desc").toString();
            menu.setDesc(desc);
            
            String price = map.get("price").toString();
            menu.setPrice(new Double (price));
            
            String category_id = map.get("category_id").toString();
            menu.setCategoryId(new Integer(category_id));
            
            String type = map.get("type").toString();
            menu.setType(type);
            
            records.add(menu);
        }
        
        return records;
    }


    
    
    /**
     *
     * @param args
     * @throws DataAccessException
     */
    public static void main(String[] args) throws DataAccessException {
        I_MenuDAO dao = new MenuDAO(new DBGenericAccessor());
        
        dao.openLocalDBConn();
        
        List<MenuItem> records = dao.retrieveAllMenuItems();
        System.out.println("Menu Records: \n");
        for (MenuItem m : records){
            System.out.println(m);
        }
    }
}

