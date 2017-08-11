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
		<title>编辑用户信息</title>
		<META content="MSHTML 6.00.6000.16674" name=GENERATOR>
		<script type="text/javascript" language="javasript"> 	
			function updateUserInfo(form)
			{
				var check_id=document.getElementsByName("roleIdSets"); 
				var id="";  
				for(i=0;i<check_id.length;i++)
				{  
  					if(check_id[i].checked)
  					{
  						id+=check_id[i].value;
  					}  
				}
				
				/*
				if (id=="") {
				   window.alert ("请至少选择1个角色");
				   return false;
				}
				*/
	   			form.action = "authority/userInfoAction!updateUserInfo.action";
	   			form.submit();
	   			
	   			return false;	   			
	   		}
	   		
	   	   //选择操作
		   function selectChkBox(form,sign)
		   {
			for(var i=0;i<form.roleIdSets.length;i++){
				var tmp = form.roleIdSets[i];
				switch(sign){
					case "allselect":{
						tmp.checked=true;
						break;
						}
					case "cancel":{
						tmp.checked=false;
						break;
					}
					case "opselect":{
					tmp.checked=!tmp.checked;
					break;
					}
				}
			   }
			   return false;
		   }
		</script>
	</head>

	<body>
		<%@ taglib uri="http://displaytag.sf.net/el" prefix="display"%>
		<s:form theme="simple">
			<table align="left" style="border: #005892 0px solid; width: 500">
				<tr>
					<td colspan="3">
						用户登录名：&nbsp;&nbsp;
						<input type="hidden" name="id1" value="${requestScope.userInfo.id}"></input>
						<input type="text" name="userInfo.loginId"
							value="${requestScope.userInfo.loginId}" maxlength="60"></input>
					</td>
				</tr>
				<tr>
					<td colspan="3">
						用户密码：
						<input type="text" name="userInfo.password"
							value="${requestScope.userInfo.password}" maxlength="30"></input>
					</td>
				</tr>
				<tr>
					<td colspan="4">
						角色列表
					</td>
				</tr>				
				<tr>
					<td colspan="4">
						<display:table name="requestScope.roleList" class="simple"
							id="item">
							<display:column title="是否分配" style="width:80px" class="textalign">
								<s:if test="%{#attr.item.roleId in roleIdSets}">
									<input type="checkbox" name="roleIdSets" value="${item.roleId}"
										checked />
								</s:if>
								<s:else>
									<input type="checkbox" name="roleIdSets" value="${item.roleId}" />
								</s:else>
							</display:column>
							<display:column title="角色名" property="roleName"
								style="width:200px">
							</display:column>
							<display:column title="角色描述" property="description">
							</display:column>
						</display:table>
					</td>
				</tr>
				<tr>
					<td align="left" colspan="4">
						<s:submit value="全选"
							onclick="return selectChkBox(this.form,'allselect');"
							cssClass="buttonbg2" />
						<s:submit value="反选"
							onclick="return selectChkBox(this.form,'opselect');"
							cssClass="buttonbg2" />
						<s:submit value="取消"
							onclick="return selectChkBox(this.form,'cancel');"
							cssClass="buttonbg2" />
					</td>
				</tr>
				<tr>
					<td height="20" align="left" valign="middle" colspan="3">
						<s:submit value="修改" theme="simple"
							onclick="return updateUserInfo(this.form);">
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
