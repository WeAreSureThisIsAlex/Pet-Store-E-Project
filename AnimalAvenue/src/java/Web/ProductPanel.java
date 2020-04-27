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
    private Product P;
    private String html;
    private final String DEFAULT = "(empty panel)";
    
    public ProductPanel() {
        html = "<div class=\"ProductPanel\">" + DEFAULT + "</div>";
    }
    
    public ProductPanel(Product Pr) {
        P = Pr;
        html = "<div class=\"ProductPanel\">" + P.getName() + "</div>";
    }
    
    public String yield() {
        return html;
    }
}
