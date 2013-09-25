/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.MenuItem;

/**
 *
 * @author Andy
 */
public class MenuDAO implements I_MenuDAO {
    
    private static final String RETRIEVE_ALL_MENU_ITEMS =
            "Select menu_item.menu_item_id, menu_item.name, menu_item.desc, menu_item.price, category.type "
            + " from menu_item join category on menu_item.category_id = category.category_id ; "; 
    

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
            
            String type = map.get("type").toString();
            menu.setType(type);

            
            records.add(menu);

        }
        
        return records;
    }

    @Override
    public MenuItem retrieveMenuItemById(String id) throws DataAccessException {
        this.openLocalDBConn();
        
        Map record;
        
        try {
            record = db.retrieveRecordByID("MENU_ITEM", "MENU_ITEM_ID", new Integer(id), true);
        } catch (SQLException sqle){
            throw new DataAccessException(sqle.getMessage(), sqle);
        } catch (Exception e) {
            throw new DataAccessException(e.getMessage(), e);
        }
        
        MenuItem item = new MenuItem();
        item.setMenuItemId(new Integer(record.get(id).toString()));
        item.setName(record.get("NAME").toString());
        item.setDesc(record.get("DESC").toString());
        item.setPrice(new Double(record.get("PRICE").toString()));
        item.setCategoryId(new Integer(record.get("CATEGORY_ID").toString()));
        
        return item;
    }

    @Override
    public void saveMenuItem(MenuItem item) throws DataAccessException  {
        
        
    }

    @Override
    public void deleteMenuItem(MenuItem item) throws DataAccessException  {
        this.openLocalDBConn();
        
        try {
            
            db.deleteRecords("menu_item", "menu_item_id", item.getMenuItemId(), true);
            
        } catch (SQLException sqle){
            throw new DataAccessException(sqle.getMessage(), sqle);
        } catch (Exception e) {
            throw new DataAccessException(e.getMessage(), e);
        }
        
    }


    
    
}
