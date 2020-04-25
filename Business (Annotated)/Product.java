package Business;

import java.sql.*;

/**
 *
 * @author Alexander Lawton
 */
public class Product {
    //Properties
    protected int sku;
    protected String name;
    protected double price;
    protected int stock;

    //Constructors
    /**
     * noargs consturctor
     */
    public Product() {
        initializeProperties();
    }

    /**
     * fullargs constructor
     * @param sku
     * @param name
     * @param price
     * @param stock 
     */
    public Product(int sku, String name, double price, int stock) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    /**
     * 
     * @return int Product.sku
     */
    public int getSku() {
        return sku;
    }

    /**
     * 
     * @return String Product.name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @return double Product.price
     */
    public double getPrice() {
        return price;
    }

    /**
     * 
     * @return int Product.stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * Sets object sku property to provided int parameter
     * @param sku 
     */
    public void setSku(int sku) {
        this.sku = sku;
    }

    /**
     * Sets object name property to provided String parameter
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets object price property to provided double parameter
     * @param price 
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Sets object stock property to provided int parameter
     * @param stock 
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Sets all object data to default values
     */
    private void initializeProperties() {
        this.sku = 0;
        this.name = "";
        this.price = 0.00;
        this.stock = 0;
    }

    /**
     * Adds specified amount to object stock property and updates Product in database
     * @param amount 
     */
    public void addProduct(int amount) {
        if (amount < 1) {
            System.out.println("Must add positive stock");
        }
        else {
            this.stock += amount;
            updateDB();
        }
        //updateDB(), uses s for sku
    }

    /**
     * Removes specified amount from object stock property and updates Product in database
     * @param amount 
     */
    public void removeProduct(int amount) {
        this.stock -= amount;
        if (this.stock<0) {
            System.out.println("Cannot have negative inventory");
        }
        else {
            updateDB();
        }
    }

    /**
     * Selects data from table and populates Product object
     * @param sku 
     */
    public void selectDB(int sku) {
        //SKUs start at 8000001
        try {
            Data.Access DA = new Data.Access();
            String sql = "Select * from Products where SKU=" + sku + ";";
            
            ResultSet rs = DA.getStatement().executeQuery(sql);
            System.out.println("Statement executed");
            while (rs.next()) {
                setSku(rs.getInt(1));
                setPrice(rs.getDouble(2));
                setStock(rs.getInt(3));
                setName(rs.getString(4));
            }
            
            DA.close();
        }
        catch (Exception ex) {
            System.out.println(ex + ": thrown by Business.Product.selectDB(" + sku + ")");
        }
    }

    /**
     * Inserts populated Product object into table
     */
    public void insertDB() {
        try {
            Data.Access DA = new Data.Access();
            String sql = "Insert into Products (SKU, Price, LeftInStock, ProductName) values(" + this.sku + ", " + this.price + ", " + this.stock + ", \"" + this.name + "\");";
            
            DA.getStatement().executeUpdate(sql);
            System.out.println("Statement executed");
            
            DA.close();
        }
        catch (Exception ex) {
            System.out.println(ex + ": thrown by Business.Product.insertDB()");
        }
    }
    
    /**
     * Updates Product object in table with current data
     */
    public void updateDB() {
        try {
            Data.Access DA = new Data.Access();
            String sql = "Update Products set ProductName = \"" + this.name + "\", Price = " + this.price + ", LeftInStock = " + this.stock + " where SKU = " + this.sku + ";";
            
            DA.getStatement().executeUpdate(sql);
            System.out.println("Statement executed");
            
            DA.close();
        }
        catch (Exception ex) {
            System.out.println(ex+ ": thrown by Business.Product.updateDB()");
        }
    }
    
    /**
     * Deletes Product object from table and initializes object data
     */
    public void deleteDB() {
        try {
            Data.Access DA = new Data.Access();
            String sql = "Delete from Products where SKU = " + this.sku + ";";
            
            DA.getStatement().executeUpdate(sql);
            System.out.println("Statement executed");
            
            DA.close();
            
        }
        catch (Exception ex) {
            System.out.println(ex + ": thrown by Business.Product.deleteDB()");
        }
    }

    /**
     * Displays current object data
     */
    public void display() {
        System.out.println(sku + " | " + name + ": $" + price + " x" + stock);
    }
    
    public static void main(String args[]) {
        Product p2 = new Product();
        p2.selectDB(8000006);
        p2.display();
    }
}
