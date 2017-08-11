<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>显示角色信息列表</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">


	</head>

	<body>
		<%@ taglib uri="http://displaytag.sf.net/el" prefix="display"%>
		<display:table name="requestScope.list" id="item"  class="simple">>
			<display:column property="roleId" title="ID" sortable="true" />
			<display:column property="roleName" title="名称" sortable="true" />
			<display:column title="操作">
				<a href="<%=basePath%>authority/roleAction!getRoleById.action?role.roleId=${item.roleId}"><img
						src="<%=basePath%>images/edit.gif" border="0">編輯</a>
			</display:column>
			<display:column title="操作">
				<a
					href="<%=basePath%>authority/roleAction!deleteRole.action?role.roleId=${item.roleId}"><img
						src="<%=basePath%>images/delete.gif" border="0">刪除</a>
			</display:column>
		</display:table>
		<a href="<%=basePath%>authority/role/addRole.jsp">添加新的角色</a>
	<%--<c:forEach items="${list }" var="role">--%>
		<%--id:${role.roleId}--%>
		<%--<br>--%>
		<%--name:${role.roleName}--%>
		<%--</c:forEach>--%>
	</body>
</html>
