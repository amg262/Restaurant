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
    
    private static final String RETRIEVE_ENTREES = 
            "Select menu_item.menu_item_id, menu_item.name, menu_item.desc, menu_item.price, menu_item.category_id, category.type"
            + " from menu_item join category on menu_item.category_id = category.category_id  "
            + " where category.category_id = '1' ; "; 
            
    private static final String RETRIEVE_SIDES = 
            "Select menu_item.menu_item_id, menu_item.name, menu_item.desc, menu_item.price, menu_item.category_id, category.type"
            + " from menu_item join category on menu_item.category_id = category.category_id  "
            + " where category.category_id = '2' ; "; 
        
    private static final String RETRIEVE_DRINKS =
            "Select menu_item.menu_item_id, menu_item.name, menu_item.desc, menu_item.price, menu_item.category_id, category.type"
            + " from menu_item join category on menu_item.category_id = category.category_id  "
            + " where category.category_id = '3' ; "; 
    
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
     * @return
     * @throws DataAccessException
     */
    @Override
    public List<Menu> retrieveEntrees() throws DataAccessException {
        this.openLocalDBConn();
        
        List<Map> rawData = new ArrayList<>();
        List<Menu> records = new ArrayList<>();
        
        try {
            rawData = db.retrieveRecords(RETRIEVE_ENTREES, true);
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
            
            
            String name = map.get("name").toString();
            menu.setName(name);
            
            String desc = map.get("desc").toString();
            menu.setDesc(desc);
            
            String price = map.get("price").toString();
            menu.setPrice(new Double (price));

            records.add(menu);
        }
        return records;
    }

    /**
     *
     * @return
     * @throws DataAccessException
     */
    @Override
    public List<Menu> retrieveSides() throws DataAccessException {
            this.openLocalDBConn();
        
        List<Map> rawData = new ArrayList<>();
        List<Menu> records = new ArrayList<>();
        
        try {
            rawData = db.retrieveRecords(RETRIEVE_SIDES, true);
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
            
            
            String name = map.get("name").toString();
            menu.setName(name);
            
            String desc = map.get("desc").toString();
            menu.setDesc(desc);
            
            String price = map.get("price").toString();
            menu.setPrice(new Double (price));

            records.add(menu);
        }
        return records;
    }

    /**
     *
     * @return
     * @throws DataAccessException
     */
    @Override
    public List<Menu> retrieveDrinks() throws DataAccessException {
            this.openLocalDBConn();
        
        List<Map> rawData = new ArrayList<>();
        List<Menu> records = new ArrayList<>();
        
        try {
            rawData = db.retrieveRecords(RETRIEVE_DRINKS, true);
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
            
            
            String name = map.get("name").toString();
            menu.setName(name);
            
            String desc = map.get("desc").toString();
            menu.setDesc(desc);
            
            String price = map.get("price").toString();
            menu.setPrice(new Double (price));

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
        
        List<Menu> records = dao.retrieveSides();
        System.out.println("Menu Records: \n");
        for (Menu m : records){
            System.out.println(m);
        }
    }
}

