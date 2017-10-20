<!DOCTYPE html>
<html>
	<head>
	    <#include "/head.ftl"/>
	</head>
<body>
<div class="right">
<div class="path">
					<span>首页</span>&gt;<span>内容管理</span>&gt;<span class="active"><#if lessonType=0>成长国学院<#elseif lessonType=1>少年科学院<#else>魔力课堂</#if>  </span>
				</div>
				<div class="formdiv">
				          <form  name="queryForm" method="post" action="lessonlist.htm">
				          <p>
                        <span>标题：</span><input name="lessonTitle" value="${lessonTitle!}" >
                        <input type="hidden" name="lessonType" value="${lessonType!}"/>
                        <span class="btn-ok"  onclick="document.queryForm.submit() ;">查询</span>
                     </p>
					    <@page.pageInput PageParam.startNum PageParam.maxCount />
					</form>
				</div>
				<div class="functionbar clearfix">
                    <span class="add js-add"  onclick="location='lessonView.htm?lessonType=${lessonType!}'">新增</span>
                </div>
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
							   <#list list as lesson >
            
				                 <tr id="lesson${lesson.id!}">
				                    <td width="28%">${lesson.lessonTitle!}</td>
				                     <td width="15%" id="lessonStatus${lesson.id!}">
				                     <#if lesson.actStatus ??  >
                                     <#if 0=lesson.actStatus   >
                                     停用
                                     <#elseif 1=lesson.actStatus >
                                         正常
                                     </#if>
                                      </#if>
				                     </td>
				                     <td width="28%">${lesson.createTime!}</td>
				                    <td width="29%"><a href="lessonView.htm?id=${lesson.id!}" class="blue-text cursor">编辑</a>
				                    <a onclick="del('${lesson.id!}')" class="blue-text cursor">删除</a>
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
        $.get("${base}/lesson/delete.do?id="+id, function(result){
            $("#lesson"+id).remove();
        });
    }
}

</script>
</html>
