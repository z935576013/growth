<#-- 自定义的分页指令。
属性说明：
   page      当前页号(int类型)
   pageSize    每页要显示的记录数(int类型)
   toURL       点击分页标签时要跳转到的目标URL(string类型)
   totalRecords 总记录数(int类型)
 使用方式：
  <#if totalRecords??>
    <#import "/pager.ftl" as q>
    <@q.pager page=page pageSize=pageSize totalRecords=totalRecords toURL="testpager.action"/>
  </#if>
 -->
<#macro pager page pageSize toURL totalRecords>  
  <#-- 定义局部变量pageCount保存总页数 -->
  <#assign pageCount=((totalRecords + pageSize - 1) / pageSize)?int>  
	<#if totalRecords==0><#return/></#if>
<#-- 页号越界处理 -->
  <#if (page > pageCount)>
    <#assign page=pageCount>
  </#if>
  <#if (page < 1)>
    <#assign page=1>
  </#if>
<#-- 输出分页表单 -->
<div class="sucPath">
        <div class="snPages">
		<#-- 把请求中的所有参数当作隐藏表单域(无法解决一个参数对应多个值的情况)-->
		
		<#list RequestParameters?keys as key>
		<#if (key!="page" && RequestParameters[key]?exists)>
		<input type="hidden" name="${key}" value="${RequestParameters[key]}"/>
		</#if>
		</#list>
		 
		<#--<form method="post" action="" name="qPagerForm">-->
		<input type="hidden" id="page" name="page" value="${page}"/>
		<#-- 上一页处理 -->
		  <#if (page == 1)>
			<span>上一页</span>
		  <#else>
		  <a href="###" class="prev" onclick="jumpPage(${page - 1},'${toURL}')"><b></b> 上一页</a>
		  </#if>
		<#-- 如果前面页数过多,显示... -->
			<#assign start=1>
			<#if (page > 4)>
			    <#assign start=(page - 1)>
				<a href="###"  onclick="jumpPage(1,'${toURL}')" >1</a>
				<a href="###" onclick="jumpPage(2,'${toURL}')" >2</a>
				<span>&hellip;</span>
			</#if>
		<#-- 显示当前页号和它附近的页号 -->
			<#assign end=(page + 1)>
			<#if (end > pageCount)>
				<#assign end=pageCount>
			</#if>
		  <#list start..end as i>
		    <#if (page==i)>
		<span><a class="current">${i}</a></span>
				<#else>
		<a href="###" onclick="jumpPage(${i},'${toURL}')">${i}</a>      
		    </#if>
		  </#list>
		<#-- 如果后面页数过多,显示... -->
		  <#if (end < pageCount - 2)>
		<span>&hellip;</span>
		  </#if>
		  <#if (end < pageCount - 1)>
		<a href="###" onclick="jumpPage(${pageCount - 1},'${toURL}')">${pageCount-1}</a>
		  </#if>
		  <#if (end < pageCount)>
		<a href="###"  onclick="jumpPage(${pageCount},'${toURL}')">${pageCount}</a>
		  </#if>
		<#-- 下一页处理 -->
		  <#if (page == pageCount)>
		  	<span>下一页</span>
		  <#else>
			<a href="###" class="next" onclick="jumpPage(${page + 1},'${toURL}')"><b></b> 下一页</a>
		  </#if>
		<div><input id="inputPageNum" name="inputPageNum" type="text" value="" size="2" onkeyup="this.value=this.value.replace(/\D/g,'')"/>页
		<input type="button" value="跳转"  onclick="jumpPage(document.getElementById('inputPageNum').value,'${toURL}')" class="pagesubmit">
		</div>
		<#--</from>-->
	</div> 
</div> 
</#macro>  