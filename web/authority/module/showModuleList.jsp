<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>显示模块信息列表</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">

	</head>

	<body>
		<%@ taglib uri="http://displaytag.sf.net/el" prefix="display"%>
		<display:table name="requestScope.list" id="item">
			class="simple">
			<display:column property="moduleId" title="ID" sortable="true" />
			<display:column property="moduleName" title="名称" sortable="true" />
			<display:column property="url" title="URL地址" />
			<display:column title="操作">
				<a href="<%=basePath%>authority/moduleAction!getModuleById.action?module.moduleId=${item.moduleId}"><img
						src="<%=basePath%>images/edit.gif" border="0">編輯</a>
			</display:column>
			<display:column title="操作">
				<a
					href="<%=basePath%>authority/moduleAction!deleteModule.action?module.moduleId=${item.moduleId}"><img
						src="<%=basePath%>images/delete.gif" border="0">刪除</a>
			</display:column>
		</display:table>
		<a href="<%=basePath%>authority/module/addModule.jsp">添加新的模块</a>
	</body>
</html>
