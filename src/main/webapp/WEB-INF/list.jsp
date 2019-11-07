<%@ page language="java" contentType="text/html; charset=utf8"
    import="util.Pager,entity.Account,java.util.List"
	pageEncoding="utf8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<link rel="stylesheet" href="/uservlet/assets/css/main.css">
<title>列出账号</title>
</head>
<body>
	<h3 align="center">账号信息</h3>
	<hr color="red">
	<center>
		<table border="1">
			<tr>
				<th>ID</th>
				<th>姓名</th>
				<th>余额</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${acts}" var="act">
				<tr>
					<td>${act.id}</td>
					<td>${act.name}</td>
					<td>${act.balance}</td>
					<td>
						<a href="user/${act.id}">查看</a>
						<a href="#" onclick="updateUser(${act.id})">修改</a>
						<a href="#" onclick="deleteUser(${act.id})">删除</a>
					</td>
				</tr>
			</c:forEach>
		</table>	
	</center>
	<script type="text/javascript" src="/uservlet/assets/js/user.js"></script>
</body>
</html>
<!-- 
	修改配置AppConfig类
 -->