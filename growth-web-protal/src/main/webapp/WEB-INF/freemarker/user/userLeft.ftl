<!--Info Column-->
                    <div class="info-column col-md-3 col-sm-12 col-xs-12">
                        <div class="inner-box">
                            <div class="u-info">
                            <#if sessionUser.headImgPath ??>
                            <div class="uppic"><img src="${imgHost}${sessionUser.headImgPath!}" /></div>
                            </#if>
                            <h3>${sessionUser.name!}</h3>
                            <!-- <h4><span><#if sessionUser.sex ??><#if sessionUser.sex==0>男<#else>女</#if></#if></span><span><#if sessionUser.age ??>${sessionUser.age!}岁</#if></span></h4> -->
                            <h5>${sessionUser.mobile!}</h5></div>
                            <!--Contact Info-->
                           
                               <ul class="u-links">
                                <li><a href="${base}/user/userView.htm">个人资料</a></li>
                                <li><a href="${base}/user/changePwd.htm">修改密码</a></li>
                                <li><a href="${base}/user/userStoryList.htm">我的日记</a></li>
                            </ul>
                        </div>
                    </div>