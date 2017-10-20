<!DOCTYPE html>
<html>
	<head>
	    <#include "/head.ftl"/>
</head>


<body>
 <form  name="submitForm" method="post" action="login.htm">
		<div class="login-content">
			<div class="header">后台管理系统</div>
			<div class="login">
				<div class="login-wrap">
					<p class="login-t-p"><span class="login-text">登录您的账号</span></p>
					<ul>
						<li>
							<span class="key"><input type="text" name="loginId" placeholder="用户名"></span>
						</li>
						<li>
							<span class="key"><input type="password" name="password"  placeholder="密码"></span>
						</li>
					</ul>
					<#if errorMessage ??>
					<p class="tips">*密码不正确</p>
					</#if>
					<p class="div-btn"  onclick="document.submitForm.submit() ;"><span class="btn-ok">登录</span></p>
				</div>
			</div>
		</div>
		</form>
	</body>
</html>
