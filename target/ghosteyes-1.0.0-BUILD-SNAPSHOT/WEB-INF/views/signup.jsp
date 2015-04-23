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
        <!-- My own js -->
        <script src = "<%=path %>/resources/media/js/signup.js"></script>
        <!-- import md5 libraruay -->
        <script src = "<%=path %>/resources/media/js/md5.js"></script>
    </head>
    
    <body>
        <div class = "container">
            <div class = "row">
                <form class = "signup-form" action = "<%=path %>/usr/signup" method = "post">
                    <div class = "signin-head">
                        <h3 class = "center">Sign up</h3>
                    </div>
                    <div class = "signup-body">
                        <table class = "table">
                            <tbody>
                                <tr>
                                    <td><input type = "text" id = "email" name = "email" placeholder = "Email address"></td>
                                    <td><input type = "text" id = "nickname" name = "username" placeholder = "Nick Name"></td>
                                    
                                </tr>
                                <tr>
                                    <td><input type = "password" id = "passwd" name = "passwd" placeholder = "Password"></td>
                                    <td><input type = "password" id = "passwd-confirm" placeholder = "Confirm Your Password"></td>
                                </tr>
                                <tr>
                                    <td><input type = "text" id = "gender" name = "gender" placeholder = "Male/Female/Secret"></td>
                                    <td><input type = "text" id = "birth" name = "birth" placeholder = "MM/DD/YYYY"></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class = "signup-footer">
                        <button class = "btn btn-lg btn-block btn-primary" id = "submit" type = "submit">Register</button>
                        <p class="center">Already have an account? <a href="signin.html">Sign in now</a></p>
                    </div>
                </form>
            </div>
        </div>
    </body>
    
</html>