(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-322142f3"],{"1b4d":function(e,a,r){"use strict";r.r(a);var l=function(){var e=this,a=e.$createElement,r=e._self._c||a;return r("div",{staticClass:"app-container"},[r("el-form",{ref:"searchForm",attrs:{"label-width":"80px"}},[r("el-form-item",{attrs:{label:"搜索条件"}},[r("el-input",{attrs:{placeholder:"请输入"},model:{value:e.searchCondition,callback:function(a){e.searchCondition=a},expression:"searchCondition"}},[r("el-button",{attrs:{slot:"append",icon:"el-icon-search"},on:{click:e.submit},slot:"append"})],1)],1),e._v(" "),r("el-row",[r("el-col",{attrs:{span:10}},[r("el-tree",{ref:"leftTree",attrs:{data:e.searchResult,"highlight-current":"","show-checkbox":""},on:{"check-change":e.handleCheckChange}})],1),e._v(" "),r("el-col",{attrs:{span:14}},[r("el-timeline",e._l(e.activities,function(e,a){return r("el-timeline-item",{key:a,attrs:{icon:e.icon,type:e.type,color:e.color,size:e.size,timestamp:e.timestamp,placement:"top"}},[r("el-card",[r("el-tree",{attrs:{data:e.content}})],1)],1)}),1)],1)],1)],1)],1)},t=[],n=r("579b"),c=(r("28a5"),r("ac6a"),r("456d"),r("bd86")),i=(r("6762"),r("2fdb"),r("7618"));function s(e){var a,r=arguments.length>1&&void 0!==arguments[1]?arguments[1]:0,l=arguments.length>2&&void 0!==arguments[2]?arguments[2]:"undef",t=arguments.length>3&&void 0!==arguments[3]?arguments[3]:"id",n=arguments.length>4&&void 0!==arguments[4]?arguments[4]:"label",b=arguments.length>5&&void 0!==arguments[5]?arguments[5]:"children",u=arguments.length>6&&void 0!==arguments[6]?arguments[6]:["姓名","年龄","检查时间"];if("object"===Object(i["a"])(e)){var o,f=[],v=-1;for(var d in e)f.push(s(e[d],r,d,t,n,b,u)),u.includes(d)&&u.indexOf(d)>v&&(v=u.indexOf(d),l=d+" : "+e[d]);return o={},Object(c["a"])(o,t,r),Object(c["a"])(o,n,l),Object(c["a"])(o,b,f),o}return a={},Object(c["a"])(a,t,r),Object(c["a"])(a,n,null!=e?l+" : "+e:l),a}function b(e,a,r){var l=arguments.length>3&&void 0!==arguments[3]?arguments[3]:"检查时间",t=[];for(var n in e)-1!==e[n].label.indexOf(l)&&Object.keys(e[n]).includes("children")&&e[n].children.length>0&&t.push({content:[e[n]],timestamp:e[n].label.split(" ")[2]});return t}var u=[{label:"右冠中端",value:1},{label:"右冠近段",value:2},{label:"右冠远段",value:3},{label:"右冠来源的后降支",value:4},{label:"左主干",value:5},{label:"前降支近段",value:6},{label:"前降支中段",value:7},{label:"前降支远段",value:8},{label:"第一对角支",value:9},{label:"第二对角支",value:10},{label:"回旋支近段",value:11},{label:"第一钝缘支",value:12},{label:"回旋支远段",value:13},{label:"第二钝缘支",value:14},{label:"回旋支来源的后降支",value:15},{label:"右冠来源的左室后支",value:16},{label:"回旋支来源的左室后支",value:17},{label:"中间支",value:18}],o=[{label:"局限(小于1mm)",value:1},{label:"节段(10mm - 20mm)",value:2},{label:"弥漫(大于20mm)",value:3}],f=[{label:"钙化斑块",value:1},{label:"非钙化斑块",value:2},{label:"混合斑块",value:3}];function v(e){var a=[];for(var r in e){var l={},t=e[r];for(var n in t)switch(n){case"cctas":var c=[];for(var i in t[n]){var s={},b=t[n][i];for(var v in b)if(null!==b[v])switch(v){case"冠状动脉CT是否异常":!0===b[v]?s["冠状动脉CT"]="异常":s["冠状动脉CT"]="正常";break;case"病变位置":b[v]>0&&b[v]<=u.length?s["病变位置"]=u[b[v]-1].label:s["病变位置"]="未知";break;case"病变长度":b[v]>0&&b[v]<=o.length?s["病变长度"]=o[b[v]-1].label:s["病变长度"]="未知";break;case"斑块特征":b[v]>0&&b[v]<=f.length?s["斑块特征"]=f[b[v]-1].label:s["斑块特征"]="未知";break;case"狭窄度":s["狭窄度"]=b[v]+"mm";break;default:s[v]=b[v]}c.push(s)}l[n]=c;break;case"bdts":var d=[];for(var k in t[n]){var h={},m=t[n][k];for(var p in m)if(null!==m[p])switch(p){case"血压":h["血压"]=m[p]+" mmHg";break;case"身高":h["身高"]=m[p]+" cm";break;case"体重":h["体重"]=m[p]+" kg";break;case"检查目的":var g=m[p];for(var w in h["检查目的"]={},g)!0===g[w]?h["检查目的"][w]=null:"其它"===w&&null!=g[w]&&""!==g[w]&&(h["检查目的"][g[w]]=null);0===Object.keys(h["检查目的"]).length&&(h["检查目的"]="无");break;case"高血压病":var O=m[p];for(var j in h["高血压病"]={},O){if("有无"===j){if(1===O[j]){h["高血压病"]="不详";break}if(2===O[j]){delete h["高血压病"];break}}switch(j){case"目前用药":var C=["ACEI 或 ARB","钙离子抑制剂","利尿剂","受体阻滞剂"];h["高血压病"]["目前用药"]=C[O["目前用药"]-1];break;case"用药后达标情况":var y=["达标","不达标","不稳定"];h["高血压病"]["用药后达标情况"]=y[O["用药后达标情况"]-1];break;default:break}}break;case"血脂异常":var T=m[p];for(var x in h["血脂异常"]={},T){if("有无"===x){if(1===T[x]){h["血脂异常"]="不详";break}if(2===T[x]){delete h["血脂异常"];break}}switch(x){case"目前用药":var _=["他汀类药物","贝特类药物","依折麦布"];h["血脂异常"]["目前用药"]=_[T["目前用药"]-1];break;case"用药后控制情况":var z=["正常","仍不正常","部分正常","不稳定"];h["血脂异常"]["用药后控制情况"]=z[T["用药后控制情况"]-1];break;default:break}}break;case"糖尿病史":var A=m[p];for(var R in h["糖尿病史"]={},A){if("有无"===R){if(1===A[R]){h["糖尿病史"]="不详";break}if(2===A[R]){delete h["糖尿病史"];break}}switch(R){case"分型":var $=["1型","2型"];h["糖尿病史"]["分型"]=$[A["分型"]-1];break;case"目前用药":var N=["胰岛素","二甲双胍","磺脲类药物","GLP-1类似物"];h["糖尿病史"]["目前用药"]=N[A["目前用药"]-1];break;case"用药后控制情况":var B=["正常","不正常","不稳定"];h["糖尿病史"]["用药后控制情况"]=B[A["用药后控制情况"]-1];break;default:break}}break;case"脑卒中病史":var E=m[p];for(var I in h["脑卒中病史"]={},E){if("有无"===I){if(1===E[I]){h["脑卒中病史"]="不详";break}if(2===E[I]){delete h["脑卒中病史"];break}}switch(I){case"发生时间":case"发生部位":h["脑卒中病史"][I]=E[I];break;case"类型":var J=["缺血性卒中","出血性卒中","TIA发作"];h["脑卒中病史"][I]=J[E[I]-1];break;default:break}}break;case"外周血管病":var D=m[p];for(var F in h["外周血管病"]={},D){if("有无"===F){if(1===D[F]){h["外周血管病"]="不详";break}if(2===D[F]){delete h["外周血管病"];break}}switch(F){case"发生时间":case"发生部位":h["外周血管病"][F]=D[F];break;case"类型":var G=["静脉","动脉"];"number"!==typeof D[F]||isNaN(D[F])?h["外周血管病"]["发生部位"]=D[F]:h["外周血管病"]["发生部位"]=G[D[F]-1];break;default:break}}break;case"吸烟史":var H=m[p];for(var L in h["吸烟史"]={},H)if("频率"===L){if(4===H[L]){delete h["吸烟史"];break}switch(H[L]){case 1:h["吸烟史"]["经常吸"]="每日 "+H["经常吸支数"]+" 支，共 "+H["经常吸年"]+" 年";break;case 2:var P="已戒烟 ";P=null===H["过去吸年"]||0===H["过去吸年"]?P+H["过去吸月"]+" 月":P+H["过去吸年"]+" 年 "+H["过去吸月"]+" 月",h["吸烟史"]["过去吸，现已戒烟"]=P;break;case 3:h["吸烟史"]["频率"]="偶吸（平均每天不足1支）";break;default:break}}break;case"饮酒史":var q=m[p];for(var K in h[p]={},q)if("频率"===K){if(4===q[K]){delete h[p];break}switch(q[K]){case 1:var M="";for(var Q in q["经常饮"])switch(Q){case"白酒":q["经常饮"]["白酒"]["毫升"]>0&&(M+=q["经常饮"]["白酒"]["度数"]+"度白酒"+q["经常饮"]["白酒"]["毫升"]+"ml ");break;case"红酒":q["经常饮"]["红酒"]>0&&(M+="红酒"+q["经常饮"]["红酒"]+"ml ");break;case"啤酒":q["经常饮"]["啤酒"]>0&&(M+="啤酒"+q["经常饮"]["啤酒"]+"ml ");break;case"黄酒":q["经常饮"]["黄酒"]>0&&(M+="黄酒"+q["经常饮"]["黄酒"]+"ml ");break;default:break}h[p]["经常饮"]=M;break;case 2:h[p]["已戒酒"]=q["过去饮年"]+" 年";break;case 3:h[p]["偶饮（<1次/周）"]=null;break;default:break}}break;case"体育锻炼史":var S=m[p];for(var U in h[p]={},S){if(null===S[U])break;if("频率"===U){if(1===S[U]){h[p]["基本不锻炼"]=null;break}var V=["每次1小时以内","每次1小时以上"];switch(S[U]){case 2:h[p]["小于3次/周"]=V[S["时长"]];break;case 3:h[p]["大于3次/周"]=V[S["时长"]];break;default:break}}}break;case"心肌梗死":2===m[p]["有无"]&&(h[p]={},h[p]["最近发生时间"]=m[p]["年月"]);break;case"目前服药":for(var W in h[p]={},m[p])!0===m[p][W]&&(h[p][W]=null);0===Object.keys(h[p]).length&&delete h[p];break;case"其他疾病史":for(var X in h[p]={},m[p])"其它"===X&&null!=m[p][X]&&m[p][X].length>0?h[p][m[p][X]]=null:!0===m[p][X]&&(h[p][X]=null);0===Object.keys(h[p]).length&&delete h[p];break;case"家族史":var Y=m[p];for(var Z in h[p]={},Y)switch(Z){case"冠心病家族史":if(null===Y[Z]||2===Y[Z]["有无"])break;h[p]["冠心病家族史"]={};var ee=Y[Z]["谁"];for(var ae in ee)null==ee[ae]&&!1===ee[ae]||(h[p]["冠心病家族史"][ae]=null);break;case"高脂血症家族史":1===Y[Z]&&(h[p]["高脂血症家族史"]=null);break;case"其它":null!=Y[Z]&&""!==Y[Z]&&(h[p][Y[Z]]=null);break;default:break}0===Object.keys(h[p]).length&&delete h[p];break;default:h[p]=m[p]}d.push(h)}l[n]=d;break;default:l[n]=t[n]}a.push(l)}return a}var d={data:function(){return{loading:!1,searchCondition:"",searchResult:[],activities:[]}},mounted:function(){},methods:{submit:function(){this.search_data()},search_data:function(){var e=this,a=this;a.loading=!0,Object(n["e"])(this.searchCondition).then(function(r){0===r.status?e.searchResult=s(v(r.data)).children:a.$message.error("失败"),a.loading=!1}).catch(function(e){a.$message.error(e),a.loading=!1})},handleCheckChange:function(e,a,r){e=this.$refs.leftTree.getCheckedNodes(),this.activities=b(e,a,r)}}},k=d,h=r("2877"),m=Object(h["a"])(k,l,t,!1,null,null,null);a["default"]=m.exports},"579b":function(e,a,r){"use strict";r.d(a,"d",function(){return t}),r.d(a,"c",function(){return n}),r.d(a,"e",function(){return c}),r.d(a,"a",function(){return i}),r.d(a,"b",function(){return s});var l=r("b775");function t(e){return Object(l["a"])({url:"/CCTA",method:"post",data:e})}function n(e){return Object(l["a"])({url:"/BDT",method:"post",data:e})}function c(e){return Object(l["a"])({url:"/search/"+e,method:"get"})}function i(e){return Object(l["a"])({url:"/analyze",method:"post",data:e})}function s(){return Object(l["a"])({url:"/analyze/all",method:"get"})}}}]);