<#-- 分页组件

 使用方式：
    <#import "/macro/paging.ftl" as page>
    <@page.pageInput condition.startIndex condition.maxCount />
    <@page.pageList pageIndex=PageParam.pageIndex pageCount=PageParam.pageCount />
、
属性说明：
   startIndex     查询开始记录序号
   maxCount         每页最大显示条数
   
   pageIndex     当前页码
   pageCount    总页码


 -->

<#macro pageInput startIndex=0 maxCount=15 > 
                <input type="hidden" name="startIndex" id="startIndex" class="" value="${startIndex}">
                <input type="hidden" name="maxCount" class="" id="maxCount" value="${maxCount}">
</#macro>


<#macro pageList pageIndex=1 pageCount=0> 

         <div class="styled-pagination text-center padd-top-20 padd-bott-20">
         <ul>
         <#if pageIndex gt 1 >
         
            <li> <a href="javascript:void(0)"  onclick=" prePage() ; ">上一页</a></li>
         
         </#if>
         
         
         
         <#if pageIndex gt 2 >
         
             <li><a href="javascript:void(0)" onclick=" getPage(${pageIndex-2}) ; " >${pageIndex-2}</a></li>
         
         </#if>
         
        <#if pageIndex gt 1 >
         
             <li><a  href="javascript:void(0)" onclick=" getPage(${pageIndex-1}) ; " >${pageIndex-1}</a></li>
         
         </#if>
         
         <li><span>${pageIndex}</span>
         
         <#if pageIndex lt pageCount>
             <li><a  href="javascript:void(0)" onclick=" getPage(${pageIndex+1}) ; " >${pageIndex+1}</a></li>
         </#if>
         
         <#if pageIndex+1 lt pageCount>
            <li><a  href="javascript:void(0)" onclick=" getPage(${pageIndex+2}) ; " >${pageIndex+2}</a></li>
         </#if>
         <#if pageIndex lt pageCount>
            <li><a href="javascript:void(0)"  onclick=" nextPage() ; ">下一页</a></li>
          </#if>
          
          </ul>
         </div>
         
         
 </#macro>