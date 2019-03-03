<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.io.*,com.mongodb.*,java.text.*,org.bson.Document,com.mongodb.client.FindIterable,com.mongodb.client.MongoCursor,com.mongodb.client.MongoCollection"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>

    <meta name="viewport" content="width=device-width, initial-scale=1.0；text/html; charset=UTF-8"  http-equiv="Content-Type" >
    <title>CCTASearchName</title>

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
                    <li ><a href="CCTAInsert.html"><i class="fa fa-tasks"></i> CCTA录入</a></li>
                    <li><a href="BDTInsert.html"><i class="fa fa-globe"></i> BDT录入</a></li>
                    <li><a href="search.html"><i class="fa fa-list-ol"></i> 数据分析</a></li>
                    <li class="selected"><a href="CCTA.jsp"><i class="fa fa-font"></i> 病例查询</a></li>       
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
          
          <div class="container">
          <div class="page-header">
            <h1>CCTA</h1>
          </div>
<%
response.setContentType("text/html;charset=utf-8");  //确保显示的汉字信息以正确编码方式显示
request.setCharacterEncoding("utf-8");            //确保获取的汉字信息以正确编码方法获取
String searchName = request.getParameter("searchName");//获得想要查询的ID
String date = ""; //就诊时间
String number = "";//就诊号
String name = "";//姓名
String gender = "";//性别
String age = "";//年龄
Boolean state = false;//????冠状动脉CT是否异常
String zhuangtai = "";//用来记录状态是否异常的string,用来放进循环显示在页面的
String bingbianweizhi = "";//病变位置
String bingbianchangdu = "";//病变长度
String bankuaitezheng = "";//斑块特征
Double xiazhaidu = 0.0;//狭窄度


