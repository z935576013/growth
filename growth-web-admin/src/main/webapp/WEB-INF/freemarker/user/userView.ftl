<!DOCTYPE html>
<html>
	<head>
	    <#include "/head.ftl"/>
</head>

<body>
<div class="right">
				<div class="path">
					<span>首页</span>&gt;<span><a href="${base}/user/userlist.htm">用户列表</a></span>&gt;<span class="active">用户详情</span>
				</div>
				<div class="userinfo clearfix">
					<div class="user-imfor fl">
						<p>
							<span class="name">会员名：</span>
							<span>${user.name!}</span>
						</p>
						<#if user.headImgPath ??>
						<p>
                            <span class="name">头像：</span>
                            <span><img width='200' height='200' src="${imgHost}${user.headImgPath!}" ></span>
                        </p>
                        </#if>
						<p>
							<span class="name">性别：</span>
							<span><#if user.sex ??  >
						                <#if 0=user.sex   >
						                 男
						                <#elseif 1=user.sex >
						                                        女
						                </#if>
						                </#if>
						</span>
						</p>
						<p>
							<span class="name">手机：</span>
							<span>${user.mobile!} </span>
						</p>
						<p>
							<span class="name">年龄：</span>
							<span>${user.age!}  </span>
						</p>
						<p>
                            <span class="name">年龄：</span>
                            <span>${user.age!}  </span>
                        </p>
                        <p>
                            <span class="name">学校：</span>
                            <span>${user.school!}  </span>
                        </p>
                        <p>
                            <span class="name">班级：</span>
                            <span>${user.gradeNum!}年级${user.classNum!}班  </span>
                        </p>
                        <p>
                            <span class="name">兴趣：</span>
                            <span>${user.hobby!}  </span>
                        </p>
                        <p>
                            <span class="name">特长：</span>
                            <span>${user.strongPoint!}  </span>
                        </p>
                         <p>
                            <span class="name">注册时间：</span>
                            <span>${user.createTime!}  </span>
                        </p>
					</div>
				</div>
	</div>						
</body>
</html>
