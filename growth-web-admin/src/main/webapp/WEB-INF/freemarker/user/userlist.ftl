<!DOCTYPE html>
<html>
	<head>
	    <#include "/head.ftl"/>
	</head>
<body>
<div class="right">
<div class="path">
					<span>首页</span>&gt;<span>会员管理</span>&gt;<span class="active">会员列表</span>
				</div>
				<div class="formdiv">
				          <form  name="queryForm" method="post" action="userlist.htm">
				          <p>
                        <span>手机号：</span><input name="mobile" value="${mobile!}" >
                        <span class="btn-ok"  onclick="document.queryForm.submit() ;">查询</span>
                    </p>
					    <@page.pageInput PageParam.startNum PageParam.maxCount />
					</form>
				</div>
				<div class="table-area mt-10">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<thead>
							<tr>
								<th width="8%">用户ID</th>
								<th width="18%">用户名</th>
								<th width="10%">性别</th>
								<th width="15%">手机号</th>
								<th width="20%">学校</th>
								<th width="15%">注册时间</th>
								<th width="14%">操作</th>
							</tr>
						</thead>
						<tbody>
							   <#list list as user >
            
				                 <tr>
				                  <td width="8%" title="${user.id!}">${user.id!}</td>
				                    <td width="18%">${user.name!}</td>
				                    <td width="10%">
				                     <#if user.sex ??  >
				                     <#if 0=user.sex   >
				                     男
				                     <#elseif 1=user.sex >
				                   		  女
				                     </#if>
				                      </#if>
				                    </td>
				                     <td width="15%">${user.mobile!}</td>
				                     <td width="20%">${user.school!}</td>
				                     <td width="15%">${user.createTime!}</td>
				                    <td width="14%"><a href="userView.htm?id=${user.id!}" class="blue-text cursor">详情</a>
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
<script>

</script>
</html>
