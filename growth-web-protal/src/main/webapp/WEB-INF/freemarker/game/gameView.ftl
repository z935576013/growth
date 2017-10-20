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
                <li class="active">我想上电视</li>
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
                                              <#if game.gameContent ?? >
                                            ${game.gameContent}
                                            </#if>
                                        </div>
                                    </div>
                                </div>
                                
                                <!--Image Column-->
                                <div class="image-column col-lg-5 col-sm-5 col-xs-12">
                                	<figure class="image-box">
                                	<#if game.coverImgPath ?? >
                                     <img  height="200"  src="${imgHost}${game.coverImgPath!}">
                                    <#else>
                                    <img src="${resRoot}/images/resource/featured-image-1.jpg" >
                                    </#if>
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
            	<#if game.joinStatus ??>
            	  <#if game.joinStatus==1>
            	    <a  class="theme-btn btn-style-one">已成功报名,请等候节目组通知</a>
            	  <#else>  
            	   <#if sessionUser.name ??>
            	    <a href="${base}/game/joinGame.htm?id=${game.id!}" class="theme-btn btn-style-one">立即报名</a>
            	   <#else>
            	    <a  onclick="editUserBeforeJoin();" class="theme-btn btn-style-one">报名前请完善个人资料</a>
            	   </#if>
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
      localStorage.setItem("gameId", '${game.id!}');
      location='${base}/login/loginPage.htm';
}
function editUserBeforeJoin(){
      localStorage.setItem("gameId", '${game.id!}');
      location='${base}/user/userEditPage.htm';
}

</script>    
</body>
</html>
