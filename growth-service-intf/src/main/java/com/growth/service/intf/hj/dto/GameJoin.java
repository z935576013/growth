/*
 * Copyright (C), 2013-2014, 
 * FileName: GameJoin.java
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
 * 实体类比赛报名   
 * 
 * @author zhuliang
 */
@Entity(name = "GAME_JOIN")
public class GameJoin implements Serializable {
    /**
     * Serial UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 编号ID 编号ID
     */
    private Long id;
    /**
     * 用户编号 用户编号
     */
    private Long userId;
    /**
     * 比赛编号 比赛编号
     */
    private Long gameId;
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
     * Get gameId
     * 
     * @return gameId
     */
    @Column(name = "GAME_ID")
    public Long getGameId() {
        return this.gameId;
    }

    /**
     * Set gameId
     * 
     * @param gameId 比赛编号
     */

    public void setGameId(Long gameId) {
        this.gameId = gameId;
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
