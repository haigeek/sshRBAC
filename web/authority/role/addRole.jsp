<%@ page language="java" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>add module</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <%@ taglib uri="http://displaytag.sf.net/el" prefix="display" %>
    <%@ taglib uri="/struts-tags" prefix="s" %>
</head>
<body>
<form action="<%=basePath%>authority/roleAction!addRole.action">
    <table>
        <tr>
            <td>
                角色名称：
            </td>
            <td>
                <input type="text" name="role.roleName"></input>
            </td>
        </tr>
        <tr>
            <td>
                角色描述：
            </td>
            <td>
                <textarea name="role.description" cols="50" rows="7"></textarea>
            </td>
        </tr>
        <tr>
        <tr>

        </tr>
        </tr>
        <tr>
            <td>
                &nbsp;
            </td>
            <td>
                <input type="submit" ID="addRole" value="添加"/>&nbsp;&nbsp;
                <input type="reset" ID="reset"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
