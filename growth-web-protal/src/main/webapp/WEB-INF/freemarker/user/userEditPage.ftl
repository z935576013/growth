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
    <!-- <section class="page-title">
    	<div class="auto-container"> -->
            <!--Bread Crumb-->
            <!-- <ul class="bread-crumb clearfix">
                <li><a href="${base}">首页</a></li>
                <li><a href="${base}/user/userView.htm">会员中心</a></li>
                <li class="active">修改资料</li>
            </ul>
            
        </div>
    </section> -->
    
    
    <!--Contact Section-->
    <section class="contact-section bg-lightgrey">
    
    	<div class="auto-container">
        	<div class="outer-container">
            	<div class="clearfix">
                	 <#include "/user/userLeft.ftl"/>
                    
                    <!--Form Column-->
            		<div class="form-column col-md-9 col-sm-12 col-xs-12">
                    	<h3>编辑个人资料</h3>
                        
                        <div class="form-outer default-form">
                            
                            <form method="post" action="${base}/user/updateUser.htm" enctype="multipart/form-data">
                                <div class="row clearfix">
                                
                                    
                                  <!-- <div class="form-group col-md-9 col-sm-9 col-xs-12">
                                  <div class="field-label">头像</div>
                                        <#if sessionUser.headImgPath ??>
                                        <div class="uppic"><img src="${imgHost}${sessionUser.headImgPath!}" /></div>
                                        </#if>
                                       <div class="upfilebox"> <input name="file" type="file" /><label>选择照片</label></div>
                                    </div> -->
                                  <div class="form-group col-md-9 col-sm-6 col-xs-12">
                                        <div class="field-label">姓名</div>
                                        <input type="text" name="name" value="${user.name!}" placeholder="姓名" required>
                                    </div>
                                    
                                    <div class="form-group col-md-9 col-sm-6 col-xs-12">
                                        <div class="field-label">年龄</div>
                                        <select name="age">
                                         <#list 3..20 as a> 
                                        	<option value="${a}" <#if user.age ?? ><#if user.age ==a >selected="selected"</#if></#if> >${a}</option>
                                         </#list>
                                        </select>
                                    </div>
                                     
                                     <div class="form-group col-md-9 col-sm-6 col-xs-12">
                                        <div class="field-label">性别</div>
                                        <select name="sex">
                                        	<option value="0" <#if user.sex ?? ><#if user.sex ==0 >selected="selected"</#if></#if>>男</option>
                                        	<option value="1" <#if user.sex ?? ><#if user.sex ==1 >selected="selected"</#if></#if>>女</option>
                                        </select>
                                    </div>
                                    
                                    <div class="form-group col-md-9 col-sm-6 col-xs-12">
                                        <div class="field-label">学校</div>
                                        <select name="school">
                                            <#list schoolList as school> 
                                            <option value="${school.schoolName!}" <#if user.school ?? ><#if user.school ==school.schoolName >selected="selected"</#if></#if>>${school.schoolName!}</option>
                                             </#list>
                                        </select>
                                    </div>
                                    
                                    <div class="form-group col-md-4 col-sm-4 col-xs-12">
                                        <div class="field-label">年级</div>
                                        <select name="gradeNum">
                                        	<#list 1..6 as a> 
                                            <option value="${a}" <#if user.gradeNum ?? ><#if user.gradeNum ==a >selected="selected"</#if></#if> >${a}</option>
                                            </#list>
                                        </select>
                                    </div>
                                    <div class="form-group col-md-4 col-sm-4 col-xs-12">
                                        <div class="field-label">班级</div>
                                        <select name="classNum">
                                        	<#list 1..20 as a> 
                                            <option value="${a}" <#if user.classNum ?? ><#if user.classNum ==a >selected="selected"</#if></#if> >${a}</option>
                                            </#list>
                                        </select>
                                    </div>
                                    
                                     <div class="form-group col-md-9 col-sm-6 col-xs-12">
                                        <div class="field-label">兴趣</div>
                                         <#list hobbyList as hobby> 
                                           <span class="ck1"><input name="hobby" <#if user.hobby ??><#if user.hobby?index_of(hobby.hobbyName)!=-1 >checked="checked"</#if></#if> type="checkbox" value="${hobby.hobbyName!}"/>${hobby.hobbyName!}</span>
                                         </#list>
                                    </div>
                                
                                    
                                    <div class="form-group col-lg-9 col-sm-9 col-xs-12">
                                        <div class="field-label">特长</div>
                                        <textarea name="strongPoint" placeholder="输入特长" required>${user.strongPoint!}</textarea>
                                    </div>
                                
                                </div>
                                <div class="padd-top-10"><button type="submit" class="theme-btn btn-style-one">保存资料</button></div>
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
<script src="${resRoot}/js/validate.js"></script>
<script src="${resRoot}/js/wow.js"></script>
<script src="${resRoot}/js/script.js"></script>
</body>
</html>
