/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy
 */
public class Menu {
    
    private int menuItemId;
    private int categoryId;
    private String name;
    private String desc;
    private double price;
    private String type;

    public Menu(int menuItemId, int categoryId, String name, String desc, double price, String type) {
        this.menuItemId = menuItemId;
        this.categoryId = categoryId;
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.type = type;
    }

    public Menu(int menuItemId, int categoryId) {
        this.menuItemId = menuItemId;
        this.categoryId = categoryId;
    }
    
    public Menu(int categoryId) {
        this.categoryId = categoryId;
    }
    
    public Menu() {}

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
     * @return the categoryId
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
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
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.menuItemId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Menu other = (Menu) obj;
        if (this.menuItemId != other.menuItemId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Menu{" + "menuItemId=" + menuItemId
                + ", categoryId=" + categoryId
                + ", name=" + name + ", desc="
                + desc + ", price=" + price + '}';
    }

    
    
}
