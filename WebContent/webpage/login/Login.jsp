<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/webpage/common/lable.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 	<link href="${ctxStatic}/frame/H+/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctxStatic}/frame/H+/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="${ctxStatic}/frame/H+/css/animate.min.css" rel="stylesheet">
    <link href="${ctxStatic}/frame/H+/css/style.min.css" rel="stylesheet">
    <link href="${ctxStatic}/frame/H+/css/login.min.css" rel="stylesheet">
    <!--[if lt IE 8]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>
        if(window.top!==window.self){window.top.location=window.location};
    </script>
<title>登录LOgin</title>
</head>
<body class="signin">
    <div class="signinpanel">
        <div class="row">
            <div class="col-sm-7">
                <div class="signin-info">
                    <div class="logopanel m-b">
                        <h1>环保行政处罚系统</h1>
                    </div>
                    <div class="m-b"></div>
                    <h4>欢迎使用 <strong>环保行政处罚系统后台</strong></h4>
                    <ul class="m-b">
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 认真</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 负责</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 公平</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 公正</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 执法</li>
                    </ul>
                </div>
            </div>
            <div class="col-sm-5">
                <form method="post" action="${ctx}/login/doLogin">
                    <h4 class="no-margins">登录：</h4>
                    <p class="m-t-md">登录到环保行政处罚系统</p>
                    <input type="text" name = "username" class="form-control uname" placeholder="用户名" />
                    <input type="password" name = "password" class="form-control pword m-b" placeholder="密码" />
                    <p>${message}</p>
                    <button class="btn btn-success btn-block">登录</button>
                </form>
            </div>
        </div>
        <div class="signup-footer">
            <div class="pull-left">
                &copy; 2018 All Rights Reserved. H+
            </div>
        </div>
    </div>
</body>


</html>