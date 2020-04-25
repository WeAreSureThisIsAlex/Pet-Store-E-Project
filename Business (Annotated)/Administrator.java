package Business;

import Data.Access;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author Neal Valdez
 */
public class Administrator extends PersonObj {
    
    //Constructors
    /**
     * no-args constructor
     */
    public Administrator() {
        //call overloaded constructor
        this("", "", "", "", "", "");
    }    
    //
    /**
     * full-args constructor
     * @param Id
     * @param fname
     * @param lname
     * @param email
     * @param password
     * @param address 
     */
    public Administrator(String Id, String fname, String lname, String email,  String password, String address) {
       
        //call super constructor
        super(Id, fname, lname, email, password, address);
    }

    //Database access methods
    //
    /**
     * Select Administrator data from database and populate object with it
     * @param ID 
     */
    @Override
    public void selectDB(String ID) {
        
        try {
            Access databaseAccess = new Access();
            
            //setup statement and execute it
            String sql = "select * from Administrators WHERE ID = '" + ID + "'";
            ResultSet rs = databaseAccess.getStatement().executeQuery(sql);
            
            rs.next();
            
            //set properties
            setId(rs.getString(1));
            setPw(rs.getString(2));
            setFname(rs.getString(3));
            setLname(rs.getString(4));
            setAddress(rs.getString(5));
            setEmail(rs.getString(6)); 
            
            //debug some info to console
            System.out.println("Administrator " + ID + " Successfully selected" + System.lineSeparator());
            
            //close connection
            databaseAccess.close();                        
        } 
        catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Exception caught - " + ex + System.lineSeparator());
        }
    }
    //
    /**
     * Insert current Administrator Object properties into database
     */
    @Override
    public void insertDB() {
        
        try {
             Access databaseAccess = new Access();
            
            //setup statment
            String sql = "INSERT INTO Administrators " +
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
            
            databaseAccess.close();

        }

        catch (ClassNotFoundException | SQLException e){
            System.out.println("Exception caught - " + e + System.lineSeparator());
        }
    }
    //
    /**
     * Delete populated Administrator Object from database (uses current Customer ID) and initializes Object data
     */
    @Override
    public void deleteDB() {
        
        try{
            Access databaseAccess = new Access();
            
            //setup statment
            String sql = "DELETE FROM Administrators WHERE ID = " + getId();          
            
            //execute Deletion                                               
            int num = databaseAccess.getStatement().executeUpdate(sql);
            
            //deal with result
            if (num == 1){
                //debug to console
                System.out.println("Deletion successful!" + System.lineSeparator());
                //reset properties to blank values
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
        } 
        catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Exception caught - " + ex + System.lineSeparator());
        }   
    }
}