<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.mongodb.*,java.text.*,org.bson.Document,com.mongodb.client.FindIterable,com.mongodb.client.MongoCursor,com.mongodb.client.MongoCollection"%>

   <%
   response.setContentType("text/html;charset=utf-8");  //确保显示的汉字信息以正确编码方式显示
   request.setCharacterEncoding("utf-8");            //确保获取的汉字信息以正确编码方法获取

   
   int ID = Integer.parseInt(request.getParameter("ID"));
   String date = new String(request.getParameter("就诊时间"));
   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
   System.out.println(sdf.parse(date));
   Date riqi = sdf.parse(date);

   
   String name = new String(request.getParameter("姓名"));
   


   String gender = new String(request.getParameter("性别"));
   
   String age = new String(request.getParameter("年龄"));
   String number = new String(request.getParameter("就诊号"));
   boolean state;//CT是否异常
   String statestring = new String(request.getParameter("异常"));
   if (statestring.equals("true"))
	   {state = true;}
   else state =false;
   int weizhi=0;//病变位置
   int leslength=0;//病变长度
   int placue=0;//斑块特征
   double nrate = 0.0;//狭窄度
   if(state){//如果冠状动脉CT异常记录遍历病变位置、病变长度、斑块特征、狭窄度  获取值 否则直接跳过
     
	   String location[] = request.getParameterValues("病变位置");
       for (int i = 0; i<location.length;i++)
   {
	   if(location[i]!=null)
		{weizhi = Integer.parseInt(location[i]);}   
   }
       
       String length[] = request.getParameterValues("病变长度");
       for (int i = 0; i<length.length;i++)
       {
    	   if(length[i]!=null)
    		{leslength = Integer.parseInt(length[i]);}   
       }
       
       String pcharac[] = request.getParameterValues("斑块特征");
       for (int i = 0; i<pcharac.length;i++)
       {
    	   if(pcharac[i]!=null)
    		{placue = Integer.parseInt(pcharac[i]);}   
       }
      
       nrate = Double.parseDouble(request.getParameter("狭窄度"));
   }
   try{   
       // 连接到 mongodb 服务
       MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
       //此处采用无用户名和密码验证方式登陆
       @SuppressWarnings("deprecation")
       DB db = mongoClient.getDB( "ACHD" );  //连接到数据库library
      
       DBCollection coll = db.getCollection("CCTAHistory");  //获取library数据库中集合CCTAHistory
       DBCollection coll2 = db.getCollection("CCTA");//获取library数据库中集合CCTA
       System.out.println("Collection CCTA and CCTAHistory selected successfully");
      
       DBObject CCTA = new BasicDBObject();//定义一个Bson变量，用于存储注册的用户名和密码
       CCTA.put("ID", ID);
       CCTA.put("时间", riqi);  
       CCTA.put("就诊号",number);
       CCTA.put("姓名",name);
       CCTA.put("性别",gender);
       CCTA.put("年龄",age);
       CCTA.put("异常",state);
       if(state)
       {
       CCTA.put("病变位置",weizhi);
       CCTA.put("病变长度",leslength);
       CCTA.put("斑块特征",placue);
       CCTA.put("狭窄度",nrate);
       }
      
       coll.insert(CCTA);    //向集合CCTAHistory中插入注册用户信息                             
       
       //判断CCTA中是否已存在该患者的报告 若没有则插入 若有则update
        
     
       DBCursor cursor = coll2.find();  //查询集合CCTA中文档信息
            boolean has_CCTA = false;
            int i=1; 
            while (cursor.hasNext()) 
            {     //检索集合CCTA中所有文档信息
                System.out.println("CCTA Document: "+i); 
                DBObject show = cursor.next();              
                System.out.println(show); 
                @SuppressWarnings("rawtypes")
                Map show1 = show.toMap();  //将检索结果show(Bson类型)转换为Map类型
                int oldID = (Integer)show1.get("ID");  //提取Map中字段名为ID的属性值
                
                if(oldID==ID){  
                //将从数据库中获取的用户名ID与表单中获取的ID进行验证，如果相等则说明CCTA库中已有该患者的报告，则对旧报告更新
                    System.out.println();
                    //request.getRequestDispatcher("welcome.jsp").forward(request, response); 
                    has_CCTA = true;
                    //System.out.println(show1.get("ID"));
                    //System.out.println(show1.get("姓名"));
                    //System.out.println(i);此处为测试输出
                }
                i++;
             }
       if(has_CCTA)//如果CCTA集合中有该患者的报告 则进行更新
       {
    	   BasicDBObject delete = new BasicDBObject("ID",ID);  
    	   
           WriteResult result = coll2.remove(delete);  
           
       }
       coll2.insert(CCTA);    //向集合CCTA中该患者报告 
       response.sendRedirect("CCTAInsert_success.jsp");  //提交成功后，自动跳转到提交成功提示页面
       mongoClient.close();                    
    
   }catch(Exception e){
       System.err.println( e.getClass().getName() + ": " + e.getMessage() );
   }    

 %>
