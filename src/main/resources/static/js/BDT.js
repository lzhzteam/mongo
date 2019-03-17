/**
 * 
 */
//设置默认时间;
// var mydateInput = document.getElementById("date1");
// var date = new Date();
// mydateInput.value = date;
// var defaultDate = document.querySelectorAll('.date-picker');
// for (var i = 0; i<defaultDate.length; i++) {
//   defaultDate[i].valueAsDate = new Date();
// }

// 高血压病
function show1(obj)
{
  var show = "";
  var radioValue = obj.value;
    if (radioValue === "3") {
    show = "<br>" +
    "&nbsp&nbsp&nbsp" +
        "目前用药：" +
        "<input type=\"radio\" name=\"BDTs[0].高血压病.目前用药\" value=\"1\" checked>ACEI或ARB" +
    "&nbsp&nbsp&nbsp" +
        "<input type=\"radio\" name=\"BDTs[0].高血压病.目前用药\" value=\"2\">钙离子拮抗剂" +
    "&nbsp&nbsp&nbsp" +
        "<input type=\"radio\" name=\"BDTs[0].高血压病.目前用药\" value=\"3\">利尿剂" +
    "&nbsp&nbsp&nbsp" +
        "<input type=\"radio\" name=\"BDTs[0].高血压病.目前用药\" value=\"4\">受体阻滞剂" +
    "<br>" + 
    "&nbsp&nbsp&nbsp" +
        "用药后达标情况：" +
        "<input type=\"radio\" name=\"BDTs[0].高血压病.用药后达标情况\" value=\"1\" checked>达标" +
    "&nbsp&nbsp&nbsp" +
        "<input type=\"radio\" name=\"BDTs[0].高血压病.用药后达标情况\" value=\"2\">不达标" +
    "&nbsp&nbsp&nbsp" +
        "<input type=\"radio\" name=\"BDTs[0].高血压病.用药后达标情况\" value=\"3\">不稳定";
  }
  
  document.all.showMessage.innerHTML = show;
}

// 血脂异常
function show2(obj) {
  var show = "";
  var radioValue = obj.value;
    if (radioValue === "3") {
    show = "<br>" +
      "&nbsp&nbsp&nbsp" +
      "目前用药：" +
        "<input type=\"radio\" name=\"BDTs[0].血脂异常.目前用药\" value=\"1\" checked>他汀类药物" +
      "&nbsp&nbsp&nbsp" +
        "<input type=\"radio\" name=\"BDTs[0].血脂异常.目前用药\" value=\"2\">贝特类药物" +
      "&nbsp&nbsp&nbsp" +
        "<input type=\"radio\" name=\"BDTs[0].血脂异常.目前用药\" value=\"3\">依折麦布" +
      "<br>" +
      "&nbsp&nbsp&nbsp" +
      "用药后控制情况：" +
        "<input type=\"radio\" name=\"BDTs[0].血脂异常.用药后控制情况\" value=\"1\" checked>正常" +
      "&nbsp&nbsp&nbsp" +
        "<input type=\"radio\" name=\"BDTs[0].血脂异常.用药后控制情况\" value=\"2\">仍不正常" +
      "&nbsp&nbsp&nbsp" +
        "<input type=\"radio\" name=\"BDTs[0].血脂异常.用药后控制情况\" value=\"3\">部分正常" +
      "&nbsp&nbsp&nbsp" +
        "<input type=\"radio\" name=\"BDTs[0].血脂异常.用药后控制情况\" value=\"4\">不稳定";
  }
  document.all.showMessage2.innerHTML = show;
}

// 糖尿病史
function show3(obj) {
  var show = "";
  var radioValue = obj.value;
    if (radioValue === "3") {
    show = "<br>" +
       "&nbsp&nbsp&nbsp" +
      "分型：" +
        "<input type=\"radio\" name=\"BDTs[0].糖尿病史.分型\" value=\"1\" checked>1型" +
      "&nbsp&nbsp&nbsp" +
        "<input type=\"radio\" name=\"BDTs[0].糖尿病史.分型\" value=\"2\">2型" +
      "<br>" +
      "&nbsp&nbsp&nbsp" +
      "目前用药：" +
        "<input type=\"radio\" name=\"BDTs[0].糖尿病史.目前用药\" value=\"1\" checked>胰岛素" +
      "&nbsp&nbsp&nbsp" +
        "<input type=\"radio\" name=\"BDTs[0].糖尿病史.目前用药\" value=\"2\">二甲双胍" +
      "&nbsp&nbsp&nbsp" +
        "<input type=\"radio\" name=\"BDTs[0].糖尿病史.目前用药\" value=\"3\">磺脲类药物" +
      "&nbsp&nbsp&nbsp" +
        "<input type=\"radio\" name=\"BDTs[0].糖尿病史.目前用药\" value=\"4\">GLP-1 类似物" +
      "<br>" +
      "&nbsp&nbsp&nbsp" +
      "用药后控制情况：" +
        "<input type=\"radio\" name=\"BDTs[0].糖尿病史.用药后控制情况\" value=\"1\" checked>正常" +
      "&nbsp&nbsp&nbsp" +
        "<input type=\"radio\" name=\"BDTs[0].糖尿病史.用药后控制情况\" value=\"2\">不正常" +
      "&nbsp&nbsp&nbsp" +
        "<input type=\"radio\" name=\"BDTs[0].糖尿病史.用药后控制情况\" value=\"3\">不稳定";
  }
  document.all.showMessage3.innerHTML = show;
}

