<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <title>walknote</title>
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
    </head>

    <body class = "hasfooter">


        <!-- Carousel
================================================== -->
        <div id="myCarousel" class="carousel slide">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
                <div class="item active">
                    <img src="<%=path %>/resources/media/img/1.jpg" style="width:100%" class="img-responsive">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>Walk With You.</h1>
                            <h1>Record Everything You've Done.</h1>
                            <p></p>
                            <p><a class="btn btn-lg btn-primary" href="<%=path %>/page/signup">Sign up now</a></p>
                            <p>or <a class = "black" href="<%=path %>/page/signin"><small>Sign in</small></a></p>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img src="<%=path %>/resources/media/img/2.jpg" style="width:100%" class="img-responsive">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>Walk With You.</h1>
                            <h1>Record Everything You've Done.</h1>
                            <p></p>
                            <p><a class="btn btn-lg btn-primary" href="<%=path %>/page/signup">Sign up now</a></p>
                            <p>or <a class = "black" href="<%=path %>/page/signin"><small>Sign in</small></a></p>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img src="<%=path %>/resources/media/img/3.jpg" style="width:100%" class="img-responsive">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>Walk With You.</h1>
                            <h1>Record Everything You've Done.</h1>
                            <p></p>
                            <p><a class="btn btn-lg btn-primary" href="<%=path %>/page/signup">Sign up now</a></p>
                            <p>or <a class = "black" href="<%=path %>/page/signin"><small>Sign in</small></a></p>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Controls -->
            <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                <span class="icon-prev"></span>
            </a>
            <a class="right carousel-control" href="#myCarousel" data-slide="next">
                <span class="icon-next"></span>
            </a>
        </div>
        <!-- /.carousel -->


        <!-- Marketing messaging and featurettes
================================================== -->
        <!-- Wrap the rest of the page in another container to center all the content. -->

        <div class="container marketing">

            <!-- Three columns of text below the carousel -->
            
                <div class="row text-center">
                    <img class="img-circle" src="<%=path %>/resources/media/img/4.png">
                    <h2>Mobile-first</h2>
                    <p>Tablets, phones, laptops. The new 3 promises to be mobile friendly from the start.</p>
           
                </div>
               
                <div class="row text-center">
                    <img class="img-circle" src="<%=path %>/resources/media/img/5.png">
                    <h2>Record-anywhere</h2>
                    <p>Record everything you want whereever you are. Walknote help you store your memory.</p>
                </div>
      


          

        </div><!-- /.container -->
        
        <!-- FOOTER -->
        <footer>
            <div class = "container">
                <p class="pull-right"><a href="#">Back to top</a></p>
                <p>WalkNote. <a href="#">Created by wzh.</a></p>
            </div>
        </footer>
    </body>
    
</html>

