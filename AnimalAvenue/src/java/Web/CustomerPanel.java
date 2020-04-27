/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

/**
 *
 * @author Alex (School)
 */
public class CustomerPanel {
    //Customer property
    private String html;
    final String DEFAULTHTML = "<li class=\"nav-item\"><a class=\"nav-link\" href=\"login.jsp\">Login</a></li><li class=\"nav-item\"><a class=\"nav-link\" href=\"customer_signup.html\">Sign Up</a></li>";
    
    public CustomerPanel() {
        html = "<div class=\"col-sm-3\"><nav class=\"navbar navbar-expand-lg navbar-light bg-light\"><div class=\"collapse navbar-collapse\" id=\"navbarTogglerDemo03\"><ul class=\"navbar-nav mr-auto mt-2 mt-lg-0\">" + DEFAULTHTML + "</ul></div></nav></div>";
    }
    
    public String yield() {
        return html;
    }
}
