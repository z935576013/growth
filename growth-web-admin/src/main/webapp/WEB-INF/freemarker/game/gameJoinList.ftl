<!DOCTYPE html>
<html>
	<head>
	    <#include "/head.ftl"/>
	</head>
<body>
<div class="right">
<div class="path">
					<span>首页</span>&gt;<span>活动管理</span>&gt;<span class="active">报名用户</span>
				</div>
				<div class="formdiv">
				          <form  name="queryForm" method="post" action="gameJoinList.htm">
				            <p>
                        <span>手机号：</span><input name="mobile" value="${mobile!}" >
                        <input type="hidden" name="gameId" value="${gameId!}"/>
                        <span class="btn-ok"  onclick="document.queryForm.submit() ;">查询</span>
                     </p>
					    <@page.pageInput PageParam.startNum PageParam.maxCount />
					</form>
				</div>
				<div class="functionbar clearfix">
                    <span class="add js-add"  onclick="location='gamelist.htm'">返回</span>
                </div>
				<div class="table-area mt-10">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<thead>
							<tr>
								<th width="28%">手机号</th>
								<th width="15%">性别</th>
								<th width="14%">姓名</th>
								<th width="14%">年龄</th>
								<th width="14%">学校</th>
								<th width="15%">报名时间</th>
							</tr>
						</thead>
						<tbody>
							   <#list list as user >
            
				                 <tr id="user${user.id!}">
				                    <td width="28%">${user.mobile!}</td>
				                     <td width="15%" >
				                     <#if user.sex ??  >
                                     <#if 0=user.sex   >
                                     男
                                     <#elseif 1=user.sex >
                                         女
                                     </#if>
                                      </#if>
				                     </td>
				                     <td width="14%">${user.name!}</td>
				                     <td width="14%">${user.age!}</td>
				                     <td width="14%">${user.school!}</td>
				                     <td width="15%">${user.createTime!}</td>
				                    </td>
				                </tr>
				              </#list>                
						</tbody>
					</table>
				</div>
				  <@page.pageList pageIndex=PageParam.pageIndex pageCount=PageParam.pageCount />
			</div>
		</div>
	</div>	
</body>
</html>
