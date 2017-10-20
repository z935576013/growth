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
                <!-- <li><a href="${base}">首页</a></li> -->
                <li><a href="${base}/story/storyList.htm?storyType=${story.storyType!}">返回</a></li>
                <li class="active">详情页</li>
            </ul>
            
        </div>
    </section>    
    <!--Sidebar Page-->
    <div class="sidebar-page-container">
    	<!--Tabs Box-->
        <div class="auto-container">
            <div class="row clearfix">
            
            	<!--Content Side-->      
                <div class="content-side col-lg-8 col-md-8 col-sm-12 col-xs-12">
                
                	<!--Blog Section / Blog Details-->
                    <section class="blog-section blog-details classic-view no-padd-bottom no-padd-top">
                        
                        <!--Blog Post-->
                        <div class="column blog-post">
                            <div class="inner-box">
                                <#if story.storyType!=2 >
                                <figure class="image-box">
                                <#if story.coverImgPath ?? >
                                 <img src="${imgHost}${story.coverImgPath!}">
                                <#else>
                                <img src="${resRoot}/images/resource/blog-image-2.jpg" >
                                </#if>
                                </figure>
                                </#if>
                                <div class="post-info clearfix">
                                 <#if story.storyType==0 >
                                    <div class="author-info pull-left"><a >${story.userName!}</a></div>
                                 </#if>   
                                    <div class="share pull-right">${story.createTime?string("yyyy.MM.dd")}</div>
                                </div>
                                <div class="content-box">
                                    <h3>${story.storyTitle!}</h3>
                                    <div class="text">
                                    <#if story.storyContent ?? >
                                    ${story.storyContent}
                                    </#if>
                                    
                                     <#if story.storyType!=0 >
                                     <#if story.vedioPath ??>
                                     <#if story.vedioPath !=''>
                                    <!-- <iframe class="vedio" width='100%' height='300' src='http://player.youku.com/embed/${story.vedioPath!}==' frameborder=0 'allowfullscreen'></iframe> -->
                                    <iframe class="vedio" style="z-index:1;" src="http://v.qq.com/iframe/player.html?vid=${story.vedioPath!}&auto=0" frameborder="0" height="285" width="100%" 'allowfullscreen'></iframe>
                                     </#if>
                                     </#if>
                                     </#if>
                                     </div>
                                </div>
                            </div>
                        </div>
                        
                    </section> 
                    
                  
                    
                    
                
                </div><!--End Content Side-->
                
                <!--Sidebar-->      
                <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                    <aside class="sidebar">
                        
                        
                        <!-- About Me -->
                        <div class="sidebar-widget about-me wow fadeInUp" data-wow-delay="0ms" data-wow-duration="1500ms">
                            <div class="sidebar-title"><h2>关于花满城</h2></div>
                            
                            <figure class="image-box"><img src="${resRoot}/images/resource/featured-image-5.jpg" alt=""></figure>
                            <div class="content">
                                <div class="text">花满城是2017年扬州广播电视总台重点打造的一档日播少儿成长类电视节目，“花满城”首创以魔幻为背景的少儿教育类节目，电视机前的所有孩子都是这所学院的初级学员，周一至周五每天会上一堂魔力课堂，孩子们可以通过魔力课堂学到各种“魔法”和“超能力”，快速成长，节目通过充满魔幻的现场和有趣有情的外拍VCR把各种少儿成长所需要的知识传递给家长和孩子。</div>
                            </div>
                            
                        </div>
                        
                       
                        
                        <!-- Recent Posts -->
                        <!--
                        <div class="sidebar-widget recent-posts wow fadeInUp" data-wow-delay="0ms" data-wow-duration="1500ms">
                            <div class="sidebar-title"><h2>最近发布</h2></div>
                            
                             <#list list as rstory >
                            <article class="post">
                            	<figure class="post-thumb">
                            	<#if rstory.coverImgPath ?? >
                                 <img  height="200"  src="${imgHost}${rstory.coverImgPath!}">
                                <#else>
                                <img src="${resRoot}/images/resource/post-thumb-1.jpg" >
                                </#if>
                            	</figure>
                                <h4><a href="${base}/story/storyView.htm?id=${rstory.id!}">${rstory.storyTitle!}</a></h4>
                                <div class="post-info">${rstory.createTime?string("yyyy.MM.dd")}</div>
                            </article>
                            </#list>
                            
                        </div>
                        -->
                        
                       
                        
                    </aside>
                </div><!--End Sidebar-->   
                
                      
                
            </div>
        </div>
    </div>
    

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
