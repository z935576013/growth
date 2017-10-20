package com.growth.common.constants;

/**
 * 错误消息常量
 *
 * @author zhuliang
 */
public enum ErrorMessage {
	//酒店profile
//	ERROR_1001("1001", "请求参数异常?"),
//	ERROR_1002("1002", "无权操作"),
//	ERROR_1003("1003", "上传文件类型错误"),
//	ERROR_1004("1004", "由酒店方保存合同条款"),
//	ERROR_1005("1005", "RFP 不存在"),
//	ERROR_1006("1006", "酒店房间报价的时候房间数不应该大于其总有的房间数"),
//	ERROR_1007("1007", "有进行中的rfp不能修改合同样板"),
//	ERROR_1008("1008", "月份参数异常"),

//	//公共异常信息
//	ERROR_0000("0000", "系统内部错误"),
//	ERROR_0001("0001", "用户名已被注册"),
//	ERROR_0002("0002", "验证码不正确"),
//	ERROR_0004("0004", "用户不存在"),
//	ERROR_0005("0005", "原密码不正确"),
//	ERROR_0013("0013", "参数类型不正确"),
//	ERROR_0014("0014", "需要登录"),

//
//	ERROR_0034("0034", "上传失败"),
//	ERROR_HOTEL_NOT_FOUND("H001", "酒店?不存在"),
//
//	ERROR_0037("0037", "请求参数校验失败"),
//	ERROR_0038("0038", "请求失败"),
//	ERROR_0039("0039", "对方设置不能自动添加好友"),
//	ERROR_0040("0040", "已经是好友"),
//	ERROR_0041("0041", "申请邮箱已被占用") ,
//	ERROR_0042("0042", "没有权限访问当前页面"),
//	ERROR_0043("0043","没有管理员用户") ;
	
	//酒店profile
	ERROR_1001("1001", "请求参数异常", "Request parameter exception?"),
	ERROR_1002("1002", "无权操作", "Unauthorized operation"),
	ERROR_1003("1003", "上传文件类型错误", "Upload file type error"),
	ERROR_1004("1004", "由酒店方保存合同条款", "Contract terms by the hotel party"),
	ERROR_1005("1005", "会议不存在", "RFP is not existing"),
	ERROR_1006("1006", "酒店房间报价的时候房间数不应该大于其总有的房间数", "Room number should not exceed the total number of rooms in the hotel room"),
	ERROR_1007("1007", "有进行中的询价书不能修改合同样板", "rfp  in progressing ,can't modify contract templet"),
	ERROR_1008("1008", "您选择的月份已经存在于当前的价格体系中，选择月份不能和当前存在月份存在交集，请重新选择后再保存", "month parameter exception"),
	ERROR_1009("1009", "密码修改链接已失效，请回到登陆页点击忘记密码", "This link is valid, please click the forget password button on the login page to get a new one."),
	ERROR_1010("1010", "密码修改链接不正确,请在觅星邮件中检查链接或直接点击邮件中修改密码按钮进行操作。", "The current link is incorrect, please check the link or click modify password button to operate in the merak system mail."),
	ERROR_1011("1011", "最多可以选中三家酒店谈判！", "Only 3 Selection Permitted!"),
	ERROR_1012("1012", "不能删除", "can't delete !"),
	
	//公共异常信息
	ERROR_0000("0000", "系统内部错误", "System internal error"),
	ERROR_0001("0001", "用户名已被注册", "User name already registered"),
	ERROR_0002("0002", "您输入的验证码错误，请输入登录邮箱收到的觅星系统验证码", "Verification code is not correct"),
	ERROR_0004("0004", "用户不存在", "Users do not exist"),
	ERROR_0005("0005", "原密码不正确", "The original password is not correct"),
	ERROR_0006("0006", "请求参数校验失败", "Verify parameters failed"),
	ERROR_0007("0007", "密码不正确", "Invalid Password"),
	ERROR_0013("0013", "参数类型不正确", "Parameter type is incorrect"),
	ERROR_0014("0014", "需要登录", "Need to log in"),
	ERROR_0015("0015", "登录状态失效或您的账号已在其他地方登录", "Your account has been in other places, is about to return to the landing page."),
	ERROR_0016("0016", "该账号已被冻结", "The account has been frozen!"),
	ERROR_0017("0017", "该账号不可用", "The account is inavailable!"),
	ERROR_0018("0018", "您的账户还未激活，请登录网页版（www.merak.com）进行激活。", "Your Merak account is not activated. Please visit www.merak.com for activation."),
	

	ERROR_0034("0034", "上传失败", "Upload failed"),
	ERROR_HOTEL_NOT_FOUND("H001", "酒店?不存在", "Hotel ? does not exist"),

