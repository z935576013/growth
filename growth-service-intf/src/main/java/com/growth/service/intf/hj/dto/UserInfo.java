/*
 * Copyright (C), 2013-2014, 
 * FileName: UserInfo.java
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
 * 实体类用户   
 * 
 * @author zhuliang
 */
@Entity(name = "USER_INFO")
public class UserInfo implements Serializable {
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
     * 密码 密码
     */
    private String password;
    /**
     * 姓名 姓名
     */
    private String name;
    /**
     * 年龄 年龄
     */
    private Integer age;
    /**
     * 性别 性别 0:男 1:女
     */
    private Integer sex;
    /**
     * 学校 学校
     */
    private String school;
    /**
     * 年级 年级
     */
    private Integer gradeNum;
    /**
     * 班级 班级
     */
    private Integer classNum;
    /**
     * 兴趣 兴趣
     */
    private String hobby;
    /**
     * 特长 特长
     */
    private String strongPoint;
    /**
     * openid
     */
    private String openid;
    /**
     * 头像
     */
    private String headImgPath;
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

    /**
     * Get name
     * 
     * @return name
     */
    @Column(name = "NAME")
    public String getName() {
        return this.name;
    }

    /**
     * Set name
     * 
     * @param name 姓名
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get age
     * 
     * @return age
     */
    @Column(name = "AGE")
    public Integer getAge() {
        return this.age;
    }

    /**
     * Set age
     * 
     * @param age 年龄
     */

    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * Get sex
     * 
     * @return sex
     */
    @Column(name = "SEX")
    public Integer getSex() {
        return this.sex;
    }

    /**
     * Set sex
     * 
     * @param sex 性别
     */

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * Get school
     * 
     * @return school
     */
    @Column(name = "SCHOOL")
    public String getSchool() {
        return this.school;
    }

    /**
     * Set school
     * 
     * @param school 学校
     */

    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * Get gradeNum
     * 
     * @return gradeNum
     */
    @Column(name = "GRADE_NUM")
    public Integer getGradeNum() {
        return this.gradeNum;
    }

    /**
     * Set gradeNum
     * 
     * @param gradeNum 年级
     */

    public void setGradeNum(Integer gradeNum) {
        this.gradeNum = gradeNum;
    }

    /**
     * Get classNum
     * 
     * @return classNum
     */
    @Column(name = "CLASS_NUM")
    public Integer getClassNum() {
        return this.classNum;
    }

    /**
     * Set classNum
     * 
     * @param classNum 班级
     */

    public void setClassNum(Integer classNum) {
        this.classNum = classNum;
    }

    /**
     * Get hobby
     * 
     * @return hobby
     */
    @Column(name = "HOBBY")
    public String getHobby() {
        return this.hobby;
    }

    /**
     * Set hobby
     * 
     * @param hobby 兴趣
     */

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    /**
     * Get strongPoint
     * 
     * @return strongPoint
     */
    @Column(name = "STRONG_POINT")
    public String getStrongPoint() {
        return this.strongPoint;
    }

    /**
     * Set strongPoint
     * 
     * @param strongPoint 特长
     */

    public void setStrongPoint(String strongPoint) {
        this.strongPoint = strongPoint;
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

	/**
	 * @return the openid
	 */
    @Column(name = "OPENID")
	public String getOpenid() {
		return openid;
	}

	/**
	 * @param openid the openid to set
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	/**
	 * @return the headImgPath
	 */
	@Column(name = "HEAD_IMG_PATH")
	public String getHeadImgPath() {
		return headImgPath;
	}

	/**
	 * @param headImgPath the headImgPath to set
	 */
	public void setHeadImgPath(String headImgPath) {
		this.headImgPath = headImgPath;
	}

}
