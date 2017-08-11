<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"ss
 "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网站后台登录</title>
<link href="<%=basePath%>css/login.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />


</head>

<body>
<div id="tab">
  <ul class="tab_menu">
    <li >网站后台登录</li>
    
 
  </ul>
  <div class="tab_box"> 
    <!-- 开发者登录开始 -->
    <div>
      <div class="stu_error_box"></div>
      <form action="<%=basePath%>bgLogin/loginAction!login.action" method="post" >
        <div id="username">
        <label>用户名或密码输入错误，请重新输入！</label></br>
        
          <label>用户名：</label>
          <input type="text" id="stu_username_hide" name="userInfo.loginId" value="" nullmsg="用户名不能为空！" datatype="s1-18" errormsg="用户名范围在6~18个字符之间！" sucmsg="您输入的用户不正确，请重新输入！"/>
          <!--ajaxurl="demo/valid.jsp"--> 
        </div>
        <div id="password">
          <label>密&nbsp;&nbsp;&nbsp;码：</label>
          <input type="password" id="stu_password_hide" name="userInfo.password" value="" nullmsg="密码不能为空！" datatype="*1-16" errormsg="密码范围在6~16位之间！" sucmsg="您输入的密码不正确，请重新输入！"/>
        </div>
        
          

        
        <div id="login">
          <button type="submit"   >登录</button>
        </div>
      </form>
    </div>
   <!-- 开发者登录结束-->
  </div>
</div>


</body>
</html>
