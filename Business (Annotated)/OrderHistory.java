package Business;

import Data.Access;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * 
 * @author Jacob Miller
 */
public class OrderHistory {
    
    //Properties
    int count;
    ArrayList<Order> orders;

    //Constructors
    /**
     * default constructor (noargs)
     */
    public OrderHistory() {
        this.orders = new ArrayList<Order>();
        this.count = 0;
    }                 	

    //Getters and Setters
    /**
     * 
     * @return int OrderHistory.count
     */
    public int getCount() {
        return count;
    }
    
    /**
     * Sets object count property to provided int parameter
     * @param count 
     */
    public void setCount(int count) {
        this.count = count;
    }
    
    /**
     * 
     * @return ArrayList(Order) OrderHistory.orders
     */
    public ArrayList<Order> getOrders() {
        return orders;
    }
    
    /**
     * Sets object orders parameter to provided ArrayList(Order) parameter
     * @param orders 
     */
    public void setOrders(ArrayList<Order> orders) {
            this.orders = orders;
    }

    //Utility
    /**
     * Add provided Order parameter to orders property
     * @param order 
     */
    public void addOrder(Order order) {
        orders.add(order);
        count++;
    }
    
    /**
     * Remove provided Order parameter from orders property
     * @param order 
     */
    public void removeOrder(Order order){
        orders.remove(order);
        count--;
    }
    
    /**
     * Displays current OrderHistory data
     */
    public void display() {
        
        System.out.println("   Order History   " + System.lineSeparator() +
                           "=========================" + System.lineSeparator());
        if (count == 0){
            System.out.println("No Orders Found");
        }
        else {
            orders.forEach((O) -> {
                O.display();
            });
        }
        System.out.println("=========================");
    }

    //DB methods
    /**
     * Fills object orders property with data from table using provided String parameter as a query condition
     * @param custID 
     */
    public void retrieveOrdersDB(String custID){
        try {
            Access databaseAccess = new Access();
            
            //setup statement and execute it
            String sql = "select * from Orders WHERE CustomerID = '" + custID + "';";
            ResultSet rs = databaseAccess.getStatement().executeQuery(sql);
            
             //geal with results
            while(rs.next()){
                //create new order object to manipulate data
                Order o = new Order();       
                
                //set properties
                o.setCustID(custID);
                o.setOrderNo(rs.getInt(1));
                o.retrieveOrderContentsDB();

                //add order object to orders list
                addOrder(o);
            }
            
            //debug some info to console
            System.out.println("Orders for " + custID + " Successfully selected" + System.lineSeparator());
            
            //close connection
            databaseAccess.close();                        
        } 
        catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Exception caught - " + ex + System.lineSeparator());
        }
    }
    
    public static void main(String args[]) {
        OrderHistory OH = new OrderHistory();
        OH.retrieveOrdersDB("C001");
        OH.display();
    }
}