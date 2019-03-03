<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/BDT.css" />
	<script type="text/javascript" src="js/BDT.js"></script>
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
<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td align="center" class="biaoti" height="60">冠心病患者基线资料表</td>
  </tr>
</table>

<form class="form" name="form1" action="./GetBDTFormServlet" method="post" onsubmit="return myCheck()">
<table width="100%" border="0" cellspacing="1" cellpadding="4" bgcolor="#cccccc" class="tabtop13" align="center">
  <tr>
  	<td>ID</td>
    <td colspan="3"><input type="text" name="ID" style="width:300px;border:0px;border-bottom:#000000 1px solid;"></td>
    <td>时间</td>
    <td colspan="3"><input type="date" name="时间" style="width:300px;border:0px;border-bottom:#000000 1px solid;"></td>
  </tr>
  <tr>
  <td>心率</td>
    <td><input type="text" name="心率" style="width:100px;border:0px;border-bottom:#000000 1px solid;"></td>
    <td>血压</td>
    <td><input type="text" name="血压" style="width:100px;border:0px;border-bottom:#000000 1px solid;">mmHG</td>
    <td>身高</td>
    <td><input type="text" name="身高" style="width:100px;border:0px;border-bottom:#000000 1px solid;">cm</td>
    <td>体重</td>
    <td><input type="text" name="体重" style="width:100px;border:0px;border-bottom:#000000 1px solid;">kg</td>
  </tr>
  <tr>
    <td>检查目的</td>
    <td colspan="9">
      &nbsp&nbsp&nbsp
      典型心绞痛：&nbsp&nbsp&nbsp
      <input type="radio" name="点型心绞痛" value="true">是
		 <input type="radio" name="点型心绞痛" value="false" checked>否
      &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
      非典型胸部不适：
      <input type="radio" name="非典型胸部不适" value="true">是
		 <input type="radio" name="非典型胸部不适" value="false" checked>否
      <br>
      &nbsp&nbsp&nbsp
      非胸痛症状：&nbsp&nbsp&nbsp
      <input type="radio" name="非胸痛症状" value="true">是
		 <input type="radio" name="非胸痛症状" value="false" checked>否
      &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
      心电图异常：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
      <input type="radio" name="心电图异常" value="true">是
		 <input type="radio" name="心电图异常" value="false" checked>否
      <br>
      &nbsp&nbsp&nbsp
      心脏超声异常：
      <input type="radio" name="心脏超声异常" value="true">是
		 <input type="radio" name="心脏超声异常" value="false" checked>否
      &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
      其他:
      <input type="text" name="检查目的其他" style="width:200px;border:0px;border-bottom:#000000 1px solid;">
      <br>
    </td>
  </tr>
  <tr>
    <td>高血压病</td>
    <td colspan="9">
      &nbsp&nbsp&nbsp
      <input type="radio" name="高血压病" value="1" onclick="show1(this)" checked>不详
      &nbsp&nbsp&nbsp
		 <input type="radio" name="高血压病" value="2" onclick="show1(this)">无
      &nbsp&nbsp&nbsp
      <input type="radio" name="高血压病" value="3" onclick="show1(this);">有
      <span id = showMessage></span>
    </td>
  </tr>
  <tr>
    <td>血脂异常</td>
    <td colspan="9">
      &nbsp&nbsp&nbsp
      <input type="radio" name="血脂异常" value="1" onclick="show2(this);" checked>不详
      &nbsp&nbsp&nbsp
		 <input type="radio" name="血脂异常" value="2" onclick="show2(this);">无
      &nbsp&nbsp&nbsp
      <input type="radio" name="血脂异常" value="3" onclick="show2(this);">有
      <span id = showMessage2></span>
    </td>
  </tr>
  <tr>
    <td>糖尿病史</td>
    <td colspan="9">
      &nbsp&nbsp&nbsp
      <input type="radio" name="糖尿病史" value="1" onclick="show3(this);" checked>不详
      &nbsp&nbsp&nbsp
		 <input type="radio" name="糖尿病史" value="2" onclick="show3(this);">无
      &nbsp&nbsp&nbsp
      <input type="radio" name="糖尿病史" value="3" onclick="show3(this);">有
      <span id = showMessage3></span>
    </td>
  </tr>
  <tr>
    <td>脑卒中病史</td>
    <td colspan="9">
      &nbsp&nbsp&nbsp
      <input type="radio" name="脑卒中病史" value="1" onclick="show4(this);" checked>不详
      &nbsp&nbsp&nbsp
		 <input type="radio" name="脑卒中病史" value="2" onclick="show4(this);">无
      &nbsp&nbsp&nbsp
      <input type="radio" name="脑卒中病史" value="3" onclick="show4(this);">有
      <span id = showMessage4></span>
    </td>
  </tr>
  <tr>
    <td>外周血管病</td>
    <td colspan="9">
      &nbsp&nbsp&nbsp
      <input type="radio" name="外周血管病" value="1" onclick="show5(this);" checked>不详
      &nbsp&nbsp&nbsp
		 <input type="radio" name="外周血管病" value="2" onclick="show5(this);">无
      &nbsp&nbsp&nbsp
      <input type="radio" name="外周血管病" value="3" onclick="show5(this);">有
      <span id = showMessage5></span>
    </td>
  </tr>
  <tr>
    <td>吸烟史</td>
    <td colspan="9">
      &nbsp&nbsp&nbsp
      <input type="radio" name="吸烟史" value="1" onclick="show6(this);">经常吸
      <span id = showMessage6_1></span>
      <br>
      &nbsp&nbsp&nbsp
		 <input type="radio" name="吸烟史" value="2" onclick="show6(this);">偶吸（平均每天不足一只）
      <br>
      &nbsp&nbsp&nbsp
      <input type="radio" name="吸烟史" value="3" onclick="show6(this);">过去吸，现已戒烟
      <span id = showMessage6_2></span>
      <br>
      &nbsp&nbsp&nbsp
      <input type="radio" name="吸烟史" value="4" onclick="show6(this);" checked>从不吸
    </td>
  </tr>
  <tr>
    <td>饮酒史</td>
    <td colspan="9">
      &nbsp&nbsp&nbsp
      <input type="radio" name="饮酒史" value="1" onclick="show7(this);" >经常饮
      <span id = showMessage7_1></span>
      <br>
      &nbsp&nbsp&nbsp
		 <input type="radio" name="饮酒史" value="2" onclick="show7(this);">偶饮（<1次/周）
      <br>
      &nbsp&nbsp&nbsp
      <input type="radio" name="饮酒史" value="3" onclick="show7(this);">过去饮
      <span id = showMessage7_2></span>
      <br>
      &nbsp&nbsp&nbsp
      <input type="radio" name="饮酒史" value="4" onclick="show7(this);" checked>从不饮
    </td>
  </tr>
  <tr>
    <td>体育锻炼史</td>
    <td colspan="9">
      &nbsp&nbsp&nbsp
      <input type="radio" name="体育锻炼史" value="1" onclick="show8(this);" checked>基本不锻炼
      &nbsp&nbsp&nbsp
		 <input type="radio" name="体育锻炼史" value="2" onclick="show8(this);">每周小于三次
      &nbsp&nbsp&nbsp
      <input type="radio" name="体育锻炼史" value="3" onclick="show8(this);">每周大于等于三次
      <span id = showMessage8></span>
    </td>
  </tr>
  <tr>
    <td>心肌梗死</td>
    <td colspan="9">
      &nbsp&nbsp&nbsp
      <input type="radio" name="心肌梗死" value="1" onclick="show9(this);" checked>无
      &nbsp&nbsp&nbsp
		 <input type="radio" name="心肌梗死" value="2" onclick="show9(this);">有
      <span id = showMessage9></span>
    </td>
  </tr>
  <tr>
    <td>目前服药</td>
    <td colspan="9">
      &nbsp&nbsp&nbsp
      <input type="checkbox" name="目前服药" value="1">阿司匹林
      &nbsp&nbsp&nbsp
		 <input type="checkbox" name="目前服药" value="2">硫酸氢氯吡格雷
      &nbsp&nbsp&nbsp
		 <input type="checkbox" name="目前服药" value="3">硝酸酯类药物
      &nbsp&nbsp&nbsp
		 <input type="checkbox" name="目前服药" value="4">华法林等抗凝药
    </td>
  </tr>
  <tr>
    <td>其他疾病史</td>
    <td colspan="9">
      &nbsp&nbsp&nbsp
      <input type="checkbox" name="其他疾病史" value="1">肝功能不全
      &nbsp&nbsp&nbsp
		 <input type="checkbox" name="其他疾病史" value="2">肾功能不全
      &nbsp&nbsp&nbsp
		 <input type="checkbox" name="其他疾病史" value="3">肿瘤
      &nbsp&nbsp&nbsp
		 <input type="checkbox" name="其他疾病史" value="4" onclick="show10(this);">其他
      <span id = showMessage10></span>
    </td>
  </tr>
  <tr>
    <td>家族史</td>
    <td colspan="9">
      &nbsp&nbsp&nbsp
      冠心病家族史：
      <input type="radio" name="冠心病家族史" value="1" onclick="show11(this)" >有
      &nbsp&nbsp&nbsp
		 <input type="radio" name="冠心病家族史" value="0" onclick="show11(this)" checked>无
      <span id = showMessage11></span>
      <br>
      &nbsp&nbsp&nbsp
      高脂血症家族史：
      <input type="radio" name="高脂血症家族史" value="1">有
      &nbsp&nbsp&nbsp
		 <input type="radio" name="高脂血症家族史" value="0" checked>无
      <br>
      &nbsp&nbsp&nbsp
      其他：
      <input type="text" name="家族病史其他" style="width:200px;border:0px;border-bottom:#000000 1px solid;">
    </td>
  </tr>
</table>
<div align="center"><input type="reset" value="重置">
<input type="submit" value="提交"></div>  
</form>

</body>
</html>