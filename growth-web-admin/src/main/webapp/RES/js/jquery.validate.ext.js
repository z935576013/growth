// 校验手机号码限制：1开始11位数字
$.validator.methods.ismobile = function(value, element, param) {
	      var length = value.length;    
	 return this.optional(element) || (length == 11 && /^1\d{10}$/.test(value));
};

//金额，小数点后两位有效数字，金额上限为整数位长度为value
$.validator.methods.money = function(value, element, param) {
	
	var patt1=new RegExp("^[1-9][0-9]{0,"+(param-1)+"}$");
	var patt2=new RegExp("^[1-9][0-9]{0,"+(param-1)+"}[.][0-9]{1,2}$");
	
	 return this.optional(element) ||  /^0\.\d{0,2}$/.test(value) || patt1.test(value) || patt2.test(value);
};



