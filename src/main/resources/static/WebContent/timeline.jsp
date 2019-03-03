<%@ page language="java" import="java.util.*,com.mongodb.*,java.math.*" pageEncoding="UTF-8" %>
<% request.setCharacterEncoding("utf-8"); %>
<% String name1=request.getParameter("jia"); %> 
 <% String name2=request.getParameter("examplejia"); %>
 <% 
 response.setContentType("text/html;charset=utf-8");  //确保显示的汉字信息以正确编码方式显示
 request.setCharacterEncoding("utf-8");            //确保获取的汉字信息以正确编码方法获取
 
 int sum=0;
 int goodbad=0;
 int goodgood=0;
 int badgood=0;
 int badbad=0;
 double rate1=0;
 double rate2=0;
 double rate=0;
 int num1=0;
 int num2=0; 
 int[] a={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};//result


    try{   
    // 连接到 mongodb 服务
    MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
    //此处采用无用户名和密码验证方式登陆
    @SuppressWarnings("deprecation")
   DB db = mongoClient.getDB( "ACHD" );  //连接到数据库ACHD
   DBCollection bdt = db.getCollection("BDT_old");  //获取ACHD数据库中集合BDT
   DBCollection ccta=db.getCollection("CCTA");//获取ACHD数据库中集合CCTA
   DBCursor cursor1 = bdt.find();  //查询集合bdt中文档信息
   DBCursor cursor2=ccta.find();  //查询集合ccta中文档信息
   
   //int sum=0;
   
   if(name1.equals("检查目的")){
	   num1=1;
	   if(name2.equals("典型心绞痛")){
		   num2=1;
	   }
	   if(name2.equals("非典型胸部不适")){
		   num2=2;
	   }
	   if(name2.equals("非胸痛症状")){
		   num2=3;
	   }
	   if(name2.equals("心电图异常")){
		   num2=4;
	   }
	   if(name2.equals("心脏超声异常")){
		   num2=5;
	   }
   }else
   if(name1.equals("高血压病")){
	   num1=2;
	   num2=1;
   }else 
   if(name1.equals("血脂异常")){
	   num1=3;
	   num2=1;
   }else 
   if(name1.equals("糖尿病史")){
	   num1=4;
	   if(name2.equals("1型")){
		   num2=1;
	   }
	   if(name2.equals("2型")){
		   num2=2;
	   }
   }else 
   if(name1.equals("脑卒中病史")){
	   num1=5;
	   num2=1;
   }else 
   if(name1.equals("外周血管病")){
	   num1=6;
	   num2=1;
   }else
   if(name1.equals("吸烟史")){
	   num1=7;
	   if(name2.equals("经常吸")){
		   num2=1;
	   }
	   if(name2.equals("偶吸")){
		   num2=2;
	   }
	   if(name2.equals("过去吸，现已戒烟")){
		   num2=3;
	   }
	   if(name2.equals("从不吸")){
		   num2=4;
	   }
   }else 
   if(name1.equals("饮酒史")){
	   num1=8;
	   if(name2.equals("经常饮")){
		   num2=1;
	   }
	   if(name2.equals("偶饮")){
		   num2=2;
	   }
	   if(name2.equals("过去饮")){
		   num2=3;
	   }
	   if(name2.equals("从不饮")){
		   num2=4;
	   }
	   
   }else 
   if(name1.equals("体育锻炼史")){
	   num1=9;
	   if(name2.equals("基本不锻炼")){
		   num2=1;
	   }
	   if(name2.equals("每周小于3次")){
		   num2=2;
	   }
	   if(name2.equals("每周大于等于3次")){
		   num2=3;
	   }
   }else 
   if(name1.equals("心肌梗死")){
	   num1=10;
	   num2=1;
   }else 
   if(name1.equals("其他疾病史")){
	   num1=11;
	   if(name2.equals("肝功能不全")){
		   num2=1;
	   }
	   if(name2.equals("肾功能不全")){
		   num2=2;
	   }
	   if(name2.equals("肿瘤")){
		   num2=3;
	   }
	   
   }else 
   if(name1.equals("家族史")){
	   num1=12;
	   if(name2.equals("冠心病家族史")){
		   num2=1;
	   }
	   if(name2.equals("高脂血症家族史")){
		   num2=2;
	   }
   }
  
   ///////////////////////////////////////
   if(num1==1&&num2==1){
	   sum=bdt.find().count();
   
	   cursor1= bdt.find();
       Boolean result1=false;
	   Boolean file_name=true;
	   while (cursor1.hasNext()){  
		   DBObject object = cursor1.next(); 
		   ArrayList<Object> versi=(ArrayList<Object>)object.get("检查目的");  
		   result1=(boolean)versi.get(0);
		   
		    int id=(int)object.get("ID");
		    DBObject query1 = new BasicDBObject("ID",id);  
		    DBObject query2 = new BasicDBObject("ID",new BasicDBObject("$gte",id));  
		    cursor2=ccta.find(query2);
		    DBObject object2 = cursor2.next(); 
		    boolean result2=(boolean)object2.get("异常");
		    if(result1==true&&result2==true){
		    	badbad++;
		    	int mm=(int)object2.get("病变位置");
		    	a[mm]++;
		    }
		    else if(result1==false&&result2==true){
		    	goodbad++;
		    }
		    else if(result1==true&&result2==false){
		    	badgood++;
		    }
		    else if(result1==false&&result2==false){
		    	goodgood++;
		    }
		    
		    
	 }
	 //计算结果
     if((badbad+goodbad)==0){
    	 rate1=0;
     }else{
    	 
	 rate1=(double)badbad/(badbad+goodbad);//bad 的发病率 
     }
     if((badgood+goodgood)==0){
    	 rate2=0;
     }else{
    	 rate2=(double)badgood/(badgood+goodgood);// good的发病率
     }
     if(rate2==0){
    	 rate=0;
     }
     else{
	  rate=(double)rate1/rate2;
     }
	  System.out.println(sum);
	  System.out.println("rate1:"+rate1);
	  System.out.println("rate2:"+rate2);
	  System.out.println("rate:"+rate);
	}
   
   else if(num1==1&&num2==2){
	   sum=bdt.find().count();
	   
	   cursor1= bdt.find();
       Boolean result1=false;
	   Boolean file_name=true;
	   while (cursor1.hasNext()){  
		   DBObject object = cursor1.next(); 
		   ArrayList<Object> versi=(ArrayList<Object>)object.get("检查目的");  
		   result1=(boolean)versi.get(1);
		   
		    int id=(int)object.get("ID");
		    DBObject query1 = new BasicDBObject("ID",id);  
		    DBObject query2 = new BasicDBObject("ID",new BasicDBObject("$gte",id));  
		    cursor2=ccta.find(query2);
		    DBObject object2 = cursor2.next(); 
		    boolean result2=(boolean)object2.get("异常");
		    if(result1==true&&result2==true){
		    	badbad++;
		    	int mm=(int)object2.get("病变位置");
		    	a[mm]++;
		    }
		    else if(result1==false&&result2==true){
		    	goodbad++;
		    }
		    else if(result1==true&&result2==false){
		    	badgood++;
		    }
		    else if(result1==false&&result2==false){
		    	goodgood++;
		    }
		    
		    
	 }
	 //计算结果
     if((badbad+goodbad)==0){
    	 rate1=0;
     }else{
    	 
	 rate1=(double)badbad/(badbad+goodbad);//bad 的发病率 
     }
     if((badgood+goodgood)==0){
    	 rate2=0;
     }else{
    	 rate2=(double)badgood/(badgood+goodgood);// good的发病率
     }
     if(rate2==0){
    	 rate=0;
     }
     else{
	  rate=(double)rate1/rate2;
     }
	  System.out.println(sum);
	  System.out.println("rate1:"+rate1);
	  System.out.println("rate2:"+rate2);
	  System.out.println("rate:"+rate);
   }
else if(num1==1&&num2==3){
	sum=bdt.find().count();
	   
	   cursor1= bdt.find();
    Boolean result1=false;
	   Boolean file_name=true;
	   while (cursor1.hasNext()){  
		   DBObject object = cursor1.next(); 
		   ArrayList<Object> versi=(ArrayList<Object>)object.get("检查目的");  
		   result1=(boolean)versi.get(2);
		   
		    int id=(int)object.get("ID");
		    DBObject query1 = new BasicDBObject("ID",id);  
		    DBObject query2 = new BasicDBObject("ID",new BasicDBObject("$gte",id));  
		    cursor2=ccta.find(query2);
		    DBObject object2 = cursor2.next(); 
		    boolean result2=(boolean)object2.get("异常");
		    if(result1==true&&result2==true){
		    	badbad++;
		    	int mm=(int)object2.get("病变位置");
		    	a[mm]++;
		    }
		    else if(result1==false&&result2==true){
		    	goodbad++;
		    }
		    else if(result1==true&&result2==false){
		    	badgood++;
		    }
		    else if(result1==false&&result2==false){
		    	goodgood++;
		    }
		    
		    
	 }
	 //计算结果
  if((badbad+goodbad)==0){
 	 rate1=0;
  }else{
 	 
	 rate1=(double)badbad/(badbad+goodbad);//bad 的发病率 
  }
  if((badgood+goodgood)==0){
 	 rate2=0;
  }else{
 	 rate2=(double)badgood/(badgood+goodgood);// good的发病率
  }
  if(rate2==0){
 	 rate=0;
  }
  else{
	  rate=(double)rate1/rate2;
  }
	  System.out.println(sum);
	  System.out.println("rate1:"+rate1);
	  System.out.println("rate2:"+rate2);
	  System.out.println("rate:"+rate);
   }
else if(num1==1&&num2==4){
	sum=bdt.find().count();
	   
	   cursor1= bdt.find();
    Boolean result1=false;
	   Boolean file_name=true;
	   while (cursor1.hasNext()){  
		   DBObject object = cursor1.next(); 
		   ArrayList<Object> versi=(ArrayList<Object>)object.get("检查目的");  
		   result1=(boolean)versi.get(3);
		   
		    int id=(int)object.get("ID");
		    DBObject query1 = new BasicDBObject("ID",id);  
		    DBObject query2 = new BasicDBObject("ID",new BasicDBObject("$gte",id));  
		    cursor2=ccta.find(query2);
		    DBObject object2 = cursor2.next(); 
		    boolean result2=(boolean)object2.get("异常");
		    if(result1==true&&result2==true){
		    	badbad++;
		    	int mm=(int)object2.get("病变位置");
		    	a[mm]++;
		    }
		    else if(result1==false&&result2==true){
		    	goodbad++;
		    }
		    else if(result1==true&&result2==false){
		    	badgood++;
		    }
		    else if(result1==false&&result2==false){
		    	goodgood++;
		    }
		    
		    
	 }
	 //计算结果
  if((badbad+goodbad)==0){
 	 rate1=0;
  }else{
 	 
	 rate1=(double)badbad/(badbad+goodbad);//bad 的发病率 
  }
  if((badgood+goodgood)==0){
 	 rate2=0;
  }else{
 	 rate2=(double)badgood/(badgood+goodgood);// good的发病率
  }
  if(rate2==0){
 	 rate=0;
  }
  else{
	  rate=(double)rate1/rate2;
  }
	  System.out.println(sum);
	  System.out.println("rate1:"+rate1);
	  System.out.println("rate2:"+rate2);
	  System.out.println("rate:"+rate); 
}
else if(num1==1&&num2==5){
   sum=bdt.find().count();
   
   cursor1= bdt.find();
   Boolean result1=false;
   Boolean file_name=true;
   while (cursor1.hasNext()){  
	   DBObject object = cursor1.next(); 
	   ArrayList<Object> versi=(ArrayList<Object>)object.get("检查目的");  
	   result1=(boolean)versi.get(4);
	   
	    int id=(int)object.get("ID");
	    DBObject query1 = new BasicDBObject("ID",id);  
	    DBObject query2 = new BasicDBObject("ID",new BasicDBObject("$gte",id));  
	    cursor2=ccta.find(query2);
	    DBObject object2 = cursor2.next(); 
	    boolean result2=(boolean)object2.get("异常");
	    if(result1==true&&result2==true){
	    	badbad++;
	    	int mm=(int)object2.get("病变位置");
	    	a[mm]++;
	    }
	    else if(result1==false&&result2==true){
	    	goodbad++;
	    }
	    else if(result1==true&&result2==false){
	    	badgood++;
	    }
	    else if(result1==false&&result2==false){
	    	goodgood++;
	    }
	    
	    
 }
 //计算结果
 if((badbad+goodbad)==0){
	 rate1=0;
 }else{
	 
 rate1=(double)badbad/(badbad+goodbad);//bad 的发病率 
 }
 if((badgood+goodgood)==0){
	 rate2=0;
 }else{
	 rate2=(double)badgood/(badgood+goodgood);// good的发病率
 }
 if(rate2==0){
	 rate=0;
 }
 else{
  rate=(double)rate1/rate2;
 }
  System.out.println(sum);
  System.out.println("rate1:"+rate1);
  System.out.println("rate2:"+rate2);
  System.out.println("rate:"+rate);
}
else if(num1==2&&num2==1){
	sum=bdt.find().count();
	   
	   cursor1= bdt.find();
    Boolean result1=false;
	   Boolean file_name=true;
	   while (cursor1.hasNext()){  
		   DBObject object = cursor1.next(); 
		   ArrayList<Object> versi=(ArrayList<Object>)object.get("高血压病");
		   int num=(int)versi.get(0);
		   if(num==3){
			   result1=true;
		   }
		   else{
			   result1=false;
		   }
		   
		   
		    int id=(int)object.get("ID");
		    DBObject query1 = new BasicDBObject("ID",id);  
		    DBObject query2 = new BasicDBObject("ID",new BasicDBObject("$gte",id));  
		    cursor2=ccta.find(query2);
		    DBObject object2 = cursor2.next(); 
		    boolean result2=(boolean)object2.get("异常");
		    if(result1==true&&result2==true){
		    	badbad++;
		    	int mm=(int)object2.get("病变位置");
		    	a[mm]++;
		    }
		    else if(result1==false&&result2==true){
		    	goodbad++;
		    }
		    else if(result1==true&&result2==false){
		    	badgood++;
		    }
		    else if(result1==false&&result2==false){
		    	goodgood++;
		    }
		    
		    
	 }
	 //计算结果
  if((badbad+goodbad)==0){
 	 rate1=0;
  }else{
 	 
	 rate1=(double)badbad/(badbad+goodbad);//bad 的发病率 
  }
  if((badgood+goodgood)==0){
 	 rate2=0;
  }else{
 	 rate2=(double)badgood/(badgood+goodgood);// good的发病率
  }
  if(rate2==0){
 	 rate=0;
  }
  else{
	  rate=(double)rate1/rate2;
  }
	  System.out.println(sum);
	  System.out.println("rate1:"+rate1);
	  System.out.println("rate2:"+rate2);
	  System.out.println("rate:"+rate);
}
else if(num1==3&&num2==1){
	sum=bdt.find().count();
	   
	   cursor1= bdt.find();
 Boolean result1=false;
	   Boolean file_name=true;
	   while (cursor1.hasNext()){  
		   DBObject object = cursor1.next(); 
		   ArrayList<Object> versi=(ArrayList<Object>)object.get("血脂异常");
		   int num=(int)versi.get(0);
		   if(num==3){
			   result1=true;
		   }
		   else{
			   result1=false;
		   }
		   
		   
		    int id=(int)object.get("ID");
		    DBObject query1 = new BasicDBObject("ID",id);  
		    DBObject query2 = new BasicDBObject("ID",new BasicDBObject("$gte",id));  
		    cursor2=ccta.find(query2);
		    DBObject object2 = cursor2.next(); 
		    boolean result2=(boolean)object2.get("异常");
		    if(result1==true&&result2==true){
		    	badbad++;
		    	int mm=(int)object2.get("病变位置");
		    	a[mm]++;
		    }
		    else if(result1==false&&result2==true){
		    	goodbad++;
		    }
		    else if(result1==true&&result2==false){
		    	badgood++;
		    }
		    else if(result1==false&&result2==false){
		    	goodgood++;
		    }
		    
		    
	 }
	 //计算结果
if((badbad+goodbad)==0){
	 rate1=0;
}else{
	 
	 rate1=(double)badbad/(badbad+goodbad);//bad 的发病率 
}
if((badgood+goodgood)==0){
	 rate2=0;
}else{
	 rate2=(double)badgood/(badgood+goodgood);// good的发病率
}
if(rate2==0){
	 rate=0;
}
else{
	  rate=(double)rate1/rate2;
}
	  System.out.println(sum);
	  System.out.println("rate1:"+rate1);
	  System.out.println("rate2:"+rate2);
	  System.out.println("rate:"+rate);
}
else if(num1==4&&num2==1){
   sum=bdt.find().count();
   
   cursor1= bdt.find();
Boolean result1=false;
   Boolean file_name=true;
   while (cursor1.hasNext()){  
	   DBObject object = cursor1.next(); 
	   ArrayList<Object> versi=(ArrayList<Object>)object.get("糖尿病史");
	   int num=(int)versi.get(0);
	   int numm=0;
	   if(num==3){
		   numm=(int)versi.get(1);
	   }
	   if(num==3&&numm==1){
		   result1=true;
	   }
	   else{
		   result1=false;
	   }
	   
	   
	    int id=(int)object.get("ID");
	    DBObject query1 = new BasicDBObject("ID",id);  
	    DBObject query2 = new BasicDBObject("ID",new BasicDBObject("$gte",id));  
	    cursor2=ccta.find(query2);
	    DBObject object2 = cursor2.next(); 
	    boolean result2=(boolean)object2.get("异常");
	    if(result1==true&&result2==true){
	    	badbad++;
	    	int mm=(int)object2.get("病变位置");
	    	a[mm]++;
	    }
	    else if(result1==false&&result2==true){
	    	goodbad++;
	    }
	    else if(result1==true&&result2==false){
	    	badgood++;
	    }
	    else if(result1==false&&result2==false){
	    	goodgood++;
	    }
	    
	    
 }
 //计算结果
if((badbad+goodbad)==0){
	 rate1=0;
}else{
	 
 rate1=(double)badbad/(badbad+goodbad);//bad 的发病率 
}
if((badgood+goodgood)==0){
	 rate2=0;
}else{
	 rate2=(double)badgood/(badgood+goodgood);// good的发病率
}
if(rate2==0){
	 rate=0;
}
else{
  rate=(double)rate1/rate2;
}
  System.out.println(sum);
  System.out.println("rate1:"+rate1);
  System.out.println("rate2:"+rate2);
  System.out.println("rate:"+rate);
}
else if(num1==4&&num2==2){
	sum=bdt.find().count();
	   
	   cursor1= bdt.find();
	Boolean result1=false;
	   Boolean file_name=true;
	   while (cursor1.hasNext()){  
		   DBObject object = cursor1.next(); 
		   ArrayList<Object> versi=(ArrayList<Object>)object.get("糖尿病史");
		   int num=(int)versi.get(0);
		   int numm=0;
		   if(num==3){
			   numm=(int)versi.get(1);
		   }
		   if(num==3&&numm==2){
			   result1=true;
		   }
		   else{
			   result1=false;
		   }
		   
		   
		    int id=(int)object.get("ID");
		    DBObject query1 = new BasicDBObject("ID",id);  
		    DBObject query2 = new BasicDBObject("ID",new BasicDBObject("$gte",id));  
		    cursor2=ccta.find(query2);
		    DBObject object2 = cursor2.next(); 
		    boolean result2=(boolean)object2.get("异常");
		    if(result1==true&&result2==true){
		    	badbad++;
		    	int mm=(int)object2.get("病变位置");
		    	a[mm]++;
		    }
		    else if(result1==false&&result2==true){
		    	goodbad++;
		    }
		    else if(result1==true&&result2==false){
		    	badgood++;
		    }
		    else if(result1==false&&result2==false){
		    	goodgood++;
		    }
		    
		    
	 }
	 //计算结果
	if((badbad+goodbad)==0){
		 rate1=0;
	}else{
		 
	 rate1=(double)badbad/(badbad+goodbad);//bad 的发病率 
	}
	if((badgood+goodgood)==0){
		 rate2=0;
	}else{
		 rate2=(double)badgood/(badgood+goodgood);// good的发病率
	}
	if(rate2==0){
		 rate=0;
	}
	else{
	  rate=(double)rate1/rate2;
	}
	  System.out.println(sum);
	  System.out.println("rate1:"+rate1);
	  System.out.println("rate2:"+rate2);
	  System.out.println("rate:"+rate);
}
else if(num1==5&&num2==1){
   sum=bdt.find().count();
   
   cursor1= bdt.find();
Boolean result1=false;
   Boolean file_name=true;
   while (cursor1.hasNext()){  
	   DBObject object = cursor1.next(); 
	   ArrayList<Object> versi=(ArrayList<Object>)object.get("脑卒中病史");
	   int num=(int)versi.get(0);
	   if(num==3){
		   result1=true;
	   }
	   else{
		   result1=false;
	   }
	   
	   
	    int id=(int)object.get("ID");
	    DBObject query1 = new BasicDBObject("ID",id);  
	    DBObject query2 = new BasicDBObject("ID",new BasicDBObject("$gte",id));  
	    cursor2=ccta.find(query2);
	    DBObject object2 = cursor2.next(); 
	    boolean result2=(boolean)object2.get("异常");
	    if(result1==true&&result2==true){
	    	badbad++;
	    	int mm=(int)object2.get("病变位置");
	    	a[mm]++;
	    }
	    else if(result1==false&&result2==true){
	    	goodbad++;
	    }
	    else if(result1==true&&result2==false){
	    	badgood++;
	    }
	    else if(result1==false&&result2==false){
	    	goodgood++;
	    }
	    
	    
 }
 //计算结果
if((badbad+goodbad)==0){
	 rate1=0;
}else{
	 
 rate1=(double)badbad/(badbad+goodbad);//bad 的发病率 
}
if((badgood+goodgood)==0){
	 rate2=0;
}else{
	 rate2=(double)badgood/(badgood+goodgood);// good的发病率
}
if(rate2==0){
	 rate=0;
}
else{
  rate=(double)rate1/rate2;
}
  System.out.println(sum);
  System.out.println("rate1:"+rate1);
  System.out.println("rate2:"+rate2);
  System.out.println("rate:"+rate);
}
else if(num1==6&&num2==1){
	sum=bdt.find().count();
	   
	   cursor1= bdt.find();
	Boolean result1=false;
	   Boolean file_name=true;
	   while (cursor1.hasNext()){  
		   DBObject object = cursor1.next(); 
		   ArrayList<Object> versi=(ArrayList<Object>)object.get("外周血管病");
		   int num=(int)versi.get(0);
		   if(num==3){
			   result1=true;
		   }
		   else{
			   result1=false;
		   }
		   
		   
		    int id=(int)object.get("ID");
		    DBObject query1 = new BasicDBObject("ID",id);  
		    DBObject query2 = new BasicDBObject("ID",new BasicDBObject("$gte",id));  
		    cursor2=ccta.find(query2);
		    DBObject object2 = cursor2.next(); 
		    boolean result2=(boolean)object2.get("异常");
		    if(result1==true&&result2==true){
		    	badbad++;
		    	int mm=(int)object2.get("病变位置");
		    	a[mm]++;
		    }
		    else if(result1==false&&result2==true){
		    	goodbad++;
		    }
		    else if(result1==true&&result2==false){
		    	badgood++;
		    }
		    else if(result1==false&&result2==false){
		    	goodgood++;
		    }
		    
		    
	 }
	 //计算结果
	if((badbad+goodbad)==0){
		 rate1=0;
	}else{
		 
	 rate1=(double)badbad/(badbad+goodbad);//bad 的发病率 
	}
	if((badgood+goodgood)==0){
		 rate2=0;
	}else{
		 rate2=(double)badgood/(badgood+goodgood);// good的发病率
	}
	if(rate2==0){
		 rate=0;
	}
	else{
	  rate=(double)rate1/rate2;
	}
	  System.out.println(sum);
	  System.out.println("rate1:"+rate1);
	  System.out.println("rate2:"+rate2);
	  System.out.println("rate:"+rate);
}
else if(num1==7&&num2==1){
   sum=bdt.find().count();
   
   cursor1= bdt.find();
Boolean result1=false;
   Boolean file_name=true;
   while (cursor1.hasNext()){  
	   DBObject object = cursor1.next(); 
	   ArrayList<Object> versi=(ArrayList<Object>)object.get("吸烟史");
	   int num=(int)versi.get(0);
	   
	   if(num==1){
		   result1=true;
	   }
	   else{
		   result1=false;
	   }
	   
	   
	    int id=(int)object.get("ID");
	    DBObject query1 = new BasicDBObject("ID",id);  
	    DBObject query2 = new BasicDBObject("ID",new BasicDBObject("$gte",id));  
	    cursor2=ccta.find(query2);
	    DBObject object2 = cursor2.next(); 
	    boolean result2=(boolean)object2.get("异常");
	    if(result1==true&&result2==true){
	    	badbad++;
	    	int mm=(int)object2.get("病变位置");
	    	a[mm]++;
	    }
	    else if(result1==false&&result2==true){
	    	goodbad++;
	    }
	    else if(result1==true&&result2==false){
	    	badgood++;
	    }
	    else if(result1==false&&result2==false){
	    	goodgood++;
	    }
	    
	    
 }
 //计算结果
if((badbad+goodbad)==0){
	 rate1=0;
}else{
	 
 rate1=(double)badbad/(badbad+goodbad);//bad 的发病率 
}
if((badgood+goodgood)==0){
	 rate2=0;
}else{
	 rate2=(double)badgood/(badgood+goodgood);// good的发病率
}
if(rate2==0){
	 rate=0;
}
else{
  rate=(double)rate1/rate2;
}
  System.out.println(sum);
  System.out.println("rate1:"+rate1);
  System.out.println("rate2:"+rate2);
  System.out.println("rate:"+rate);
}
else if(num1==7&&num2==2){
	sum=bdt.find().count();
	   
	   cursor1= bdt.find();
	Boolean result1=false;
	   Boolean file_name=true;
	   while (cursor1.hasNext()){  
		   DBObject object = cursor1.next(); 
		   ArrayList<Object> versi=(ArrayList<Object>)object.get("吸烟史");
		   int num=(int)versi.get(0);
		   
		   if(num==2){
			   result1=true;
		   }
		   else{
			   result1=false;
		   }
		   
		   
		    int id=(int)object.get("ID");
		    DBObject query1 = new BasicDBObject("ID",id);  
		    DBObject query2 = new BasicDBObject("ID",new BasicDBObject("$gte",id));  
		    cursor2=ccta.find(query2);
		    DBObject object2 = cursor2.next(); 
		    boolean result2=(boolean)object2.get("异常");
		    if(result1==true&&result2==true){
		    	badbad++;
		    	int mm=(int)object2.get("病变位置");
		    	a[mm]++;
		    }
		    else if(result1==false&&result2==true){
		    	goodbad++;
		    }
		    else if(result1==true&&result2==false){
		    	badgood++;
		    }
		    else if(result1==false&&result2==false){
		    	goodgood++;
		    }
		    
		    
	 }
	 //计算结果
	if((badbad+goodbad)==0){
		 rate1=0;
	}else{
		 
	 rate1=(double)badbad/(badbad+goodbad);//bad 的发病率 
	}
	if((badgood+goodgood)==0){
		 rate2=0;
	}else{
		 rate2=(double)badgood/(badgood+goodgood);// good的发病率
	}
	if(rate2==0){
		 rate=0;
	}
	else{
	  rate=(double)rate1/rate2;
	}
	  System.out.println(sum);
	  System.out.println("rate1:"+rate1);
	  System.out.println("rate2:"+rate2);
	  System.out.println("rate:"+rate);
}
else if(num1==7&&num2==3){
	sum=bdt.find().count();
	   
	   cursor1= bdt.find();
	Boolean result1=false;
	   Boolean file_name=true;
	   while (cursor1.hasNext()){  
		   DBObject object = cursor1.next(); 
		   ArrayList<Object> versi=(ArrayList<Object>)object.get("吸烟史");
		   int num=(int)versi.get(0);
		   
		   if(num==3){
			   result1=true;
		   }
		   else{
			   result1=false;
		   }
		   
		   
		    int id=(int)object.get("ID");
		    DBObject query1 = new BasicDBObject("ID",id);  
		    DBObject query2 = new BasicDBObject("ID",new BasicDBObject("$gte",id));  
		    cursor2=ccta.find(query2);
		    DBObject object2 = cursor2.next(); 
		    boolean result2=(boolean)object2.get("异常");
		    if(result1==true&&result2==true){
		    	badbad++;
		    	int mm=(int)object2.get("病变位置");
		    	a[mm]++;
		    }
		    else if(result1==false&&result2==true){
		    	goodbad++;
		    }
		    else if(result1==true&&result2==false){
		    	badgood++;
		    }
		    else if(result1==false&&result2==false){
		    	goodgood++;
		    }
		    
		    
	 }
	 //计算结果
	if((badbad+goodbad)==0){
		 rate1=0;
	}else{
		 
	 rate1=(double)badbad/(badbad+goodbad);//bad 的发病率 
	}
	if((badgood+goodgood)==0){
		 rate2=0;
	}else{
		 rate2=(double)badgood/(badgood+goodgood);// good的发病率
	}
	if(rate2==0){
		 rate=0;
	}
	else{
	  rate=(double)rate1/rate2;
	}
	  System.out.println(sum);
	  System.out.println("rate1:"+rate1);
	  System.out.println("rate2:"+rate2);
	  System.out.println("rate:"+rate);
}
else if(num1==7&&num2==4){
	sum=bdt.find().count();
	   
	   cursor1= bdt.find();
	Boolean result1=false;
	   Boolean file_name=true;
	   while (cursor1.hasNext()){  
		   DBObject object = cursor1.next(); 
		   ArrayList<Object> versi=(ArrayList<Object>)object.get("吸烟史");
		   int num=(int)versi.get(0);
		   
		   if(num==4){
			   result1=true;
		   }
		   else{
			   result1=false;
		   }
		   
		   
		    int id=(int)object.get("ID");
		    DBObject query1 = new BasicDBObject("ID",id);  
		    DBObject query2 = new BasicDBObject("ID",new BasicDBObject("$gte",id));  
		    cursor2=ccta.find(query2);
		    DBObject object2 = cursor2.next(); 
		    boolean result2=(boolean)object2.get("异常");
		    if(result1==true&&result2==true){
		    	badbad++;
		    	int mm=(int)object2.get("病变位置");
		    	a[mm]++;
		    }
		    else if(result1==false&&result2==true){
		    	goodbad++;
		    }
		    else if(result1==true&&result2==false){
		    	badgood++;
		    }
		    else if(result1==false&&result2==false){
		    	goodgood++;
		    }
		    
		    
	 }
	 //计算结果
	if((badbad+goodbad)==0){
		 rate1=0;
	}else{
		 
	 rate1=(double)badbad/(badbad+goodbad);//bad 的发病率 
	}
	if((badgood+goodgood)==0){
		 rate2=0;
	}else{
		 rate2=(double)badgood/(badgood+goodgood);// good的发病率
	}
	if(rate2==0){
		 rate=0;
	}
	else{
	  rate=(double)rate1/rate2;
	}
	  System.out.println(sum);
	  System.out.println("rate1:"+rate1);
	  System.out.println("rate2:"+rate2);
	  System.out.println("rate:"+rate);
}
else if(num1==8&&num2==1){
   sum=bdt.find().count();
   
   cursor1= bdt.find();
Boolean result1=false;
   Boolean file_name=true;
   while (cursor1.hasNext()){  
	   DBObject object = cursor1.next(); 
	   ArrayList<Object> versi=(ArrayList<Object>)object.get("饮酒史");
	   int num=(int)versi.get(0);
	   
	   if(num==1){
		   result1=true;
	   }
	   else{
		   result1=false;
	   }
	   
	   
	    int id=(int)object.get("ID");
	    DBObject query1 = new BasicDBObject("ID",id);  
	    DBObject query2 = new BasicDBObject("ID",new BasicDBObject("$gte",id));  
	    cursor2=ccta.find(query2);
	    DBObject object2 = cursor2.next(); 
	    boolean result2=(boolean)object2.get("异常");
	    if(result1==true&&result2==true){
	    	badbad++;
	    	int mm=(int)object2.get("病变位置");
	    	a[mm]++;
	    }
	    else if(result1==false&&result2==true){
	    	goodbad++;
	    }
	    else if(result1==true&&result2==false){
	    	badgood++;
	    }
	    else if(result1==false&&result2==false){
	    	goodgood++;
	    }
	    
	    
 }
 //计算结果
if((badbad+goodbad)==0){
	 rate1=0;
}else{
	 
 rate1=(double)badbad/(badbad+goodbad);//bad 的发病率 
}
if((badgood+goodgood)==0){
	 rate2=0;
}else{
	 rate2=(double)badgood/(badgood+goodgood);// good的发病率
}
if(rate2==0){
	 rate=0;
}
else{
  rate=(double)rate1/rate2;
}
  System.out.println(sum);
  System.out.println("rate1:"+rate1);
  System.out.println("rate2:"+rate2);
  System.out.println("rate:"+rate);
}
else if(num1==8&&num2==2){
	sum=bdt.find().count();
	   
	   cursor1= bdt.find();
	Boolean result1=false;
	   Boolean file_name=true;
	   while (cursor1.hasNext()){  
		   DBObject object = cursor1.next(); 
		   ArrayList<Object> versi=(ArrayList<Object>)object.get("饮酒史");
		   int num=(int)versi.get(0);
		   
		   if(num==2){
			   result1=true;
		   }
		   else{
			   result1=false;
		   }
		   
		   
		    int id=(int)object.get("ID");
		    DBObject query1 = new BasicDBObject("ID",id);  
		    DBObject query2 = new BasicDBObject("ID",new BasicDBObject("$gte",id));  
		    cursor2=ccta.find(query2);
		    DBObject object2 = cursor2.next(); 
		    boolean result2=(boolean)object2.get("异常");
		    if(result1==true&&result2==true){
		    	badbad++;
		    	int mm=(int)object2.get("病变位置");
		    	a[mm]++;
		    }
		    else if(result1==false&&result2==true){
		    	goodbad++;
		    }
		    else if(result1==true&&result2==false){
		    	badgood++;
		    }
		    else if(result1==false&&result2==false){
		    	goodgood++;
		    }
		    
		    
	 }
	 //计算结果
	if((badbad+goodbad)==0){
		 rate1=0;
	}else{
		 
	 rate1=(double)badbad/(badbad+goodbad);//bad 的发病率 
	}
	if((badgood+goodgood)==0){
		 rate2=0;
	}else{
		 rate2=(double)badgood/(badgood+goodgood);// good的发病率
	}
	if(rate2==0){
		 rate=0;
	}
	else{
	  rate=(double)rate1/rate2;
	}
	  System.out.println(sum);
	  System.out.println("rate1:"+rate1);
	  System.out.println("rate2:"+rate2);
	  System.out.println("rate:"+rate);
}
else if(num1==8&&num2==3){
	sum=bdt.find().count();
	   
	   cursor1= bdt.find();
	Boolean result1=false;
	   Boolean file_name=true;
	   while (cursor1.hasNext()){  
		   DBObject object = cursor1.next(); 
		   ArrayList<Object> versi=(ArrayList<Object>)object.get("饮酒史");
		   int num=(int)versi.get(0);
		   
		   if(num==3){
			   result1=true;
		   }
		   else{
			   result1=false;
		   }
		   
		   
		    int id=(int)object.get("ID");
		    DBObject query1 = new BasicDBObject("ID",id);  
		    DBObject query2 = new BasicDBObject("ID",new BasicDBObject("$gte",id));  
		    cursor2=ccta.find(query2);
		    DBObject object2 = cursor2.next(); 
		    boolean result2=(boolean)object2.get("异常");
		    if(result1==true&&result2==true){
		    	badbad++;
		    	int mm=(int)object2.get("病变位置");
		    	a[mm]++;
		    }
		    else if(result1==false&&result2==true){
		    	goodbad++;
		    }
		    else if(result1==true&&result2==false){
		    	badgood++;
		    }
		    else if(result1==false&&result2==false){
		    	goodgood++;
		    }
		    
		    
	 }
	 //计算结果
	if((badbad+goodbad)==0){
		 rate1=0;
	}else{
		 
	 rate1=(double)badbad/(badbad+goodbad);//bad 的发病率 
	}
	if((badgood+goodgood)==0){
		 rate2=0;
	}else{
		 rate2=(double)badgood/(badgood+goodgood);// good的发病率
	}
	if(rate2==0){
		 rate=0;
	}
	else{
	  rate=(double)rate1/rate2;
	}
	  System.out.println(sum);
	  System.out.println("rate1:"+rate1);
	  System.out.println("rate2:"+rate2);
	  System.out.println("rate:"+rate); 
}
else if(num1==8&&num2==4){
	sum=bdt.find().count();
	   
	   cursor1= bdt.find();
	Boolean result1=false;
	   Boolean file_name=true;
	   while (cursor1.hasNext()){  
		   DBObject object = cursor1.next(); 
		   ArrayList<Object> versi=(ArrayList<Object>)object.get("饮酒史");
		   int num=(int)versi.get(0);
		   
		   if(num==4){
			   result1=true;
		   }
		   else{
			   result1=false;
		   }
		   
		   
		    int id=(int)object.get("ID");
		    DBObject query1 = new BasicDBObject("ID",id);  
		    DBObject query2 = new BasicDBObject("ID",new BasicDBObject("$gte",id));  
		    cursor2=ccta.find(query2);
		    DBObject object2 = cursor2.next(); 
		    boolean result2=(boolean)object2.get("异常");
		    if(result1==true&&result2==true){
		    	badbad++;
		    	int mm=(int)object2.get("病变位置");
		    	a[mm]++;
		    }
		    else if(result1==false&&result2==true){
		    	goodbad++;
		    }
		    else if(result1==true&&result2==false){
		    	badgood++;
		    }
		    else if(result1==false&&result2==false){
		    	goodgood++;
		    }
		    
		    
	 }
	 //计算结果
	if((badbad+goodbad)==0){
		 rate1=0;
	}else{
		 
	 rate1=(double)badbad/(badbad+goodbad);//bad 的发病率 
	}
	if((badgood+goodgood)==0){
		 rate2=0;
	}else{
		 rate2=(double)badgood/(badgood+goodgood);// good的发病率
	}
	if(rate2==0){
		 rate=0;
	}
	else{
	  rate=(double)rate1/rate2;
	}
	  System.out.println(sum);
	  System.out.println("rate1:"+rate1);
	  System.out.println("rate2:"+rate2);
	  System.out.println("rate:"+rate);   
}//ok
else if(num1==9&&num2==1){
	sum=bdt.find().count();
	   
	   cursor1= bdt.find();
	Boolean result1=false;
	   Boolean file_name=true;
	   while (cursor1.hasNext()){  
		   DBObject object = cursor1.next(); 
		   ArrayList<Object> versi=(ArrayList<Object>)object.get("体育锻炼史");
		   int num=(int)versi.get(0);
		   
		   if(num==1){
			   result1=true;
		   }
		   else{
			   result1=false;
		   }
		   
		   
		    int id=(int)object.get("ID");
		    DBObject query1 = new BasicDBObject("ID",id);  
		    DBObject query2 = new BasicDBObject("ID",new BasicDBObject("$gte",id));  
		    cursor2=ccta.find(query2);
		    DBObject object2 = cursor2.next(); 
		    boolean result2=(boolean)object2.get("异常");
		    if(result1==true&&result2==true){
		    	badbad++;
		    	int mm=(int)object2.get("病变位置");
		    	a[mm]++;
		    }
		    else if(result1==false&&result2==true){
		    	goodbad++;
		    }
		    else if(result1==true&&result2==false){
		    	badgood++;
		    }
		    else if(result1==false&&result2==false){
		    	goodgood++;
		    }
		    
		    
	 }
	 //计算结果
	if((badbad+goodbad)==0){
		 rate1=0;
	}else{
		 
	 rate1=(double)badbad/(badbad+goodbad);//bad 的发病率 
	}
	if((badgood+goodgood)==0){
		 rate2=0;
	}else{
		 rate2=(double)badgood/(badgood+goodgood);// good的发病率
	}
	if(rate2==0){
		 rate=0;
	}
	else{
	  rate=(double)rate1/rate2;
	}
	  System.out.println(sum);
	  System.out.println("rate1:"+rate1);
	  System.out.println("rate2:"+rate2);
	  System.out.println("rate:"+rate);   
}
else if(num1==9&&num2==2){
   sum=bdt.find().count();
   
   cursor1= bdt.find();
Boolean result1=false;
   Boolean file_name=true;
   while (cursor1.hasNext()){  
	   DBObject object = cursor1.next(); 
	   ArrayList<Object> versi=(ArrayList<Object>)object.get("体育锻炼史");
	   int num=(int)versi.get(0);
	   
	   if(num==2){
		   result1=true;
	   }
	   else{
		   result1=false;
	   }
	   
	   
	    int id=(int)object.get("ID");
	    DBObject query1 = new BasicDBObject("ID",id);  
	    DBObject query2 = new BasicDBObject("ID",new BasicDBObject("$gte",id));  
	    cursor2=ccta.find(query2);
	    DBObject object2 = cursor2.next(); 
	    boolean result2=(boolean)object2.get("异常");
	    if(result1==true&&result2==true){
	    	badbad++;
	    	int mm=(int)object2.get("病变位置");
	    	a[mm]++;
	    }
	    else if(result1==false&&result2==true){
	    	goodbad++;
	    }
	    else if(result1==true&&result2==false){
	    	badgood++;
	    }
	    else if(result1==false&&result2==false){
	    	goodgood++;
	    }
	    
	    
 }
 //计算结果
if((badbad+goodbad)==0){
	 rate1=0;
}else{
	 
 rate1=(double)badbad/(badbad+goodbad);//bad 的发病率 
}
if((badgood+goodgood)==0){
	 rate2=0;
}else{
	 rate2=(double)badgood/(badgood+goodgood);// good的发病率
}
if(rate2==0){
	 rate=0;
}
else{
  rate=(double)rate1/rate2;
}
  System.out.println(sum);
  System.out.println("rate1:"+rate1);
  System.out.println("rate2:"+rate2);
  System.out.println("rate:"+rate); 
}
else if(num1==9&&num2==3){
   sum=bdt.find().count();
   
   cursor1= bdt.find();
Boolean result1=false;
   Boolean file_name=true;
   while (cursor1.hasNext()){  
	   DBObject object = cursor1.next(); 
	   ArrayList<Object> versi=(ArrayList<Object>)object.get("体育锻炼史");
	   int num=(int)versi.get(0);
	   
	   if(num==3){
		   result1=true;
	   }
	   else{
		   result1=false;
	   }
	   
	   
	    int id=(int)object.get("ID");
	    DBObject query1 = new BasicDBObject("ID",id);  
	    DBObject query2 = new BasicDBObject("ID",new BasicDBObject("$gte",id));  
	    cursor2=ccta.find(query2);
	    DBObject object2 = cursor2.next(); 
	    boolean result2=(boolean)object2.get("异常");
	    if(result1==true&&result2==true){
	    	badbad++;
	    	int mm=(int)object2.get("病变位置");
	    	a[mm]++;
	    }
	    else if(result1==false&&result2==true){
	    	goodbad++;
	    }
	    else if(result1==true&&result2==false){
	    	badgood++;
	    }
	    else if(result1==false&&result2==false){
	    	goodgood++;
	    }
	    
	    
 }
 //计算结果
if((badbad+goodbad)==0){
	 rate1=0;
}else{
	 
 rate1=(double)badbad/(badbad+goodbad);//bad 的发病率 
}
if((badgood+goodgood)==0){
	 rate2=0;
}else{
	 rate2=(double)badgood/(badgood+goodgood);// good的发病率
}
if(rate2==0){
	 rate=0;
}
else{
  rate=(double)rate1/rate2;
}
  System.out.println(sum);
  System.out.println("rate1:"+rate1);
  System.out.println("rate2:"+rate2);
  System.out.println("rate:"+rate);  
}
else if(num1==10&&num2==1){
   sum=bdt.find().count();
   
   cursor1= bdt.find();
Boolean result1=false;
   Boolean file_name=true;
   while (cursor1.hasNext()){  
	   DBObject object = cursor1.next(); 
	   ArrayList<Object> versi=(ArrayList<Object>)object.get("心肌梗死");
	   int num=(int)versi.get(0);
	   if(num==2){
		   result1=true;
	   }
	   else{
		   result1=false;
	   }
	   
	   
	    int id=(int)object.get("ID");
	    DBObject query1 = new BasicDBObject("ID",id);  
	    DBObject query2 = new BasicDBObject("ID",new BasicDBObject("$gte",id));  
	    cursor2=ccta.find(query2);
	    DBObject object2 = cursor2.next(); 
	    boolean result2=(boolean)object2.get("异常");
	    if(result1==true&&result2==true){
	    	badbad++;
	    	int mm=(int)object2.get("病变位置");
	    	a[mm]++;
	    }
	    else if(result1==false&&result2==true){
	    	goodbad++;
	    }
	    else if(result1==true&&result2==false){
	    	badgood++;
	    }
	    else if(result1==false&&result2==false){
	    	goodgood++;
	    }
	    
	    
 }
 //计算结果
if((badbad+goodbad)==0){
	 rate1=0;
}else{
	 
 rate1=(double)badbad/(badbad+goodbad);//bad 的发病率 
}
if((badgood+goodgood)==0){
	 rate2=0;
}else{
	 rate2=(double)badgood/(badgood+goodgood);// good的发病率
}
if(rate2==0){
	 rate=0;
}
else{
  rate=(double)rate1/rate2;
}
  System.out.println(sum);
  System.out.println("rate1:"+rate1);
  System.out.println("rate2:"+rate2);
  System.out.println("rate:"+rate);
}
else if(num1==11&&num2==1){
   sum=bdt.find().count();
   
   cursor1= bdt.find();
   Boolean result1=false;
   Boolean file_name=true;
   while (cursor1.hasNext()){  
	   DBObject object = cursor1.next(); 
	   ArrayList<Object> versi=(ArrayList<Object>)object.get("其他疾病史");  
	   result1=(boolean)versi.get(0);
	   
	    int id=(int)object.get("ID");
	    DBObject query1 = new BasicDBObject("ID",id);  
	    DBObject query2 = new BasicDBObject("ID",new BasicDBObject("$gte",id));  
	    cursor2=ccta.find(query2);
	    DBObject object2 = cursor2.next(); 
	    boolean result2=(boolean)object2.get("异常");
	    if(result1==true&&result2==true){
	    	badbad++;
	    	int mm=(int)object2.get("病变位置");
	    	a[mm]++;
	    }
	    else if(result1==false&&result2==true){
	    	goodbad++;
	    }
	    else if(result1==true&&result2==false){
	    	badgood++;
	    }
	    else if(result1==false&&result2==false){
	    	goodgood++;
	    }
	    
	    
 }
 //计算结果
 if((badbad+goodbad)==0){
	 rate1=0;
 }else{
	 
 rate1=(double)badbad/(badbad+goodbad);//bad 的发病率 
 }
 if((badgood+goodgood)==0){
	 rate2=0;
 }else{
	 rate2=(double)badgood/(badgood+goodgood);// good的发病率
 }
 if(rate2==0){
	 rate=0;
 }
 else{
  rate=(double)rate1/rate2;
 }
  System.out.println(sum);
  System.out.println("rate1:"+rate1);
  System.out.println("rate2:"+rate2);
  System.out.println("rate:"+rate); 
}
else if(num1==11&&num2==2){
   sum=bdt.find().count();
   
   cursor1= bdt.find();
   Boolean result1=false;
   Boolean file_name=true;
   while (cursor1.hasNext()){  
	   DBObject object = cursor1.next(); 
	   ArrayList<Object> versi=(ArrayList<Object>)object.get("其他疾病史");  
	   result1=(boolean)versi.get(1);
	   
	    int id=(int)object.get("ID");
	    DBObject query1 = new BasicDBObject("ID",id);  
	    DBObject query2 = new BasicDBObject("ID",new BasicDBObject("$gte",id));  
	    cursor2=ccta.find(query2);
	    DBObject object2 = cursor2.next(); 
	    boolean result2=(boolean)object2.get("异常");
	    if(result1==true&&result2==true){
	    	badbad++;
	    	int mm=(int)object2.get("病变位置");
	    	a[mm]++;
	    }
	    else if(result1==false&&result2==true){
	    	goodbad++;
	    }
	    else if(result1==true&&result2==false){
	    	badgood++;
	    }
	    else if(result1==false&&result2==false){
	    	goodgood++;
	    }
	    
	    
 }
 //计算结果
 if((badbad+goodbad)==0){
	 rate1=0;
 }else{
	 
 rate1=(double)badbad/(badbad+goodbad);//bad 的发病率 
 }
 if((badgood+goodgood)==0){
	 rate2=0;
 }else{
	 rate2=(double)badgood/(badgood+goodgood);// good的发病率
 }
 if(rate2==0){
	 rate=0;
 }
 else{
  rate=(double)rate1/rate2;
 }
  System.out.println(sum);
  System.out.println("rate1:"+rate1);
  System.out.println("rate2:"+rate2);
  System.out.println("rate:"+rate);  
}
else if(num1==11&&num2==3){
   sum=bdt.find().count();
   
   cursor1= bdt.find();
   Boolean result1=false;
   Boolean file_name=true;
   while (cursor1.hasNext()){  
	   DBObject object = cursor1.next(); 
	   ArrayList<Object> versi=(ArrayList<Object>)object.get("其他疾病史");  
	   result1=(boolean)versi.get(2);
	   
	    int id=(int)object.get("ID");
	    DBObject query1 = new BasicDBObject("ID",id);  
	    DBObject query2 = new BasicDBObject("ID",new BasicDBObject("$gte",id));  
	    cursor2=ccta.find(query2);
	    DBObject object2 = cursor2.next(); 
	    boolean result2=(boolean)object2.get("异常");
	    if(result1==true&&result2==true){
	    	badbad++;
	    	int mm=(int)object2.get("病变位置");
	    	a[mm]++;
	    }
	    else if(result1==false&&result2==true){
	    	goodbad++;
	    }
	    else if(result1==true&&result2==false){
	    	badgood++;
	    }
	    else if(result1==false&&result2==false){
	    	goodgood++;
	    }
	    
	    
 }
 //计算结果
 if((badbad+goodbad)==0){
	 rate1=0;
 }else{
	 
 rate1=(double)badbad/(badbad+goodbad);//bad 的发病率 
 }
 if((badgood+goodgood)==0){
	 rate2=0;
 }else{
	 rate2=(double)badgood/(badgood+goodgood);// good的发病率
 }
 if(rate2==0){
	 rate=0;
 }
 else{
  rate=(double)rate1/rate2;
 }
  System.out.println(sum);
  System.out.println("rate1:"+rate1);
  System.out.println("rate2:"+rate2);
  System.out.println("rate:"+rate); 
}
else if(num1==12&&num2==1){
 sum=bdt.find().count();
   
   cursor1= bdt.find();
   Boolean result1=false;
   Boolean file_name=true;
   while (cursor1.hasNext()){  
	   DBObject object = cursor1.next(); 
	   ArrayList<Object> versi=(ArrayList<Object>)object.get("家族史");  
	   result1=(boolean)versi.get(0);
	   
	    int id=(int)object.get("ID");
	    DBObject query1 = new BasicDBObject("ID",id);  
	    DBObject query2 = new BasicDBObject("ID",new BasicDBObject("$gte",id));  
	    cursor2=ccta.find(query2);
	    DBObject object2 = cursor2.next(); 
	    boolean result2=(boolean)object2.get("异常");
	    if(result1==true&&result2==true){
	    	badbad++;
	    	int mm=(int)object2.get("病变位置");
	    	a[mm]++;
	    }
	    else if(result1==false&&result2==true){
	    	goodbad++;
	    }
	    else if(result1==true&&result2==false){
	    	badgood++;
	    }
	    else if(result1==false&&result2==false){
	    	goodgood++;
	    }
	    
	    
 }
 //计算结果
 if((badbad+goodbad)==0){
	 rate1=0;
 }else{
	 
 rate1=(double)badbad/(badbad+goodbad);//bad 的发病率 
 }
 if((badgood+goodgood)==0){
	 rate2=0;
 }else{
	 rate2=(double)badgood/(badgood+goodgood);// good的发病率
 }
 if(rate2==0){
	 rate=0;
 }
 else{
  rate=(double)rate1/rate2;
 }
  System.out.println(sum);
  System.out.println("rate1:"+rate1);
  System.out.println("rate2:"+rate2);
  System.out.println("rate:"+rate); 
}
else if(num1==12&&num2==2){
 sum=bdt.find().count();
   
   cursor1= bdt.find();
   Boolean result1=false;
   Boolean file_name=true;
   while (cursor1.hasNext()){  
	   DBObject object = cursor1.next(); 
	   ArrayList<Object> versi=(ArrayList<Object>)object.get("家族史");  
	   result1=(boolean)versi.get(5);
	   
	    int id=(int)object.get("ID");
	    DBObject query1 = new BasicDBObject("ID",id);  
	    DBObject query2 = new BasicDBObject("ID",new BasicDBObject("$gte",id));  
	    cursor2=ccta.find(query2);
	    DBObject object2 = cursor2.next(); 
	    boolean result2=(boolean)object2.get("异常");
	    if(result1==true&&result2==true){
	    	badbad++;
	    	int mm=(int)object2.get("病变位置");
	    	a[mm]++;
	    }
	    else if(result1==false&&result2==true){
	    	goodbad++;
	    }
	    else if(result1==true&&result2==false){
	    	badgood++;
	    }
	    else if(result1==false&&result2==false){
	    	goodgood++;
	    }
	    
	    
 }
 //计算结果
 if((badbad+goodbad)==0){
	 rate1=0;
 }else{
	 
 rate1=(double)badbad/(badbad+goodbad);//bad 的发病率 
 }
 if((badgood+goodgood)==0){
	 rate2=0;
 }else{
	 rate2=(double)badgood/(badgood+goodgood);// good的发病率
 }
 if(rate2==0){
	 rate=0;
 }
 else{
  rate=(double)rate1/rate2;
 }
  System.out.println(sum);
  System.out.println("rate1:"+rate1);
  System.out.println("rate2:"+rate2);
  System.out.println("rate:"+rate);   
  
}
   
   
   //select username, email from users   
   System.out.println("Collection userInfo selected successfully");
   
   
   mongoClient.close();
    }catch(Exception e){
    	 System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    	}
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <title>Timeline - Dark Admin</title>

    <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css" />
    <link rel="stylesheet" type="text/css" href="css/local.css" />

    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/echarts.js"></script>
     
      <style>

        div {
            padding-bottom:20px;
        }

    </style>
    <script type="text/javascript">
        
        
        
		
    </script>
