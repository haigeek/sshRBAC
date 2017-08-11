<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>add module</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">

	</head>
	<body>
		<form action="<%=basePath%>authority/userInfoAction!addUserInfo.action">
			<table>
				<tr>
					<td>
						用户登录名：
					</td>
					<td>
						<input type="text" name="userInfo.loginId"></input>
					</td>
				</tr>
				<tr>
					<td>
						用户初始密码：
					</td>
					<td>
						<input type="text" name="userInfo.password" />
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td>
						<input type="submit" ID="addUserInfo" value="添加" />&nbsp;&nbsp;
						<input type="reset" ID="reset" />
					</td>
				</tr>
			</table>
		</form>
	</body>	
</html>
