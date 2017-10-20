/*
 * Copyright (C), 2013-2014, 
 * FileName: GameInfo.java
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
 * 实体类比赛   
 * 
 * @author zhuliang
 */
@Entity(name = "GAME_INFO")
public class GameInfo implements Serializable {
    /**
     * Serial UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 编号ID 编号ID
     */
    private Long id;
    /**
     * 比赛标题 比赛标题
     */
    private String gameTitle;
    /**
     * 封面图片 封面图片
     */
    private String coverImgPath;
    /**
     * 内容 内容
     */
    private String gameContent;
    /**
     * 报名人数 报名人数
     */
    private Integer joinCount;
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
     * Get gameTitle
     * 
     * @return gameTitle
     */
    @Column(name = "GAME_TITLE")
    public String getGameTitle() {
        return this.gameTitle;
    }

    /**
     * Set gameTitle
     * 
     * @param gameTitle 比赛标题
     */

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
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
     * Get gameContent
     * 
     * @return gameContent
     */
    @Column(name = "GAME_CONTENT")
    public String getGameContent() {
        return this.gameContent;
    }

    /**
     * Set gameContent
     * 
     * @param gameContent 内容
     */

    public void setGameContent(String gameContent) {
        this.gameContent = gameContent;
    }

    /**
     * Get joinCount
     * 
     * @return joinCount
     */
    @Column(name = "JOIN_COUNT")
    public Integer getJoinCount() {
        return this.joinCount;
    }

    /**
     * Set joinCount
     * 
     * @param joinCount 报名人数
     */

    public void setJoinCount(Integer joinCount) {
        this.joinCount = joinCount;
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
