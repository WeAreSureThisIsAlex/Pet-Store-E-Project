<%  boolean loggedin = false;
    session = request.getSession();
 if(session != null && session.getAttribute("c1") != null) {
     loggedin = true;
 }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Pet Store</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/style.css">
    <!--BOOTSTRAP 4-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <!--FONTS-->
        <link href="https://fonts.googleapis.com/css?family=Englebert&display=swap" rel="stylesheet">
    <!--STYLESHEETS-->
        <link rel="stylesheet" href="../styles/pet_pages.css">
    <!--ICONS-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">

</head>
<style>
    #header-nav {
        
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
        border: 1px solid rgba(0, 0, 0, 0.1);
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
            <h1>Animal <img src="../pictures/logo_cutout_transparent.png" class="logo-img"> Avenue</h1>
        </div>
    </div>
    <div class="container"> 
        <div class="row" id="header-nav">
            <div class="col-sm-3">
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                     <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
                         <ul class="navbar-nav mr-auto mt-2 mt-lg-0" >
                            <li class="nav-item">
                                <a class="nav-link"href="../admin_login.html">
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
                                <a class="nav-link" href="../index.jsp">Home <span class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="../aboutUs.jsp">About Us</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="../contactUs.jsp">Contact</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="../FAQ.jsp">FAQ</a>
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
                                    <a class="nav-link" href="../logout.jsp"><i class="fa fa-power-off"></i></a>
                                </li> 
                            <% } else { %>
                                <li class="nav-item">
                                    <a class="nav-link" href="../customer_login.html">Login</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="../customer_signup.html">Sign Up</a>
                                </li>
                            <% } %>
                        </ul>
                    </div>
                </nav>
        </div>
        </div>
        
            <ul class="nav nav-tabs nav-justified">
            <li class="nav-item">
                <a class="nav-link active" href="dogs.jsp">Dogs</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="cats.jsp">Cats</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="reptiles.jsp">Reptiles</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="aquatics.jsp">Aquatics</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="small_animals.jsp">Small Animals</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="birds.jsp">Birds</a>
            </li>
        </ul>
        
        <div class="row" id="dog-food">
            <div class="col-sm-12">
                <h1> Dog Food </h1>
            </div>
        </div>
        <div class="row" id="food-row-one">
            <div class="column">
                <div class="content">
                    <img id="product-img"src="../pictures/dogfood-BlueBuffaloCanned.jpg" alt="Blue Buffalo Canned">
                    <div id="product-modal" class="modal">
                        <span class="close">&times;</span>
                        <img class="modal-content" id="modal-img">
                        <div id="caption">
                            <p class="product-description">Keep your furry friend going strong with Blue Buffalo Homestyle Recipe Chicken Dinner with Garden Vegetables and Brown Rice Canned Dog Food. Each can features real chicken as the first ingredient with garden fruits and veggies because your pup deserves nothing but the best. This paté is formulated to support the nutritional needs of adult dogs with high-quality protein to help maintain lean muscle mass. It is made with healthy carbohydrates to provide your companion with the energy he needs for an active life. This food is also enhanced with vitamins and minerals. This canned food from Blue Buffalo contains no by-product meals, corn, wheat or soy, and no artificial flavors or preservatives for a meal you can feel good about giving to your sidekick</p>
                        </div>
                    </div>
                    <h3>Blue Buffalo Canned</h3>
                    <h6>$25.99</h6>
                    
                    <button type="button" class="add-button"> <img src="../pictures/add_button.png" alt="+"> Add to Cart</button>
                </div>
            </div>
            <div class="column">
                <div class="content">
                    <img id="product-img"src="../pictures/dogfood-RachaelRayNutrish.jpg" alt="Rachael Ray Nutrish">
                    <div id="product-modal" class="modal">
                        <span class="close">&times;</span>
                        <img class="modal-content" id="modal-img">
                        <div id="caption">
                            <p class="product-description">Product Description</p>
                        </div>
                    </div>
                    <h3>Name</h3>
                    <h6>$0.00</h6>
                    <button type="button" class="add-button"> <img src="../pictures/add_button.png" alt="+"> Add to Cart</button>
                </div>
            </div>
            <div class="column">
                <div class="content">
                    <img id="product-img"src="../pictures/dogfood-PurinaProPlan.jpg" alt="Purina Pro Plan">
                    <div id="product-modal" class="modal">
                        <span class="close">&times;</span>
                        <img class="modal-content" id="modal-img">
                        <div id="caption">
                            <p class="product-description">Product Description</p>
                        </div>
                    </div>
                    <h3>Name</h3>
                    <h6>$0.00</h6>
                    <button type="button" class="add-button"> <img src="../pictures/add_button.png" alt="+"> Add to Cart</button>
                </div>
            </div>
        
        </div>
        <div class="row" id="food-row-two">
            <div class="column">
                <div class="content">
                    <img id="product-img"src="../pictures/dogfood_TasteOfTheWild.jpg" alt="Taste of the Wild">
                    <div id="product-modal" class="modal">
                        <span class="close">&times;</span>
                        <img class="modal-content" id="modal-img">
                        <div id="caption">
                            <p class="product-description">Product Description</p>
                        </div>
                    </div>
                    <h3>Name</h3>
                    <h6>$0.00</h6>
                    <button type="button" class="add-button"> <img src="../pictures/add_button.png" alt="+"> Add to Cart</button>
                </div>
            </div>
            <div class="column">
                <div class="content">
                    <img id="product-img"src="../pictures/dogfood_BlueBuffalo.jpg" alt="Blue Buffalo">
                    <div id="product-modal" class="modal">
                        <span class="close">&times;</span>
                        <img class="modal-content" id="modal-img">
                        <div id="caption">
                            <p class="product-description">Product Description</p>
                        </div>
                    </div>
                    <h3>Name</h3>
                    <h6>$0.00</h6>
                    <button type="button" class="add-button"> <img src="../pictures/add_button.png" alt="+"> Add to Cart</button>
                </div>
            </div>
            <div class="column">
                <div class="content">
                    <img id="product-img"src="../pictures/dogfood-Cesar.jpg" alt="Cesar">
                    <div id="product-modal" class="modal">
                        <span class="close">&times;</span>
                        <img class="modal-content" id="modal-img">
                        <div id="caption">
                            <p class="product-description">Product Description</p>
                        </div>
                    </div>
                    <h3>Name</h3>
                    <h6>$0.00</h6>
                    <button type="button" class="add-button"> <img src="../pictures/add_button.png" alt="+"> Add to Cart</button>
                </div>
            </div>  
        </div>
        
        <div class="row" id="dog-treats">
            <div class="col-sm-12">
                <h1> Dog Treats </h1>
            </div>
        </div>
        <div class="row" id="treats-row-one">
             <div class="column">
                <div class="content">
                    <img src="#" alt="">
                    <h3>Name</h3>
                    <h6>$0.00</h6>
                    <p class="product-description">Product Description</p>
                    <button type="button" class="add-button"> <img src="../pictures/add_button.png" alt="+"> Add to Cart</button>
                </div>
            </div> 
             <div class="column">
                <div class="content">
                    <img src="#" alt="">
                    <h3>Name</h3>
                    <h6>$0.00</h6>
                    <p class="product-description">Product Description</p>
                    <button type="button" class="add-button"> <img src="../pictures/add_button.png" alt="+"> Add to Cart</button>
                </div>
            </div> 
             <div class="column">
                <div class="content">
                    <img src="#" alt="">
                    <h3>Name</h3>
                    <h6>$0.00</h6>
                    <p class="product-description">Product Description</p>
                    <button type="button" class="add-button"> <img src="../pictures/add_button.png" alt="+"> Add to Cart</button>
                </div>
            </div> 
        
        </div>
        <div class="row" id="treats-row-two">
             <div class="column">
                <div class="content">
                    <img src="#" alt="">
                    <h3>Name</h3>
                    <h6>$0.00</h6>
                    <p class="product-description">Product Description</p>
                    <button type="button" class="add-button"> <img src="../pictures/add_button.png" alt="+"> Add to Cart</button>
                </div>
            </div> 
             <div class="column">
                <div class="content">
                    <img src="#" alt="">
                    <h3>Name</h3>
                    <h6>$0.00</h6>
                    <p class="product-description">Product Description</p>
                    <button type="button" class="add-button"> <img src="../pictures/add_button.png" alt="+"> Add to Cart</button>
                </div>
            </div> 
             <div class="column">
                <div class="content">
                    <img src="#" alt="">
                    <h3>Name</h3>
                    <h6>$0.00</h6>
                    <p class="product-description">Product Description</p>
                    <button type="button" class="add-button"> <img src="../pictures/add_button.png" alt="+"> Add to Cart</button>
                </div>
            </div> 
        
        </div>
        
        <div class="row" id="dog-toys">
            <div class="col-sm-12">
                <h1> Dog Toys </h1>
            </div>
        </div>
        <div class="row" id="toys-row-one">
             <div class="column">
                <div class="content">
                    <img src="#" alt="">
                    <h3>Name</h3>
                    <h6>$0.00</h6>
                    <p class="product-description">Product Description</p>
                    <button type="button" class="add-button"> <img src="../pictures/add_button.png" alt="+"> Add to Cart</button>
                </div>
            </div> 
             <div class="column">
                <div class="content">
                    <img src="#" alt="">
                    <h3>Name</h3>
                    <h6>$0.00</h6>
                    <p class="product-description">Product Description</p>
                    <button type="button" class="add-button"> <img src="../pictures/add_button.png" alt="+"> Add to Cart</button>
                </div>
            </div> 
             <div class="column">
                <div class="content">
                    <img src="#" alt="">
                    <h3>Name</h3>
                    <h6>$0.00</h6>
                    <p class="product-description">Product Description</p>
                    <button type="button" class="add-button"> <img src="../pictures/add_button.png" alt="+"> Add to Cart</button>
                </div>
            </div> 
        
        </div>
        <div class="row" id="toys-row-two">
             <div class="column">
                <div class="content">
                    <img src="#" alt="">
                    <h3>Name</h3>
                    <h6>$0.00</h6>
                    <p class="product-description">Product Description</p>
                    <button type="button" class="add-button"> <img src="../pictures/add_button.png" alt="+"> Add to Cart</button>
                </div>
            </div> 
             <div class="column">
                <div class="content">
                    <img src="#" alt="">
                    <h3>Name</h3>
                    <h6>$0.00</h6>
                    <p class="product-description">Product Description</p>
                    <button type="button" class="add-button"> <img src="../pictures/add_button.png" alt="+"> Add to Cart</button>
                </div>
            </div> 
             <div class="column">
                <div class="content">
                    <img src="#" alt="">
                    <h3>Name</h3>
                    <h6>$0.00</h6>
                    <p class="product-description">Product Description</p>
                    <button type="button" class="add-button"> <img src="../pictures/add_button.png" alt="+"> Add to Cart</button>
                </div>
            </div> 
        
        </div>
        
        <div class="row" id="dog-accessories">
            <div class="col-sm-12">
                <h1> Dog Accessories </h1>
            </div>
        </div>
        <div class="row" id="accessories-row-one">
             <div class="column">
                <div class="content">
                    <img src="#" alt="">
                    <h3>Name</h3>
                    <h6>$0.00</h6>
                    <p class="product-description">Product Description</p>
                    <button type="button" class="add-button"> <img src="../pictures/add_button.png" alt="+"> Add to Cart</button>
                </div>
            </div> 
             <div class="column">
                <div class="content">
                    <img src="#" alt="">
                    <h3>Name</h3>
                    <h6>$0.00</h6>
                    <p class="product-description">Product Description</p>
                    <button type="button" class="add-button"> <img src="../pictures/add_button.png" alt="+"> Add to Cart</button>
                </div>
            </div> 
             <div class="column">
                <div class="content">
                    <img src="#" alt="">
                    <h3>Name</h3>
                    <h6>$0.00</h6>
                    <p class="product-description">Product Description</p>
                    <button type="button" class="add-button"> <img src="../pictures/add_button.png" alt="+"> Add to Cart</button>
                </div>
            </div> 
        
        </div>
        <div class="row" id="accessories-row-two">
             <div class="column">
                <div class="content">
                    <img src="#" alt="">
                    <h3>Name</h3>
                    <h6>$0.00</h6>
                    <p class="product-description">Product Description</p>
                    <button type="button" class="add-button"> <img src="../pictures/add_button.png" alt="+"> Add to Cart</button>
                </div>
            </div> 
             <div class="column">
                <div class="content">
                    <img src="#" alt="">
                    <h3>Name</h3>
                    <h6>$0.00</h6>
                    <p class="product-description">Product Description</p>
                    <button type="button" class="add-button"> <img src="../pictures/add_button.png" alt="+"> Add to Cart</button>
                </div>
            </div> 
             <div class="column">
                <div class="content">
                    <img src="#" alt="">
                    <h3>Name</h3>
                    <h6>$0.00</h6>
                    <p class="product-description">Product Description</p>
                    <button type="button" class="add-button"> <img src="../pictures/add_button.png" alt="+"> Add to Cart</button>
                </div>
            </div> 
        
        </div>
        
         <div class="row" id="scroll-btn-row">
            <button onclick="topFunction()" id="btn-scroll-top" title="Back to Top">Back to Top</button>
        </div>
    </div>
    
    </body>
    
