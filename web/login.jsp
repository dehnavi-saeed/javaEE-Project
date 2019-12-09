<%--
  Created by IntelliJ IDEA.
  User: NOAVARAN
  Date: 12/7/2019
  Time: 12:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ورود به برنامه</title>

    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="assets/signin.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <form class="form-signin" action="login" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputUserName" class="sr-only">User Name</label>
        <input type="text" id="inputUserName" class="form-control" placeholder="Email address" name="username" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="password" required>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me" name="remember"> Remember me
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>

</div> <!-- /container -->


</body>
</html>
