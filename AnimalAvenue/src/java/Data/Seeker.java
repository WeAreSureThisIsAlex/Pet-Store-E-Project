package Data;

import Business.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Alexander Lawton
 */
public class Seeker {
    private int SIZE;
    private Object[] items;
    
    public Seeker() {
        initializeProperties();
    }
    
    public Object[] getItems() {
        return items;
    }
    
    public void addObject(Object O) {
        SIZE++;
        int count = 0;
        Object[] newObjects = new Object[SIZE];
        for (Object Ob: items) {
            newObjects[count] = Ob;
            count++;
        }
        newObjects[count] = O;
        items = newObjects;
    }
    
    private void initializeProperties() {
        SIZE = 0;
        items = new Object[SIZE];
    }
    
    /**
     * Executes SELECT query and compiles ResultSet data into a String array
     * @param tableName name of DB table
     * @return String array of raw data to be used with unpack methods
     **/
    public ArrayList<String> parse(String tableName) {
        ArrayList<String> test = new ArrayList();
        int columns = 0;
        switch (tableName) {
            case "Orders":
                columns = 3;
                break;
            
            case "OrderContents":
                columns = 3;
                break;
                
            case "Products":
                columns = 4;
                break;
                
            case "Administrators":
                columns = 5;
                break;
                
            case "Customers":
                columns = 6;
                break;
        }
        
        try {
            Access DA = new Access(false);
            String sql = "Select * from " + tableName + ";";
            
            ResultSet R = DA.getStatement().executeQuery(sql);
            while (R.next()) {
                String S = "";
                for (int i = 1;i<=columns;i++) {
                    S += R.getString(i);
                    if (i<columns) {
                        S+= "~";
                    }
                }
                test.add(S);
            }
            
            DA.quietClose();
        }
        catch (Exception ex) {
            System.out.println(ex + ": thrown by Data.Seeker.parse(\"" + tableName + "\")");
        }
        
        return test;
    }
    
    private void unpackOrders() {
        initializeProperties();
        ArrayList<String> ORDERS = parse("Orders");
        for (String S:ORDERS) {
            String[] s = S.split("~", 3);
            Order O = new Order(Integer.parseInt(s[0]), s[1]);
            addObject(O);
        }
    }
    
    private void unpackProducts() {
        initializeProperties();
        ArrayList<String> PRODUCTS = parse("Products");
        for (String S:PRODUCTS) {
            String[] s = S.split("~", 4);
            Product P = new Product(Integer.parseInt(s[0]), s[3], Double.parseDouble(s[1]), Integer.parseInt(s[2]));
            addObject(P);
        }
    }
    
    public Order[] yieldOrders() {
        unpackOrders();
        return Arrays.copyOf(items, items.length, Order[].class);
    }
    
    public Product[] yieldProducts() {
        unpackProducts();
        return Arrays.copyOf(items, items.length, Product[].class);
    }
    
    /**
     * Testing method to return all raw String data for each database table (declared in method body in tables array)
     **/
    public void fullParse() {
        String[] tables = {"Administrators", "Customers", "Orders", "OrderContents", "Products"};
        for (String s:tables) {
            System.out.println(parse(s));
        }
    }
    
    public static void main(String args[]) {
        Seeker S = new Seeker();
        for(Business.Product P : S.yieldProducts()){
            P.display();
        }
    }
}
