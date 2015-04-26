<%@page import="com.wzh.ghosteyes.po.Usr"%>
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
        <script src="<%=path %>/resources/media/js/jquery.min.js" type="text/javascript"></script> 
        <!-- Latest compiled and minified JavaScript for bootstrap-->
        <script src="<%=path %>/resources/media/js/bootstrap.js" type="text/javascript"></script>
        <!-- Latest compiled and minified CSS for bootstrap-->
        <link rel="stylesheet" href="<%=path %>/resources/media/css/bootstrap.css">
        <!-- My own css -->
        <link rel = "stylesheet" href = "<%=path %>/resources/media/css/mycss.css">
        <!-- Import summernote js&css-->
        <script type='text/javascript' src="//cdnjs.cloudflare.com/ajax/libs/summernote/0.5.0/summernote.min.js"></script>
        <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/summernote/0.5.0/summernote.css">
        <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/summernote/0.5.0/summernote-bs3.css">
        <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.0.3/css/font-awesome.min.css">
        <!-- My own js -->
        <script src="<%=path %>/resources/media/js/note.js" type="text/javascript"></script>
    </head>

    <body>      
        <div class = "note-wrapper well-font">
            <div  class="note-head navbar-wrapper">
       
                    <div class="navbar navbar-default navbar-static-top">
                        <div class="navbar-heade">
                            <a class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </a>
                            <a class="navbar-brand" href="/index.html"><img src = "<%=path %>/resources/media/img/logo.png" /></a>
                        </div>
                        <div class="navbar-collapse collapse">
                            <ul class="nav navbar-nav">
                                <li class="active"><a href="/index.html">Home</a></li>
                                <li><a href="note/index.html">Note</a></li>
                                <li><a href="blog/index.html">Blog</a></li>
                                <li><a href="">About</a></li>
                                <li><a href="contact/index.html">Contact</a></li>
                                
                            </ul>
                            <ul class="nav navbar-nav pull-right">
                                <li>
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">User <b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">Profile</a></li>
                                        <li><a href="#">Statics</a></li>
                                        <li><a href="#">Sign out</a></li>
                                        <li class="divider"></li>
                                    </ul>
                                </li>
                            </ul>
                        </div>

                    </div>
   
            </div><!-- /navbar wrapper -->
         
            
            <div class = "note-body ">
                <div class = "fill">
                    
                    <div class = "note-aside">
                        
                        <div class = "note-aside-top">
                            
                        </div>
                        
                        <div class = "note-aside-body" id = "aside">
                            
                            <div class = boundary>
                                &nbsp;
                            </div>
                            
                            <div id="list1">
                                
                                <div class="btn btn-primary title-font hand-cursor">
                                    <span class="glyphicon glyphicon-th-list"></span>
                                    Note
                                    <span class="pull-right icon glyphicon glyphicon-plus"></span>
                                    &nbsp;
                                </div>
                                
                            </div>
                            <!-- used for adding notebook -->
                            <table class = "table table-hover table-bordered table-condensed">
                            	<tbody id = "note-name1">            
                                </tbody>
                            </table>
                            
                            <div class = "boundary">
                                &nbsp;
                            </div>
                            
                            <div id="list2">
                                
                                <div class="btn btn-primary title-font hand-cursor">
                                    <span class="glyphicon glyphicon-th-list"></span>
                                    Time&nbsp;&nbsp;&nbsp;
                                </div>
                            </div>
                            
                             <table class = "table table-hover table-bordered table-condensed">
                                        <tbody id = "note-name2">
                                        </tbody>
                            </table>
                            
                            <div class = boundary>
                                &nbsp;
                            </div>
                            
                            <div id="list3">
                                <div class="btn btn-primary title-font hand-cursor" data-toggle="collapse" data-target="#collapse3" data-parent="#aside">
                                    <span class="glyphicon glyphicon-th-list"></span>
                                    Recycle&nbsp;
                                </div>
                            </div>
                            
                            <table class = "table table-hover table-bordered table-condensed">
                                <tbody id = "note-name3">
                                </tbody>
                           </table>
                          
                        </div>
                    </div>
                    
                    <div class = "note-list">
                        <div class = "note-list-top">
                        
                            <div>
                               
                        		<button id="create" type="button" class = "btn btn-primary">
                                    &nbsp;&nbsp;create&nbsp;&nbsp;
                                </button>
                        		
                            </div>
                    
                        </div>
                        
                        <div class = "note-list-body" id = "list4">
                           
                        </div>
                    </div>
                        
                    <div class = "note-content">
                        <div class = "note-content-top">
                        	
                        	<div class = "note-content-top-element ">
                            <div>
                            	
                                <button id="edit" type="button" class = "btn  btn-primary">
                                    &nbsp;&nbsp;edit&nbsp;&nbsp;&nbsp;
                                </button>
                                <button id="save" type="button" class = "btn  btn-primary">
                                    &nbsp;&nbsp;save&nbsp;&nbsp;
                                </button>
                                <button id="cancel" type="button" class = "btn  btn-primary">
                                    &nbsp;&nbsp;cancel&nbsp;&nbsp;
                                </button>                
                                <button id="delete" type = "button" class = "btn  btn-primary">
                                    &nbsp;&nbsp;delete&nbsp;&nbsp;
                                </button>
                                <button id="recover" type = "button" class = "btn  btn-primary">
                                    &nbsp;&nbsp;recover&nbsp;&nbsp;
                                </button>
                            </div>
                            </div>
                        </div>
                        <div class = "note-content-body">
                            <div id = "note-meta">
                            	Title: <input type = "text"  id = "title" name = "title"/>
                            	Category: <input type = "text"  id = "category" name = "category"/>
                            	NoteBook: <input type = "text" id = "notebook" name = "notebook"/>
                            	<input type = "hidden" id = "curNoteId" name = "curNoteId" />
                            	<input type = "hidden" id = "ifrecover" name = "ifrecover" />
                            </div>

                            <div id="editor">
                            </div>
                            
                        </div>
                        
                    </div>
                </div>
            </div>
            
            <div class = "note-footer">
              
                    <p class="pull-right"><a href="#">Back to top</a></p>
                    <p>WalkNote. <a href="#">Created by wzh.</a></p>
         
            </div>
            
           <div id = "usrid">${usrid}</div>
            
        </div>
       
        
        
    </body>
    
</html>

