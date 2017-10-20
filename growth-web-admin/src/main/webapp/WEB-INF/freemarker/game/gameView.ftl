<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><#if game.id ??>编辑活动<#else>新增活动</#if></title>
<#include "/head.ftl"/>
<script type="text/javascript" charset="utf-8" src="${resRoot}/plugin/ue/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${resRoot}/plugin/ue/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="${resRoot}/plugin/ue/lang/zh-cn/zh-cn.js"></script>

</head>

<body>
<div class="right">
    <div class="title"><b>活动管理</b><span><#if game.id ??>编辑活动<#else>新增活动</#if></span></div>
    <div class="mainbar">
    <form id="submitForm" name="submitForm" method="post" action="gameSave.htm" enctype="multipart/form-data">
        <dl class="formbar2">
        <dd>
            <label class="form-tit">标题：</label>
            <div class="form-lable"><input name="gameTitle" value="${game.gameTitle!}"/> </div>
        </dd>
         <#if game.id ??>
        <dd>
            <label class="form-tit">报名人数：</label>
            <div class="form-lable">${game.joinCount!} </div>
        </dd>
        </#if>
        <dd>
            <label class="form-tit">图片：</label>
                <div class="form-lable">
                    <#if game.coverImgPath ?? > 
                    <img width="300" hight="300" src="${imgHost}/${game.coverImgPath}" />
                    </#if>  
                    <input type="file" name="file"  /> 
                </div>
        </dd>
         <dd>
            <label class="form-tit">启用状态：</label>
            <div class="form-text">
                <select  name="actStatus" >
                      <option value="0" <#if game.actStatus ?? ><#if game.actStatus==0> selected="selected" </#if></#if>>停用</option>
                      <option value="1" <#if game.actStatus ?? ><#if game.actStatus==1> selected="selected" </#if></#if>>启用</option>
              </select>
             </div> 
        </dd>
        <#if game.id ??>
        <dd>
            <label class="form-tit">微信菜单地址：</label>
            <div class="form-lable">${wxmenu}${game.id!}</div>
        </dd>
        </#if>
        <dd>
            <label class="form-tit">详情：</label>
            <div class="form-text">
             <script id="editor" type="text/plain" style="width:2000;height:500;"></script>
            <input type="hidden" id="gameContent" name="gameContent" value="${game.gameContent!}">
            </div>
        </dd>
         <dd>
           <div class="form-lable">
             <input id="saveButton" type="button" onclick="subForm();" value="保存" /> 
             <input type="button" onclick="location='gamelist.htm'" value="返回" /> 
           </div>
        </dd>
         </dl>
         <input type="hidden" name="id" value="${game.id!}"/>
         </form>
        </div>
    </div>
    <div class="foot" style="height:30px;"></div>
</div>


<script type="text/javascript">
 var ue =null;

$(function(){

<#if success ??>
  alert('保存成功');
</#if>
ue = UE.getEditor('editor');
ue.ready(function(){
ue.setContent(' ${game.gameContent!}', true); 
 });

}); 

function subForm(){
 $('#gameContent').val(ue.getContent());
 $('#submitForm').submit();
}


</script>   


</body>
</html>
