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
    private final String DEFAULT_NAME = "Name";
    private final String DEFAULT_DESCRIPTION = "(product description)";
    private final double DEFAULT_PRICE = 19.99;
    private final int DEFAULT_STOCK = 50;
    
    public ProductPanel() {
        html = "<div class=\"column\">" +
               "<div class=\"content\">" +
               "<img id=\"product-img\"src=\"../pictures/cs.png\" alt=\"" + DEFAULT_NAME + "\" height=190px width=190px>" +
               "<div id=\"product-modal\" class=\"modal\">" +
               "<span class=\"close\">&times;</span>" +
               "<img class=\"modal-content\" id=\"modal-img\">" +
               "<div id=\"caption\">" +
               "<p class=\"product-description\">" + DEFAULT_DESCRIPTION + "</p>" +
               "</div>" +
               "</div>" +
               "<h3>" + DEFAULT_NAME + "</h3>" +
               "<h6>$" + DEFAULT_PRICE + "</h6>" +
               "<button type=\"button\" class=\"add-button\"> <img src=\"../pictures/add_button.png\" alt=\"+\"> Add to Cart</button>" +
               "</div>" +
               "</div>";
    }
    
    public ProductPanel(Product Pr) {
        this(Pr.getSku(), Pr.getName(), Pr.getPrice(), Pr.getStock());
    }
    
    public ProductPanel(int sku, String name, double price, int stock) {
        html = "<form action=\"../cartHandler?action=" + sku + "\" method=\"post\">" +
               "<div class=\"column\">" +
               "<div class=\"content\">" +
               "<img id=\"product-img\"src=\"../pictures/" + sku + ".jpg\" alt=\"" + name + "\" height=190px width=190px>" +
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
               "</div>" +
               "</form>";
    }
    
    public String yield() {
        return html;
    }
}
