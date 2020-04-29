/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import Business.Product;
/**
 *
 * @author Alex (School)
 */
public class ProductPanel {
    private String html;
    private final int DEFAULT_SKU = 1000000;
    private final String DEFAULT_NAME = "(product name)";
    private final String DEFAULT_DESCRIPTION = "(product description)";
    private final double DEFAULT_PRICE = 19.99;
    private final int DEFAULT_STOCK = 50;
    
    public ProductPanel() {
        html = "<form action=\"../cartHandler?action=" + DEFAULT_SKU + "\" method=\"post\">" +
               "<div class=\"content\">" +
               "<img id=\"product-img\"src=\"../pictures/" + DEFAULT_SKU + ".jpg\" alt=\"" + DEFAULT_NAME + "\">" +
               "<div id=\"product-modal\" class=\"modal\">" +
               "<span class=\"close\">&times;</span>" +
               "<img class=\"modal-content\" id=\"modal-img\">" +
               "<div id=\"caption\">" +
               "<p class=\"product-description\">" + DEFAULT_DESCRIPTION + "</p>" +
               "</div>" +
               "</div>" +
               "<h3>" + DEFAULT_NAME + "</h3>" +
               "<h6>$" + DEFAULT_PRICE + "</h6>" +
               "<button type=\"submit\" class=\"add-button\"> <img src=\"../pictures/add_button.png\" alt=\"+\"> Add to Cart</button>" +
               "</div>" +
               "</form>";
    }
    
    public ProductPanel(Product Pr) {
        this(Pr.getSku(), Pr.getName(), Pr.getPrice(), Pr.getStock());
        System.out.println("Confirm error");
    }
    
    public ProductPanel(int sku, String name, double price, int stock) {
        html = "<form action=\"../cartHandler?action=" + sku + "\" method=\"post\">" +
               "<div class=\"content\">" +
               "<img id=\"product-img\"src=\"../pictures/" + sku + ".jpg\" alt=\"" + name + "\">" +
               "<div id=\"product-modal\" class=\"modal\">" +
               "<span class=\"close\">&times;</span>" +
               "<img class=\"modal-content\" id=\"modal-img\">" +
               "<div id=\"caption\">" +
               "<p class=\"product-description\">" + DEFAULT_DESCRIPTION + "</p>" +
               "</div>" +
               "</div>" +
               "<h3>" + name + "</h3>" +
               "<h6>$" + price + "</h6>" +
               "<button type=\"submit\" class=\"add-button\"> <img src=\"../pictures/add_button.png\" alt=\"+\"> Add to Cart</button>" +
               "</div>" +
               "</form>";
    }
    
    public String yield() {
        return html;
    }
}
