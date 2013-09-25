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
    private List<MenuItem> order = new ArrayList<>();
    

    /**
     *
     * @param items
     */
    public OrderCalculator(List<MenuItem> items){
        this.order = items;
    }
    

    /**
     * @return the bill
     */
    public double getBill() {
        for (MenuItem menu : order){
            bill += menu.getPrice();
        }
        return bill;
    }
    

    /**
     *
     * @return
     */
    public double getGratuity(){
        gratuity = bill * 0.165;
        return gratuity;
    }
    
    /**
     * @return the tax
     */
    public double getTax() {
        tax = bill * 0.05;
        return tax;
    }

    /**
     * 
     * @return finalBill
     */
    public double getFinalBill(){
        finalBill = bill + gratuity + tax ;
        return finalBill;
    }
}