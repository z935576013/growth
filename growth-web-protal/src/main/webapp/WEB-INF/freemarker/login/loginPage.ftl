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
               <!--  <li><a href="${base}">首页</a></li> -->
                <li class="active">登录</li>
            </ul>
            
        </div>
    </section>
    
    
    <!--Contact Section-->
    <section class="contact-section bg-lightgrey">
    
    	<div class="auto-container">
        	<div class="outer-container">
            	<div class="clearfix">
                	
                    <!--Form Column-->
            		<div class="form-column col-md-8 col-sm-12 col-xs-12">
                    	<h3>登录</h3>
                        
                        <div class="form-outer default-form">
                            
                            <form method="post" action="${base}/login/login.htm" id="submitForm">
                                <div class="row clearfix">
                                  
                                    
                                  <div class="form-group col-md-9 col-sm-6 col-xs-12">
                                        <div class="field-label">账号</div>
                                        <input type="text" name="mobile" value="${mobile!}" placeholder="手机号码" required>
                                    </div>
                                    
                                  <div class="form-group col-md-9 col-sm-6 col-xs-12">
                                        <div class="field-label">密码</div>
                                        <input type="password" name="password" value="" placeholder="输入密码">
                                    </div>
                                    <#if error ?? >
                                     <div class="form-group col-md-9 col-sm-6 col-xs-12">
                                        <div class="field-label"><font color='red'>密码不正确</font></div>
                                    </div>
                                    </#if>
                                    
                                   <div class="form-group col-md-9 col-sm-6 col-xs-12">
                                        <div class="field-label"><a href="${base}/login/findPwd.htm">忘记密码？</a></div>
                                    </div>
                                    
                                
                                </div>
                                <div class="padd-top-10"><button onclick="subForm();" class="theme-btn btn-style-one">立即登录</button></div>
                                <div class="padd-top-30">还没有账号？<a href="${base}/login/registPage.htm">立即注册</a></div>
                            </form>
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
<div class="scroll-to-top scroll-to-target" data-target=".main-header"><span class="icon flaticon-transport-2"></span></div>

<script src="${resRoot}/js/jquery-1.10.2.min.js"></script>
<script src="${resRoot}/js/bootstrap.js"></script>
<script src="${resRoot}/js/jquery.fancybox.pack.js"></script>
<script src="${resRoot}//mixitup.js"></script>
<script src="${resRoot}/js/bxslider.js"></script>
<script src="${resRoot}/js/owl.js"></script>
<script src="${resRoot}/js/validate.js"></script>
<script src="${resRoot}/js/wow.js"></script>
<script src="${resRoot}/js/script.js"></script>
<script type="text/javascript">
 function subForm(){
    $('submitForm').submit();
 }
 
</script> 
</body>
</html>
