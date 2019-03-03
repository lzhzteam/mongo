<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.mongodb.*,java.text.*"%>
<!DOCTYPE html>
<html>
<head>

    <meta name="viewport" content="width=device-width, initial-scale=1.0；text/html; charset=UTF-8"  http-equiv="Content-Type" >
    <title>CCTA-Insert-Success</title>

    <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css" />
    <link rel="stylesheet" type="text/css" href="css/local.css" />

    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script> 
     <style>

        div {
            padding-bottom:20px;
        }
        </style>
        
               <script type="text/javascript">  
            function myCheck()  
            {  
               for(var i=0;i<6;i++)  
               {  
                  if(document.form1.elements[i].value=="")  
                  {  
                     alert("当前表单不能有空项");  
                     document.form1.elements[i].focus();  
                     return false;  
                  }  
               }
               
               return true;  
                
            }  
        </script>
        
</head>
<body>
     <div id="wrapper">
      <!-- 以下为侧边菜单栏 -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Back to Home</a>
            </div>
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                   <li ><a href="index.html"><i class="fa fa-bullseye"></i> ACDH简介</a></li>
                    <li class="selected"><a href="CCTAInsert.html"><i class="fa fa-tasks"></i> CCTA录入</a></li>
                    <li><a href="BDTInsert.html"><i class="fa fa-globe"></i> BDT录入</a></li>
                    <li><a href="search.html"><i class="fa fa-list-ol"></i> 数据分析</a></li>
                    <li ><a href="CCTA.jsp"><i class="fa fa-font"></i> 病例查询</a></li> 
                </ul>
                <ul class="nav navbar-nav navbar-right navbar-user">
                    <li class="dropdown messages-dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope"></i> Messages <span class="badge">2</span> <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li class="dropdown-header">2 New Messages</li>
                            <li class="message-preview">
                                <a href="#">
                                    <span class="avatar"><i class="fa fa-bell"></i></span>
                                    <span class="message">Security alert</span>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li class="message-preview">
                                <a href="#">
                                    <span class="avatar"><i class="fa fa-bell"></i></span>
                                    <span class="message">Security alert</span>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="#">Go to Inbox <span class="badge">2</span></a></li>
                        </ul>
                    </li>
                     <li class="dropdown user-dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> Steve Miller<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="#"><i class="fa fa-user"></i> Profile</a></li>
                            <li><a href="#"><i class="fa fa-gear"></i> Settings</a></li>
                            <li class="divider"></li>
                            <li><a href="#"><i class="fa fa-power-off"></i> Log Out</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>

        <hr/>
        <!-- CCTA表格 -->
        <div class="container">
          <div class="page-header">
            <h1>CCTAInsert</h1>
          </div>
          <div class="row">
              
                  <div class="col-sm-9">
                   <div class="row" >
                           <h1> &nbsp;&nbsp;Submitted successfully!</h1>
                   </div>
              
                  </div>
              
                
           </div>
        </div>
        
        
        
        
    </div>
</body>
</html>