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
                <!-- <li><a href="${base}">成长学院</a></li> -->
                <li class="active">电视六一晚会</li>
            </ul>
            
        </div>
    </section>
    
            
             <!--Tabs Section-->
    <section class="tabs-section default-section" style="padding-bottom:50px;">
    	<div class="auto-container">
            <div class="outer-container">
            	<!--Tabs Box-->
                <div class="tabs-box">
                    <!--Tabs Content-->
                    <div class="tab-content">
                        
                        <!--Tab / Active Tab-->
                        <div class="tab active-tab" id="tab-one">
                            <div class="row clearfix">
                            	<!--Content Column-->
                                <div class="content-column col-lg-7 col-sm-7 col-xs-12">
                                	<h3>比赛介绍</h3>
                                    <div class="upper-content">
                                    	<div class="text">
                                              2017直通六一电视少儿晚会，由是文明办、扬州市教育局、共青团扬州市委、扬州广播电视总台共同主办，扬州电视台全新日播少儿《成长学院》承办的大型少儿才艺晚会。该晚会由著名童星还珠格格3东儿的扮演者东儿主持，晚会主要面向全扬州5到16岁的小朋友，只要你有过人的才艺，只要你能通过我们选拔，就能最终登上2017六一电视少儿晚会的舞台。
                                            你会主持   你会跳舞   你会唱歌   你会朗诵 你会独奏
还有你们会群舞
总之不管你会什么
只要你敢秀!
都有机会登上2017扬州电视台“六一”超级盛典的舞台
与《还珠格格》的东儿哥哥同场表演！
扬州电视台《成长学院》栏目现面向全扬州5—16岁的小朋友
选拔优秀少儿主持人、个人才艺、集体才艺参与六一晚会演出
                                        </div>
                                    </div>
                                </div>
                                
                                <!--Image Column-->
                                <div class="image-column col-lg-5 col-sm-5 col-xs-12">
                                	<figure class="image-box">
                                    <img src="${resRoot}/images/resource/featured-image-1.jpg" >
                                	<div class="over-layer"><span class="left-layer"></span><span class="right-layer"></span></div></figure>
                                </div>
                                
                            </div>
                        </div>
                        
                    </div>
                </div>
            </div>
            
        </div>
    </section>
        
        </div>
     </div>
     
 <!--Default Section-->
    <section class="default-section">
    	<div class="auto-container">
        	<div class="default-content text-center">
        	<#if sessionUser ??>
            	<#if actJoin ??>
            	    <a  class="theme-btn btn-style-one">已成功报名,请等候节目组通知</a>
            	<#else>
            	   <a href="${base}/act/joinPage.htm" class="theme-btn btn-style-one">立即报名</a>
            	</#if>
            <#else>
                 <a onclick="loginBeforeJoin();" class="theme-btn btn-style-one">报名前请先登陆</a>
            </#if>	
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
$(function(){
   localStorage.removeItem("gameId");
 });

function loginBeforeJoin(){
      localStorage.setItem("gameId", '0');
      location='${base}/login/loginPage.htm';
}

</script>   
</body>
</html>
