<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>添加共享模块</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">


	</head>
	<body>
		<form action="<%=basePath%>authority/shareModuleAction!addModule.action">
			<table>
				<tr>
					<td>
						共享模块名称：
					</td>
					<td>
						<input type="text" name="module.moduleName"></input>
					</td>
				</tr>
				<tr>
					<td>
						共享模块描述：
					</td>
					<td>
						<textarea name="module.description" cols="50" rows="7"></textarea>
					</td>
				</tr>
				<tr>
					<td>
						url地址：
					</td>
					<td>
						<input name="module.url" />
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td>
						<input type="submit" ID="addModule" value="添加" />&nbsp;&nbsp;
						<input type="reset" ID="reset" />
					</td>
				</tr>
			</table>
		</form>
	</body>	
</html>
