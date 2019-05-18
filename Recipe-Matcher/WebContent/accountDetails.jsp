<!DOCTYPE html>
<%@ page import="java.sql.*" %> 
<%@ page import="com.recipes.util.*" %>
<%@ page import="com.recipes.dao.*" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>My Account</title>
	<link rel="icon" href="img/Fevicon2.png" type="image/png">
  <link rel="stylesheet" href="vendors/bootstrap/bootstrap.min.css">
  <link rel="stylesheet" href="vendors/themify-icons/themify-icons.css">
  <link rel="stylesheet" href="vendors/owl-carousel/owl.theme.default.min.css">
  <link rel="stylesheet" href="vendors/owl-carousel/owl.carousel.min.css">
  <link rel="stylesheet" href="vendors/Magnific-Popup/magnific-popup.css">
  <link rel="stylesheet" href="css/style.css">
<script language="javascript" type="text/javascript">

function gotopage()
{
    document.location = 'userDashboard.jsp';
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

<%
	String username = (String) session.getAttribute("username");
	Connection conn=null;
	Statement stmt = null;
	ResultSet rs = null;
	
	try
	{
		conn = DBConnection.createConnection();
		String sql = "select * from user_tbl where user_email='"+username+"'";
		stmt=conn.createStatement();
		rs=stmt.executeQuery(sql);	
		System.out.println(sql);
%>

 <!--================Hero Banner Section start =================-->
  <section class="hero-banner">
    <div class="hero-wrapper">
      <div class="hero-left" style="margin-tope:0%;">
        <div class="form-group" >
    		<h5 style="font-family:sans serif;"> Profile Details </h5>
    		<form action="UserRegister" method="get">
    		<%
    		while(rs.next())
			{%>
                User ID:<input type="text" name="user_id" placeholder="<%=rs.getInt("user_id") %>" readonly="readonly" style="margin-bottom:5px;"/><br>
                User Email: <input type="email" name="user_email" style="margin-bottom:5px;" placeholder="<%=username %>"/><br>
                First Name: <input type="text" name="fname" style="margin-bottom:5px;" placeholder="<%=rs.getString("user_fname") %>"/><br>
                Last Name: <input type="text" name="lname" style="margin-bottom:5px;" placeholder="<%=rs.getString("user_lname") %>"/><br>
            <%} 
            }
	catch(Exception ex)
	{
		ex.printStackTrace();
	}%>
                <input type="submit" value="Update"/>
                <input type="button" value="Cancel" onclick="gotopage()"/>
            </form> 
            <br>
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