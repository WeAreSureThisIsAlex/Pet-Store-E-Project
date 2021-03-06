<%-- 
    Document   : cart
    Created on : Mar 9, 2020, 1:50:48 PM
    Author     : Neal Valdez
--%>
<%@page import="Business.*" %>
<%@page import="Data.Access" %>
<%  boolean cartPresent = false;
    session = request.getSession();
 if(session != null && session.getAttribute("cart") != null) {
     cartPresent = true;
 }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cart</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--BOOTSTRAP 4-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <!--FONTS-->
        <link href="https://fonts.googleapis.com/css?family=Englebert&display=swap" rel="stylesheet">
    <!--STYLESHEETS-->
        <link rel="stylesheet" href="styles/login_signup.css">
    <!--ICONS-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">      
    </head>
    <body>
        <%
            Cart cart = new Cart();
            if (cartPresent) {
                cart = (Cart)session.getAttribute("cart");
            }
            if (cart.getItems().getCount()==0) { %>
            <h1>Cart is currently empty</h1>
        <% }
                else { 
                    for (Item I : cart.getItems().getList()) {
                        out.println(I.getName() + ": $" + I.getPrice() + " x" + I.getQuantity() + "<br>");
                    }
                }
        %><br>
        $<%= cart.getItems().getTotal() %><br>
        <a href="javascript:history.back()">Click here to keep shopping!</a>
        
    </body>
</html>
