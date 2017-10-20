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
                    
                    <!--Form Column-->
            		<div class="form-column col-md-9 col-sm-12 col-xs-12">
                    	<h3>我的日记</h3>
                        
                        <div class="form-outer default-form">
                            
                            <form method="post" id="form1" action="${base}/user/saveUserStory.htm"  enctype="multipart/form-data">
                                <div class="row clearfix">
                                
                                    
                                  <div class="form-group col-md-9 col-sm-6 col-xs-12">
                                        <div class="field-label">标题</div>
                                        <input type="text" name="storyTitle" value="${story.storyTitle!}" required>
                                    </div>
                                    
                                 <div class="form-group col-md-9 col-sm-9 col-xs-12">
                                  <div class="field-label">图片</div>
                                       <div id="preview" class="uppic">
                                       <#if story.coverImgPath ?? >
                                           <img height="100" width="100" src="${imgHost}${story.coverImgPath!}">
                                        </#if>
                                       </div>
                                        <div class="upfilebox"> <input type="file" name="file" onchange="preview(this)" /><label>上传图片</label></div>
                                    </div>
                                
                                    
                                    <div class="form-group col-lg-9 col-sm-9 col-xs-12">
                                        <div class="field-label">正文</div>
                                        <!-- <script id="editor" type="text/plain" style="width:500;height:500;"></script> -->
                                        <input type="hidden" id="storyContent" name="storyContent" value="${story.storyContent!}">
                                        <textarea id="storyContentEditor" name="storyContentEditor" style="width:100%; height:200px;border:2px solid #1d93e5;padding:5px;">${story.storyContent!}</textarea>
                                        
                                    </div>
                                
                                </div>
                                <input type="hidden" name="id" value="${story.id!}">
                                <input type="hidden" name="storyType" value="${story.storyType!}">
                                <div class="padd-top-10"> <button type="button" onclick="subForm();" class="theme-btn btn-style-one">确认发表</button></div>
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
<script src="${resRoot}/js/bootstrap.js"></script>
<script src="${resRoot}/js/jquery.fancybox.pack.js"></script>
<script src="${resRoot}/js/mixitup.js"></script>
<script src="${resRoot}/js/bxslider.js"></script>
<script src="${resRoot}/js/owl.js"></script>
<script src="${resRoot}/js/wow.js"></script>
<script src="${resRoot}/js/script.js"></script>
<script type="text/javascript" charset="utf-8" src="${resRoot}/plugin/ue/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${resRoot}/plugin/ue/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="${resRoot}/plugin/ue/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
// var ue = UE.getEditor('editor');

$(function(){
loadContent();
}); 

function subForm(){
	var newString = $("#storyContentEditor").val().replace(/\n/g, '_@').replace(/\r/g, '_#');
	newString = newString.replace(/_#_@/g, '<br/>');//IE7-8
    newString = newString.replace(/_@/g, '<br/>');//IE9、FF、chrome
    newString = newString.replace(/\s/g, '&nbsp;');//空格处理
	document.getElementById("storyContent").value = newString;
 	$('#form1').submit();
}

function loadContent() {
		newString = $("#storyContent").val().replace(/<br\/>/g, "\n");
		newString = newString.replace(/&nbsp;/g, " ");
		$("#storyContentEditor").val(newString);
}

 function preview(file)  
 {  
	 var prevDiv = document.getElementById('preview');  
	 if (file.files && file.files[0])  {  
		 var reader = new FileReader();  
		 reader.onload = function(evt){  
		 prevDiv.innerHTML = '<img src="' + evt.target.result + '" />';  
		 }    
	 	reader.readAsDataURL(file.files[0]);  
	}  
	 else    
	 {  
		 prevDiv.innerHTML = '<div class="img" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + file.value + '\'"></div>';  
	 }  
 } 

</script>    
</body>
</html>
