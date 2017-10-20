/*
 * Copyright (C), 2013-2014, 
 * FileName: School.java
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
 * 实体类学校   
 * 
 * @author zhuliang
 */
@Entity(name = "SCHOOL")
public class School implements Serializable {
    /**
     * Serial UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 编号ID 编号ID
     */
    private Long id;
    /**
     * 学校名 学校名
     */
    private String schoolName;
    /**
     * 学校类型 学校类型 0:小学 1:初中
     */
    private Integer schoolType;

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
     * Get schoolName
     * 
     * @return schoolName
     */
    @Column(name = "SCHOOL_NAME")
    public String getSchoolName() {
        return this.schoolName;
    }

    /**
     * Set schoolName
     * 
     * @param schoolName 学校名
     */

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    /**
     * Get schoolType
     * 
     * @return schoolType
     */
    @Column(name = "SCHOOL_TYPE")
    public Integer getSchoolType() {
        return this.schoolType;
    }

    /**
     * Set schoolType
     * 
     * @param schoolType 学校类型
     */

    public void setSchoolType(Integer schoolType) {
        this.schoolType = schoolType;
    }

}
