package Data;

import java.sql.*;

/**
 *
 * @author Alexander Lawton
 */
public class Access {
    private String DATABASEPATH = "F:/AnimalAvenue/DB/AA_DB(v0.1).accdb";
    private Connection CONNECTION;
    private Statement STATEMENT;
    
    public Access() throws ClassNotFoundException, SQLException {
        System.out.println("Connecting to database....");
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        CONNECTION = DriverManager.getConnection("jdbc:ucanaccess://" + DATABASEPATH);
        System.out.println("Connected");
        STATEMENT = CONNECTION.createStatement();
    }
        
    public Access(boolean b) throws ClassNotFoundException, SQLException {
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        CONNECTION = DriverManager.getConnection("jdbc:ucanaccess://" + DATABASEPATH);
        STATEMENT = CONNECTION.createStatement();
    }

    public Statement getStatement() {
        return STATEMENT;
    }

    public void close() throws SQLException {
        CONNECTION.close();
        System.out.println("Connection closed.");
    }
        
    public void quietClose() throws SQLException {
        CONNECTION.close();
    }

    //Testing method
    public static void main(String args[]) {
        try {
            Access data = new Access();
            String sql = "Delete * from Products;";

            int i = data.getStatement().executeUpdate(sql);
            //ResultSet rs = data.getStatement().executeQuery(sql);
            System.out.println("Statement executed");
            if (i>0) {
                System.out.println("delete successful");
            }
            else {
                System.out.println("delete failed");
            }
            /*
            while (rs.next()) {
                    System.out.println(rs.getString(2));
            }
            */
            
            data.close();
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }
}