// 脑卒中病史
function show4(obj) {
  var show = "";
  var radioValue = obj.value;
    if (radioValue === "3") {
    show = "<br>" +
       "&nbsp&nbsp&nbsp" +
        "发生时间：" +
        "<input type=\"month\" name=\"BDTs[0].脑卒中病史.发生时间\" style=\"width:140px;border:0;border-bottom:#000000 1px solid;\">" +
        "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp" +
        "发生部位：" +
        "<input type=\"text\" name=\"BDTs[0].脑卒中病史.发生部位\" style=\"width:140px;border:0;border-bottom:#000000 1px solid;\">" +
        "<br>" +
       	 "&nbsp&nbsp&nbsp&nbsp" +
        "<input type=\"radio\" name=\"BDTs[0].脑卒中病史.类型\" value=\"1\" checked>缺血性卒中" +
         "&nbsp&nbsp&nbsp" +
        "<input type=\"radio\" name=\"BDTs[0].脑卒中病史.类型\" value=\"2\">出血性卒中" +
         "&nbsp&nbsp&nbsp" +
        "<input type=\"radio\" name=\"BDTs[0].脑卒中病史.类型\" value=\"3\">TIA 发作";
  }
  document.all.showMessage4.innerHTML = show;
}

// 外周血管病
function show5(obj) {
  var show = "";
  var radioValue = obj.value;
    if (radioValue === "3") {
    show = "<br>" +
       "&nbsp&nbsp&nbsp" +
        "发生时间：" +
        "<input type=\"month\" name=\"BDTs[0].外周血管病.发生时间\" style=\"width:140px;border:0;border-bottom:#000000 1px solid;\">" +
        "<br>" +
        "&nbsp&nbsp&nbsp" +
        "发生部位：" +
        "<input type=\"text\" name=\"BDTs[0].外周血管病.发生部位\" style=\"width:140px;border:0;border-bottom:#000000 1px solid;\">" +
        "<input type=\"radio\" name=\"BDTs[0].外周血管病.类型\" value=\"1\" checked>静脉" +
        "&nbsp&nbsp&nbsp" +
        "<input type=\"radio\" name=\"BDTs[0].外周血管病.类型\" value=\"2\">动脉";
  }
  document.all.showMessage5.innerHTML = show;
}

// 吸烟史
function show6(obj) {
    var show1 = "(每日<input type=\"text\" name=\"BDTs[0].吸烟史.经常吸支数\" style=\"width:30px;border:0;border-bottom:#000000 1px solid;\">支，共<input type=\"text\" name=\"BDTs[0].吸烟史.经常吸年\" style=\"width:30px;border:0;border-bottom:#000000 1px solid;\">年)";
  var showNothing = "";
    var show3 = "(戒烟<input type=\"text\" name=\"BDTs[0].吸烟史.过去吸年\" style=\"width:30px;border:0;border-bottom:#000000 1px solid;\">年，如不满一年，<input type=\"text\" name=\"BDTs[0].吸烟史.过去吸月\" style=\"width:30px;border:0;border-bottom:#000000 1px solid;\">月)";
  var radioValue = obj.value;
    if (radioValue === "1") {
    document.all.showMessage6_1.innerHTML = show1;
    document.all.showMessage6_2.innerHTML = showNothing;
  } else if (radioValue === 3) {
    document.all.showMessage6_1.innerHTML = showNothing;
    document.all.showMessage6_2.innerHTML = show3;
  }
  else {
    document.all.showMessage6_1.innerHTML = showNothing;
    document.all.showMessage6_2.innerHTML = showNothing;
  }
}

// 饮酒史
function show7(obj) {
  var show1 = "&nbsp&nbsp&nbsp" +
      "白酒<input type=\"text\" name=\"BDTs[0].饮酒史.经常饮.白酒.毫升\" style=\"width:30px;border:0;border-bottom:#000000 1px solid;\">ml/次，常饮白酒度数<input type=\"text\" name=\"BDTs[0].饮酒史.经常饮.白酒.度数\" style=\"width:30px;border:0;border-bottom:#000000 1px solid;\">" +
      "<br>" +
      "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp" +
      "红酒<input type=\"text\" name=\"BDTs[0].饮酒史.经常饮.红酒\" style=\"width:30px;border:0;border-bottom:#000000 1px solid;\">ml/次" +
      "<br>" + 
      "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp" +
      "啤酒<input type=\"text\" name=\"BDTs[0].饮酒史.经常饮.啤酒\" style=\"width:30px;border:0;border-bottom:#000000 1px solid;\">ml/次" +
      "<br>" + 
      "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp" +
      "黄/米酒<input type=\"text\" name=\"BDTs[0].饮酒史.经常饮.黄酒\" style=\"width:30px;border:0;border-bottom:#000000 1px solid;\">ml/次";
  var showNothing = "";
    var show3 = "(已戒酒<input type=\"text\" name=\"BDTs[0].饮酒史.过去饮年\" style=\"width:30px;border:0;border-bottom:#000000 1px solid;\">年）";
  var radioValue = obj.value;
    if (radioValue === "1") {
    document.all.showMessage7_1.innerHTML = show1;
    document.all.showMessage7_2.innerHTML = showNothing;
  } else if (radioValue === 3) {
    document.all.showMessage7_1.innerHTML = showNothing;
    document.all.showMessage7_2.innerHTML = show3;
  }
  else {
    document.all.showMessage7_1.innerHTML = showNothing;
    document.all.showMessage7_2.innerHTML = showNothing;
  }
}

