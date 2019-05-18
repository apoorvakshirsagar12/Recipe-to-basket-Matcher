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
		$('#myBasketContainer').jtable({
			title : 'My Grocery List',
			paging : true,
			pageSize : 10,
			sorting : true,
			actions : {
				listAction : 'MyBasketServlet?action=list',
				createAction : 'MyBasketServlet?action=create',
				updateAction : 'MyBasketServlet?action=update',
				deleteAction : 'MyBasketServlet?action=delete'
			},
			fields : {
				ingredient_id : {
					title : 'ID',
					key : true,
					list : false
				},
				ingredient_name : {
					title : 'Ingredient Name',
					width : '30%',
					edit : true,
					list: true,
					create: true
				}
			}
		});
		$('#myBasketContainer').jtable('load');
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
 
   <!--================Hero Banner Section start =================-->
  <section class="hero-banner">
    <div class="hero-wrapper" style=" padding-top:3%;">
      <div class="hero-left" style="padding-left:0%; padding-top:0%;">
        <div class="row home_content_wrapper">
			<div class="feature_content col-md-12">
				<div class="two_col-div row">
				<div style="width: 80%; margin-right: 10%; margin-left: 10%; text-align: center;">
				<h4>NOTE: Add all types of ingredients in your pantry to get best recipes.</h4>
    					<div id="myBasketContainer"></div>
        			</div>
					
				</div>
			</div>
		</div>
      </div>
      <div class="hero-right" style="width:50%; text-align:justify;">
        <div style="width: 80%; margin-right: 5%; margin-left: 5%; text-align: center;">
    		<h3>OR <br>Add the ingredients by uploading Excel File.</h3>
    		<h4 style="font-family:sans serif; font-size:large; color:red;">File name must be in the form of 'user_#.xlsx', where # is your user_id. You can find your user id under My Account.<br>
    		Follow the format given in following sample ingredients file to add the ingredients. </h4>
    
    		<a href="https://drive.google.com/open?id=19IdEcPZhsCHj-oN9e7kDqR1pVBu04Phr" target="_blank">Download sample ingredients file</a>
    		<br>
    		<div class="form-group">
    		<h5 style="font-family:sans serif;"> Choose File to process the ingredients. </h5>
    		<form action="ProcessIngredients" method="post" enctype="multipart/form-data">
                <input type="file" name="file" />
                <input type="submit" value="Process" />
            </form> 
            <br>
    		</div>
    		
    		<div id="result">
            <h3 style="font-family:sans serif; font-size:large; color:red;">${requestScope["message"]}</h3>
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