<script>
/****SCRIPT FOR PRODUCT IMG MODAL****/
    // Get the modal
    var modal = document.getElementById("product-modal");

    // Get img and insert it in the modal 
    var img = document.getElementById("product-img");
    var modalImg = document.getElementById("modal-img");
    var captionText = document.getElementById("caption");
    img.onclick = function(){
      modal.style.display = "block";
      modalImg.src = this.src;
      captionText.innerHTML = this.getElementById("caption");
        button.style.display = "hidden";
    }

    // Get the span element that closes modal
    var span = document.getElementsByClassName("close")[0];

    // When the user clicks on span (x), close the modal
    span.onclick = function() { 
      modal.style.display = "none";
    }
 
    
    
    
/****SCRIPT FOR SCROLL TO TOP BUTTON****/
    //Get the button
        var mybutton = document.getElementById("btn-scroll-top");

    // When the user scrolls down 20px from the top of the document, show the button
        window.onscroll = function() {scrollFunction()};

        function scrollFunction() {
            if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
                mybutton.style.display = "block";
            } else {
                mybutton.style.display = "none";
            }
        }
    // When the user clicks on the button, scroll to the top of the document
        function topFunction() {
            document.body.scrollTop = 0;
            document.documentElement.scrollTop = 0;
        }
</script>
</html>