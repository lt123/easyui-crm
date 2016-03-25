<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function append(){
		$('#userForm').form('reset');
		$('#userDialog').dialog('open');
	}
	
	function removeit(){
		var rows = $('#userDatagrid').datagrid('getSelections');
		if(rows.length > 0){
			var ids = new Array();
			$(rows).each(function(i,row){
				ids[i] = row.id;
				$.post('/user/delete',{'ids':ids},function(data){
					$.debug(data)
				})
			 });
		}else{
			$.error('请选择一行');	
		}
	}

	function accept(){
		
	}
		
	function cancel(){
		
	}
	
	function search(){
		
	}
	
	function onclickRow(rowIndex, rowData) {
		/* console.debug(rowData) */
	}
	
	$(function(){
		
	})
	
	$.extend($.fn.validatebox.defaults.rules, {    
    	ageValidate: {    
        	validator: function(value, param){    
            	return value > 0 && value < 150 ? true:false;
        	},    
        	message: '年龄必须大于0小于150'   
    	},
    	equals: {    
            validator: function(value,param){    
                return value == $(param[0]).val();    
            },    
            message: '请检查两次密码是否一致'   
        }    
	});
	

	
	function save(){
		$('#userForm').form('submit',{    
		    url:'/user/save',
		    success:function(data){
		    	data = $.parseJSON(data)
		    	if(data.code == 100) {
		    		$('#userDialog').dialog('close');
		    		$.alert('添加成功',function(){
		    			$("#userDatagrid").datagrid("reload");
		    		})
		    	}else {
		    		
		    	}
		        console.debug(data);
		    }
		}); 
	}
	
	function reset(){
		$('#userForm').form('reset');
	}

</script>
</head>
<body>
	
	<div id="tb" style="height:auto">
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="append()">添加</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="removeit()">删除</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="accept()">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-undo',plain:true" onclick="cancel()">取消</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="search()">搜索</a>
	</div>
	
	<div id="formButton">
		<a class="easyui-linkbutton" iconCls="icon-save" onclick="save()">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="reset()">重置</a>
	</div>
	
	<table id="userDatagrid" class="easyui-datagrid" style="width: 400px; height: 250px"
		data-options="url:'/user/list',fitColumns:true,singleSelect:false,pagination:true,fit:true,pageSize:20,toolbar:'#tb',
				onClickRow:onclickRow,rownumbers:true,border:false">
		<thead>
			<tr>
				<th field="id" width="100" data-options="checkbox:true"></th>
				<th field="username" width="100">用户名</th>
				<th field="email" width="100">E-mail</th>
				<!-- <th field="dept" width="100" data-options="formatter:formatUtils.deptFormat">所属部门</th> -->
				<th field="age" width="50">年龄</th>
				<th field="sex" width="50" data-options="formatter:formatUtil.sexFormat">性别</th>
				<th field="status" width="50" data-options="formatter:formatUtil.statusFormat">状态</th>
				<th field="lastLoginTime" width="80">上次登录时间</th>
				<th field="lastLoginIp" width="80">上次登录IP</th>
			</tr>
		</thead>
	</table>
	
	<div id="userDialog" class="easyui-dialog" style="width: 300px;padding:10px;" 
		data-options="title:'用户录入',buttons:'#formButton',closed:true" >
		<form method="post" id="userForm">
			<table>
				<tr>
					<td>用户名</td>
					<td><input type="text" name="username" class="easyui-validatebox" data-options="required:true" /> </td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" name="email" class="easyui-validatebox" data-options="required:true,validType:'email'"/> </td>
				</tr>
				<tr>
					<td>密码</td>
					<td><input id="pwd" type="password" name="password" class="easyui-validatebox" data-options="required:true"/> </td>
				</tr>
				<tr>
					<td>确认密码</td>
					<td><input type="password" class="easyui-validatebox" data-options="required:true" validType="equals['#pwd']" /> </td>
				</tr>
				<tr>
					<td>年龄</td>
					<td><input type="text" name="age" class="easyui-validatebox" data-options="required:true,validType:'ageValidate'"/></td>
				</tr>
				<tr>
					<td>性别</td>
					<td>
						男<input type="radio" name="sex" value="1" checked="checked"/>
						女<input type="radio" name="sex" value="0"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
	
</body>
</html>