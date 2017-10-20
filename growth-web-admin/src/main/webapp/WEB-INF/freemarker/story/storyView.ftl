<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><#if story.id ??>编辑内容<#else>新增内容</#if></title>
<#include "/head.ftl"/>
<script type="text/javascript" charset="utf-8" src="${resRoot}/plugin/ue/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${resRoot}/plugin/ue/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="${resRoot}/plugin/ue/lang/zh-cn/zh-cn.js"></script>


</head>

<body>
<div class="right">
    <div class="title"><b>内容管理</b><span><#if story.id ??>编辑内容<#else>新增内容</#if></span></div>
    <div class="mainbar">
    <form id="submitForm" name="submitForm" method="post" action="storySave.htm" enctype="multipart/form-data">
        <dl class="formbar2">
        <dd>
            <label class="form-tit">标题：</label>
            <div class="form-lable"><input name="storyTitle" value="${story.storyTitle!}"/> </div>
        </dd>
         <#if storyType==0 >
        <dd>
            <label class="form-tit">创建用户：</label>
            <div class="form-lable">${story.userName!}</div>
        </dd>
        </#if>
        <#if storyType!=2 >
        <dd>
            <label class="form-tit">图片：</label>
                <div class="form-lable">
                    <#if story.coverImgPath ?? > 
                    <img width="300" hight="300" src="${imgHost}/${story.coverImgPath}" />
                    </#if>  
                    <input type="file" name="file"  /> 
                </div>
        </dd>
        </#if>
        <#if storyType!=0 >
        <dd>
            <label class="form-tit">视频编号：</label>
            <div class="form-lable"><input name="vedioPath" value="${story.vedioPath!}"/> </div>
        </dd>
        </#if>
         <dd>
            <label class="form-tit">启用状态：</label>
            <div class="form-text">
                <select  name="actStatus" >
                      <option value="0" <#if story.actStatus ?? ><#if story.actStatus==0> selected="selected" </#if></#if>>停用</option>
                      <option value="1" <#if story.actStatus ?? ><#if story.actStatus==1> selected="selected" </#if></#if>>启用</option>
              </select>
             </div> 
        </dd>
        <dd>
            <label class="form-tit">详情：</label>
            <div class="form-text" style="width:100%;">
            <!-- <script id="editor" type="text/plain" style="width:1000;height:500;"></script> -->
            <input type="hidden" id="storyContent" name="storyContent" value="${story.storyContent!}">
            <textarea id="storyContentEditor" name="storyContentEditor" style="width:100%; height:200px;border:2px solid #1d93e5;padding:5px;">${story.storyContent!}</textarea>
            </div>
        </dd>
         <dd>
           <div class="form-lable">
             <input id="saveButton" type="button" onclick="subForm();" value="保存" /> 
             <input type="button" onclick="location='storylist.htm?storyType=${storyType!}'" value="返回" /> 
           </div>
        </dd>
         </dl>
         <input type="hidden" name="id" value="${story.id!}"/>
         <input type="hidden" name="storyType" value="${storyType!}"/>
         </form>
        </div>
    </div>
    <div class="foot" style="height:30px;"></div>
</div>

var ue =null;

<script type="text/javascript">
$(function(){

<#if success ??>
  alert('保存成功');
</#if>

loadContent();

}); 

function subForm(){
	var newString = $("#storyContentEditor").val().replace(/\n/g, '_@').replace(/\r/g, '_#');
	newString = newString.replace(/_#_@/g, '<br/>');//IE7-8
    newString = newString.replace(/_@/g, '<br/>');//IE9、FF、chrome
    newString = newString.replace(/\s/g, '&nbsp;');//空格处理
	document.getElementById("storyContent").value = newString;
 	$('#submitForm').submit();
}

function loadContent() {
		newString = $("#storyContent").val().replace(/<br\/>/g, "\n");
		newString = newString.replace(/&nbsp;/g, " ");
		$("#storyContentEditor").val(newString);
}


</script>    


</body>
</html>
