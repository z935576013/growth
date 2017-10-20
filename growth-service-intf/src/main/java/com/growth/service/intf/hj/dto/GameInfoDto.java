/*
 * Copyright (C), 2013-2014, 
 * FileName: GameInfo.java
 * Author:   zhuliang
 * Date:     2014年10月16日 下午1:30:32
 */
package com.growth.service.intf.hj.dto;

/**
 * 实体类比赛   
 * 
 * @author zhuliang
 */
public class GameInfoDto extends GameInfo {
    /**
     * Serial UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 参与状态 0:未参加 1:已参加
     */
    private Integer joinStatus;

	/**
	 * @return the joinStatus
	 */
	public Integer getJoinStatus() {
		return joinStatus;
	}

	/**
	 * @param joinStatus the joinStatus to set
	 */
	public void setJoinStatus(Integer joinStatus) {
		this.joinStatus = joinStatus;
	}
    
    
}
