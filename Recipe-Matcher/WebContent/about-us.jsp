<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>About Us</title>
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

  
  <!--================About Section start =================-->
  <section class="about section-margin pb-xl-70" style="margin: 50px;">
    <div class="container" style="margin: 50px;">
      <div class="row" style="width:80%;margin-left:10%;">
        
          <div class="section-intro mb-lg-4">
            <h4 class="intro-title">About Us</h4>
            <h3>Miscellany in, Delicious out</h3>
          </div>
          <p style="text-align:justify;">Cooking something only from the ingredients you have in your pantry can be challenging and when you are a beginner in cooking then its quite difficult to make something healthy and delicious. 
          We will provide you with healthy and delicious recipes using the ingredients you have in your pantry. 
          The main aim behind this is to reduce the food wastage and get rid of unhealthy food habits.<br>
          You can access the recipes once you registered in the system. Create your basket of ingredients after successful registration.
          You can always update or remove ingredients from your basket. You can also save the recipes in your account.
          </p>
          
           <div class="section-intro mb-lg-4" style="margin-top:30px;">
            <h4 class="intro-title">About Essex Farm CSA</h4>
            <h3>Healthy soil, healthy plants, healthy animals, healthy people, healthy planet.</h3>
            
          </div>
          <p style="text-align:justify;">
          Essex Farm is a 1,100 acre sustainable, diversified farm in the Champlain Valley of Upstate New York. 
          They offer a full diet, year-round CSA Membership with weekly on farm pick up and direct door-to-door delivery to the Adirondacks, 
          Capital Region, and New York City (with stops along the way).<br>
          Kristin Kimball and her husband, Mark, started Essex Farm in Essex, New York, with a seemingly impossible goal: 
          to provide 100 local residents with every one of their ingredient needs. 
          After a grueling first year, the Kimballs were producing beef, pork, chicken, eggs, milk, cheese, vegetables, herbs, fruit, grains, flour, dried beans, lard and maple syrup. 
          And they did it all the old-fashioned way of —using horse-drawn plows, for instance— with no outside help. 
          In her new book, The Dirty Life, Kristin tells the story of launching the farm in 2003 and describes the meals she has since learned to make for the Essex crew. 
           </p>
          Essex Farm: because better soil makes better food and a better planet.<br>
		<br> <a href="https://essexfarmcsa.com/">SIGN UP FOR A FARM SHARE!</a> 
         
        </div>
        
      </div>
    
  </section>
  <!--================About Section End =================-->

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