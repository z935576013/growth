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
                <li class="active"><#if storyType=0>成长日记<#elseif storyType=1>养花教程<#else>成长故事展播</#if> </li>
            </ul>
            
        </div>
    </section>
    
    <!--Blog Section-->
    <section class="blog-section">
    	<div class="auto-container">
    		<#if storyType==0 >
            <div class="c-title">
                	<div class="c-r"><button onclick="postUserStory();" class="theme-btn btn-style-two">发表日记</button></div>
             </div>
             </#if>
        	<div class="row clearfix">
            	
                 <#list list as story >
                
                 <!--Blog Post-->
            	<div class="column blog-post col-md-4 col-sm-6 col-xs-12">
                	<div class="inner-box">
                	    <figure class="image-box" <#if story.storyType==0>style="height:228px;overflow: hidden;"</#if>>
                	    <a href="${base}/story/storyView.htm?id=${story.id!}">
                	    <#if story.storyType==0 >
                        	<#if story.coverImgPath ?? >
                        	   <img src="${imgHost}${story.coverImgPath!}">
                        	<#else>
                        	   <img src="${resRoot}/images/resource/blog-image-2.jpg" >
                        	</#if>
                    	<#else>
                    	 <#if story.vedioPath ??>
                    	  <#if story.vedioPath !=''>
                    	  <!-- <iframe class="vedio" width='100%' height='240' src='http://player.youku.com/embed/${story.vedioPath!}==' frameborder=0 'allowfullscreen'></iframe> -->
                    	  <iframe class="vedio" style="z-index:1;" src="http://v.qq.com/iframe/player.html?vid=${story.vedioPath!}&auto=0" frameborder="0" height="228" width="100%" 'allowfullscreen'></iframe>
                          <#else>
                            <img src="${resRoot}/images/resource/blog-image-2.jpg" >    
                           </#if>
                         <#else>
                            <img src="${resRoot}/images/resource/blog-image-2.jpg" >
                         </#if>
                    	</#if>
                    	</a><div class="date">${story.createTime?string("yyyy.MM.dd")}</div></figure>
                        <div class="content-box">
                        	<h3><a href="${base}/story/storyView.htm?id=${story.id!}">${story.storyTitle!}</a></h3>
                        </div>
                        <#if storyType==0 >
                        <div class="post-info clearfix">
                        	<div class="author-info pull-left"><a >${story.userName!}</a></div>
                        </div>
                        </#if>
                    </div>
                </div>
                
               </#list>
                
            </div>
            
            <!-- Styled Pagination   -->
            <form  name="queryForm" method="post" action="storyList.htm">
                        <input type="hidden" name="storyType" value="${storyType!}"/>
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
<script type="text/javascript"  src="${resRoot}/js/paging.js"></script>
<script type="text/javascript">
$(function(){
    $('.vedio').each(function(){
        $(this).attr('height',$(this).width()/1.33);
    });
 }); 
 
 function postUserStory() {
 	localStorage.setItem("redirectUrl", '${base}/user/userStoryEdit.htm');
 	location.href = "${base}/user/userStoryEdit.htm";
 }
</script> 
</body>
</html>
