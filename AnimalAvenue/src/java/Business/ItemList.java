package Business;

import java.util.ArrayList;

/**
 * 
 * @author Jacob Miller
 */
public class ItemList {
    
    //Properties
    int count = 0;
    double total;
    ArrayList<Item> items = new ArrayList<>();

    //Constructors
    /**
     * default constructor (noargs)
     */
    public ItemList() {
        total = 0.00;
    }
    
    //Getters and Setters
    /**
     * 
     * @return int ItemList.count
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
     * @return double ItemList.total
     */
    public double getTotal() {
        return Math.round(total*100.0)/100.0;
    }
    
    /**
     * Sets object total property to provided double parameter
     * @param total 
     */
    public void setTotal(double total) {
        this.total = total;
    }
    
    /**
     * 
     * @return ArrayList<Item> ItemList.items
     */
    public ArrayList<Item> getList() {
        return this.items;
    }
    
    /**
     * Sets object items property to provided Item ArrayList parameter
     * @param I 
     */
    public void setList(ArrayList<Item> I) {
        items = I;
    }
            
    //Utility
    /**
     * Displays current Items in object
     */
    public void display(){
        if (count == 0){
            System.out.println("No Items Found");
        }
        else {
            items.forEach((i) -> {i.display();});
        }

        
    }
    
    /**
     * Adds Item parameter to items property
     * @param item 
     */
    public void add(Item item){
        boolean flag = false;
        int match = 0;
        for (Item I : this.items) {
            if (I.getSku()==item.getSku()) {
                flag = true;
                break;
            }
            match++;
        }
        if (flag&&match<this.count) {
            int newQuan = this.get(match).getQuantity() + item.getQuantity();
            this.get(match).setQuantity(newQuan);
        } else {
            items.add(item);
            count++;
        }
        calculateTotal();
    }
    
    /**
     * Removes Item parameter from items property
     * @param item 
     */
    public void remove(Item item){
        items.remove(item);
        count--;
        calculateTotal();
    }
    
    /**
     * Returns Item at specified index parameter
     * @param index
     * @return Item items[index]
     */
    public Item get(int index){
        return items.get(index);
    }
    
    /**
     * Calculates total based on Item prices in items property
     */
    public void calculateTotal() {
        double newTotal = 0.0;
        for (Item I:items) {
            newTotal += (I.getPrice()*I.getQuantity());
        }
        total = Math.round(newTotal*100.0)/100.0;
    }
    
    public static void main(String args[]) {
        ItemList IL = new ItemList();
        for (Product P: new Data.Seeker().yieldProducts()) {
            IL.add(new Item(P.getSku(), P.getName(), P.getPrice(), P.getStock(), 1));
        }
        Product p = new Product();
        p.selectDB(8000003);
        IL.add(new Item(p.getSku(), p.getName(), p.getPrice(), p.getStock(), 4));
        IL.display();
    }
}