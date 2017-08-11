
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="AuthorityTagLib" prefix="auth"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>RBAC</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>easyui/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>easyui/themes/icon.css">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css/admin.css">
		<script type="text/javascript" src="<%=basePath%>easyui/jquery.js"></script>
		<script type="text/javascript" src="<%=basePath%>easyui/easyui.js"></script>
		<script type="text/javascript" src="<%=basePath%>easyui/locale/zh_CN.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>easyui/plugins/jquery.edatagrid.js"></script>
		<script type="text/javascript">
	$(function() {
		$('#cc').layout();
		//$('#win').window({closed:true,onMove:function(left,top){$('#win').window('refresh');}});
	});
	function addTab(title, href) {
		var tt = $('#main-center');
		if (tt.tabs('exists', title)) {
			tt.tabs('close', title);
		}
		if (href) {			
			var content = '<iframe scrolling="scroll" frameborder="0"  src="' + href + '" style="width:100%;height:100%;">';
		} else {
			var content = '未实现';
		}
		tt.tabs('add', {
			title : title,
			closable : true,
			content : content
		});
	}
	function addTabSrc(title, href) {
		var tt = $('#main-center');
		if (tt.tabs('exists', title)) {
			tt.tabs('close', title);
		}
		if (href) {
		    alert("href:"+href);
			var content = '<iframe scrolling="scroll" frameborder="0"  src="' + href + '" style="width:100%;height:100%;" ></iframe>';			
		} else {
			var content = '未实现';
		}
		tt.tabs('add', {
			title : title,
			closable : true,
			content : content
		}); 
	}
	function openwindow(title, href, width, height) {
		$('#win').window( {
			title : title,
			href : href,
			width : width,
			height : height,
			collapsible : false,
			minimizable : false,
			maximizable : false,
			modal : false,
			cache : false
		});
	}
</script>
		<style type="text/css">
body {
	background-color: #D2E0F2;
}

#mb1,#mb2,#mb3,#mb6,#mb7,#mm1,#mm2,#mm3,#mm6,#mm7 {
	width: 120px;
}

#mb4,#mb5 {
	width: 120px;
}
)
</style>

	</head>

	<body>
		<DIV class=page_style>
			<div id="cc" class="easyui-layout" style="width: 100%; height: 100%;">
				<div region="north" title="后台管理"
					style="height: 70px; padding: 5px;" split="true">
					<span>角色权限模块的权限设计</span>
					<span style="float: right;"><a class="easyui-linkbutton"
						href="<%=basePath%>bgLogin/index.jsp">退出登录 </a>
					</span>
				</div>

				
				<div region="west" split="true" title="菜单栏" iconCls="icon-save"
					style="width: 180px;">
					<div class="easyui-accordion" border="false"
						style="overflow: visible;">
							<auth:authorityTag role="权限管理员,开发者">	
							<div class="accordion" style="overflow: hidden;" title="权限管理" iconCls="icon-add">
							<a href="javascript:void(0)" class="easyui-linkbutton"
								plain="true" iconCls="icon-sum" style="width: 100%;"
								onclick="javascript:addTab('用户设置', '<%=basePath%>authority/userInfoAction!showUserInfoList.action')">用户设置</a>
							<a href="javascript:void(0)" class="easyui-linkbutton"
								plain="true" iconCls="icon-sum" style="width: 100%;"
								onclick="javascript:addTab('角色设置', '<%=basePath%>authority/roleAction!showRoleList.action')">角色设置</a>
							<a href="javascript:void(0)" class="easyui-linkbutton"
								plain="true" iconCls="icon-sum" style="width: 100%;"
								onclick="javascript:addTab('模块设置', '<%=basePath%>authority/moduleAction!showModuleList.action')">模块设置</a>
							<a href="javascript:void(0)" class="easyui-linkbutton"
								plain="true" iconCls="icon-sum" style="width: 100%;"
								onclick="javascript:addTab('共享模块设置', '<%=basePath%>authority/shareModuleAction!showModuleList.action')">共享模块设置</a>	
							</div>
						</auth:authorityTag>	  	
					</div>
				</div>
				<div region="center" collapsible="true" title="功能区"
					iconCls="icon-print" style="overflow: scroll;">
					<div id="main-center" class="easyui-tabs" border="false" style=""></div>
				</div>
			</div>
			<div id="win"></div>
		</DIV>
	</body>
</html>
