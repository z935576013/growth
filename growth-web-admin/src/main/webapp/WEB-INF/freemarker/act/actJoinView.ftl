<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>电视六一晚会</title>
<#include "/head.ftl"/>

</head>

<body>
<div class="right">
    <div class="title"><b>活动管理</b><span>电视六一晚会</span></div>
    <div class="mainbar">
        <dl class="formbar2">
        <dd>
            <label class="form-tit">姓名：</label>
            <div class="form-lable">${actJoin.name!}</div>
        </dd>
        <dd>
            <label class="form-tit">年龄：</label>
            <div class="form-lable">${actJoin.age!}</div>
        </dd>
         <dd>
            <label class="form-tit">性别：</label>
            <div class="form-lable">${actJoin.sex!}</div>
        </dd>
         <dd>
            <label class="form-tit">民族：</label>
            <div class="form-lable">${actJoin.nation!}</div>
        </dd>
        <dd>
            <label class="form-tit">绰号：</label>
            <div class="form-lable">${actJoin.nickname!}</div>
        </dd>
        <dd>
            <label class="form-tit">父亲联系方式：</label>
            <div class="form-lable">${actJoin.fatherPhone!}</div>
        </dd>
        <dd>
            <label class="form-tit">母亲联系方式：</label>
            <div class="form-lable">${actJoin.motherPhone!}</div>
        </dd>
        <dd>
            <label class="form-tit">所在学校及年级：</label>
            <div class="form-lable">${actJoin.school!}</div>
        </dd>
        <dd>
            <label class="form-tit">表演的节目：</label>
            <div class="form-lable">${actJoin.perform!}</div>
        </dd>
        <dd>
            <label class="form-tit">兴趣、爱好、特长：</label>
            <div class="form-lable">${actJoin.strongPoint!}</div>
        </dd>
        <dd>
            <label class="form-tit">印象中最开心的事：</label>
            <div class="form-lable">${actJoin.content1!}</div>
        </dd>
        <dd>
            <label class="form-tit">印象中最难过的事：</label>
            <div class="form-lable">${actJoin.content2!}</div>
        </dd>
        <dd>
            <label class="form-tit">未来最想从事的职业（为什么）：</label>
            <div class="form-lable">${actJoin.content3!}</div>
        </dd>
        <dd>
            <label class="form-tit">最想完成的心愿（为什么）：</label>
            <div class="form-lable">${actJoin.content4!}</div>
        </dd>
         <dd>
            <label class="form-tit">最喜欢的人|最不喜欢的人（为什么）：</label>
            <div class="form-lable">${actJoin.content5!}</div>
        </dd>
        <dd>
            <label class="form-tit">最喜欢的电视主持人是谁（为什么）：</label>
            <div class="form-lable">${actJoin.content6!}</div>
        </dd>
         <dd>
            <label class="form-tit">最想去的地方是哪里（为什么）：</label>
            <div class="form-lable">${actJoin.content7!}</div>
        </dd>
         <dd>
           <div class="form-lable">
             <input type="button" onclick="location='actJoinlist.htm'" value="返回" /> 
           </div>
        </dd>
         </dl>
        </div>
    </div>
    <div class="foot" style="height:30px;"></div>
</div>

<script>

$(function(){
<#if success ??>
  alert('保存成功');
</#if>
}); 





</script>

</body>
</html>
