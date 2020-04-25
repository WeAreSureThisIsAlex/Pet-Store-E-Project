/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 * 
 * @author Jacob Miller
 */
public class Item extends Product {
	
    //Properties
    int quantity;
   
    //Constuctors
    /**
     * noargs constructor
     */
    public Item() {
        this(0, "", 0.00, 0, 1);
    }
    
    /**
     * fullargs constructor
     * @param SKU
     * @param name
     * @param price
     * @param stock
     * @param quantity 
     */
    public Item(int SKU, String name, double price, int stock, int quantity) {
        
        super(SKU, name, price, stock);
        this.quantity = quantity;
    }
    
    //Getters and Setters    
    /**
     * 
     * @return int Item.quantity
     */
    public int getQuantity() {
        return quantity;
    }
    
    /**
     * Sets object quantity property to provided int parameter
     * @param quantity 
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    /**
     * Displays current object data
     */
    public void display() {
        super.display();
        System.out.println("x" + quantity + "\n");
    }
    
    public static void main(String args[]) {
        Product P = new Product();
        P.selectDB(8000001);
        Item I = new Item(P.getSku(), P.getName(), P.getPrice(), P.getStock(), 1);
        I.display();
    }
}