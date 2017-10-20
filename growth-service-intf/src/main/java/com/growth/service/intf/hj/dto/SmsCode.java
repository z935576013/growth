/*
 * Copyright (C), 2013-2014, 
 * FileName: SmsCode.java
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
 * 实体类短信验证码   
 * 
 * @author zhuliang
 */
@Entity(name = "SMS_CODE")
public class SmsCode implements Serializable {
    /**
     * Serial UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 编号ID 编号ID
     */
    private Long id;
    /**
     * 手机号 手机号
     */
    private String mobile;
    /**
     * 验证码 验证码
     */
    private String valCode;
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
     * Get mobile
     * 
     * @return mobile
     */
    @Column(name = "MOBILE")
    public String getMobile() {
        return this.mobile;
    }

    /**
     * Set mobile
     * 
     * @param mobile 手机号
     */

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * Get valCode
     * 
     * @return valCode
     */
    @Column(name = "VAL_CODE")
    public String getValCode() {
        return this.valCode;
    }

    /**
     * Set valCode
     * 
     * @param valCode 验证码
     */

    public void setValCode(String valCode) {
        this.valCode = valCode;
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
