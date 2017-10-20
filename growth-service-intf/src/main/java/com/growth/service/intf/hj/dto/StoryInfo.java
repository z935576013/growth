/*
 * Copyright (C), 2013-2014, 
 * FileName: StoryInfo.java
 * Author:   zhuliang
 * Date:     2014年10月16日 下午1:30:32
 */
package com.growth.service.intf.hj.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 实体类故事   
 * 
 * @author zhuliang
 */
@Entity(name = "STORY_INFO")
public class StoryInfo implements Serializable {
    /**
     * Serial UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 编号ID 编号ID
     */
    private Long id;
    /**
     * 故事类型 故事类型 0:种子 1:养花 2:成长
     */
    private Integer storyType;
    /**
     * 用户编号 用户编号
     */
    private Long userId;
    /**
     * 用户姓名 用户姓名
     */
    private String userName;
    /**
     * 标题 标题
     */
    private String storyTitle;
    /**
     * 封面图片 封面图片
     */
    private String coverImgPath;
    /**
     * 内容 内容
     */
    private String storyContent;
    /**
     * 视频地址 视频地址
     */
    private String vedioPath;
    /**
     * 启用状态 启用状态  0:停用  1:启用
     */
    private Integer actStatus;
    /**
     * 创建时间 创建时间
     */
    private java.util.Date createTime;

    /**
     * Get id
     * 
     * @return id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    public Long getId() {
        return this.id;
    }

    /**
     * Set id
     * 
     * @param id 编号ID
     */

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get storyType
     * 
     * @return storyType
     */
    @Column(name = "STORY_TYPE")
    public Integer getStoryType() {
        return this.storyType;
    }

    /**
     * Set storyType
     * 
     * @param storyType 故事类型
     */

    public void setStoryType(Integer storyType) {
        this.storyType = storyType;
    }

    /**
     * Get userId
     * 
     * @return userId
     */
    @Column(name = "USER_ID")
    public Long getUserId() {
        return this.userId;
    }

    /**
     * Set userId
     * 
     * @param userId 用户编号
     */

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Get userName
     * 
     * @return userName
     */
    @Column(name = "USER_NAME")
    public String getUserName() {
        return this.userName;
    }

    /**
     * Set userName
     * 
     * @param userName 用户姓名
     */

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Get storyTitle
     * 
     * @return storyTitle
     */
    @Column(name = "STORY_TITLE")
    public String getStoryTitle() {
        return this.storyTitle;
    }

    /**
     * Set storyTitle
     * 
     * @param storyTitle 标题
     */

    public void setStoryTitle(String storyTitle) {
        this.storyTitle = storyTitle;
    }

    /**
     * Get coverImgPath
     * 
     * @return coverImgPath
     */
    @Column(name = "COVER_IMG_PATH")
    public String getCoverImgPath() {
        return this.coverImgPath;
    }

    /**
     * Set coverImgPath
     * 
     * @param coverImgPath 封面图片
     */

    public void setCoverImgPath(String coverImgPath) {
        this.coverImgPath = coverImgPath;
    }

    /**
     * Get storyContent
     * 
     * @return storyContent
     */
    @Column(name = "STORY_CONTENT")
    public String getStoryContent() {
        return this.storyContent;
    }

    /**
     * Set storyContent
     * 
     * @param storyContent 内容
     */

    public void setStoryContent(String storyContent) {
        this.storyContent = storyContent;
    }

    /**
     * Get vedioPath
     * 
     * @return vedioPath
     */
    @Column(name = "VEDIO_PATH")
    public String getVedioPath() {
        return this.vedioPath;
    }

    /**
     * Set vedioPath
     * 
     * @param vedioPath 视频地址
     */

    public void setVedioPath(String vedioPath) {
        this.vedioPath = vedioPath;
    }

    /**
     * Get actStatus
     * 
     * @return actStatus
     */
    @Column(name = "ACT_STATUS")
    public Integer getActStatus() {
        return this.actStatus;
    }

    /**
     * Set actStatus
     * 
     * @param actStatus 启用状态
     */

    public void setActStatus(Integer actStatus) {
        this.actStatus = actStatus;
    }

    /**
     * Get createTime
     * 
     * @return createTime
     */
    @Column(name = "CREATE_TIME")
    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    /**
     * Set createTime
     * 
     * @param createTime 创建时间
     */

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

}
