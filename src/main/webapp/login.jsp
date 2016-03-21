<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

</script>
</head>
<body style="height: 100%; height: 100%">
	<div id="bs">
		<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'"
			onclick="$('#loginForm').submit();">登录</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="$('#loginForm').form('clear')">重置</a>
	</div>
	<div id="dd" class="easyui-dialog" title="用户登录"
		style="width: 300px; height: 200px;"
		data-options="iconCls:'icon-save',resizable:true,modal:true,buttons:'#bs'">
		<form id="loginForm" action="/demo/menu.json" method="post">
			<table>
				<tr>
					<td>用户名</td>
					<td><input type="text" value="admin" name="username"
						class="easyui-validatebox"
						data-options="required:true,validType:'length[5,12]'" /></td>
				</tr>
				<tr>
					<td>密&emsp;码</td>
					<td><input type="password" value="admin" name="password"
						class="easyui-validatebox"
						data-options="required:true,validType:'length[5,18]'" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>