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
                <li class="active">注册</li>
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
                    	<h3>注册</h3>
                        
                        <div class="form-outer default-form">
                            
                            <form method="post" action="${base}/login/register.htm" id="form1">
                                <div class="row clearfix">
                                  
                                    
                                  <div class="form-group col-md-9 col-sm-6 col-xs-12">
                                        <div class="field-label">手机号码</div>
                                        <input type="text" id="mobile" name="mobile" value="${mobile!}" placeholder="手机号码" required>
                                    </div>
                                   <div class="form-group col-md-6 col-sm-6 col-xs-12">
                                        <div class="field-label">验证码</div>
                                        <input type="text" name="valCode" value="" placeholder="验证码">
                                    </div> 
                                    <div class="form-group col-md-6 col-sm-6 col-xs-12">
                                      <button id="sms" type="button" onclick="sendSms();" class="theme-btn btn-style-two" style="margin-top:20px">发送验证码</button>
                                    </div> 
                                  <div class="form-group col-md-9 col-sm-6 col-xs-12">
                                        <div class="field-label">设置密码</div>
                                        <input type="password" id="password" name="password" value="" placeholder="输入密码">
                                    </div>
                                     <div class="form-group col-md-9 col-sm-6 col-xs-12">
                                        <div class="field-label">确认密码</div>
                                        <input type="password" id="password2" value="" placeholder="再次输入密码">
                                    </div>
                                     <div class="form-group col-md-9 col-sm-6 col-xs-12">
                                        <div class="field-label"> <input type="checkbox" checked>&nbsp;我已阅读并同意<a href="#">用户协议</a></div>
                                    </div>
                                      <div class="form-group col-md-9 col-sm-6 col-xs-12">
                                        <div class="field-label"><font id="errorMsg" color='red'>${error!}</font></div>
                                       </div>
                                </div>
                                <div class="padd-top-10"><button type="button" onclick="subForm();" class="theme-btn btn-style-one">立即注册</button></div>
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
        $.get("${base}/login/sendValCode.do?regist=1&mobile="+mobile, function(result){
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
