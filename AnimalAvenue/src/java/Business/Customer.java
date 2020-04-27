package Business;

import Data.Access;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author Neal Valdez
 */
public class Customer extends PersonObj {
    
    //Properties
    String cardInfo;
    
    //Constructors
    /**
     * no-args constructor
     */
    public Customer() {
        
        //call overloaded constructor
        this("", "", "", "", "", "", "");
    }    
    
    /**
     * full-args constructor
     * @param Id
     * @param fname
     * @param lname
     * @param email
     * @param password
     * @param address
     * @param cardInfo 
     */
    public Customer(String Id, String fname, String lname, String email, String password, String address, String cardInfo) {
        
        //call super constructor
        super(Id, fname, lname, email, password, address);
        
        this.cardInfo = cardInfo;
        
    }     

    //Getters and Setters
    /**
     * 
     * @return String Customer.cardInfo
     */
    public String getCardInfo() {
        return cardInfo;
    }

    /**
     * Sets object cardInfo property to provided String parameter
     */
    public void setCardInfo(String cardInfo) {
        this.cardInfo = cardInfo;
    }
           
    //Database access methods
    /**
     * Select Customer data from database and populate object with it
     * @param ID 
     */
    @Override
    public void selectDB(String ID) {
        try{
            Access databaseAccess = new Access();
            
            //execute statment
            String sql = "select CustomerID, Password, FirstName, LastName, Address, PaymentCard from Customers WHERE CustomerID = '" + ID + "'";             
            ResultSet result = databaseAccess.getStatement().executeQuery(sql);            

            result.next();
            
            //set properties
            setId(result.getString(1));
            setPw(result.getString(2));
            setFname(result.getString(3));
            setLname(result.getString(4));
            setAddress(result.getString(5));
            setEmail("");                        
            
            System.out.println("Customer " + ID + " Successfully selected" + System.lineSeparator());
            
            databaseAccess.close();            
        } 
        catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Exception caught - " + ex + System.lineSeparator());
        }
    }

    /**
     * Insert data from populated Customer object into table
     */
    @Override
    public void insertDB() {
        try{
            Access databaseAccess = new Access();
            
            //setup statment
            String sql = "INSERT INTO Customers " +
                         "VALUES ('" + getId()+ "', '" + getPw()+ "', '" + getFname()+ "', '" + getLname()+ "', '" + getAddress()+ "', '" + getEmail()+ "')";             
            
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
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Exception caught - " + ex + System.lineSeparator());
        }
    }

    @Override
    /**
     * Delete populated Customer object data from table and reset Customer object data
     */
    public void deleteDB() {
       try{
            Access databaseAccess = new Access();
            
            //setup statment
            String sql = "DELETE FROM Customers WHERE CustID = " + getId(); 
                     
            //execute Deletion                         
            int num = databaseAccess.getStatement().executeUpdate(sql);
            
            //deal with result
            if (num == 1){
                //debug to console
                System.out.println("Deletion successful!" + System.lineSeparator());
                
                //reset properties
                this.setId("");
                this.setPw("");
                this.setFname("");
                this.setLname("");
                this.setAddress("");
                this.setEmail("");
            }else {
                //debug to console
                System.out.println("Deletion failed!" + System.lineSeparator());
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Exception caught - " + ex + System.lineSeparator());
        }
    }
    //add display override
    
    public static void main(String args[]) {
        Customer C = new Customer();
        C.selectDB("C001");
        C.display();
    }
}