package Business;

/**
 * 
 * @author Neal Valdez
 */
public abstract class PersonObj {
    
    //Properties
    protected String Id;
    protected String fname;
    protected String lname;
    protected String email;
    protected String pw;
    protected String address; 
    
    //Constructors
    /**
     * noargs constructor
     */
    protected PersonObj() {
        Id = "";
        fname = "";
        lname = "";
        email = "";
        pw = "";
        address = "";   
    }
    
    /**
     * fullargs constructor
     * @param Id
     * @param fname
     * @param lname
     * @param email
     * @param password
     * @param address 
     */
    protected PersonObj(String Id, String fname, String lname, String email, String password, String address){
        this.Id = Id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.pw = password;
        this.address = address;    
    }
    
    //getters and Setters
    /**
     * 
     * @return String Person.Id
     */
    public String getId() {
        return Id;
    }
    
    /**
     * Sets object Id property to provided String parameter
     * @param Id 
     */
    public void setId(String Id) {
        this.Id = Id;
    }
    
    /**
     * 
     * @return String Person.fname
     */
    public String getFname() {
        return fname;
    }
    
    /**
     * Sets object fname property to provided String parameter
     * @param fname 
     */
    public void setFname(String fname) {
        this.fname = fname;
    }
    
    /**
     * 
     * @return String Person.lname
     */
    public String getLname() {
        return lname;
    }

    /**
     * Sets object lname property to provided String parameter
     * @param lname 
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * 
     * @return String Person.email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets object email property to provided String parameter
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @return String Person.pw
     */
    public String getPw() {
        return pw;
    }

    /**
     * Sets object pw property to provided String parameter
     * @param pw
     */
    public void setPw(String pw) {
        this.pw = pw;
    }

    /**
     * 
     * @return String Person.address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets object address property to provided String parameter
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }
        
    //Database access methods
    /**
     * (abstract) Select child object data from database and populate object with data using provided parameter as SQL search condition
     * @param primaryKey 
     */
    public abstract void selectDB(String primaryKey);
    
    /**
     * (abstract) Insert data from populated child object into table
     */
    public abstract void insertDB();     
    
    /**
     * (abstract) Delete populated child object data from table and reset child object data
     */
    public abstract void deleteDB();
    
    //finish method body
    public void display() {
        System.out.println(Id + " | " + fname + " " + lname + " | " + email + " | " + pw + " | " + address);
    }

}