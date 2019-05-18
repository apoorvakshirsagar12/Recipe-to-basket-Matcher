<!DOCTYPE html>
<%@ page import="java.util.*" %> 
<%@ page import="com.recipes.util.*" %>
<%@ page import="com.recipes.dao.*" %>
<%
ArrayList<RecipeBean> recipe_picks=new ArrayList<>();
UserRecipes recipes = new UserRecipes();
recipe_picks = recipes.get_community_pick_recipes();
%>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Home</title>
	<link rel="icon" href="img/Fevicon2.png" type="image/png">

  <link rel="stylesheet" href="vendors/bootstrap/bootstrap.min.css">
  <link rel="stylesheet" href="vendors/themify-icons/themify-icons.css">
  <link rel="stylesheet" href="vendors/owl-carousel/owl.theme.default.min.css">
  <link rel="stylesheet" href="vendors/owl-carousel/owl.carousel.min.css">
  <link rel="stylesheet" href="vendors/Magnific-Popup/magnific-popup.css">
  <link rel="stylesheet" href="css/style.css">
 
</head>
<body>

  <!--================ Header Menu Area start =================-->
  <header class="header_area">
    <div class="main_menu">
      <nav class="navbar navbar-expand-lg navbar-light">
        <div class="container box_1620">
          <a class="navbar-brand logo_h" href="index.jsp"><img src="img/logo.png" alt="Recipe-Matcher"  height="120" width="172"></a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>

          <div class="collapse navbar-collapse offset" id="navbarSupportedContent">
            <ul class="nav navbar-nav menu_nav justify-content-end">
              <li class="nav-item active"><a class="nav-link" href="index.jsp">Home</a></li> 
              <li class="nav-item"><a class="nav-link" href="about-us.jsp">About</a></li> 
              <li class="nav-item"><a class="nav-link" href="contact-us.jsp">Contact</a></li>
              <li class="nav-item"><a class="nav-link" href="login.jsp">Register/Login</a></li>
            </ul>
          </div> 
        </div>
      </nav>
    </div>
  </header>