</head>

<body>
   
   
  


    <div id="wrapper">
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Back to Admin</a>
            </div>
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li ><a href="index.html"><i class="fa fa-bullseye"></i> ACDH简介</a></li>
                    <li ><a href="CCTAInsert.html"><i class="fa fa-tasks"></i> CCTA录入</a></li>
                    <li><a href="BDTInsert.html"><i class="fa fa-globe"></i> BDT录入</a></li>
                    <li class="selected"><a href="search.html"><i class="fa fa-list-ol"></i> 数据分析</a></li>
                    <li><a href="CCTA.jsp"><i class="fa fa-font"></i> 病例查询</a></li>        
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

         <hr />
        <div class="container">
            <div class="page-header">
                <h1 id="timeline">查询条件：<%=name1 %>-----<%=name2 %></h1>
            </div>
	
	<div class="page-header">
		<h3 id="timeline">发病率对照表</h3>
    </div>
	<!--  表格 -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title"><i class="fa fa-bar-chart-o"></i><%=name1%></h3>
				</div>
				<div class="panel-body">
                	<table class="table table-bordered table-hover " align="center" border="2px">
						<tr>
							<td rowspan="2" align="center">
								<%=name2%><br><br>
								<%=badbad+badgood%>人
							</td>
							<td style="width:400px">
								<div style="width:100px;height:10px;float:left;">&nbsp;&nbsp;冠心病患者</div>
								<div style="width:100px;height:10px;float:right;"><%=badbad %>人</div>
							</td>
							<td rowspan="2" align="center">发病率
								<br><br><%=new BigDecimal(rate1*100).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue() %>%</td>
							<td rowspan="4" align="center"><br><br>比率
								<br><br><%=(int)(new BigDecimal(rate1*100).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue()) %>
										<%=(int)(new BigDecimal(rate2*100).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue()) %>
							</td>
						</tr>
						<tr>
							<td>
								<div style="width:100px;height:10px;float:left;">&nbsp;&nbsp;非冠心病患者</div>
								<div style="width:100px;height:10px;float:right;"><%=badgood %>人</div>
							</td>
						</tr>
						<tr>
							<td rowspan="2" align="center">其他
								<br><br><%=goodbad+goodgood %>人</td>
							<td style="width:400px">
								<div style="width:100px;height:10px;float:left;">&nbsp;&nbsp;冠心病患者</div>
								<div style="width:100px;height:10px;float:right;"><%=goodbad %>人</div>
							</td>
							<td rowspan="2" align="center">发病率
								<br><br><%=new BigDecimal(rate2*100).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue() %>%</td>
						</tr>
						<tr>
							<td style="width:400px">
								<div style="width:100px;height:10px;float:left;">&nbsp;&nbsp;冠心病患者</div>
								<div style="width:100px;height:10px;float:right;"><%=goodgood %>人</div>
							</td>
						</tr>
                    </table>

           		</div>
  			</div>
		</div>
	</div>
	
	<div class="page-header">
		<h3 id="timeline">冠心病患者病变位置</h3>
    </div>
    
    <div class="row">
		<div class="col-lg-12">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title"><i class="fa fa-bar-chart-o"></i>直方图</h3>
				</div>
				<div class="panel-body">
                	<div id="main" style="width: 100%;height:400px;"></div>
                	<!-- 柱形图 -->
    			<script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据
        var option = {
            title: {
                text: 'ACHD患者病变位置'
            },
            tooltip: {},
            legend: {
                data:['人数']
            },
            grid:{
            	y2:140
            },
            xAxis: {
            	boundaryGap: ['10%', '10%'],
            	data: ["右冠中段","右冠近段","右冠远段","右冠来源的后降支","左主干","前降支近段",
                	"前降支中段","前降支远段","第一对角支","第二对角支","回旋支近段","第一钝缘支",
                	"回旋支远段","第二钝缘支","回旋支来源的后降支","右冠来源的左室后支","回旋支来源的左室后支","中间支"],
            	axisLabel:{  
                	interval:0,//横轴信息全部显示  
                	rotate:-30,//-30度角倾斜显示  
           		},
           		axisLine: {
           			lineStyle: {
           				color: '#FFFFFFFF'
           			}
           		}
            },
            yAxis: {
            	axisLine: {
           			lineStyle: {
           				color: '#FFFFFFFF'
           			}
           		}
            },
            series: [{
                name: '人数',
                type: 'bar',
                data: [<%=a[1]%>,<%=a[2]%>,<%=a[3]%>,<%=a[4]%>,<%=a[5]%>,<%=a[6]%>,
                	<%=a[7]%>,<%=a[8]%>,<%=a[9]%>,<%=a[10]%>,<%=a[11]%>,<%=a[12]%>,
                	<%=a[13]%>,<%=a[14]%>,<%=a[15]%>,<%=a[16]%>,<%=a[17]%>,<%=a[18]%>]
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>
    
   
           		</div>
  			</div>
		</div>
	</div>

    <div class="row">
		<div class="col-lg-12">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title"><i class="fa fa-bar-chart-o"></i>扇形图</h3>
				</div>
				<div class="panel-body">
                	<div id="main1" style="width: 800px;height:400px;"></div>
    <script>
    var myChart = echarts.init(document.getElementById('main1'));
    option = {
    	    title: {
    	        text: '病变位置',
    	        left: 'center'
    	    },
    	    tooltip : {
    	        trigger: 'item',
    	        formatter: "{a} <br/>{b} : {c} ({d}%)"
    	    },
    	    legend: {
    	    	type: 'scroll',
    	        orient: 'vertical',
    	        right: -30,
    	        top: 20,
    	        bottom: 20,
    	        data: ["右冠中段","右冠近段","右冠远段","右冠来源的后降支","左主干","前降支近段",
                	"前降支中段","前降支远段","第一对角支","第二对角支","回旋支近段","第一钝缘支",
                	"回旋支远段","第二钝缘支","回旋支来源的后降支","右冠来源的左室后支","回旋支来源的左室后支","中间支"]
    	    },
    	    series : [
    	        {
    	            type: 'pie',
    	            radius : '65%',
    	            center: ['50%', '50%'],
    	            selectedMode: 'single',
    	            data:[
    	                {value:<%=a[1]%>, name: '右冠中段'},
    	                {value:<%=a[2]%>, name: '右冠近段'},
    	                {value:<%=a[3]%>, name: '右冠远段'},
    	                {value:<%=a[4]%>, name: '右冠来源的后降支'},
    	                {value:<%=a[5]%>, name: '左主干'},
    	                {value:<%=a[6]%>, name: '前降支近段'},
    	                {value:<%=a[7]%>, name: '前降支中段'},
    	                {value:<%=a[8]%>, name: '前降支远段'},
    	                {value:<%=a[9]%>, name: '第一对角支'},
    	                {value:<%=a[10]%>, name: '第二对角支'},
    	                {value:<%=a[11]%>, name: '回旋支近段'},
    	                {value:<%=a[12]%>, name: '第一钝缘支'},
    	                {value:<%=a[13]%>, name: '回旋支远段'},
    	                {value:<%=a[14]%>, name: '第二钝缘支'},
    	                {value:<%=a[15]%>, name: '回旋支来源的后降支'},
    	                {value:<%=a[16]%>, name: '右冠来源的左室后支'},
    	                {value:<%=a[17]%>, name: '回旋支来源的左室后支'},
    	                {value:<%=a[18]%>, name: '中间支'}
    	            ],
    	            itemStyle: {
    	                emphasis: {
    	                    shadowBlur: 10,
    	                    shadowOffsetX: 0,
    	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
    	                }
    	            }
    	        }
    	    ]
    	};
    myChart.setOption(option);
    </script>
    
   
           		</div>
  			</div>
		</div>
	</div>
     

    
    
            
            <div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			
		</div>
	</div>
</div>
    </div>
    </div>
                       
   


</body>
</html>
