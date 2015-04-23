<!DOCTYPE html>
<html>
    
    <head>
        <title>index</title>
        <meta charset="utf-8">
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">    
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="This is my page">
        <meta name="viewport" content="width=device-width, 
                                     initial-scale=1.0, 
                                     maximum-scale=1.0, 
                                     user-scalable=no">
        <meta name="author" content="wzh">
        <!-- Latest jquery.js -->
        <script src="../js/jquery.min.js"></script> 
        <!-- Latest less.js -->
        <script src="../js/less.min.js"></script>
        <!-- Latest compiled and minified JavaScript for bootstrap-->
        <script src="../js/bootstrap.js"></script>
        <!-- Latest compiled and minified CSS for bootstrap-->
        <link rel = "stylesheet" href = "../css/mycss.css">
        <link rel="stylesheet" href="../css/bootstrap.css">
        <!-- Optional theme for bootstrap-->
        <link rel="stylesheet" href="../css/bootstrap-theme.css">
    </head>

    <body>
        
        <!--<img src="img/logo.jpg" class = "img-responsive">-->

        <!-- Wrap all page content here -->
        <div id="wrap">
            
            <!-- Fixed navbar -->
            <div class="navbar navbar-inverse navbar-fixed-top">
                <div class="container">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="/index.html">GhostEyes</a>
                    </div>
                    <div>
                        <ul class="nav navbar-nav navbar-left collapse navbar-collapse">
                            <li class="active"><a href="#">Home</a></li>
                            <li><a href = "#chatroom">Chatroom</a>
                            <li><a href="#about">Blog</a></li>
                            <li><a href="#about">Tools</a></li>
                            <li><a href="#contact">Contact</a></li>
                            
                            
                            <!--  has not logged in  -->
                            <form class="navbar-form navbar-right" role="search">
                                <div class="input-group input-group-xs">
                                    <input type="text" id = "username" class="form-control input-group-sm" placeholder="Username">
                                </div>
                                <div class="input-group input-group-xs">
                                    <input type="password" id = "passwd" class="form-control input-group-sm" placeholder="Password">
                                </div>
                                <button type="submit" class="btn btn-default">Sign in</button>
                            </form>
                        
                            <!--  has already logged in  -->
                            <ul class="nav navbar-nav navbar-right">
                                <li class="dropdown">
                                    <a class="dropdown-toggle" data-toggle="dropdown">
                                        <span class="glyphicon glyphicon-user"></span>User
                                    </a>    
                                    <ul class="dropdown-menu">
                                        <li><a href="#">Profile</a></li>
                                        <li class = "divider"></li>
                                        <li><a href = "#">Setting</a></li>
                                        <li class="divider"></li>
                                        <li><a href="#">Sign out</a></li>
                                    </ul>
                                </li>
                            </ul>
                            
                        </ul>
                        <!--/.nav-collapse -->
                        
                    </div>
                </div>
            </div>
  
            <!-- Begin page content -->
            <div class="container">
                <div class="page-header">
                    <h1>Chat Room</h1>
                </div>
                <p class="lead">1. Random join a room.</p>
                <p class="lead">2. Choose a room based on topic.</p>
                <p class="lead">3. Create a room.</p>
                
                <div class="page-header">
                    <h1>Blog</h1>
                </div>
                <p class="lead">1. Create a blog.</p>
                <p class="lead">2. Browse others' blog.</p>
                <p class="lead">3. Download a blog.</p>
                
                <div class="page-header">
                    <h1>Tools <small><small>To be added</small></small></h1>
                </div>
                <p class="lead">Some useful and intesting tools are listed here.</p>
                
            </div>
        
        </div>

        <!-- sticky footer -->
        <div id="footer">
            <div class="container">
                <p class="text-muted credit">Created by wzh.</p>
            </div>
        </div>

    
    </body>
        
</html>