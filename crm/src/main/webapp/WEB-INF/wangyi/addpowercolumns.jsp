<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    

    <title>H+ 后台主题UI框架 - 写信</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="<%=basePath%>favicon.ico"> <link href="<%=basePath%>css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="<%=basePath%>css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="<%=basePath%>css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <link href="<%=basePath%>css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="<%=basePath%>css/plugins/summernote/summernote.css" rel="stylesheet">
    <link href="<%=basePath%>css/plugins/summernote/summernote-bs3.css" rel="stylesheet">
    <link href="<%=basePath%>css/animate.min.css" rel="stylesheet">
    <link href="<%=basePath%>css/style.min.css?v=4.0.0" rel="stylesheet"><base target="_blank">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content">
        <div class="row">
            
                
            <div class="col-sm-9 animated fadeInRight">
                <div class="mail-box-header">
                    
                    <h2>
                    添加权限分栏
                </h2>
                </div>
                <div class="mail-box">


                    <div class="mail-body">

                        <form id="form1" target="_self" class="form-horizontal" method="get" action="../SysPowerColumnsCtrl/addPowerColumns.do">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">权限分栏名：</label>

                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="columnsName" id="i1">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">备注信息：</label>

                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="remarks" id="i2">
                                </div>
                            </div>
                    </div>

                   
                    <div class="mail-body text-right tooltip-demo J_menuItem">
                        <button  class="btn btn-sm btn-primary" data-toggle="tooltip" data-placement="top" title="Send">
                        <i class="fa fa-reply "></i>提交</button>
                        
                    </div>
                    </form>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
    </div>
    <script src="<%=basePath%>js/jquery.min.js?v=2.1.4"></script>
    <script src="<%=basePath%>js/bootstrap.min.js?v=3.3.5"></script>
    <script src="<%=basePath%>js/content.min.js?v=1.0.0"></script>
    <script src="<%=basePath%>js/plugins/sweetalert/sweetalert.min.js"></script>
    <script src="<%=basePath%>js/plugins/iCheck/icheck.min.js"></script>
    <script src="<%=basePath%>js/plugins/summernote/summernote.min.js"></script>
    <script src="<%=basePath%>js/plugins/summernote/summernote-zh-CN.js"></script>
    <script>
        $(document).ready(function(){
        	$("#form1").submit(function(){
        		if($("#i1").val()==''){
        			swal({title:"提交失败",text:"权限分栏名不能为空"});
        			return false;
        		}
        		if($("#i2").val()==''){
        			swal({title:"提交失败",text:"备注信息不能为空"});
        			return false;
        		}
        	})
        });
    	if(${issuc=='yes'}){
        		swal({title:"太帅了",text:"添加权限分栏成功",type:"success"})
        	}
    </script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>

</html>
