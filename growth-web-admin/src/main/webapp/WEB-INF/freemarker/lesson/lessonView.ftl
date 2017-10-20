<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><#if lesson.id ??>编辑内容<#else>新增内容</#if></title>
<#include "/head.ftl"/>
<script type="text/javascript" charset="utf-8" src="${resRoot}/plugin/ue/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${resRoot}/plugin/ue/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="${resRoot}/plugin/ue/lang/zh-cn/zh-cn.js"></script>

</head>

<body>
<div class="right">
    <div class="title"><b>内容管理</b><span><#if lesson.id ??>编辑内容<#else>新增内容</#if></span></div>
    <div class="mainbar">
    <form id="submitForm" name="submitForm" method="post" action="lessonSave.htm">
        <dl class="formbar2">
        <dd>
            <label class="form-tit">标题：</label>
            <div class="form-lable"><input name="lessonTitle" value="${lesson.lessonTitle!}"/> </div>
        </dd>
        <dd>
            <label class="form-tit">视频编号：</label>
            <div class="form-lable"><input name="vedioPath" value="${lesson.vedioPath!}"/> </div>
        </dd>
         <dd>
            <label class="form-tit">启用状态：</label>
            <div class="form-text">
                <select  name="actStatus" >
                      <option value="0" <#if lesson.actStatus ?? ><#if lesson.actStatus==0> selected="selected" </#if></#if>>停用</option>
                      <option value="1" <#if lesson.actStatus ?? ><#if lesson.actStatus==1> selected="selected" </#if></#if>>启用</option>
              </select>
             </div> 
        </dd>
        <dd>
            <label class="form-tit">详情：</label>
            <div class="form-text">
            <script id="editor" type="text/plain" style="width:1000;height:500;"></script>
            <input type="hidden" id="lessonContent" name="lessonContent" value="${lesson.lessonContent!}">
            </div>
        </dd>
         <dd>
           <div class="form-lable">
             <input id="saveButton" type="button" onclick="subForm();" value="保存" /> 
             <input type="button" onclick="location='lessonlist.htm?lessonType=${lessonType!}'" value="返回" /> 
           </div>
        </dd>
         </dl>
         <input type="hidden" name="id" value="${lesson.id!}"/>
         <input type="hidden" name="lessonType" value="${lessonType!}"/>
         </form>
        </div>
    </div>
    <div class="foot" style="height:30px;"></div>
</div>

<script>
var ue =null;

$(function(){
<#if success ??>
  alert('保存成功');
</#if>
ue = UE.getEditor('editor');
ue.ready(function(){
ue.setContent(' ${lesson.lessonContent!}', true); 
 });

}); 

function subForm(){
 $('#lessonContent').val(ue.getContent());
 $('#submitForm').submit();
}


</script>

</body>
</html>
