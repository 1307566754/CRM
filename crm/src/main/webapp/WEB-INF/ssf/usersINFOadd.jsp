<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'khinfoadd.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link rel="shortcut icon" href="favicon.ico">
<link href="css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
<link href="css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
<link href="css/plugins/iCheck/custom.css" rel="stylesheet">
<link href="css/animate.min.css" rel="stylesheet">
<link href="css/style.min.css?v=4.0.0" rel="stylesheet">
<base target="_blank">

</head>

<body class="gray-bg">
	<center>
		<h1>添加员工</h1>
	</center>

	<div class="ibox-content">
		<form class="form-horizontal m-t" id="commentForm"
			action="SysUsersInfoCtrl/add.do" method="post" target="_self"
			enctype="multipart/form-data" onsubmit="return checksize()">
			<div class="form-group">
				<label class="col-sm-3 control-label">员工姓名：</label>
				<div class="col-sm-8">
					<input id="empName" name="empName" class="form-control" type="text"
						required>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">员工性别：</label>
				<div class="col-sm-8">
					<select name="empSex">
						<option>男</option>
						<option>女</option>
					</select>
					<!--  <input  name="empSex" class="form-control" type="text" aria-required="true" aria-invalid="false" class="valid"> -->
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-3 control-label">员工照片</label>
				<div class="col-sm-8">
					<input name="upload" class="form-control" type="file">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">身份证号：</label>
				<div class="col-sm-8">
					<input id="idNumber" name="idNumber" class="form-control"
						type="text">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">联系电话：</label>
				<div class="col-sm-8">
					<input id="phoneNumber" name="phoneNumber" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">职务编号：</label>
				<div class="col-sm-8">
					<select name="postId"
						style="width: 1065.83px;height: 34px;border-radius: 5px;outline: none;">
						<c:forEach items="${q}" var="info">
							<option value="${info.postId}">${info.postId}</option>
						</c:forEach>
					</select>
				</div>
				
				<div class="form-group">
					<label class="col-sm-3 control-label">公司编号:</label>
					<div class="col-sm-8">
						<select name="companyId"
							style="width: 1065.83px;height: 34px;border-radius: 5px;outline: none;">
							<c:forEach items="${p}" var="info">
								<option value="${info.pk}">${info.pk}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-8 col-sm-offset-3">
						<button class="btn btn-primary" type="submit">提交</button>
					</div>
				</div>
		</form>
	</div>



	<script src="js/jquery.min.js?v=2.1.4"></script>
	<script src="js/bootstrap.min.js?v=3.3.5"></script>
	<script src="js/content.min.js?v=1.0.0"></script>
	<script src="js/plugins/validate/jquery.validate.min.js"></script>
	<script src="js/plugins/validate/messages_zh.min.js"></script>
	<script src="js/demo/form-validate-demo.min.js"></script>
	<script type="text/javascript"
		src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>
</html>
<script>
	function checksize() {
		var number = document.getElementById("idNumber").value;
		if (number.length != 18) {
			alert("编辑失败！身份证号为十八位，当前位数为：" + number.length);
			return false;

		}
	}
</script>

