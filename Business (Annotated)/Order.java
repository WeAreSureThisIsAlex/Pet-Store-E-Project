package Business;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author Jacob Miller
 */
public class Order {
    
    //Properties
    private int orderNo;
    private String custNo;
    private ItemList items;
    
    //Constructors
    /**
     * noargs constructor
     */
    public Order() {
        orderNo = 0;
        custNo = "";
        items = new ItemList();
            
    }
    
    /**
     * single-arg constructor
     * @param o 
     */
    public Order(int o) {
        this.orderNo = o;
        this.items = new ItemList();
        retrieveOrderContentsDB();
    }
    //generates its orderNo from DB
    public Order(String custID, ItemList items){
        //gets total from ItemList and fills that property
        //fills orderNo from DB
        this.orderNo = generateOrderNumber();
        
    }
    /*
    public Order(int orderNo, int custID, ItemList items) {
        //gets total from ItemList and fills that property
        this.total = items.getTotal();       
        //fills orderNo from parameters
        this.orderNo = orderNo;
    }        
    */
    //Getters and Setters
    /**
     * 
     * @return int Order.orderNo
     */
    public int getOrderNo() {
        return orderNo;
    }
    
    /**
     * Sets object orderNo property to provided int parameter
     * @param orderNo 
     */
    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }
    
    /**
     * Sets object custNo property to provided String parameter
     * @param custNo 
     */
    public void setCustID(String custNo) {
        this.custNo = custNo;
    }
    
    /**
     * 
     * @return String Order.custNo
     */
    public String getCustID() {
        return custNo;
    }
    
    /**
     * 
     * @return ItemList items
     */
    public ItemList getItems() {
        return items;
    }
    
    //DB methods
    /**
     * Select Order from database and populate object with it
     */
    public void selectDB(int orderNo) {
        try {
            Data.Access databaseAccess = new Data.Access();
            
            //setup statement and execute it
            String sql = "select * from Orders WHERE OrderNo = '" + orderNo + "'";
            ResultSet rs = databaseAccess.getStatement().executeQuery(sql);
            
            rs.next();
            
            //set properties
            setOrderNo(rs.getInt(1));
            setCustID(rs.getString(2));
            
            //populates Items ItemList from ORder contents table
            retrieveOrderContentsDB();
            
            
            //debug some info to console
            System.out.println("Order " + orderNo + " Successfully selected" + System.lineSeparator());
            
            //close connection
            databaseAccess.close();                        
        } 
        catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Exception caught - " + ex + System.lineSeparator());
        }
    }
    
    /**
     * Insert populated Order Object into database
     */
    public void insertDB() {
        try {
             Data.Access databaseAccess = new Data.Access();
            
            //setup statment
            String sql = "INSERT INTO Orders " +
                         "VALUES ('" + getOrderNo()+ "', '" + getCustID()+ "', '" + false + "')";             
            
            //execute insertion                         
            int num = databaseAccess.getStatement().executeUpdate(sql);
            
            //deal with result
            if (num == 1){
                
                //debug to console
                System.out.println("Insert successful!" + System.lineSeparator());
                
            }else {
                //debug to console
                System.out.println("Insert failed!" + System.lineSeparator());
            }
            
            //insert order contents into OrderContents DB
            insertOrderContentsDB();
            
            databaseAccess.close();

        }

        catch (ClassNotFoundException | SQLException e){
            System.out.println("Exception caught - " + e + System.lineSeparator());
        }
    }
    
    /**
     * Delete populated Order Object into database
     */
    public void deleteDB() {
        try{
            Data.Access databaseAccess = new Data.Access();
            
            //setup statment
            String sql = "DELETE FROM Orders WHERE OrderNo = " + getOrderNo();          
            
            //execute Deletion                                               
            int num = databaseAccess.getStatement().executeUpdate(sql);
            
            //deal with result
            if (num == 1){
                //debug to console
                System.out.println("Deletion successful!" + System.lineSeparator());
                //reset properties to blank values
                this.setOrderNo(0);
                this.setCustID("");
                items = new ItemList();
   
            }else {
                //debug to console
                System.out.println("Deletion failed!" + System.lineSeparator());
            }                        
        } 
        catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Exception caught - " + ex + System.lineSeparator());
        }
    }
    
    /**
     * Inserts Order contents into OrderContents Table
     */
    public void insertOrderContentsDB(){
        
        try{
            Data.Access databaseAccess = new Data.Access();
            
            for(int i = 0; i < items.count; i++){
                //set up string
                String sql = "INSERT INTO OrderContents " +
                         "VALUES ('" + items.get(i).getSku() + "', '" + getOrderNo()+ "', '" + items.get(i).getQuantity()+ "')";
                //execute insertion                         
                int num = databaseAccess.getStatement().executeUpdate(sql);

                //deal with result
                if (num == 1){

                    //debug to console
                    System.out.println("Insert successful!" + System.lineSeparator());

                }else {
                    //debug to console
                    System.out.println("Insert failed!" + System.lineSeparator());
                }
            }                        
            
            //debug some info to console
            System.out.println("Order contents for " + getOrderNo() + " Successfully Inserted" + System.lineSeparator());
            
            //close connection
            databaseAccess.close();
            
        }
        catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Exception caught - " + ex + System.lineSeparator());
        }
        
        
    }
    /**
     * retrieves order contents from OrderContents Table
     */
    public void retrieveOrderContentsDB(){
        
        try{
            Data.Access databaseAccess = new Data.Access();
            
            //setup statement and execute it
            String sql = "select * from OrderContents WHERE OrderNumber = " + getOrderNo() + ";";
            ResultSet rs = databaseAccess.getStatement().executeQuery(sql);
            
            //deal with results
            while(rs.next()){
                //create new Item object to get product information from product table
                Product P = new Product();
                P.selectDB(rs.getInt(1));
                Item i = new Item(P.getSku(), P.getName(), P.getPrice(), P.getStock(), rs.getInt(3));
                
                //add item to ItemList
                items.add(i);
            }                     
            
            //debug some info to console
            System.out.println("Order contents for " + getOrderNo() + " Successfully retrieved" + System.lineSeparator());
            
            //close connection
            databaseAccess.close();
            
        }
        catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Exception caught - " + ex + System.lineSeparator());
        }
    }
    
    //Utility Methods
    /**
     * Generates Order Number from DB (Checks max order number and adds 1 to it), 5 digit number beginning with 1
     * @return int resultValue
     */
    private int generateOrderNumber(){
        
        //return value
        int resultValue = 0;
        
        //access DB
        try {
            Data.Access databaseAccess = new Data.Access();
            
            //setup statement and execute it
            String sql = "select MAX(OrderNo) from Orders";
            ResultSet rs = databaseAccess.getStatement().executeQuery(sql);
            
            rs.next();
            
            //use result to generate return OrderNo
            resultValue = rs.getInt(1) + 1;
            
            //debug some info to console
            System.out.println("Orders Successfully selected and OrderNo generated" + System.lineSeparator());
                        
            //close connection
            databaseAccess.close();                        
        } 
        catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Exception caught - " + ex + System.lineSeparator());
        }
        
        return resultValue;
        
    }
    
    /**
     * Displays Order data
     */
    public void display(){
        System.out.println("   Order Information   " + System.lineSeparator() +
                           "=========================");
        items.display();
        System.out.println("\nTotal: $" + items.getTotal());
    }
    
    public static void main(String args[]) {
        Order O = new Order();
        O.setOrderNo(10001);
        O.retrieveOrderContentsDB();
        O.display();
    }
}
