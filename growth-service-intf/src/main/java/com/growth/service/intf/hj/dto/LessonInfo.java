/*
 * Copyright (C), 2013-2014, 
 * FileName: LessonInfo.java
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
 * 实体类课堂   
 * 
 * @author zhuliang
 */
@Entity(name = "LESSON_INFO")
public class LessonInfo implements Serializable {
    /**
     * Serial UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 编号ID 编号ID
     */
    private Long id;
    /**
     * 课堂类型 课堂类型 0:成长 1:少年 2:魔力
     */
    private Integer lessonType;
    /**
     * 课堂标题 课堂标题
     */
    private String lessonTitle;
    /**
     * 封面图片 封面图片
     */
    private String coverImgPath;
    /**
     * 课堂内容 课堂内容
     */
    private String lessonContent;
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
     * Get lessonType
     * 
     * @return lessonType
     */
    @Column(name = "LESSON_TYPE")
    public Integer getLessonType() {
        return this.lessonType;
    }

    /**
     * Set lessonType
     * 
     * @param lessonType 课堂类型
     */

    public void setLessonType(Integer lessonType) {
        this.lessonType = lessonType;
    }

    /**
     * Get lessonTitle
     * 
     * @return lessonTitle
     */
    @Column(name = "LESSON_TITLE")
    public String getLessonTitle() {
        return this.lessonTitle;
    }

    /**
     * Set lessonTitle
     * 
     * @param lessonTitle 课堂标题
     */

    public void setLessonTitle(String lessonTitle) {
        this.lessonTitle = lessonTitle;
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
     * Get lessonContent
     * 
     * @return lessonContent
     */
    @Column(name = "LESSON_CONTENT")
    public String getLessonContent() {
        return this.lessonContent;
    }

    /**
     * Set lessonContent
     * 
     * @param lessonContent 课堂内容
     */

    public void setLessonContent(String lessonContent) {
        this.lessonContent = lessonContent;
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
