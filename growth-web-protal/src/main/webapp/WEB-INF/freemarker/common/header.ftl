  <!-- Main Header-->
    <header class="main-header">
        
        <!-- Header Top -->
        <div class="header-top">
            <div class="auto-container clearfix">
            
                <!-- Top Right -->
                <div class="top-right">
                    <ul class="clearfix">
                        <#if sessionUser ??>
                        	<#if sessionUser.name ??>
                        		<li><a href="${base}/user/userView.htm">${sessionUser.name!}</a></li>
                        	<#else>
                        		<li><a href="${base}/user/userView.htm">${sessionUser.mobile!}</a></li>
                        	</#if>
                        <li><a href="${base}/login/logout.htm">退出</a></li>
                        <#else>
                        <li><a href="${base}/login/registPage.htm">注册</a></li>
                        <li><a href="${base}/login/loginPage.htm">登录</a></li>
                        </#if>
                    </ul>
                </div>
                
            </div>
        </div><!-- Header Top End -->
        
        <!--Header-Lower-->
        <div class="header-lower">
            <div class="auto-container">
                <div class="outer clearfix">
                    <!--Logo -->
                    <div class="logo-outer">
                        <div class="logo"><a href="${base}"><img src="${resRoot}/images/logo.png" alt=""></a></div>
                    </div>
                    
                    <!-- Main Menu -->
                    <nav class="main-menu">
                        <div class="navbar-header">
                            <!-- Toggle Button -->      
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            </button>
                        </div>
                        
                        <div class="navbar-collapse collapse clearfix">
                            <ul class="navigation clearfix">
                                <li><a href="${base}">首页</a>
                                </li>
                                <li class="dropdown"><a >花满城</a>
                                    <ul>
                                        <li><a href="${base}/story/storyList.htm?storyType=0">成长日记</a></li>
                                        <li><a href="${base}/story/storyList.htm?storyType=1">养花教程</a></li>
                                        <li><a href="${base}/story/storyList.htm?storyType=2">成长故事展播</a></li>
                                    </ul>
                                </li>
                               <li class="dropdown"><a >我想上电视</a>
                                    <ul>
                                     <#list gameService.getList(null,true,0,5) as game>
                                     	<#if game.gameTitle != "小主持人大赛" && game.gameTitle != "少儿才艺大赛">
                                        	<li><a href="${base}/game/gameView.htm?id=${game.id!}">${game.gameTitle!}</a></li>
                                        </#if>
                                     </#list>   
                                        <li><a href="${base}/act/actView.htm">电视六一晚会</a></li>
                                    </ul>
                                </li>
                                <li class="dropdown"><a >成长学院</a>
                                    <ul>
                                        <li><a href="${base}/lesson/lessonList.htm?lessonType=0">成长国学院</a></li>
                                        <li><a href="${base}/lesson/lessonList.htm?lessonType=1">少年科学院</a></li>
                                        <li><a href="${base}/lesson/aboutus.htm">关于我们</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                    </nav><!-- Main Menu End-->
                    
                </div>
            </div>
        </div>
    
    </header>
    <!--End Main Header -->