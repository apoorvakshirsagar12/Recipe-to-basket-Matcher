<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Recipe Page</title>
	<link rel="icon" href="img/Fevicon2.png" type="image/png">
  <link rel="stylesheet" href="vendors/bootstrap/bootstrap.min.css">
  <link rel="stylesheet" href="vendors/themify-icons/themify-icons.css">
  <link rel="stylesheet" href="vendors/owl-carousel/owl.theme.default.min.css">
  <link rel="stylesheet" href="vendors/owl-carousel/owl.carousel.min.css">
  <link rel="stylesheet" href="vendors/Magnific-Popup/magnific-popup.css">
  <link rel="stylesheet" href="css/style.css">
   <link rel="stylesheet" href="css/image-gallery.css">
  <script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="js/jquery-1.8.2.js" type="text/javascript"></script>
  
  <script type="text/javascript">
	    $(document).ready(function() {
		var url_string = window.location;
		var url = new URL(url_string);
		var recipe_id = url.searchParams.get("recipe_id");
		console.log(recipe_id);
		$.ajax({
			type : 'GET',
			url : 'GetRecipeDetails?recipe_id=' + recipe_id,
			success : function(response) {
				if (response != null)
					$('#RecipeDetails').html(response);
				else
					$('#msg').html("No details available");
			},
			failure : function(error) {
				console.log(error)
			}
		});
	});
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

<section class="section-margin" style="margin: 50px;">
    <div class="container">
    	<div id="RecipeDetails" style="text-align:justify; width:70%; margin-left:15%;"></div>
		<h4 id="msg"></h4>  
	</div>
</section>    



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

</body>
  <script>
var slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
  showSlides(slideIndex += n);
}

function showSlides(n) {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  console.log(slides.length);
  if (n > slides.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = slides.length}
  
  for (i = 0; i < slides.length; i++) {
	  console.log(slides[i]);
      slides[i].style.display = "none";  
  }
  slides[slideIndex-1].style.display = "block"; 
}

function save(recipe_id)
{
	document.location = 'SaveRecipes?recipe_id=' + recipe_id;	
}

function complete(recipe_id)
{
	document.location = 'CompletedRecipes?recipe_id=' + recipe_id;
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
</html>