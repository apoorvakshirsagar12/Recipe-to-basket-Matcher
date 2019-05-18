<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Login</title>
	<link rel="icon" href="img/Fevicon2.png" type="image/png">

  <link rel="stylesheet" href="vendors/bootstrap/bootstrap.min.css">
  <link rel="stylesheet" href="vendors/themify-icons/themify-icons.css">
  <link rel="stylesheet" href="vendors/owl-carousel/owl.theme.default.min.css">
  <link rel="stylesheet" href="vendors/owl-carousel/owl.carousel.min.css">
  <link rel="stylesheet" href="vendors/Magnific-Popup/magnific-popup.css">
	<link rel="stylesheet" href="css/style2.css">
	
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
              <li class="nav-item"><a class="nav-link" data-toggle="modal" href="login.jsp">Register/Login</a></li>
            </ul>
          </div> 
        </div>
      </nav>
    </div>
  </header>
<!--================Header Menu Area =================-->


  <!-- Modal for Login -->
  <!-- <div class="modal fade" id="mylogin" role="dialog">
    <div class="modal-dialog modal-sm">
      <div class="modal-content">
        <div class="modal-header">
           <h4 class="modal-title"><span class="glyphicon glyphicon-lock"></span>User Login</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body">
          <form role="form" action="UserLogin" method="post" id="login-form">
            <div class="form-group">
              <label for="usrname"><span class="glyphicon glyphicon-user"></span> Username</label>
              <input type="text" class="form-control" id="usrname" name="username" placeholder="Enter email" required>
            </div>
            <div class="form-group">
              <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
              <input type="password" class="form-control" id="psw" name="psw" placeholder="Enter password" required>
            </div>
            <div class="checkbox">
              <label><input type="checkbox" value="" checked>Remember me</label>
            </div>
              <input type="submit" value="Login" class="btn btn-success btn-block" style="background-color:#e22104">
          </form>
        </div>
      </div>
    </div>
  </div> -->

  <!-- Modal for Search End -->
  
  <!--================Reservation section start =================-->
 <section class="section-margin" style="margin: 50px;">
    <div class="container" style="margin-bottom:50px;">
      <div class="cta-area text-center" style="padding: 10px 0 20px 0;">
       
  <div id="login-box">
  <div class="left">
    <h3>-Register-</h3>
    <br>
    <form action="UserRegister" method="post" id="login-form">
    <input type="text" name="fname" placeholder="First Name" required/>
    <input type="text" name="lname" placeholder="Last Name" required/>
    <input type="text" name="username" placeholder="E-mail" required/>
    <input type="password" name="passwd" id="passwd" placeholder="Password" required/>
    <input type="password" name="passwd2" id="passwd2" placeholder="Retype password" required/>
    <input type="submit" name="signup_submit" value="Sign Up" />
    </form>
  </div>
  
  <div class="right" style="margin-top: 50px;">
    <h3>-Login-</h3>
    <br>
    <form action="UserLogin" method="post" id="login-form">
    <input type="text" name="username" placeholder="Username/Email" />
    <input type="password" name="psw" placeholder="Password" />
    <input type="submit" name="signup_submit" value="Sign In" />
    </form>
  </div>
  <div class="or">OR</div>
</div>
      </div>
    </div>
  </section>
  <!--================Reservation section end =================-->    


  <!-- ================ start footer Area ================= -->
  <footer class="footer-area section-gap" style="padding-top:40px; padding-bottom:0px;">
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
  
<script>
  
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