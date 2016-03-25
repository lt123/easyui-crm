formatUtil = {
	sexFormat:function(value,row,index){
		return value == 1 ? '男':'女';
	},
	statusFormat:function(value,row,index) {
		return value == 1 ?"<font color='blue'>正常</font>" : "<font color='red'>离职</font>";
	}

}

$.alert = function(msg,callback){
	$.messager.alert("温馨提示",msg,"info",callback);
};
$.error = function(msg,callback){
	$.messager.alert("温馨提示",msg,"error",callback);
};
$.debug = function(msg){
	console.debug(msg)
}