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
                <li><a href="${base}">首页</a></li>
                <li><a href="${base}/user/userView.htm">会员中心</a></li>
                <li class="active">我的日记</li>
            </ul>
            
        </div>
    </section>
    
    
    <!--Contact Section-->
    <section class="contact-section bg-lightgrey">
    
    	<div class="auto-container">
        	<div class="outer-container">
            	<div class="clearfix">
                	<#include "/user/userLeft.ftl"/>
                    
                   <!--Content Side-->      
                <div class="content-side c-bai col-lg-9 col-md-9 col-sm-12 col-xs-12">
                	<div class="c-title">
                        	<h3>我的日记</h3><div class="c-r"><button onclick="location='${base}/user/userStoryEdit.htm'" class="theme-btn btn-style-two">发表日记</button></div>
                     </div>
                	<!--Blog Section / Classic View-->
                    <section class="blog-section classic-view no-padd-bottom no-padd-top">
                        
                        <#list list as story>
                        <!--Blog Post-->
                        <div class="column blog-post">
                            <div class="inner-box">
                                <figure class="image-box" style="height:200px; overflow:hidden;"><a href="${base}/user/userStoryView.htm?id=${story.id!}" >
                                <#if story.coverImgPath ?? >
                                   <img src="${imgHost}${story.coverImgPath!}">
                                <#else>
                                   <img src="${resRoot}/images/resource/blog-image-4.jpg" >
                                </#if>
                                </a><div class="date">${story.createTime?string("yyyy.MM.dd")}</div></figure>
                                <div class="post-info clearfix">
                                    <div class="author-info pull-left">By  ${story.userName!}</div>
                                    <div class="more pull-right"><a href="${base}/user/userStoryView.htm?id=${story.id!}" class="read-more">${story.storyTitle!}</a></div>
                                </div>
                            </div>
                        </div>
                        </#list>
                        
                          <!-- Styled Pagination   -->
                            <form  name="queryForm" method="post" action="${base}/user/userStoryList.htm">
                                        <input type="hidden" name="storyType" value="${storyType!}"/>
                                        <@page.pageInput PageParam.startNum PageParam.maxCount />
                            </form>
                            <@page.pageList pageIndex=PageParam.pageIndex pageCount=PageParam.pageCount />
                        
                    </section>  
                
                </div><!--End Content Side-->
                
            		
                    
                </div>
            </div>
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
</body>
</html>
