package Business;

/**
 * 
 * @author Neal Valdez
 */
class Cart {
    
    //Properties
    String custID;
    ItemList items;
    double total = 0;
    
    //Constructors
    /**
     * no-args constructor
     */
    public Cart() {
            this("", new ItemList());
    }
    //
    /**
     * full-args constructor
     * @param custID
     * @param items 
     */
    public Cart(String custID, ItemList items) {
            this.custID = custID;
            this.items = items;
    }

    //Getters and Setters
    /**
     * 
     * @return String Cart.custID
     */
    public String getCustID() {
        return custID;
    }
    
    /**
     * Sets object custID property to provided String parameter
     * @param custID 
     */
    public void setCustID(String custID) {
        this.custID = custID;
    }
    
    /**
     * 
     * @return ItemList Cart.items
     */
    public ItemList getItems() {
        return items;
    }
    
    /**
     * Sets object items property to provided ItemList parameter
     * @param items 
     */
    public void setItems(ItemList items) {
        this.items = items;
    }
    //
    /**
     * 
     * @return double total
     */
    public double getTotal() {
        return total;
    }
    //
    public void setTotal(double total) {
        this.total = total;
    }
    
    //Utility
    /**
     * Adds Item object to Cart's ItemList and updates total
     * @param item 
     */
    public void addItem(Item item){
        items.add(item);
        total = items.getTotal();
    }
    
    /**
     * Creates Order object from cart and inserts to db i.e. checkout
     * @param custID 
     */
    public void placeOrder(String custID) {
            //creates Order object based on current cart
            Order order = new Order(custID, getItems());
            //inserts new order into DB
            order.insertDB();
    }
    /**
     * Displays Cart information, including ItemList information, to console
     */
    public void display() {
        System.out.println("   Cart Information   " + System.lineSeparator() +
                           "=========================" + System.lineSeparator() +
                           "Customer ID: " + getCustID() + System.lineSeparator() + 
                           "Cart Total: " + getTotal()+ System.lineSeparator());
        items.display();
    }
}