try{   
    // 连接到 mongodb 服务
    MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
    //此处采用无用户名和密码验证方式登陆
    @SuppressWarnings("deprecation")
    DB db = mongoClient.getDB( "ACHD" );  //连接到数据库library
   
    DBCollection coll = db.getCollection("CCTAHistory");//获取library数据库中集合CCTA
    System.out.println("Collection CCTAHistory selected successfully");
   
    DBCursor cursor = coll.find();  //查询集合CCTA中文档信息
    
    //建立数组存储查询到的信息
    //String date[] =;
    //String name[] ;
    //String gender[];
    //String age[] ;
   // String number[] ;
    //boolean state [] = {false};
    
    
    boolean has_CCTA = false;//用来检测搜寻的ID在CCTAHistory里是否有报告
         
         int i=1; 
         while (cursor.hasNext()) 
         {     //检索集合CCTA中所有文档信息
             System.out.println("CCTA Document: "+i); 
             DBObject show = cursor.next();              
             System.out.println(show); 
             @SuppressWarnings("rawtypes")
             Map show1 = show.toMap();  //将检索结果show(Bson类型)转换为Map类型
             String tempName = (String)show1.get("姓名");  //提取Map中字段名为ID的属性值
             System.out.println(tempName);
             if(tempName.equals(searchName))
            {  
            	 i++; //加i继续循环
            	 if(i==1) {%>
            	 <ul class="timeline">
            	 <% }
            	//将从数据库中获取的用户名ID与表单中获取的ID进行验证，如果相等则说明该CCTA是所查找项
                 System.out.println();
                
                 has_CCTA = true;
                 //System.out.println(show1.get("ID"));
                 //System.out.println(show1.get("姓名"));
                 //System.out.println(i);此处为测试输出
                                                   
                 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                 //System.out.println(sdf.format(date));

                 date = sdf.format(show1.get("时间"));
                 System.out.println(date);
                 name = (String)show1.get("姓名");
                 System.out.println(name);
                 gender = (String)show1.get("性别");
                 System.out.println(gender);
                 age = ((String)show1.get("年龄"));
                 System.out.println(age);
                 number = ((String)show1.get("就诊号"));
                 System.out.println(number);
                 state = ((boolean)show1.get("异常"));
                 System.out.println(state);
  %>      
  <% 
         if(i%2==1)
         {
        	 out.print(" <li><div class='timeline-badge info'><i class='fa fa-unlock'></i></div>");
         }
         else
         {
        	 out.print("<li class='timeline-inverted'><div class='timeline-badge success'><i class='fa fa-search'></i></div>");
         }   
          
          %>
                    <div class="timeline-panel">
                        <div class="timeline-heading">
                            <h4 class="timeline-title"><%=name %></h4>                            
                            <span><i class="fa fa-clock-o fa-2x"></i>&nbsp;<%=date%></span>
                            <hr>
                        </div>
                        <div class="timeline-body">
                            <ul>
                             <li>性别&nbsp;<%=gender %></li>
                             <li>年龄&nbsp;<%=age %></li>
                             <li>就诊号&nbsp;<%=number %></li>
                               
  <%              if(state)
                 {
                         int location = (int)show1.get("病变位置");//病变位置
                         
                         System.out.println(location);
                         switch(location)
                            {
                               case 1:
                    	            bingbianweizhi = "右冠中段";
                               case 2:
                            	    bingbianweizhi = "右冠近段";
                               case 3:
                           	    bingbianweizhi = "右冠远段";
                               case 4:
                           	    bingbianweizhi = "右冠来源的后降支";
                               case 5:
                           	    bingbianweizhi = "左主干";
                               case 6:
                           	    bingbianweizhi = "前降支近段";
                               case 7:
                           	    bingbianweizhi = "前降支中段";
                               case 8:
                            	    bingbianweizhi = "前降支远段";
                               case 9:
                              	    bingbianweizhi = "第一对角支";
                               case 10:
                             	    bingbianweizhi = "第二对角支";
                               case 11:
                             	    bingbianweizhi = "回旋支近段";
                               case 12:
                             	    bingbianweizhi = "第一钝缘支";
                               case 13:
                             	    bingbianweizhi = "回旋支远段";
                               case 14:
                            	    bingbianweizhi = "第二顿缘支";
                               case 15:
                            	    bingbianweizhi = "回旋支来源的后降支";
                               case 16:
                            	    bingbianweizhi = "右冠来源的左室后支";
                               case 17:
                            	    bingbianweizhi = "回旋支来源的左室后支";
                               case 18:
                            	    bingbianweizhi = "中间支";
                    /*	 右冠中段  右冠近段  右冠远段  右冠来源的后降支  左主干  前降支近段  
                    	 前降支中段  前降支远段  第一对角支  第二对角支  回旋支近段  第一钝缘支  
                    	 回旋支远段  第二顿缘支  回旋支来源的后降支  右冠来源的左室后支  回旋支来源的左室后支  中间支 */
                    	 
                    	 
                             }//这个是switch结束
                             System.out.println(bingbianweizhi);   
                             
                         int leslength = (Integer)show1.get("病变长度");//病变长度
                         switch(leslength)
                         {
                         case 1:
                        	  bingbianchangdu = "局限 （小于10mm）";
                        	  //局限（小于10mm））（2）节段（10mm-20mm））（3）弥漫（大于20mm
                         case 2:
                        	 bingbianchangdu = "节段 （10mm-20mm）";
                         case 3:
                        	 bingbianchangdu = "弥漫 （大于20mm）";
                         }
                         System.out.println(bingbianchangdu);
                         
                         int placue = (Integer)show1.get("斑块特征");//斑块特征
                         switch(placue)
                         {
                         case 1:
                        	 bankuaitezheng = "钙化斑块";
                        	 //钙化斑块（2）非钙化斑块（3）混合斑块
                         case 2:
                        	 bankuaitezheng = "非钙化斑块";
                         case 3:
                        	 bankuaitezheng = "混合斑块";
                         }
                         System.out.println(bankuaitezheng);
                         
                         double nrate = (Double)show1.get("狭窄度");//狭窄度
                         xiazhaidu= nrate;
                         System.out.println(xiazhaidu);
                        
                  
                
               
               %>
                     <li>冠状动脉CT是否异常&nbsp;是</li>
                     <li>病变位置&nbsp;<%=bingbianweizhi %></li>
                     <li>病变长度&nbsp;<%=bingbianchangdu %></li>
                     <li>斑块特征&nbsp;<%=bankuaitezheng %></li>
                     <li>狭窄度&nbsp;<%=xiazhaidu %></li>
                     
                    
               
<%      
                 }//上面if的结尾
                 else{
                	 System.out.println("否");
                	 %>
                	  <li>冠状动脉CT是否异常&nbsp;否</li>
<%                 }
  %>
 							 </ul>
                        </div>
                        </div>
                    <% 
            }//if tempID==ID 的结尾
              i++; //加i继续循环
        }//while循环的结尾

         if(age.equals("")){ %>
         <p>该姓名不存在</p>
         <% }
        mongoClient.close();                    
 
}catch(Exception e){
    System.err.println( e.getClass().getName() + ": " + e.getMessage() );
}    

%>
  </div>   
</body>
</html>