<!DOCTYPE html>
<html>
    <head>
        <#include "/head.ftl"/>
<script type="text/javascript">
    function changeIfmSrc(ele)
    {
        $('#iframe').attr('src',ele.attributes.name.value);
    }

        $(document).ready(function() {

            // Store variables
            
            var accordion_head = $('.accordion > li > a'),
                accordion_body = $('.accordion li > .sub-menu');

            // Open the first tab on load

            accordion_head.first().addClass('active').next().slideDown('normal');

            // Click function

            accordion_head.on('click', function(event) {

                // Disable header links
                
                event.preventDefault();

                // Show and hide the tabs on click

                if ($(this).attr('class') != 'active'){
                    accordion_body.slideUp('normal');
                    $(this).next().stop(true,true).slideToggle('normal');
                    accordion_head.removeClass('active');
                    $(this).addClass('active');
                }

            });

        });

    </script>
</head>

<body>
        <div class="main">
            <div class="left">
                <span class="title-name">后台管理系统</span>
                <span class="user-infor clearfix">
                    <span class="name fl">${userInfo.loginId!}</span>
                    <span class="exit fr cursor" onclick="location='${base}/logout.htm'">退出</span>
                </span>
                <ul>
                    <li>
                        <div class="firstmenu">
                            <span class="title active clearfix"><span class="fl">用户管理</span><em class="fr"></em></span>
                            <div class="secondmenu show">
                                <span name="user/userlist.htm"  onclick="changeIfmSrc(this);"><i></i>用户列表</span>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="firstmenu">
                            <span class="title clearfix"><span class="fl">内容管理</span><em class="fr"></em></span>
                            <div class="secondmenu">
                                <span  name="story/storylist.htm?storyType=0" onclick="changeIfmSrc(this);"><i></i>日记审核</span>
                                <span  name="lesson/lessonlist.htm?lessonType=0" onclick="changeIfmSrc(this);"><i></i>成长国学院内容管理</span>
                                <span  name="lesson/lessonlist.htm?lessonType=1" onclick="changeIfmSrc(this);"><i></i>少年科学院内容管理</span>
                                <span  name="story/storylist.htm?storyType=2" onclick="changeIfmSrc(this);"><i></i>成长故事展播内容管理</span>
                                <span  name="story/storylist.htm?storyType=1" onclick="changeIfmSrc(this);"><i></i>养花教程内容管理</span>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="firstmenu">
                            <span class="title clearfix"><span class="fl">活动管理</span><em class="fr"></em></span>
                            <div class="secondmenu">
                                <div class="hasmenu">
                                    <span name="game/gamelist.htm" onclick="changeIfmSrc(this);"><i></i>活动管理</span>
                                    <span name="act/actJoinlist.htm" onclick="changeIfmSrc(this);"><i></i>电视六一晚会</span>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
            <iframe id="iframe" name="main" src="welcome.htm" allowtransparency="true" width="100%" height="100%" frameborder="0" scrolling="yes" style="overflow-y:scroll"> </iframe>
        </div>
    </body>
</html>