	ERROR_0037("0037", "请求参数校验失败", "Request parameter check failed"),
	ERROR_0038("0038", "请求失败", "Request failure"),
	ERROR_0039("0039", "对方设置不能自动添加好友", "The other settings can not automatically add friends"),
	ERROR_0040("0040", "已经是好友", "Has been a good friend"),
	ERROR_0041("0041", "申请邮箱已被占用", "Application mail has been occupied"),
	ERROR_0042("0042", "没有权限访问当前页面", "No Authority"),
	ERROR_0043("0043", "没有管理员用户", "no admin user") ,
	ERROR_0044("0044", "您无权限发送预算，请添加更高权限用户", "No permission send budget approval , please add another user"),
	ERROR_0053("0053", "发送询价书到非协议酒店需通过企业管理员审批，请添加管理员进行审批", "Admin approval is required when sending RFP to non preferred hotel. Please add  Admin for approval."),
	ERROR_0054("0054", "当前询价书预算金额已超出权限，需要通过企业管理员审批，请添加管理员进行审批", "This RFP exceeds company budget limitation. Please add admin for approval."),
	ERROR_0055("0055", "当前询价书预算金额已超出权限，发送询价书到非协议酒店需通过企业管理员审批，请添加管理员进行审批发送", "This RFP exceeds company budget limitation. Admin approval is required when sending RFP to non preferred hotel. Please add Admin for approval."),
	

	ERROR_0045("0045", "身份码验证失败!", "Verification code is invalid"),
	ERROR_0052("0052", "没有超级管理员用户", "no superAdmin user") ,
	
	/******** 客户端没有用到 ***********/
	
	//模板异常信息
	ERROR_0046("0046", "模板数量已到最大限制!"),
	ERROR_0047("0047", "模板不存在!"),
	ERROR_0048("0048", "用户没有部门，请加入部门后才能提交模板审核!"),
	ERROR_0049("0049", "模板名称已存在，请重新命名!"),
	ERROR_0050("0050", "模板撤销失败!"),
	ERROR_0051("0051", "您选择的模板已经被移除，刷新页面，重新选择模板"),
	
	ERROR_0060("0060", "您不是该公司或酒店的成员"),
	
	ERROR_0070("0070", "积分账户不存在","The Point Account does not exist"),
	
	ERROR_0080("0080", "已超过当日设置次数上限", "The maximum number of settings for the day has passed") ,
	//sso
//	ERROR_1000("1000", "无效token"),
	
	ERROR_4001("4001", "待审核的信息已发生变动，请刷新页面", "Pending review has changed. Please refresh the page"),
	ERROR_5001("5001", "Excel文件解析失败", "Excel file parsing failed"),
	
	
	/** 后台权限错误 **/
	ERROR_2000("2000", "后台账号已冻结"),
	ERROR_2001("2001", "已存在角色名"),
	ERROR_2002("2002", "删除角色失败"),
	ERROR_2003("2003", "角色信息更新失败"),
	
	ERROR_2004("2004", "已存在岗位名"),
	ERROR_2005("2005", "删除岗位失败"),
	ERROR_2006("2006", "岗位信息更新失败"),
	
	ERROR_2007("2007", "该账号不为酒店用户"),
	
	/******** 客户端没有用到 ***********/
	
	/** 子账号错误begin **/
	ERROR_3000("3000", "被注册的手机号已存在", "The number is existing"),
	ERROR_3001("3001", "用户名不存在", "This number is unprotected"),
	ERROR_3002("3002", "密码不正确", "Password is incorrect"),
	ERROR_3003("3003", "账号不可用", "The account is unavailable"),
	ERROR_3004("3004", "短信验证码不正确", "Verification code is incorrect"),
	ERROR_3005("3005", "未绑定手机号", "This number is not unprotected"),
	ERROR_3006("3006", "手机号已被绑定", "This number is already protected to a Merak account"),
	ERROR_3007("3007", "当日获取验证码最大次数为5", "Maximum 5 verification code per day"),
	ERROR_3008("3008", "推荐码不存在", "Invalid referral code"),
	/** 子账号错误end **/
	
	ERROR_9000("9000", "状态不正确", "Cannot be edited in current status");
	
	/**
	 * 错误编码
	 */
	private String errorCode;
	/**
	 * 错误描述
	 */
	private String errorMessage;
	
	private String errorMessgaeEn;

	/**
	 * 
	 * @param errorCode
	 * @param errorMessage
	 */
	private ErrorMessage(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	private ErrorMessage(String errorCode, String errorMessage, String errorMessageEn) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.errorMessgaeEn = errorMessageEn;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	public String getErrorMessgaeEn() {
		return errorMessgaeEn;
	}
}
