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
    
    private double bill;
    private double gratuity;
    private double tax;
    private double finalBill;
    
    private List entrees = new ArrayList();
    private List sides = new ArrayList();
    private List drinks = new ArrayList();
    
    public List getEntree(String entree){
        
        if (entree.equals("steak")){
            entrees.add(entree);
            bill += 20.00;
            
        } else if (entree.equals("burger")){
            entrees.add(entree);
            bill += 20.00;
            
        } else if (entree.equals("chicken")){
            entrees.add(entree);
            bill += 20.00;
            
        } else if (entree.equals("salad")){
            entrees.add(entree);
            bill += 10.00;
        }
        return entrees;
    }
    
    public List getSides(String side){
        
        if (side.equals("fries")){
            sides.add(side);
            bill += 5.00;
            
        } else if (side.equals("potato")){
            sides.add(side);
            bill += 5.00;
            
        } else if (side.equals("salad")){
            sides.add(side);
            bill += 5.00;
            
        } else if (side.equals("soup")){
            sides.add(side);
            bill += 5.00;
        }
        return sides;
    }
    
    public List getDrinks(String drink){
        
        if (drink.equals("high life")){
            drinks.add(drink);
            bill += 4.00;
            
        } else if (drink.equals("miller lite")){
            drinks.add(drink);
            bill += 4.00;
            
        } else if (drink.equals("blue moon")){
            drinks.add(drink);
            bill += 4.00;
            
        } else if (drink.equals("soda")){
            drinks.add(drink);
            bill += 2.00;
        }
        return drinks;
    }

    /**
     * @return the bill
     */
    public double getBill() {
        return bill;
    }

    /**
     * @return the gratuity
     */
    public double getGratuity() {
        
        gratuity = (getBill() * .10);
        return gratuity;
    }

    /**
     * @return the tax
     */
    public double getTax() {
        return tax;
    }
}