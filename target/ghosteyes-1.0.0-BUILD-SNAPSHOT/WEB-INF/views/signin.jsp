<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Welcome back</title>
        <meta http-equiv="Content-Type" content="text/html" />
        <meta charset="utf-8">
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
        <meta http-equiv="keywords" content="note,cloudnote,walk">
        <meta http-equiv="description" content="This is my page">
        <meta name="viewport"
	   content="width=device-width, 
                                     initial-scale=1.0, 
                                     maximum-scale=1.0, 
                                     user-scalable=no">
        <meta name="author" content="wzh">
        <!-- Latest jquery.js -->
        <script src="<%=path %>/resources/media/js/jquery.min.js"></script> 
        <!-- Latest less.js -->
        <script src="<%=path %>/resources/media/js/less.min.js"></script>
        <!-- Latest compiled and minified JavaScript for bootstrap-->
        <script src="<%=path %>/resources/media/js/bootstrap.js"></script>
        <!-- Latest compiled and minified CSS for bootstrap-->
        <link rel = "stylesheet" href = "<%=path %>/resources/media/css/mycss.css">
        <link rel="stylesheet" href="<%=path %>/resources/media/css/bootstrap.css">
        <!-- import md5 libraruay -->
        <script src = "<%=path %>/resources/media/js/md5.js"></script>
        <!--  import my own js -->
        <script src = "<%=path %>/resources/media/js/signin.js"></script>
    </head>
    
    <body>
        <div class = "container">
            <div class = "row">
                <form class = "signin-form"action = "<%=path %>/usr/signin" method="post">
                    <div class = "signin-head">
                        <h3 class = "center">Sign In</h3>
                    </div>
                    <div class = "signin-body">
                        <input type = "text" id = "email" name = "email" placeholder = "Email address"/>
                        <input type = "password" id = "passwd" placeholder = "Password"/>
                        <input type = "hidden" id = "passwd_md5" name = "passwd">
                    </div>
                    <div class = "signin-footer">
                        <button class = "btn btn-lg btn-block btn-primary" type = "submit" id = "submit">Sign in</button>
                        <p class="center">Not yet a member? <a href="usr?action=signup">Sign up now</a></p>
                        <p class="center"> <a href = "usr?action=retrieve">Forgot your Password?</a> </p>
                    </div>
                </form>
            </div>
        </div>
    </body>
    
</html>