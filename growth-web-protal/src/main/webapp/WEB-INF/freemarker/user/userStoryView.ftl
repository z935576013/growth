<!DOCTYPE html>
<html>
<head>
 <#include "/common/head.ftl"/>
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
                        	<h3>我的日记</h3><div class="c-r"><button onclick="delStory();"  class="theme-btn btn-style-two">删除日记</button> 
                        	<button onclick="location='${base}/user/userStoryEdit.htm?id=${story.id!}'"  class="theme-btn btn-style-one">修改日记</button></div>
                     </div>
                <!--Blog Section / Blog Details-->
                    <section class="blog-section blog-details classic-view no-padd-bottom no-padd-top">
                        
                        <!--Blog Post-->
                        <div class="column blog-post">
                            <div class="inner-box">
                                <figure class="image-box">
                                <#if story.coverImgPath ?? >
                                   <img width="100%" src="${imgHost}${story.coverImgPath!}">
                                <#else>
                                   <img src="${resRoot}/images/resource/blog-image-4.jpg" >
                                </#if>
                                </figure>
                                <div class="post-info clearfix">
                                    <div class="share pull-right">${story.createTime?string("yyyy.MM.dd")}</div>
                                </div>
                                <div class="content-box">
                                	
                                    <h3>${story.storyTitle!}</h3>
                                    <div class="text">
                                        <#if story.storyContent ?? >
                                            ${story.storyContent!}
                                        </#if>
                                     </div>
                                </div>
                            </div>
                        </div>
                        
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
<script type="text/javascript">
function delStory(){
    if(confirm('确认删除吗?')){
       location='${base}/user/deleteUserStory.htm?id=${story.id!}';
    }
}
</script>
</body>
</html>