<!--================Header Menu Area =================-->

  <!-- Modal for Search -->
  <!-- <div class="modal fade" id="mysearch" role="dialog">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
      <form action="SearchRecipeServlet" method="post">
        <div class="modal-header">
           <h4 class="modal-title">Enter Ingredient</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body">
          <div style="float:left">
            <p>Recipe</p>
          </div>
          <div style="padding-left:100px;">
            <select id="check" style="border:0;">
             	<option value="Select">Select</option>
                <option value="With">With</option>
                <option value="Without">Without</option>
            </select>
            <input type="text" style="margin-left:50px; border:0; border-bottom:1px solid #ccc;" onkeyup="myFunction()" id="myfood">
            <br>
            <div><input type="text" id="cwith" name="cwith" style="font-size:15px; border:0px;"/></div>
            <div><input type="text" id="cwithout" name="cwithout" style="font-size:15px; border:0px;"/></div>
          </div>

        </div>
        <div class="modal-footer">
          <input type="submit" class="btn btn-default" />
        </div>
        </form>
      </div>
    </div>
  </div> -->
 <!-- Modal for Search End -->

  
  <!--================Hero Banner Section start =================-->
  <section class="hero-banner">
    <div class="hero-wrapper">
      <div class="hero-left">
        <h2 class="hero-title" style="font-size: 50px;">Recipes you can make with ingredients you already have</h2>
        <div class="d-sm-flex flex-wrap">
          <a href="myRecipes.jsp" class="button button-hero button-shadow">Get Recipe</a>
        </div>
        
      </div>
      <div class="hero-right">
        <div class="owl-carousel owl-theme hero-carousel">
          <div class="hero-carousel-item">
            <a href="myRecipes.jsp"><img class="img-fluid" src="img/banner/Coconut-Lime Pork Tacos with Black Beans and Avocado.jpg" alt="Coconut-Lime Pork Tacos with Black Beans and Avocado"></a>
          </div>
          <div class="hero-carousel-item">
            <a href="myRecipes.jsp"><img class="img-fluid" src="img/banner/Tomato, Peach, Chèvre, and Herb Salad with Apple Vinaigrette.jpg" alt="Tomato, Peach, Chèvre, and Herb Salad with Apple Vinaigrette"></a>
          </div>
          <div class="hero-carousel-item">
            <a href="myRecipes.jsp"><img class="img-fluid" src="img/banner/Whole Grain Sweet Potato Muffins.jpg" alt="Whole Grain Sweet Potato Muffins"></a>
          </div>
          <div class="hero-carousel-item">
            <a href="myRecipes.jsp"><img class="img-fluid" src="img/banner/Pan-Fried Pork Chops with Vinegar Peppers.jpg" alt="Pan-Fried Pork Chops with Vinegar Peppers"></a>
          </div>
        </div>
      </div>
    
    </div>
  </section>
  <!--================Hero Banner Section end =================-->

  
  <!--================About Section start =================-->
  <section class="about section-margin pb-xl-70">
    <div class="container">
      <div class="row">
        <div class="col-md-6 col-xl-6 mb-5 mb-md-0 pb-5 pb-md-0">
          <div class="img-styleBox">
            <div class="styleBox-border">
              <a href="about-us.jsp"><img class="styleBox-img1 img-fluid" src="img/home/about-img1.png" alt=""></a>
            </div>
            <a href="about-us.jsp"><img class="styleBox-img2 img-fluid" src="img/home/about-img2.png" alt=""></a>
          </div>
        </div>
        <div class="col-md-6 pl-md-5 pl-xl-0 offset-xl-1 col-xl-5">
          <div class="section-intro mb-lg-4">
            <h4 class="intro-title">About Us</h4>
            <h2>Miscellany in, Delicious out</h2>
          </div>
          <p style="text-align:justify;">Cooking something only from the ingredients you have in your pantry can be challenging and when you are a beginner in cooking then its quite difficult to make something healthy and delicious. 
          We will provide you with healthy and delicious recipes using the ingredients you have in your pantry. 
          The main aim behind this is to reduce the food wastage and get rid of unhealthy food habits.
          </p>
          <a class="button button-shadow mt-2 mt-lg-4" href="about-us.jsp">Learn More</a>
        </div>
      </div>
    </div>
  </section>
  <!--================About Section End =================-->

  <!--================Featured Section Start =================-->
  <section class="section-margin mb-lg-100">
    <div class="container">
      <div class="section-intro mb-75px">
       <h4 class="intro-title">Recipes for a Crowd</h4>
        <h2>Community Picks</h2>
      </div>
      <div class="owl-carousel owl-theme featured-carousel">
      <% for(RecipeBean recipe:recipe_picks) {
    	  if(recipe.getRecipe_gallery().size()==1)
    	  {
    	  String url = recipe.getRecipe_gallery().get(0);
    	  %> 
      <div class="featured-item">
      <a href="myRecipes.jsp"> <img class="card-img rounded-0" src="<%=url %>" alt=""> </a>
          <div class="item-body">
            <a href="myRecipes.jsp">
              <h3><%=recipe.getRecipe_title() %></h3>
            </a>
          </div>
        </div> 
        <% }
    	  }%>       
      </div>
    </div>
  </section>
  <!--================Featured Section End =================-->

  <!--================Reservation section start =================-->
  <section class="bg-lightGray section-padding">
    <div class="container">
      <div class="row align-items-center">
        <div class="col-md-6 col-xl-5 mb-4 mb-md-0">
          <div class="section-intro">
            <h4 class="intro-title">Register</h4>
            <h2 class="mb-3">Get Recipes from Recipe Matcher</h2>
          </div>
          <p>Given the list of ingredients you have in your pantry, we will provide you with healthy and delicious recipes. </p>
        </div>
        <div class="col-md-6 offset-xl-2 col-xl-5">
          <div class="search-wrapper">
            <h3>Create Account</h3>

            <form class="search-form" action="UserRegister" method="post">
              <div class="form-group">
                <div class="input-group">
                  <input type="text" class="form-control" placeholder="First Name" name="fname" id="fname" style="color:black;" required>
                  <div class="input-group-append">
                    <span class="input-group-text"><i class="ti-user"></i></span>
                  </div>
                </div>
              </div>
              <div class="form-group">
                <div class="input-group">
                  <input type="text" class="form-control" placeholder="Last Name" name="lname" id="lname" style="color:black;" required>
                  <div class="input-group-append">
                    <span class="input-group-text"><i class="ti-user"></i></span>
                  </div>
                </div>
              </div>
              <div class="form-group">
                <div class="input-group">
                  <input type="email" class="form-control" placeholder="Email Address" name="username" id="username" style="color:black;" required>
                  <div class="input-group-append">
                    <span class="input-group-text"><i class="ti-email"></i></span>
                  </div>
                </div>
              </div>
              <div class="form-group">
                <div class="input-group">
                  <input type="password" class="form-control" placeholder="Password" name="passwd" id="passwd" style="color:black;" required>
                  <div class="input-group-append">
                    <span class="input-group-text"><i class="ti-user"></i></span>
                  </div>
                </div>
              </div>
              <div class="form-group">
                <div class="input-group">
                  <input type="password" class="form-control" placeholder="Confirm Password" name="passwd2" onkeyup="checkpasswd()" id="passwd2" style="color:black;" required>
                  <div class="input-group-append">
                    <span class="input-group-text"><i class="ti-user"></i></span>
                  </div>
                </div>
              </div>
              <div class="form-group form-group-position">
              	<p id="respass" style="color:white"></p>
                <button class="button border-0" type="submit">Submit</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!--================Reservation section end =================-->    


  <!-- ================ start footer Area ================= -->
  <footer class="footer-area section-gap" style="padding-top:40px; padding-bottom:0px;">
		<div class="container">

			<div class="footer-bottom row align-items-center text-center text-lg-left">
				<p class="footer-text m-0 col-lg-8 col-md-12">
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved</p>
				<div class="col-lg-4 col-md-12 text-center text-lg-right footer-social">
					<a href="https://www.facebook.com/baskettorecipes/"><i class="ti-facebook"></i></a>
					<a href="#"><i class="ti-instagram"></i></a>
					<a href="#"><i class="ti-youtube"></i></a>
					<a href="#"><i class="ti-pinterest"></i></a>
				</div>
			</div>
		</div>
	</footer>
  <!-- ================ End footer Area ================= -->
  
