/*
 * Copyright (C), 2013-2014, 
 * FileName: AdminInfo.java
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
 * 实体类管理员   
 * 
 * @author zhuliang
 */
@Entity(name = "ADMIN_INFO")
public class AdminInfo implements Serializable {
    /**
     * Serial UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 编号ID 编号ID
     */
    private Long id;
    /**
     * 账号 账号
     */
    private String loginId;
    /**
     * 密码 密码
     */
    private String password;

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
     * Get loginId
     * 
     * @return loginId
     */
    @Column(name = "LOGIN_ID")
    public String getLoginId() {
        return this.loginId;
    }

    /**
     * Set loginId
     * 
     * @param loginId 账号
     */

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    /**
     * Get password
     * 
     * @return password
     */
    @Column(name = "PASSWORD")
    public String getPassword() {
        return this.password;
    }

    /**
     * Set password
     * 
     * @param password 密码
     */

    public void setPassword(String password) {
        this.password = password;
    }

}
