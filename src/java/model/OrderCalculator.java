/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author agunn1
 */
public class OrderCalculator {
    
    private double bill = 0;
    private double gratuity = 0;
    private double tax = 0;
    private double finalBill = 0;
    private List<Menu> order = new ArrayList<>();
    
    /**
     *
     */
    public OrderCalculator() {}
    
    /**
     *
     * @param items
     */
    public OrderCalculator(List<Menu> items){
        this.order = items;
    }
    

    /**
     * @return the bill
     */
    public double getBill() {
        for (Menu menu : order){
            bill += menu.getPrice();
        }
        return bill;
    }
    

    /**
     * @return the gratuity
     */
    public double getGratuity() {
        gratuity = getBill() * .165;
        //return getBill() * .165
        return gratuity;
    }

    /**
     * @return the tax
     */
    public double getTax() {
        tax = getBill() * .055;
        //return getBill() * .055
        return tax;
    }

    /**
     * 
     * @return finalBill
     */
    public double getFinalBill(){
        finalBill = getBill() + getGratuity() + getTax();
        return finalBill;
    }
}