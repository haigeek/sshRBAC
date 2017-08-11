<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>编辑共享模块信息</title>
		<META content="MSHTML 6.00.6000.16674" name=GENERATOR>
		<script type="text/javascript" language="javasript"> 
			function updateModule(form)
			{
	   			form.action = "authority/shareModuleAction!updateModule.action";
	   			form.submit();
	   			
	   			return true;	   			
	   		}
		</script>
	</head>

	<body>
		<%@ taglib uri="http://displaytag.sf.net/el" prefix="display"%>
		<s:form theme="simple">
			<table align="left" style="border: #005892 0px solid; width: 500">
			<tr>
					<td colspan="3">
						共享模块名称：&nbsp;&nbsp;
						<input type="hidden" name="id"
							value="${requestScope.module.moduleId}"></input>
						<input type="text" name="module.moduleName"
							value="${requestScope.module.moduleName}" maxlength="60"></input>
					</td>
				</tr>
				<tr>
					<td colspan="3">
						共享模块url：&nbsp;&nbsp;
						<input type="text" name="module.url"
							value="${requestScope.module.url}" maxlength="60"></input>
					</td>
				</tr>
				<tr>
					<td colspan="3">
						模块描述：
						<input type="text" name="module.description"
							value="${requestScope.module.description}" maxlength="30"></input>
					</td>
				</tr>
				<tr>
					<td height="20" align="left" valign="middle" colspan="3">
						<s:submit value="修改" theme="simple"
							onclick="return updateModule(this.form);">
						</s:submit>
						&nbsp;&nbsp;&nbsp;
						<input type="button" name="back"
							onclick="javascript:history.back()" value="返回" />
					</td>
				</tr>				
			</table>
		</s:form>
	</body>
</html>
