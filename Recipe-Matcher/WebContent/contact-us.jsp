<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Contact Us</title>
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
  <section class="bg-lightGray section-padding">
    <div class="container">
      <div class="row align-items-center">
        <div class="col-md-6 col-xl-5 mb-4 mb-md-0">
          <div class="section-intro">
            <h4 class="intro-title">Contact</h4>
            <h2 class="mb-3">You can contact us via email.</h2>
          </div>
        </div>
        <div class="col-md-6 offset-xl-2 col-xl-5">
          <div class="search-wrapper">
            <h3>Contact Us</h3>

            <form class="search-form" action="#" method="post">
              <div class="form-group">
                <div class="input-group">
                  <input type="text" class="form-control" placeholder="Name" name="fname" id="fname" style="color:black;" required>
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
                  <textarea rows = "5" cols = "50"  placeholder="Enter Message" name="msg" id="msg" style="color:black;" required></textarea>
                 
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