// 体育锻炼史
function show8(obj) {
  var show = "";
  var radioValue = obj.value;
    if (radioValue === "2" || radioValue === "3") {
    show = "<br>" +
       "&nbsp&nbsp&nbsp" +
        "每次锻炼时间：" +
        "<input type=\"radio\" name=\"BDTs[0].体育锻炼史.时常\" value=\"1\" checked>小于1小时" +
        "&nbsp&nbsp&nbsp" +
        "<input type=\"radio\" name=\"BDTs[0].体育锻炼史.时常\" value=\"2\">大于等于1小时";
  }
  document.all.showMessage8.innerHTML = show;
}

// 心肌梗死
function show9(obj) {
  var show = "";
  var radioValue = obj.value;
    if (radioValue === "2") {
    show = "&nbsp&nbsp&nbsp" +
        "最近一次心梗时间：" +
        "<input type=\"month\" name=\"BDTs[0].心肌梗死.年月\" style=\"width:140px;border:0;border-bottom:#000000 1px solid;\">";
  }
  document.all.showMessage9.innerHTML = show;
}

// 其他疾病史
function show10(obj) {
  var show = "";
  var radioValue = obj.value;
    if (obj.checked === true) {
        show = "：<input type=\"text\" name=\"BDTs[0].其他疾病史.其它\" style=\"width:200px;border:0;border-bottom:#000000 1px solid;\">";
  }
  
  document.all.showMessage10.innerHTML = show;
}

//冠心病家族史
function show11(obj) {
  var show = "";
  var radioValue = obj.value;
    if (radioValue === "1") {
    show = "<br>" + 
      "&nbsp&nbsp&nbsp" +
        "<input type=\"checkbox\" name=\"BDTs[0].家族史.冠心病家族史.谁.父亲1\" value=\"1\" onclick=\"show12(this)\">父有" +
      "<span id = showMessage12></span>" +
    "&nbsp&nbsp&nbsp" +
        "<input type=\"checkbox\" name=\"BDTs[0].家族史.冠心病家族史.谁.母亲1\" value=\"2\" onclick=\"show13(this)\">兄弟姐妹有" +
      "<span id = showMessage13></span>" +
    "<br>" + 
      "&nbsp&nbsp&nbsp" +
        "<input type=\"checkbox\" name=\"BDTs[0].家族史.冠心病家族史.谁.兄弟姐妹1\" value=\"3\" onclick=\"show14(this)\">母有" +
      "<span id = showMessage14></span>" +
    "&nbsp&nbsp&nbsp" +
        "<input type=\"checkbox\" name=\"BDTs[0].家族史.冠心病家族史.谁.子女1\" value=\"4\" onclick=\"show15(this)\">子女有" +
      "<span id = showMessage15></span>";
  }
  
  document.all.showMessage11.innerHTML = show;
}

// 父有
function show12(obj) {
  var show = "";
    if (obj.checked == true) {
        show = "：（发病年龄<input type=\"text\" name=\"BDTs[0].家族史.冠心病家族史.谁.父亲\" style=\"width:30px;border:0;border-bottom:#000000 1px solid;\">岁）";
  }
  document.all.showMessage12.innerHTML = show;
}

// 兄弟姐妹有
function show13(obj) {
  var show = "";
    if (obj.checked == true) {
        show = "：（最小发病年龄<input type=\"text\" name=\"BDTs[0].家族史.冠心病家族史.谁.母亲\" style=\"width:30px;border:0;border-bottom:#000000 1px solid;\">岁）";
  }
  document.all.showMessage13.innerHTML = show;
}

// 母有
function show14(obj) {
  var show = "";
    if (obj.checked == true) {
        show = "：（发病年龄<input type=\"text\" name=\"BDTs[0].家族史.冠心病家族史.谁.兄弟姐妹\" style=\"width:30px;border:0;border-bottom:#000000 1px solid;\">岁）";
  }
  document.all.showMessage14.innerHTML = show;
}

// 子女有
function show15(obj) {
  var show = "";
    if (obj.checked == true) {
        show = "：（最小发病年龄<input type=\"text\" name=\"BDTs[0].家族史.冠心病家族史.谁.子女\" style=\"width:30px;border:0;border-bottom:#000000 1px solid;\">岁）";
  }
  document.all.showMessage15.innerHTML = show;
}










