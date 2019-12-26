
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>修改部门信息</title>
<meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
<meta name="description"
	content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

<link rel="shortcut icon" href="<%=basePath%>favicon.ico">
<link href="<%=basePath%>css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
<link href="<%=basePath%>css/font-awesome.min.css?v=4.4.0"
	rel="stylesheet">
<link href="<%=basePath%>css/plugins/sweetalert/sweetalert.css"
	rel="stylesheet">
<link href="<%=basePath%>css/plugins/iCheck/custom.css" rel="stylesheet">
<link href="<%=basePath%>css/animate.min.css" rel="stylesheet">
<link href="<%=basePath%>css/style.min.css?v=4.0.0" rel="stylesheet">
<base target="_blank">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">

		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>添加部门信息</h5>
						<div class="ibox-tools">
							<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
							</a> <a class="dropdown-toggle" data-toggle="dropdown"
								href="form_basic.html#"> <i class="fa fa-wrench"></i>
							</a>
							<ul class="dropdown-menu dropdown-user">
								<li><a href="form_basic.html#">选项1</a></li>
								<li><a href="form_basic.html#">选项2</a></li>
							</ul>
							<a class="close-link"> <i class="fa fa-times"></i>
							</a>
						</div>
					</div>
					<div class="ibox-content">
						<form method="post" class="form-horizontal"
							action="../SysPostCtrl/add.do" target="_self"
							enctype="multipart/form-data">


							<div class="hr-line-dashed"></div>
							<div class="form-group">
								<label class="col-sm-2 control-label">部门编号：</label>

								<div class="col-sm-10">
									<input type="text" class="form-control" name="postId">
								</div>
							</div>
							<div class="hr-line-dashed"></div>
							<div class="form-group">
								<label class="col-sm-2 control-label">部门名称：</label>

								<div class="col-sm-10">
									<input type="text" class="form-control" name="postName">
								</div>
							</div>

							<div class="hr-line-dashed"></div>
							<div class="form-group">
								<label class="col-sm-2 control-label">职务编号：</label>

								<div class="col-sm-10">
									<input type="text" class="form-control" name="deptId">
								</div>
							</div>
							<div class="hr-line-dashed"></div>
							<div class="form-group">
								<label class="col-sm-2 control-label">备注：</label>

								<div class="col-sm-10">
									<input type="text" class="form-control" name="beizhu">
								</div>
							</div>
							
							<div class="hr-line-dashed"></div>
							<div class="form-group">
								<label class="col-sm-2 control-label">公司编号：</label>

								<div class="col-sm-10">
									<input type="text" class="form-control" name="companyId">
								</div>
							</div>
							<div class="hr-line-dashed"></div>
							<div class="form-group">
								<label class="col-sm-2 control-label">最后修改时间</label>

								<div class="col-sm-10">
									<input type="text" class="form-control" name="changDate">
								</div>
							</div>
							<div class="hr-line-dashed"></div>

							<div class="form-group">
								<div class="col-sm-4 col-sm-offset-2">
									<button class="btn btn-primary" type="submit">确认添加</button>
									<button class="btn btn-white" type="reset">清空</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div id="modal-form" class="modal fade" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<div class="row">
						<div class="col-sm-6 b-r">
							<h3 class="m-t-none m-b">登录</h3>

							<p>欢迎登录本站(⊙o⊙)</p>

							<form role="form">
								<div class="form-group">
									<label>用户名：</label> <input type="email" placeholder="请输入用户名"
										class="form-control">
								</div>
								<div class="form-group">
									<label>密码：</label> <input type="password" placeholder="请输入密码"
										class="form-control">
								</div>
								<div>
									<button class="btn btn-sm btn-primary pull-right m-t-n-xs"
										type="submit">
										<strong>登录</strong>
									</button>
									<label> <input type="checkbox" class="i-checks">自动登录
									</label>
								</div>
							</form>
						</div>
						<div class="col-sm-6">
							<h4>还不是会员？</h4>
							<p>您可以注册一个账户</p>
							<p class="text-center">
								<a href="form_basic.html"><i class="fa fa-sign-in big-icon"></i></a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="<%=basePath%>js/jquery.min.js?v=2.1.4"></script>
	<script src="<%=basePath%>js/bootstrap.min.js?v=3.3.5"></script>
	<script src="<%=basePath%>js/content.min.js?v=1.0.0"></script>
	<script src="<%=basePath%>js/plugins/sweetalert/sweetalert.min.js"></script>
	<script src="<%=basePath%>js/plugins/iCheck/icheck.min.js"></script>
	<script>
        $(document).ready(function(){$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green",})});
    	if(${issuc=='yes'}){
        		swal({title:"太帅了",text:"添加权限成功",type:"success"})
        	}
    </script>
	<script type="text/javascript"
		src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>

</html>

<!-- <center>
       <h2>添加用户</h2>
       <form action="SysUsersInfoCtrl/add.do" method="post" enctype="multipart/form-data">
          <table width="40%" border="1">
            <tr>
              <td>用户名</td>
              <td>
                <input type="text" name="empName">
              </td>
            </tr>
            <tr>
              <td>电话号码</td>
              <td>
                <input type="text" name="phoneNumber">
              </td>
            </tr>
            <tr>
              <td>性别</td>
              <td>
                <input type="radio" name="empSex" value="男" checked="checked">男
                <input type="radio" name="empSex" value="女">女
              </td>
            </tr>
     
            
            <tr>
              <td>图片</td>
              <td>
               <input type="file" name="upload">
              </td>
            </tr>
            <tr>
              <td>用户状态状态</td>
              <td>
                <select name="checkState">
                  <option value="0">启用</option>
                  <option value="1">禁用</option>
                </select>
              </td>
            </tr>
            <tr>
              <td colspan="2" align="center">
                 <input type="submit" value="提交">
              </td>
            </tr>
          </table>
       </form> 
    </center> -->

<%-- <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'usersadd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- 引入日历控件js -->
	<script language="javascript" type="text/javascript" src="<%=basePath %>js/My97DatePicker/WdatePicker.js"></script>

  </head>
  
  <body>
    
    <center>
       <h2>添加用户</h2>
       <form action="SysPostCtrl/add.do" method="post">
          <table width="40%" border="1">
            <tr>
              <td>职务编号</td>
              <td>
                <input type="text" name=postId>
              </td>
            </tr>
            <tr>
              <td>职务名称</td>
              <td>
                <input type="text" name="postName">
              </td>
            </tr>
             <tr>
              <td>部门编号</td>
              <td>
                <input type="text" name="deptId">
              </td>
            </tr>
              <tr>
              <td>备注</td>
              <td>
                <input type="text" name="beizhu">
              </td>
            </tr>
             <tr>
              <td>公司编号</td>
              <td>
                <input type="text" name="companyId">
              </td>
            </tr>
     
            
           
            
            <tr>
              <td colspan="2" align="center">
                 <input type="submit" value="提交">
              </td>
            </tr>
          </table>
       </form> 
    </center>

  </body>
</html> --%>