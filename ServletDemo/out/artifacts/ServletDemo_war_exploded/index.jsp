<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: likun
  Date: 2020/5/10
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body onload="init()">
    <a href = "/ServletDemo/Servlet1" >跳转赶过去</a>
    <a href = "/ServletDemo/dist/" >跳到vue页面</a>
    <button id="btn1" onclick="showtime()" >爱我呀么么</button>
    <div id="showDiv" style="position: absolute; background-color: white; border: 1px solid black;"></div>
  </body>
  <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js">
  </script>
  <script type="text/javascript">
    let date1  = new Date(2020,5,6,22,10,0)
    let date2  = new Date(2020,5,6,22,10,30)
    let start_date = new Date(1591452600000)
    let end_date = new Date(1591452630000)
    document.write('<br>' + "startdate: "+start_date)
    document.write('<br>' + "enddate: "+end_date)
    function init() {
      let now_date = new Date()
      if(now_date > start_date && now_date < end_date) {
      }else{
        $("#btn1").attr("title","该功能正在维护中，请于凌晨五点后再试")
      }
    }
    function showtime() {
      let now_date = new Date()
      if(now_date > start_date && now_date < end_date){
        // tipsShow(event)
        // setTimeout(tipsHide,3000)
        return;
      }else {
        //正常的逻辑
      }
    }
    // function tipsShow() {
    //   var showDiv = document.getElementById('showDiv');
    //   showDiv.style.left = event.clientX;
    //   showDiv.style.top = event.clientY;
    //   showDiv.style.display = 'block';
    //   showDiv.innerHTML = '凌晨五点后再试';
    // }
    //
    // function tipsHide(a) {
    //   var showDiv = document.getElementById('showDiv');
    //   showDiv.style.display = 'none';
    //   showDiv.innerHTML = '';
    // }
  </script>
</html>
