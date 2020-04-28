<%  boolean loggedin = false;
    session = request.getSession();
 if(session != null && session.getAttribute("c1") != null) {
     loggedin = true;
 }
%>
<!DOCTYPE html>

<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<html>



<head>



    <title>Pet Store</title>



    <meta charset="utf-8">



    <meta name="viewport" content="width=device-width, initial-scale=1.0">



    



    <!--BOOTSTRAP 4-->



    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">



    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>



    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>



    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>



    <!--FONTS-->



    <link href="https://fonts.googleapis.com/css?family=Englebert&display=swap" rel="stylesheet">



    <!--STYLESHEETS-->



    <link rel="stylesheet" href="styles/style.css">

    

    <!--ICONS-->



    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">



    </head>



    <style>



        #header-nav {



            border-bottom: 2px solid #e6e6e6;



            padding-bottom: 50px;



            padding-top: 50px;          



        }



        .jumbotron {        



            background: rgba(71, 144, 71, 0.82);



            /*background-image: url(pictures/logo_opacity.png);*/



            background-repeat: no-repeat;



            background-size: 10px;



            background-origin: content-box;



            background-position: center;



            box-shadow: 0px 0px 30px rgba(0, 0, 0, 0.54);



            border: 1px solid rgba(0, 0, 0, 0.1);



        }



        .container {



            background: rgba(71, 144, 71, 0.82);



            box-shadow: 0px 0px 30px rgba(0, 0, 0, 0.54);



            border: 1px solid rgba(0, 0, 0, 0.1);



        }



        .navbar {



            box-shadow: 0px 0px 30px rgba(0, 0, 0, 0.54);



        }



         .nav-link {



        color: white;



        font-weight: bold;



        font-size: 20px;



        letter-spacing: 2px;



    }



        @media screen and (max-width: 600px) {



            .navbar {



                box-shadow: 0px 0px 0px;



                justify-content: center;



            }



            



        }







        



    </style>



    



    <body>



    <div class="jumbotron jumbotron-fluid">



        <div class="container-fluid">



            <h1>Animal <img src="pictures/logo_cutout_transparent.png" class="logo-img"> Avenue</h1>



        </div>



    </div>



    <div class="container"> 



        <div class="row" id="header-nav">



            <div class="col-sm-3">



                <nav class="navbar navbar-expand-lg navbar-light bg-light">



                     <div class="collapse navbar-collapse" id="navbarTogglerDemo03">



                         <ul class="navbar-nav mr-auto mt-2 mt-lg-0" >
                            <li class="nav-item">
                                <a class="nav-link"href="admin_login.html">
                                    <i class="fas fa-user-lock"></i> Admin
                                </a>
                             </li>
                         </ul>



                    </div>



                </nav>



            </div>



            <div class="col-sm-6">
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
                        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                            <li class="nav-item">
                                <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="aboutUs.jsp">About Us</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="contactUs.jsp">Contact</a>
                            </li>
                            <li class="nav-item active">
                                <a class="nav-link" href="FAQ.jsp">FAQ</a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>



            <div class="col-sm-3">



                <nav class="navbar navbar-expand-lg navbar-light bg-light">



                    <div class="collapse navbar-collapse" id="navbarTogglerDemo03">



                        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                            <% if (loggedin) { %>
                                <li class="nav-item">
                                    <a class="nav-link" style="color: black;">Hello, ${c1.getFname()}!</a>
                                </li>
                                <li class="nav-item"> 
                                  <a class="nav-link" href="cart.jsp"><i class="fa fa-shopping-cart"></i></a>
                                </li> 
                                <li class="nav-item">
                                    <a class="nav-link" href="logout.jsp"><i class="fa fa-power-off"></i></a>
                                </li> 
                            <% } else { %>
                                <li class="nav-item">
                                    <a class="nav-link" href="customer_login.html">Login</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="customer_signup.html">Sign Up</a>
                                </li>
                            <% } %>
                        </ul>



                    </div>



                </nav>



        </div>



        </div>



        <div class="row" id="shop-by-pet">



            <div class="col-sm-12">



                <h1> FAQ </h1>



            </div>



		             <h2>How long on average does it take to recieve my order?</h2>

                            <p>It takes around 3 to 5 business days on average for the order to arrive.</p>
                            
                 <h2> How do I return an item?</h2>
                 
                            <p> Please contact one of our representatives to recieve information on how to return an item.</p>

                 <h2>How can I contact you guys?</h2>

                            <p>Please see our contact page for more information.</p>

                 <h2>How can I cancel my order?</h2>

                            <p>Contact one of our representatives to cancel your order.</p>

                 <h2>Do you have products for other pets?</h2>

                     	     <p>We provide products for several different types of animals currently.</p>

                  <h2>How do I create an account?</h2>

                            <p>Click the Sign up link at the top of the page and follow the steps from there.</p>




            </div>



        </div>



    </div>



    </body>







</html>
