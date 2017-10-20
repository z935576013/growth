<!DOCTYPE html>
<html>
	<head>
	    <#include "/head.ftl"/>
	</head>
<body>
<div class="right">
<div class="path">
					<span>首页</span>&gt;<span>活动管理</span>&gt;<span class="active">活动管理</span>
				</div>
				<div class="formdiv">
				          <form  name="queryForm" method="post" action="gamelist.htm">
				           <p>
                        <span>标题：</span><input name="gameTitle" value="${gameTitle!}" >
                        <input type="hidden" name="gameType" value="${gameType!}"/>
                        <span class="btn-ok"  onclick="document.queryForm.submit() ;">查询</span>
                     </p>
					    <@page.pageInput PageParam.startNum PageParam.maxCount />
					</form>
				</div>
				<div class="functionbar clearfix">
                    <span class="add js-add"  onclick="location='gameView.htm?gameType=${gameType!}'">新增</span>
                </div>
				<div class="table-area mt-10">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<thead>
							<tr>
								<th width="28%">标题</th>
								<th width="15%">状态</th>
								<th width="14%">报名人数</th>
								<th width="14%">创建时间</th>
								<th width="29%">操作</th>
							</tr>
						</thead>
						<tbody>
							   <#list list as game >
            
				                 <tr id="game${game.id!}">
				                    <td width="28%">${game.gameTitle!}</td>
				                     <td width="15%" id="gameStatus${game.id!}">
				                     <#if game.actStatus ??  >
                                     <#if 0=game.actStatus   >
                                     停用
                                     <#elseif 1=game.actStatus >
                                         正常
                                     </#if>
                                      </#if>
				                     </td>
				                     <td width="14%">${game.joinCount!}</td>
				                     <td width="14%">${game.createTime!}</td>
				                    <td width="29%"><a href="gameView.htm?id=${game.id!}" class="blue-text cursor">编辑</a>
				                    <a onclick="del('${game.id!}')" class="blue-text cursor">删除</a>
				                    <a href="gameJoinList.htm?gameId=${game.id!}" class="blue-text cursor">报名用户</a>
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
function del(id){
    if(confirm('确认删除吗?')){
        $.get("${base}/game/delete.do?id="+id, function(result){
            $("#game"+id).remove();
        });
    }
}

</script>
</html>
