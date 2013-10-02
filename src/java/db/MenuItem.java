package db;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy
 */
public class MenuItem {
    
    private int menuItemId;
    private String name;
    private double price;

    /**
     *
     * @param menuItemId
     * @param name
     * @param price
     */
    public MenuItem(int menuItemId, String name, double price) {
        this.menuItemId = menuItemId;
        this.name = name;
        this.price = price;
    }



    /**
     *
     * @param menuItemId
     */
    public MenuItem(int menuItemId) {
        this.menuItemId = menuItemId;
    }
    
    
    /**
     *
     */
    public MenuItem() {}

    /**
     * @return the menuItemId
     */
    public int getMenuItemId() {
        return menuItemId;
    }

    /**
     * @param menuItemId the menuItemId to set
     */
    public void setMenuItemId(int menuItemId) {
        this.menuItemId = menuItemId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    
    

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.menuItemId;
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MenuItem other = (MenuItem) obj;
        if (this.menuItemId != other.menuItemId) {
            return false;
        }
        return true;
    }
    
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Menu Item \n{\n" + "menuItemId=" + menuItemId
                + "\n name=" + name + 
                "\n price=" + price
                + "\n}\n";
    }
}
