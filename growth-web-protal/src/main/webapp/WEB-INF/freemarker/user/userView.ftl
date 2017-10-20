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
                <li class="active">会员中心</li>
            </ul>
            
        </div>
    </section>
    
    
    <!--Contact Section-->
    <section class="contact-section bg-lightgrey">
    
    	<div class="auto-container">
        	<div class="outer-container">
            	<div class="clearfix">
            	   
            	    <#include "/user/userLeft.ftl"/>
            	
                    <!--Form Column-->
            		<div class="form-column col-md-9 col-sm-12 col-xs-12">
                    	<h3>个人资料</h3>
                        
                        <div class="form-outer default-form">
                            
                                <div class="row clearfix">
                                  
                                  <div class="form-group col-md-9 col-sm-6 col-xs-12">
                                        <div class="field-label">姓名</div>
                                       ${user.name!}
                                    </div>
                                    
                                    <div class="form-group col-md-9 col-sm-6 col-xs-12">
                                        <div class="field-label">年龄</div>
                                        ${user.age!}
                                    </div>
                                     
                                     <div class="form-group col-md-9 col-sm-6 col-xs-12">
                                        <div class="field-label">性别</div>
                                        <#if sessionUser.sex ??><#if sessionUser.sex==0>男<#else>女</#if></#if>
                                    </div>
                                    
                                    <div class="form-group col-md-9 col-sm-6 col-xs-12">
                                        <div class="field-label">学校</div>
                                       ${user.school!}
                                    </div>
                                    
                                    <div class="form-group col-md-4 col-sm-4 col-xs-12">
                                        <div class="field-label">年级</div>
                                        <#if user.gradeNum ??>
                                        ${user.gradeNum!}年级
                                        </#if>
                                    </div>
                                    <div class="form-group col-md-4 col-sm-4 col-xs-12">
                                        <div class="field-label">班级</div>
                                        <#if user.classNum ??>
                                        ${user.classNum!}班
                                        </#if>
                                    </div>
                                    
                                     <div class="form-group col-md-9 col-sm-6 col-xs-12">
                                        <div class="field-label">兴趣</div>
                                          <#if user.hobby ??>
                                          <#list user.hobby?split(",") as hobby>
                                        <span class="ck1">${hobby!}</span>
                                        </#list>
                                         </#if>
                                    </div>
                                
                                    
                                    <div class="form-group col-lg-9 col-sm-9 col-xs-12">
                                        <div class="field-label">特长</div>
                                        ${user.strongPoint!}
                                    </div>
                                
                                </div>
                                <div class="padd-top-10"><button onclick="location='${base}/user/userEditPage.htm'" class="theme-btn btn-style-two">编辑个人资料</button></div>
                        </div>
                    </div>
                 
            		
                    
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
<script src="${resRoot}/js/validate.js"></script>
<script src="${resRoot}/js/wow.js"></script>
<script src="${resRoot}/js/script.js"></script>
<script type="text/javascript">
$(function(){
	var redirectUrl=localStorage.getItem("redirectUrl");
   if(redirectUrl!=null && redirectUrl==""){
   	localStorage.removeItem("redirectUrl");
    location.href=redirectUrl;
    return;
   }
   
   var gameId=localStorage.getItem("gameId");
   if(gameId!=null && gameId!=0){
   	localStorage.removeItem("gameId");
    location='${base}/game/gameView.htm?id='+gameId;
   }
   
    
 });
</script> 
</body>
</html>
