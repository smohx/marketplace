<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html >
<head>
  <meta charset="UTF-8">
  <title>Marketplace Admin Panel</title>
  
  
  
      <link rel="stylesheet" href="css/style.css">

  
</head>

<body>
  <div class="login-page">
   <div class="form">
     <form class="login-form" name="loginForm" action="<c:url value='j_spring_security_check' />" method='POST'>
      <input type="text" placeholder="E Mail" name="username">
      <input type="password" placeholder="password" name="password"/>
       <input class="button" type="submit" value="Submit"/>
      <input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
    </form>
</div>
</body>
</html>
