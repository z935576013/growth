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
                <li class="active">找回密码</li>
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
                    	<h3>找回密码</h3>
                        
                        <div class="form-outer default-form">
                            
                            <form method="post" action="${base}/login/resetPwd.htm" id="form1">
                                <div class="row clearfix">
                                  
                                    
                                  <div class="form-group col-md-9 col-sm-6 col-xs-12">
                                        <div class="field-label">手机号码</div>
                                        <input type="text" id="mobile" name="mobile" value="" placeholder="手机号码" required>
                                    </div>
                                    <div class="form-group col-md-6 col-sm-6 col-xs-12">
                                        <div class="field-label">验证码</div>
                                        <input type="text" name="valCode" value="" placeholder="验证码">
                                    </div>
                                    <div class="form-group col-md-6 col-sm-6 col-xs-12">
                                      <button id="sms" type="button" onclick="sendSms();" class="theme-btn btn-style-two" style="margin-top:20px">发送验证码</button>
                                    </div>
                                  <div class="form-group col-md-9 col-sm-6 col-xs-12">
                                        <div class="field-label">重新设置密码</div>
                                        <input type="password" id="password"  name="password" value="" placeholder="输入密码">
                                    </div>
                                     <div class="form-group col-md-9 col-sm-6 col-xs-12">
                                        <div class="field-label">确认密码</div>
                                        <input type="password" id="password2" value="" placeholder="再次输入密码">
                                    </div>
                                     <div class="form-group col-md-9 col-sm-6 col-xs-12">
                                        <div class="field-label"><font id="errorMsg" color='red'>${error!}</font></div>
                                       </div>
                                </div>
                                <div class="padd-top-10"><button type="button" onclick="subForm();" class="theme-btn btn-style-one">重置密码</button></div>
                            </form>
                        </div>
                    </div>
                 
            		
                    
                </div>
            </div>
        </div>
    </section>
    
    
     <!--Main Footer-->
    <footer class="main-footer">
        <!--Footer Bottom-->
    	<div class="footer-bottom">
            <div class="auto-container">
                <div class="outer-box clearfix">
                	<!--Footer Nav-->
                	<nav class="footer-nav pull-left">
                    	<ul class="clearfix">
                        	<li><a href="#">首页</a></li>
                            <li><a href="#">成长学院</a></li>
                            <li><a href="#">精彩回放</a></li>
                            <li><a href="#">给我投票</a></li>
                            <li><a href="#">联系我们</a></li>
                        </ul>
                    </nav>
                    
                    <!--Copyright-->
                	<div class="copyright pull-right">&copy; Copyrights 2017 <a href="" target="_blank">成长学院</a>. All rights reserved</div>
                    
                </div>
            </div>
        </div>
    </footer>
    
    
    
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
    if(checkMobile()){
    
         var password=$('#password').val();
         var password2=$('#password2').val();
         if(password=='' || password2=='' || password!=password2){
             $('#errorMsg').html('两次密码不一致');
                }else{
             $('#form1').submit();
         }
        
    }
}


function sendSms(){
    if(checkMobile()){
        var mobile=$('#mobile').val();
        $.get("${base}/login/sendValCode.do?regist=0&mobile="+mobile, function(result){
            $("#sms").html("已发送");
            alert("发送成功");
            
        });
    }
}

function checkMobile(){
    var mobile=$('#mobile').val();
    var reg = /^0?1[0-9][0-9]\d{8}$/;
     if (reg.test(mobile)) {
        $('#errorMsg').html('');
        return true;
     }else{
        $('#errorMsg').html('请输入正确的手机号');
        return false;
     };
}
</script>
</body>
</html>
