<!DOCTYPE html>
<html>
<head>
 <#include "/common/head.ftl"/>
 <#import "/macro/paging.ftl" as page>
</head>

<body>
<div class="page-wrapper">
 	
    <!-- Preloader -->
    <div class="preloader"></div>
 	
    <#include "/common/header.ftl"/>
    
    <!--Page Title-->
    <section class="page-title">
    	<div class="auto-container">
            <!--Bread Crumb-->
            <ul class="bread-crumb clearfix">
                <!-- <li><a href="${base}">首页</a></li> -->
                <li class="active"><#if lessonType=0>成长国学院<#elseif lessonType=1>少年科学院<#else>魔力课堂</#if></li>
                
            </ul>
            
        </div>
    </section>
    
    
    <!--Team Section-->
    <section class="team-section bg-lightgrey">
    	<div class="auto-container">
            
        	<div class="row clearfix">
            	
            	<#list list as lesson >
            	
                <!--Team Member-->
            	<div class="column team-member col-md-4 col-sm-6 col-xs-12">
                	<div class="inner-box">
                    	<figure class="image-box"><a href="${base}/lesson/lessonView.htm?id=${lesson.id!}">
                    	<#if lesson.vedioPath ??>
                          <#if lesson.vedioPath !=''>
                       		<!-- <iframe class="vedio"  width='100%' height='228' src='http://player.youku.com/embed/${lesson.vedioPath!}==' frameborder=0 'allowfullscreen'></iframe> -->
                       		<iframe class="vedio" style="z-index:1;" src="http://v.qq.com/iframe/player.html?vid=${lesson.vedioPath!}&auto=0" frameborder="0" height="228" width="100%" 'allowfullscreen'></iframe>
                          <#else>
                            <img src="${resRoot}/images/resource/team-image-1.jpg" alt="">
                           </#if>
                         <#else>
                            <img src="${resRoot}/images/resource/team-image-1.jpg" alt="">
                         </#if>
                    	</a></figure>
                        <div class="content-box">
                        	<h3><a href="${base}/lesson/lessonView.htm?id=${lesson.id!}">${lesson.lessonTitle!}</a></h3>
                            <div class="designation">${lesson.createTime?string("yyyy.MM.dd")}</div>
                            
                        </div>
                        
                    </div>
                </div>
                
                </#list>
                
            </div>
            
            <!-- Styled Pagination   -->
            <form  name="queryForm" method="post" action="lessonList.htm">
                        <input type="hidden" name="lessonType" value="${lessonType!}"/>
                        <@page.pageInput PageParam.startNum PageParam.maxCount />
            </form>
            <@page.pageList pageIndex=PageParam.pageIndex pageCount=PageParam.pageCount />
            
        </div>
    </section>
    
    
    <#include "/common/footer.ftl"/>    
    
    
</div>
<!--End pagewrapper-->

<!--Scroll to top-->
<!-- <div class="scroll-to-top scroll-to-target" data-target=".main-header"><span class="icon flaticon-transport-2"></span></div> -->

<script src="${resRoot}/js/jquery-1.10.2.min.js"></script>
<script src="${resRoot}/js/bootstrap.js"></script>
<script src="${resRoot}/js/jquery.fancybox.pack.js"></script>
<script src="${resRoot}/js/mixitup.js"></script>
<script src="${resRoot}/js/bxslider.js"></script>
<script src="${resRoot}/js/owl.js"></script>
<script src="${resRoot}/js/wow.js"></script>
<script src="${resRoot}/js/script.js"></script>
<script type="text/javascript">
$(function(){
    $('.vedio').each(function(){
        $(this).attr('height',$(this).width()/1.33);
    });
 }); 
</script> 
</body>
</html>
