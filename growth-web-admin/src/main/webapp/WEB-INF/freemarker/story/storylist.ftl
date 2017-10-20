<!DOCTYPE html>
<html>
	<head>
	    <#include "/head.ftl"/>
	</head>
<body>
<div class="right">
<div class="path">
					<span>首页</span>&gt;<span>内容管理</span>&gt;<span class="active"><#if storyType=0>种子日记<#elseif storyType=1>养花教程<#else>成长故事展播</#if>  </span>
				</div>
				<div class="formdiv">
				          <form  name="queryForm" method="post" action="storylist.htm">
				           <p>
                        <span>标题：</span><input name="storyTitle" value="${storyTitle!}" >
                        <input type="hidden" name="storyType" value="${storyType!}"/>
                        <span class="btn-ok"  onclick="document.queryForm.submit() ;">查询</span>
                     </p>
					    <@page.pageInput PageParam.startNum PageParam.maxCount />
					</form>
				</div>
				 <#if storyType!=0 >
				<div class="functionbar clearfix">
                    <span class="add js-add"  onclick="location='storyView.htm?storyType=${storyType!}'">新增</span>
                </div>
                </#if>
				<div class="table-area mt-10">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<thead>
							<tr>
								<th width="28%">标题</th>
								<th width="15%">状态</th>
								<th width="28%">创建时间</th>
								<th width="29%">操作</th>
							</tr>
						</thead>
						<tbody>
							   <#list list as story >
            
				                 <tr id="story${story.id!}">
				                    <td width="28%">${story.storyTitle!}</td>
				                     <td width="15%" id="storyStatus${story.id!}">
				                     <#if story.actStatus ??  >
                                     <#if 0=story.actStatus   >
                                     停用
                                     <#elseif 1=story.actStatus >
                                         正常
                                     </#if>
                                      </#if>
				                     </td>
				                     <td width="28%">${story.createTime!}</td>
				                    <td width="29%"><a href="storyView.htm?id=${story.id!}" class="blue-text cursor">编辑</a>
				                    <a onclick="del('${story.id!}')" class="blue-text cursor">删除</a>
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
        $.get("${base}/story/delete.do?id="+id, function(result){
            $("#story"+id).remove();
        });
    }
}

</script>
</html>
