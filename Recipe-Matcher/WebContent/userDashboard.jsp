<!DOCTYPE html>
<%@ page import="java.util.*" %> 
<%@ page import="com.recipes.util.*" %>
<%@ page import="com.recipes.dao.*" %>
<%
ArrayList<RecipeBean> user_recipes=new ArrayList<>();
UserRecipes recipes = new UserRecipes();
%>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Dashboard</title>
	<link rel="icon" href="img/Fevicon2.png" type="image/png">
  <link rel="stylesheet" href="vendors/bootstrap/bootstrap.min.css">
  <link rel="stylesheet" href="vendors/themify-icons/themify-icons.css">
  <link rel="stylesheet" href="vendors/owl-carousel/owl.theme.default.min.css">
  <link rel="stylesheet" href="vendors/owl-carousel/owl.carousel.min.css">
  <link rel="stylesheet" href="vendors/Magnific-Popup/magnific-popup.css">
  <link rel="stylesheet" href="css/style.css">
<script language="javascript" type="text/javascript">

function getRecipe(recipe_id, recipe_title)
{
    document.location = 'single-recipe.jsp?recipe_id=' + recipe_id;
}

</script>
</head>
<body>
	<%
		if (session.getAttribute("username") == null) {

			response.sendRedirect("login.jsp");

		}
	%>
	  <!--================ Header Menu Area start =================-->
  <header class="header_area">
    <div class="main_menu">
      <nav class="navbar navbar-expand-lg navbar-light">
        <div class="container box_1620">
          <a class="navbar-brand logo_h" href="index.jsp"><img src="img/logo.png" alt="Recipe-Matcher" height="120" width="172"></a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>

          <div class="collapse navbar-collapse offset" id="navbarSupportedContent">
            <ul class="nav navbar-nav menu_nav justify-content-end">
              <li class="nav-item active"><a class="nav-link" href="userDashboard.jsp">Home</a></li> 
              <li class="nav-item"><a class="nav-link" href="myBasket.jsp">My Basket</a></li>
              <li class="nav-item"><a class="nav-link" href="myRecipes.jsp">My Recipes</a></li> 
              <li class="nav-item"><a class="nav-link" href="savedRecipes.jsp">Saved Recipes</a></li>
              <li class="nav-item"><a class="nav-link" href="myMealPlan.jsp">Weekly Meal Schedule</a></li>
                    <li class="nav-item"><a class="nav-link" href="accountDetails.jsp">My Account</a></li>
              <li class="nav-item"><a class="nav-link" href="LogoutServlet">Logout</a></li> 
            </ul>
          </div> 
        </div>
      </nav>
    </div>
  </header>
<!--================Header Menu Area =================-->


 <!--================Hero Banner Section start =================-->
  <section class="hero-banner">
    <div class="hero-wrapper">
      <div class="hero-left">
        <h2 class="hero-title" style="font-size: 50px;">Recipes you can make with ingredients you already have</h2>
        <div class="d-sm-flex flex-wrap">
          <a href="myRecipes.jsp" class="button button-hero button-shadow">Get my recipes</a>
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
   
  
  <!--================Featured Section Start =================-->
  <section class="section-margin mb-lg-100">
    <div class="container">
      <div class="section-intro mb-75px">
       <h4 class="intro-title">Featured Recipes</h4>
        <h2>Community Picks</h2>
      </div>
     <div class="owl-carousel owl-theme featured-carousel">
      <% 
      if(session.getAttribute("username")!= null)
      {
      String username = session.getAttribute("username").toString();
      user_recipes = recipes.get_user_community_picks(username);
      }
      for(RecipeBean recipe:user_recipes) {
    	  if(recipe.getRecipe_gallery().size()==1)
    	  {
    	  String url = recipe.getRecipe_gallery().get(0);
    	  %> 
      <div class="featured-item">
      <a onclick="javascript:getRecipe(<%=recipe.getRecipe_id() %>, '<%=recipe.getRecipe_title() %>')"> <img class="card-img rounded-0" src="<%=url %>" alt=""> </a>
          <div class="item-body">
            <a onclick="javascript:getRecipe(<%=recipe.getRecipe_id() %>, '<%=recipe.getRecipe_title() %>')">
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


  <!-- ================ start footer Area ================= -->
  <footer class="footer-area section-gap" style="padding-top:10px; padding-bottom:0px;">
		<div class="container">

			<div class="footer-bottom row align-items-center text-center text-lg-left">
				<p class="footer-text m-0 col-lg-8 col-md-12"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
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