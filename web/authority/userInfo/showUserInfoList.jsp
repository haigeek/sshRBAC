<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>显示用户信息列表</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">

	</head>

	<body>
		<%@ taglib uri="http://displaytag.sf.net/el" prefix="display"%>
		<display:table name="requestScope.list" id="item">
			class="simple">
			<display:column property="id" title="ID" sortable="true" />
			<display:column property="loginId" title="登录名" sortable="true" />
			<display:column property="password" title="密码" />
			<display:column title="操作">
				<a href="<%=basePath%>authority/userInfoAction!getUserInfoById.action?userInfo.id=${item.id}"><img
						src="<%=basePath%>images/edit.gif" border="0">編輯</a>
			</display:column>
			<display:column title="操作">
				<a
					href="<%=basePath%>authority/userInfoAction!deleteUserInfo.action?userInfo.id=${item.id}"><img
						src="<%=basePath%>images/delete.gif" border="0">刪除</a>
			</display:column>
		</display:table>
		<a href="<%=basePath%>authority/userInfo/addUserInfo.jsp">添加新的用户</a>
	</body>
</html>
