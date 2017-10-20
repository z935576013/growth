/*
 * Copyright (C), 2013-2014, 
 * FileName: Hobby.java
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
 * 实体类兴趣   
 * 
 * @author zhuliang
 */
@Entity(name = "HOBBY")
public class Hobby implements Serializable {
    /**
     * Serial UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 编号ID 编号ID
     */
    private Long id;
    /**
     * 兴趣名 兴趣名
     */
    private String hobbyName;

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
     * Get hobbyName
     * 
     * @return hobbyName
     */
    @Column(name = "HOBBY_NAME")
    public String getHobbyName() {
        return this.hobbyName;
    }

    /**
     * Set hobbyName
     * 
     * @param hobbyName 兴趣名
     */

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
    }

}
