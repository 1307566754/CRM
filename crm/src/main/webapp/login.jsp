<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		var islogin="${param.islogin}";
		if(islogin=="no"){
			alert("请先登录");
		}
		function lala(img){
			img.src="validatecode.jsp?t="+new Date().getTime();
		}
	</script>

  </head>
  
  <body>
    
	<center>
	<a href="OfficeKpictrl/listpage.do">wwwwwwww</a>
		<h1>用户登录</h1>
		<h2 style="color:red">
			${param.isfail=="unknown" ? "用户名不存在":"" }
			${param.isfail=="error" ? "密码不正确":"" }
			${param.isfail=="code" ? "验证码错误":"" }
			${param.isfail=="other" ? "登陆发生未知错误":"" }
		</h2>
		<form action="loginctrl/login.do" method="post">
		
			用户名：<input type="text" name="uname" placeholder="请输入用户名"><br><br>
			密码：<input type="password" name="upass" placeholder="请输入密码"><br><br>
			
			验证码：<input type="text" name="randomcode" id="randomcode" size="8" placehoder="请输入验证码">
			<img alt="" src="${basePath }validatecode.jsp" id="img" 
			width="56px" height="20px" onclick="lala(this)">
			<br>
			<br>
			<input type="submit" value="登陆">
		</form>
		
		<a href="test/test1.do">test</a>
		
	</center>
	
  </body>
</html>
