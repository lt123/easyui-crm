<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/WEB-INF/view/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CRM管理系统</title>

<script type="text/javascript">
	$(function(){
		window.onload=function(){
			$('#menuTrue').tree({
				onClick: function(node){
					var title = node.text;
					var url = node.attributes.url;
					if(url){
						if(!$("#mainTabs").tabs(('exists'),title)){
							$("#mainTabs").tabs("add",{
								title:title,
								closable:true,
								iconCls:"icon-ok",
								content:"<iframe src='"+url+"' frameborder='0' style='width:100%;height:100%' />"
							})
						}else{
							$('#mainTabs').tabs("select",title);
						}
					}
				}
			});
		}
	})
</script>

</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false"
		style="height: 60px; overflow: hidden;">
		<h1>CRM管理系统</h1>
	</div>
	<div data-options="region:'west',iconCls:'icon-ok',title:'系统菜单'"
		style="width: 180px;">
		<ul id="menuTrue" class="easyui-tree" data-options="url:'/demo/menu.json'"></ul>  
	</div>
	<div data-options="region:'center'">
		<div class="easyui-tabs" id="mainTabs" data-options='fit:true,border:false'>
			<div title="欢迎界面">
				欢迎使用<br />
				当前用户：${sessionScope.user.username}<br />
				上次登录时间：<fmt:formatDate value="${sessionScope.user.lastLoginTime }" pattern="yyyy-MM-dd HH:mm:ss"/><br />
				上次登录IP：${sessionScope.user.lastLoginIp}<br />
			</div>
		</div>
	</div>
	<div data-options="region:'south',border:false" style="text-align: center;">
		Copyright © 2010-2016 <br> 
		www.jeasyui.com
	</div>
</body>
</html>