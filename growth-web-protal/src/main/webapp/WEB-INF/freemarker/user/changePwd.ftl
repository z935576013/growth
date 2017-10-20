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
                <li class="active">修改密码</li>
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
                    	<h3>修改密码</h3>
                        
                        <div class="form-outer default-form">
                            
                            <form method="post" action="${base}/user/updatePwd.htm" id="form1">
                                <div class="row clearfix">
                                  <div class="form-group col-md-9 col-sm-6 col-xs-12">
                                        <div class="field-label">旧密码</div>
                                        <input type="password" name="oldPwd" value="" placeholder="输入旧密码" required>
                                    </div>
                                   
                                   <div class="form-group col-md-9 col-sm-6 col-xs-12">
                                        <div class="field-label">新密码</div>
                                        <input type="password" id="password" name="newPwd" value="" placeholder="输入新密码" required>
                                    </div>
                                    <div class="form-group col-md-9 col-sm-6 col-xs-12">
                                        <div class="field-label">确认新密码</div>
                                        <input type="password"id="password2" value="" placeholder="再次输入新密码" required>
                                    </div>
                                    <div class="form-group col-md-9 col-sm-6 col-xs-12">
                                          <div class="field-label"><font id="errorMsg" color='red'>${error!}</font></div>
                                    </div>
                                
                                </div>
                                <div class="padd-top-10"><button type="button" onclick="subForm();" class="theme-btn btn-style-one">保存修改</button></div>
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
<!-- <div class="scroll-to-top scroll-to-target" data-target=".main-header"><span class="icon flaticon-transport-2"></span></div> -->

<script src="${resRoot}/js/jquery-1.10.2.min.js"></script>
<script src="${resRoot}/${resRoot}/js/bootstrap.js"></script>
<script src="${resRoot}/js/jquery.fancybox.pack.js"></script>
<script src="${resRoot}/js/mixitup.js"></script>
<script src="${resRoot}/js/bxslider.js"></script>
<script src="${resRoot}/js/owl.js"></script>
<script src="${resRoot}/js/validate.js"></script>
<script src="${resRoot}/js/wow.js"></script>
<script src="${resRoot}/js/script.js"></script>
<script type="text/javascript">
function subForm(){
    
         var password=$('#password').val();
         var password2=$('#password2').val();
         if(password=='' || password2=='' || password!=password2){
             $('#errorMsg').html('两次密码不一致');
                }else{
             $('#form1').submit();
         }
}

</script>
</body>
</html>
