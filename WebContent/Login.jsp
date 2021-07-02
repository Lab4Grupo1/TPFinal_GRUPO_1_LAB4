<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/Login.css" rel="stylesheet" type="text/css" />
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
</head>
<body>



<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->

    <!-- Icon -->
    <div class="fadeIn first">
      <img src="https://image.flaticon.com/icons/png/128/848/848006.png" id="icon" alt="User Icon" />
    </div>

    <!-- Login Form -->
    <form action="post" method="/servletLogin.java">
      <input type="text" name="login" class="fadeIn second" name="login" placeholder="User">
      <input type="password" name="password" class="fadeIn third" name="login" placeholder="Password">
      <input type="submit" class="fadeIn fourth" value="Log In">
    </form>


  </div>
</div>

</body>
</html>