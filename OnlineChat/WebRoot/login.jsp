<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Cookie[] cookies = request.getCookies();
	for (Cookie c : cookies) {
		if ("useremail".equals(c.getName())) {
			pageContext.setAttribute("useremail", c.getValue());
			break;
		}
	}
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>用户登录</title>
    <!-- Bootstrap core CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="resources/signin.css" rel="stylesheet">
    
    <link href="resources/css/styles.css">
    
  </head>

  <body>

    <div class="container">

      <form class="form-signin" action="login" method="post">
      	<!-- 隐藏标记 -->
      	<input type="hidden" name="method" value="login">
      	
        <h2 class="form-signin-heading">用户登录</h2>
        <label><font color='red' >${requestScope["login.message"]}</font></label>
        <label for="inputEmail" class="sr-only">邮箱地址</label>
        <input type="email" id="inputEmail" name="useremail" class="form-control" placeholder="邮箱地址" value="${ useremail }" required autofocus>
        <label for="inputPassword" class="sr-only">密码</label>
        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="密码" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="1" name = "remember"> 记住邮箱
          </label>
          <label>
            <a href="regist.jsp">没有账号？点我注册</a>
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
      </form>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
