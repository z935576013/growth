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
    
    <!--Contact Section-->
    <section class="contact-section bg-lightgrey">
    
    	<div class="auto-container">
        	<div class="outer-container">
            	<div class="clearfix">
                    
                    <!--Form Column-->
            		<div class="form-column col-md-9 col-sm-12 col-xs-12">
                    	<h3>报名信息</h3>
                        
                        <div class="form-outer default-form">
                            
                            <form method="post" id="submitForm" action="${base}/act/join.htm">
                                <div class="row clearfix">
                                
                                    
                                    <div class="form-group col-md-3 col-sm-3 col-xs-12">
                                        <div class="field-label">姓名</div>
                                        <input type="text" name="name" value="${sessionUser.name!}" class="required" required>
                                    </div>
                                    
                                     <div class="form-group col-md-3 col-sm-3 col-xs-12">
                                        <div class="field-label">年龄</div>
                                        <input type="text" name="age" value="${sessionUser.age!}" class="required" required>
                                    </div>
                                    
                                    <div class="form-group col-md-3 col-sm-3 col-xs-12">
                                        <div class="field-label">性别</div>
                                        <input type="text" name="sex" 
                                        <#if sessionUser.sex ?? >
                                            <#if sessionUser.sex ==0 >value="男" </#if>
                                            <#if sessionUser.sex ==1 >value="女" </#if>
                                        </#if>
                                        class="required" required>
                                    </div>
                                     
                                     <div class="form-group col-md-3 col-sm-3 col-xs-12">
                                        <div class="field-label">民族</div>
                                        <input type="text" name="nation" value="" class="required" required>
                                        </select>
                                    </div>
                                    
                                     <div class="form-group col-md-4 col-sm-4 col-xs-12">
                                        <div class="field-label">绰号</div>
                                        <input type="text" name="nickname" value="" >
                                        </select>
                                    </div>
                                    
                                     <div class="form-group col-md-4 col-sm-4 col-xs-12">
                                        <div class="field-label">父亲联系方式</div>
                                        <input type="text" name="fatherPhone" value="" class="required" required>
                                        </select>
                                    </div>
                                    
                                     <div class="form-group col-md-4 col-sm-4 col-xs-12">
                                        <div class="field-label">母亲联系方式</div>
                                        <input type="text" name="motherPhone" value="" >
                                        </select>
                                    </div>
                                    
                                    
                                    <div class="form-group col-md-6 col-sm-6 col-xs-12">
                                        <div class="field-label">所在学校及年级</div>
                                        <input type="text" name="school" value="" class="required" required>
                                        </select>
                                    </div>
                                    
                                    <div class="form-group col-md-6 col-sm-6 col-xs-12">
                                        <div class="field-label">表演的节目</div>
                                        <input type="text" name="perform" value="" class="required" required>
                                        </select>
                                    </div>
                                    
                                    <div class="form-group col-md-12 col-sm-12 col-xs-12">
                                        <div class="field-label">兴趣、爱好、特长</div>
                                        <input type="text" name="strongPoint" value="" >
                                        </select>
                                    </div>
                                    
                                    <div class="form-group col-md-12 col-sm-12 col-xs-12">
                                        <div class="field-label">印象中最开心的事</div>
                                        <input type="text" name="content1" value="" >
                                        </select>
                                    </div>
                                    
                                    <div class="form-group col-md-12 col-sm-12 col-xs-12">
                                        <div class="field-label">印象中最难过的事</div>
                                        <input type="text" name="content2" value="" >
                                        </select>
                                    </div>
                                    
                                    <div class="form-group col-md-12 col-sm-12 col-xs-12">
                                        <div class="field-label">未来最想从事的职业（为什么）</div>
                                        <input type="text" name="content3" value="" >
                                        </select>
                                    </div>
                                    
                                    <div class="form-group col-md-12 col-sm-12 col-xs-12">
                                        <div class="field-label">最想完成的心愿（为什么）</div>
                                        <input type="text" name="content4" value="" >
                                        </select>
                                    </div>
                                    
                                    <div class="form-group col-md-12 col-sm-12 col-xs-12">
                                        <div class="field-label">最喜欢的人|最不喜欢的人（为什么）</div>
                                        <input type="text" name="content5" value="" >
                                        </select>
                                    </div>
                                    
                                    <div class="form-group col-md-12 col-sm-12 col-xs-12">
                                        <div class="field-label">最喜欢的电视主持人是谁（为什么）</div>
                                        <input type="text" name="content6" value="" >
                                        </select>
                                    </div>
                                    
                                    <div class="form-group col-md-12 col-sm-12 col-xs-12">
                                        <div class="field-label">最想去的地方是哪里（为什么）</div>
                                        <input type="text" name="content7" value="" >
                                        </select>
                                    </div>
                                
                                </div>
                                <div class="padd-top-10"><button type="button" onclick="subForm()" class="theme-btn btn-style-one">确认报名</button></div>
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
<script type="text/javascript">
 function subForm(){
    var req=0;
    $('.required').each(function(){
        var content=$(this).val();
        if(content==null || content==''){
            req=1;
            $(this).attr('style','border: #FF0000 1px solid');
            $(this).focus();
        }else{
             $(this).attr('style','');
        }
    });
    if(req==0){
        $('#submitForm').submit();
    }else{
        return;
    }
 }
 
</script> 
style="border: #FF0000 1px solid;"



</body>
</html>
