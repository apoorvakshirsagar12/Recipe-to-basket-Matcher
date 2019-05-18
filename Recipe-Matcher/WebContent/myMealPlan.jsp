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
  <title>Meal Achedule</title>
	<link rel="icon" href="img/Fevicon2.png" type="image/png">
  <link rel="stylesheet" href="vendors/bootstrap/bootstrap.min.css">
  <link rel="stylesheet" href="vendors/themify-icons/themify-icons.css">
  <link rel="stylesheet" href="vendors/owl-carousel/owl.theme.default.min.css">
  <link rel="stylesheet" href="vendors/owl-carousel/owl.carousel.min.css">
  <link rel="stylesheet" href="vendors/Magnific-Popup/magnific-popup.css">
  <link rel="stylesheet" href="css/style.css">
<script language="javascript" type="text/javascript">

function getRecipe(recipe_id)
{
    document.location = 'single-recipe.jsp?recipe_id=' + recipe_id;
}

</script>
</head>
<body>
	<%
	session.setAttribute("parent_page", "meal_plan");
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
  
  <!--================Featured Section Start =================-->
  <section class="section-margin mb-lg-100">
    <div class="container" style="">
      <% 
      if(session.getAttribute("username")!= null)
      {
      String username = session.getAttribute("username").toString();
      user_recipes = recipes.get_my_recipes(username);
      }
      RecipeBean[] meals = new RecipeBean[user_recipes.size()];
      int i=0;
      for(RecipeBean j:user_recipes)
      {
    	  meals[i]=j;
    	  i++;
      }  
      if(meals.length>=14)
      {
     %>
     <h4 class="intro-title">Monday</h4>
     <div class="owl-carousel owl-theme featured-carousel">
    <%
    	 	if(meals[0].getRecipe_gallery().size()==1)
    	  	{
    	  	String url = meals[0].getRecipe_gallery().get(0);
    	  	%> 
      		<div class="featured-item">
      		<a onclick="javascript:getRecipe(<%=meals[0].getRecipe_id() %>)"> <img class="card-img rounded-0" src="<%=url %>" alt=""> </a>
          	<div class="item-body">
            <a onclick="javascript:getRecipe(<%=meals[0].getRecipe_id() %>)">
              <h3><%=meals[0].getRecipe_title() %></h3>
            </a>
          </div>
        </div> 
        <%}
    	 	 if(meals[1].getRecipe_gallery().size()==1)
     	  	{
     	  	String url2 = meals[1].getRecipe_gallery().get(0);
     	  	%> 
       		<div class="featured-item">
       		<a onclick="javascript:getRecipe(<%=meals[1].getRecipe_id() %>)"> <img class="card-img rounded-0" src="<%=url2 %>" alt=""> </a>
           	<div class="item-body">
             <a onclick="javascript:getRecipe(<%=meals[1].getRecipe_id() %>)">
               <h3><%=meals[1].getRecipe_title() %></h3>
             </a>
           </div>
         </div> 
         <%}
    	 %>
    	 </div> 
    	 <h4 class="intro-title">Tuesday</h4>
    	 <div class="owl-carousel owl-theme featured-carousel">
    <%
    	 	if(meals[2].getRecipe_gallery().size()==1)
    	  	{
    	  	String url = meals[2].getRecipe_gallery().get(0);
    	  	%> 
      		<div class="featured-item">
      		<a onclick="javascript:getRecipe(<%=meals[2].getRecipe_id() %>)"> <img class="card-img rounded-0" src="<%=url %>" alt=""> </a>
          	<div class="item-body">
            <a onclick="javascript:getRecipe(<%=meals[2].getRecipe_id() %>)">
              <h3><%=meals[2].getRecipe_title() %></h3>
            </a>
          </div>
        </div> 
        <%}
    	 	 if(meals[3].getRecipe_gallery().size()==1)
     	  	{
     	  	String url2 = meals[3].getRecipe_gallery().get(0);
     	  	%> 
       		<div class="featured-item">
       		<a onclick="javascript:getRecipe(<%=meals[3].getRecipe_id() %>)"> <img class="card-img rounded-0" src="<%=url2 %>" alt=""> </a>
           	<div class="item-body">
             <a onclick="javascript:getRecipe(<%=meals[3].getRecipe_id() %>)">
               <h3><%=meals[3].getRecipe_title() %></h3>
             </a>
           </div>
         </div> 
         <%}
    	 %>
    	 </div> 
    	 <h4 class="intro-title">Wednesday</h4>
    	 <div class="owl-carousel owl-theme featured-carousel">
    <%
    	 	if(meals[4].getRecipe_gallery().size()==1)
    	  	{
    	  	String url = meals[4].getRecipe_gallery().get(0);
    	  	%> 
      		<div class="featured-item">
      		<a onclick="javascript:getRecipe(<%=meals[4].getRecipe_id() %>)"> <img class="card-img rounded-0" src="<%=url %>" alt=""> </a>
          	<div class="item-body">
            <a onclick="javascript:getRecipe(<%=meals[4].getRecipe_id() %>)">
              <h3><%=meals[4].getRecipe_title() %></h3>
            </a>
          </div>
        </div> 
        <%}
    	 	 if(meals[5].getRecipe_gallery().size()==1)
     	  	{
     	  	String url2 = meals[5].getRecipe_gallery().get(0);
     	  	%> 
       		<div class="featured-item">
       		<a onclick="javascript:getRecipe(<%=meals[5].getRecipe_id() %>)"> <img class="card-img rounded-0" src="<%=url2 %>" alt=""> </a>
           	<div class="item-body">
             <a onclick="javascript:getRecipe(<%=meals[5].getRecipe_id() %>)">
               <h3><%=meals[5].getRecipe_title() %></h3>
             </a>
           </div>
         </div> 
         <%}
    	 %>
    	 </div> 
    	 <h4 class="intro-title">Thursday</h4>
    	 <div class="owl-carousel owl-theme featured-carousel">
    <%
    	 	if(meals[6].getRecipe_gallery().size()==1)
    	  	{
    	  	String url = meals[6].getRecipe_gallery().get(0);
    	  	%> 
      		<div class="featured-item">
      		<a onclick="javascript:getRecipe(<%=meals[6].getRecipe_id() %>)"> <img class="card-img rounded-0" src="<%=url %>" alt=""> </a>
          	<div class="item-body">
            <a onclick="javascript:getRecipe(<%=meals[6].getRecipe_id() %>)">
              <h3><%=meals[6].getRecipe_title() %></h3>
            </a>
          </div>
        </div> 
        <%}
    	 	 if(meals[7].getRecipe_gallery().size()==1)
     	  	{
     	  	String url2 = meals[7].getRecipe_gallery().get(0);
     	  	%> 
       		<div class="featured-item">
       		<a onclick="javascript:getRecipe(<%=meals[7].getRecipe_id() %>)"> <img class="card-img rounded-0" src="<%=url2 %>" alt=""> </a>
           	<div class="item-body">
             <a onclick="javascript:getRecipe(<%=meals[7].getRecipe_id() %>)">
               <h3><%=meals[7].getRecipe_title() %></h3>
             </a>
           </div>
         </div> 
         <%}
    	 %>
    	 </div> 
    	 <h4 class="intro-title">Friday</h4>
    	 <div class="owl-carousel owl-theme featured-carousel">
    <%
    	 	if(meals[8].getRecipe_gallery().size()==1)
    	  	{
    	  	String url = meals[8].getRecipe_gallery().get(0);
    	  	%> 
      		<div class="featured-item">
      		<a onclick="javascript:getRecipe(<%=meals[8].getRecipe_id() %>)"> <img class="card-img rounded-0" src="<%=url %>" alt=""> </a>
          	<div class="item-body">
            <a onclick="javascript:getRecipe(<%=meals[8].getRecipe_id() %>)">
              <h3><%=meals[8].getRecipe_title() %></h3>
            </a>
          </div>
        </div> 
        <%}
    	 	 if(meals[9].getRecipe_gallery().size()==1)
     	  	{
     	  	String url2 = meals[9].getRecipe_gallery().get(0);
     	  	%> 
       		<div class="featured-item">
       		<a onclick="javascript:getRecipe(<%=meals[9].getRecipe_id() %>)"> <img class="card-img rounded-0" src="<%=url2 %>" alt=""> </a>
           	<div class="item-body">
             <a onclick="javascript:getRecipe(<%=meals[9].getRecipe_id() %>)">
               <h3><%=meals[9].getRecipe_title() %></h3>
             </a>
           </div>
         </div> 
         <%}
    	 %>
    	 </div> 
    	 <h4 class="intro-title">Saturday</h4>
    	 <div class="owl-carousel owl-theme featured-carousel">
    <%
    	 	if(meals[10].getRecipe_gallery().size()==1)
    	  	{
    	  	String url = meals[10].getRecipe_gallery().get(0);
    	  	%> 
      		<div class="featured-item">
      		<a onclick="javascript:getRecipe(<%=meals[10].getRecipe_id() %>)"> <img class="card-img rounded-0" src="<%=url %>" alt=""> </a>
          	<div class="item-body">
            <a onclick="javascript:getRecipe(<%=meals[10].getRecipe_id() %>)">
              <h3><%=meals[10].getRecipe_title() %></h3>
            </a>
          </div>
        </div> 
        <%}
    	 	 if(meals[11].getRecipe_gallery().size()==1)
     	  	{
     	  	String url2 = meals[11].getRecipe_gallery().get(0);
     	  	%> 
       		<div class="featured-item">
       		<a onclick="javascript:getRecipe(<%=meals[11].getRecipe_id() %>)"> <img class="card-img rounded-0" src="<%=url2 %>" alt=""> </a>
           	<div class="item-body">
             <a onclick="javascript:getRecipe(<%=meals[11].getRecipe_id() %>)">
               <h3><%=meals[11].getRecipe_title() %></h3>
             </a>
           </div>
         </div> 
         <%}
    	 %>
    	 </div> 
    	 <h4 class="intro-title">Sunday</h4>
    	 <div class="owl-carousel owl-theme featured-carousel">
    <%
    	 	if(meals[12].getRecipe_gallery().size()==1)
    	  	{
    	  	String url = meals[12].getRecipe_gallery().get(0);
    	  	%> 
      		<div class="featured-item">
      		<a onclick="javascript:getRecipe(<%=meals[12].getRecipe_id() %>)"> <img class="card-img rounded-0" src="<%=url %>" alt=""> </a>
          	<div class="item-body">
            <a onclick="javascript:getRecipe(<%=meals[12].getRecipe_id() %>)">
              <h3><%=meals[12].getRecipe_title() %></h3>
            </a>
          </div>
        </div> 
        <%}
    	 	 if(meals[13].getRecipe_gallery().size()==1)
     	  	{
     	  	String url2 = meals[13].getRecipe_gallery().get(0);
     	  	%> 
       		<div class="featured-item">
       		<a onclick="javascript:getRecipe(<%=meals[13].getRecipe_id() %>)"> <img class="card-img rounded-0" src="<%=url2 %>" alt=""> </a>
           	<div class="item-body">
             <a onclick="javascript:getRecipe(<%=meals[13].getRecipe_id() %>)">
               <h3><%=meals[13].getRecipe_title() %></h3>
             </a>
           </div>
         </div> 
         <%}
    	 %>
    	 </div>
      <%}
      else
      {
    	  %>
    	  <h3 class="intro-title">Not enough ingredients to generate weekly meal schedule!!</h3>
    	  <%
      }%>
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