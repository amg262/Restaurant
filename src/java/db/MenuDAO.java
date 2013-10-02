/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Andy
 */
public class MenuDAO implements I_MenuDAO {
    
    private static final String RETRIEVE_ALL_MENU_ITEMS =
            "Select * "
            + " from menu_item ; "; 
    

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
                    "jdbc:mysql://localhost:3306/restaurant_menu",
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

            
            String price = map.get("price").toString();
            menu.setPrice(new Double (price));

            
            records.add(menu);

        }
        
        return records;
    }

    /**
     *
     * @param id
     * @return
     * @throws DataAccessException
     */
    @Override
    public MenuItem retrieveMenuItemById(String id) throws DataAccessException {
        this.openLocalDBConn();
        
        Map record;
        
        try {
            record = db.retrieveRecordByID("menu_item", "menu_item_id", new Integer(id), true);
        } catch (SQLException sqle){
            throw new DataAccessException(sqle.getMessage(), sqle);
        } catch (Exception e) {
            throw new DataAccessException(e.getMessage(), e);
        }
        
        MenuItem item = new MenuItem();

        item.setMenuItemId(new Integer(record.get("menu_item_id").toString()));
        item.setName(record.get("name").toString());
        item.setPrice(new Double(record.get("price").toString()));
        
        return item;
    }

    /**
     *
     * @param item
     * @throws DataAccessException
     */
    @Override
    public void saveMenuItem(MenuItem item) throws DataAccessException  {
        this.openLocalDBConn();
        
        List<String> fields;
        List values;
        String tableName = "menu_item";
        
        
        fields = new ArrayList<>();
        fields.add("name");
        fields.add("price");
        
        values = new ArrayList();
        values.add(item.getName());
        values.add(item.getPrice());
        
        try {
            if (item.getMenuItemId() == 0){
                db.insertRecord(tableName, fields, values, true);
                
            } else {
                db.updateRecords(tableName, fields, values, "menu_item_id", item.getMenuItemId(), true);
            }
        } catch (SQLException sqle){
            throw new DataAccessException(sqle.getMessage(), sqle);
        } catch (Exception e){
            throw new DataAccessException(e.getMessage(), e);
        }

    }

    /**
     *
     * @param item
     * @throws DataAccessException
     */
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
//
//
//    public static void main(String[] args) throws DataAccessException {
//        
//        MenuDAO dao = new MenuDAO(new DBGenericAccessor() );
//        MenuItem item = new MenuItem();
//        List<MenuItem> list = new ArrayList();
//        
////        dao.openLocalDBConn();
////       // item.setMenuItemId(8);
////        item.setName("delete this");
////        item.setPrice(1.99);
////        
////        dao.openLocalDBConn();
////        dao.saveMenuItem(item);
//        
//        dao.openLocalDBConn();
//        item = dao.retrieveMenuItemById("10");
//        dao.deleteMenuItem(item);
//        
//        System.out.println(item.toString());
//
//    }
    
}
