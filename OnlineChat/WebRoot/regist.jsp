<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

    <title>用户注册</title>

    <!-- Bootstrap core CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">

	<link href="resources/css/styles.css">

    <!-- Custom styles for this template -->
    <link href="resources/signin.css" rel="stylesheet">
    
  </head>

  <body>

    <div class="container">

      <form class="form-signin" action="login" method="post">
      	<!-- 隐藏标记 -->
      	<input type="hidden" name="method" value="regist">
      	
        <h2 class="form-signin-heading">用户注册</h2>
        <label><font color="red">${requestScope["regist.message"]}</font></label>
        <label for="inputEmail" class="sr-only">用户名</label>
        <input type="text" id="inputName" name="username" class="form-control" placeholder="用户名" required autofocus>
        <label for="inputEmail" class="sr-only">邮箱地址</label>
        <input type="email" id="inputEmail" name="useremail" class="form-control" placeholder="邮箱地址" required autofocus>
        <label for="inputPassword" class="sr-only">密码</label>
        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="密码" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
       <!--  <button class="btn btn-lg btn-primary btn-block" type="reset">重置</button> -->
      </form>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
