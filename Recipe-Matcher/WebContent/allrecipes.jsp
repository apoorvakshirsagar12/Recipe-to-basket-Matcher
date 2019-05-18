<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>My Basket</title>
	<link rel="icon" href="img/Fevicon2.png" type="image/png">
  <link rel="stylesheet" href="vendors/bootstrap/bootstrap.min.css">
  <link rel="stylesheet" href="vendors/themify-icons/themify-icons.css">
  <link rel="stylesheet" href="vendors/owl-carousel/owl.theme.default.min.css">
  <link rel="stylesheet" href="vendors/owl-carousel/owl.carousel.min.css">
  <link rel="stylesheet" href="vendors/Magnific-Popup/magnific-popup.css">
  <link rel="stylesheet" href="css/style.css">
  <link href="css/metro/crimson/jtable.css" rel="stylesheet"
	type="text/css" />
<link href="css/jquery-ui-1.10.3.custom.css" rel="stylesheet"
	type="text/css" />
	 <script src="js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
<script src="js/jquery.jtable.js" type="text/javascript"></script>
  
  
  <script type="text/javascript">
	    $(document).ready(function() {
		//initialize jTable
		$('#allRecipesContainer').jtable({
			title : 'All Recipes',
			sorting : true,
			actions : {
				listAction : 'RecipesController?action=list',
				deleteAction : 'RecipesController?action=delete'
			},
			fields : {
				recipe_id : {
					title : 'Recipe ID',
					key : true,
					list : true,
					width : '10%',
				},
				recipe_title : {
					title : 'Recipe Name',
					list: true,
					width : '90%',
				}
				/* recipe_serves : {
					title : 'Recipe Serves',
					key : true,
					list : false,
				},
				recipe_reviews : {
					title : 'Recipe Reviews',
					key : true,
					list : false,
				},
				recipe_images : {
					title : 'Recipe Images',
					key : true,
					list : false,
				},
				recipe_steps : {
					title : 'Recipe Steps',
					key : true,
					list : false,
				} */
			}
		});
		$('#allRecipesContainer').jtable('load');
	});
</script>
  
</head>
<body>
	<%
		if (session.getAttribute("admin_username") == null) {

			response.sendRedirect("recipe-matcher-admin-login.jsp");

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
              <li class="nav-item active"><a class="nav-link" href="adminDashboard.jsp">Home</a></li> 
              <li class="nav-item"><a class="nav-link" href="allrecipes.jsp">All Recipes</a></li>
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
   
      <div class="hero-left" style="padding-left:0%; padding-top:5%;">
        <div class="row home_content_wrapper">
			<div class="feature_content col-md-12">
				<div class="two_col-div row">
					<div style="width: 80%; margin-right: 10%; margin-left: 10%; text-align: center;">
    					<div id="allRecipesContainer"></div>
        			</div>
				</div>
			</div>
		</div>
      </div>
      <div class="hero-right">
        <div class="owl-carousel owl-theme hero-carousel">
          <div class="hero-carousel-item">
            <a href="allrecipes.jsp"><img class="img-fluid" src="img/banner/Coconut-Lime Pork Tacos with Black Beans and Avocado.jpg" alt="Coconut-Lime Pork Tacos with Black Beans and Avocado"></a>
          </div>
          <div class="hero-carousel-item">
            <a href="allrecipes.jsp"><img class="img-fluid" src="img/banner/Tomato, Peach, Chèvre, and Herb Salad with Apple Vinaigrette.jpg" alt="Tomato, Peach, Chèvre, and Herb Salad with Apple Vinaigrette"></a>
          </div>
          <div class="hero-carousel-item">
            <a href="allrecipes.jsp"><img class="img-fluid" src="img/banner/Whole Grain Sweet Potato Muffins.jpg" alt="Whole Grain Sweet Potato Muffins"></a>
          </div>
          <div class="hero-carousel-item">
            <a href="allrecipes.jsp"><img class="img-fluid" src="img/banner/Pan-Fried Pork Chops with Vinegar Peppers.jpg" alt="Pan-Fried Pork Chops with Vinegar Peppers"></a>
          </div>
        </div>
      </div>
    
    </div>
  </section>
  <!--================Hero Banner Section end =================-->
  

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
  
 
  <script src="vendors/bootstrap/bootstrap.bundle.min.js"></script>
  <script src="vendors/owl-carousel/owl.carousel.min.js"></script>
  <script src="vendors/nice-select/jquery.nice-select.min.js"></script>
  <script src="vendors/Magnific-Popup/jquery.magnific-popup.min.js"></script>
  <script src="js/jquery.ajaxchimp.min.js"></script>
  <script src="js/mail-script.js"></script>
  <script src="js/main.js"></script>
</body>
</html>