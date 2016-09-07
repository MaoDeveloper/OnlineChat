<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
 %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>OC</title>
</head>
<body>
	<h1>欢迎您<font color="red">${user.name}</font>,感谢您关注OC在线聊天，我们正在努力完善中...</h1>
</body>
</html>