<script>
function myFunction()
{
	var a = document.getElementById("check").value;
	if(a != "Select")
	{
		if(a == "With")
		{
	  	var y = document.getElementById("myfood");
	  	document.getElementById("cwith").value = a + ":" + y.value;
		}
		else
		{
	  	var y = document.getElementById("myfood");
	  	document.getElementById("cwithout").value = a + ":" + y.value;
		}
	}
}
  
  function checkpasswd()
  {
  	var a = document.getElementById("passwd").value;
  	var b = document.getElementById("passwd2").value;
  	if(a != b)
  	{
    	document.getElementById("respass").innerHTML = "Password doesn't match!";
  	}
  	else
  	{
  		document.getElementById("respass").innerHTML = "";
  	}
  }
</script>
  <script src="vendors/jquery/jquery-3.2.1.min.js"></script>
  <script src="vendors/bootstrap/bootstrap.bundle.min.js"></script>
  <script src="vendors/owl-carousel/owl.carousel.min.js"></script>
  <script src="vendors/nice-select/jquery.nice-select.min.js"></script>
  <script src="vendors/Magnific-Popup/jquery.magnific-popup.min.js"></script>
  <script src="js/jquery.ajaxchimp.min.js"></script>
  <script src="js/mail-script.js"></script>
  <script src="js/main.js"></script>
</body>
</html>