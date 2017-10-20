<!DOCTYPE html>
<html>
	<head>
	    <#include "/head.ftl"/>
	</head>
<body>
<div class="right">
<div class="path">
					<span>首页</span>&gt;<span>电视六一晚会</span>&gt;<span class="active">电视六一晚会</span>
				</div>
				<div class="formdiv">
				          <form  name="queryForm" method="post" action="actJoinlist.htm">
				           <p>
                        <span>姓名：</span><input name="name" value="${name!}" >
                        <span class="btn-ok"  onclick="document.queryForm.submit() ;">查询</span>
                     </p>
					    <@page.pageInput PageParam.startNum PageParam.maxCount />
					</form>
				</div>
				<div class="table-area mt-10">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<thead>
							<tr>
								<th width="23%">姓名</th>
								<th width="15%">性别</th>
								<th width="14%">年龄</th>
								<th width="19%">绰号</th>
								<th width="14%">报名时间</th>
								<th width="15%">操作</th>
							</tr>
						</thead>
						<tbody>
							   <#list list as actJoin >
            
				                 <tr>
				                    <td width="23%">${actJoin.name!}</td>
				                     <td width="15%">${actJoin.sex!}</td>
				                     <td width="14%">${actJoin.age!}</td>
				                     <td width="19%">${actJoin.nickname!}</td>
				                     <td width="14%">${actJoin.createTime!}</td>
				                    <td width="15%">
				                    <a href="actJoinView.htm?id=${actJoin.id!}" class="blue-text cursor">查看详情</a>
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
<script type="text/javascript">

</script>
</html>
