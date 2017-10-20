/*
 * Copyright (C), 2013-2014, 
 * FileName: ActJoin.java
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
 * 实体类活动报名   
 * 
 * @author zhuliang
 */
@Entity(name = "ACT_JOIN")
public class ActJoin implements Serializable {
    /**
     * Serial UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 编号ID 编号ID
     */
    private Long id;
    /**
     * 姓名 姓名
     */
    private String name;
    /**
     * 年龄 年龄
     */
    private String age;
    /**
     * 性别 性别
     */
    private String sex;
    /**
     * 民族 民族
     */
    private String nation;
    /**
     * 绰号 绰号
     */
    private String nickname;
    /**
     * 父电话 父电话
     */
    private String fatherPhone;
    /**
     * 母电话 母电话
     */
    private String motherPhone;
    /**
     * 学校 学校
     */
    private String school;
    /**
     * 特长 特长
     */
    private String strongPoint;
    /**
     * 节目 节目
     */
    private String perform;
    /**
     * 内容1 内容1
     */
    private String content1;
    /**
     * 内容3 内容3
     */
    private String content3;
    /**
     * 内容2 内容2
     */
    private String content2;
    /**
     * 内容4 内容4
     */
    private String content4;
    /**
     * 内容5 内容5
     */
    private String content5;
    /**
     * 内容6 内容6
     */
    private String content6;
    /**
     * 内容7 内容7
     */
    private String content7;
    /**
     * 用户编号
     */
    private Long userId;
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
    public String getAge() {
        return this.age;
    }

    /**
     * Set age
     * 
     * @param age 年龄
     */

    public void setAge(String age) {
        this.age = age;
    }

    /**
     * Get sex
     * 
     * @return sex
     */
    @Column(name = "SEX")
    public String getSex() {
        return this.sex;
    }

    /**
     * Set sex
     * 
     * @param sex 性别
     */

    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Get nation
     * 
     * @return nation
     */
    @Column(name = "NATION")
    public String getNation() {
        return this.nation;
    }

    /**
     * Set nation
     * 
     * @param nation 民族
     */

    public void setNation(String nation) {
        this.nation = nation;
    }

    /**
     * Get nickname
     * 
     * @return nickname
     */
    @Column(name = "NICKNAME")
    public String getNickname() {
        return this.nickname;
    }

    /**
     * Set nickname
     * 
     * @param nickname 绰号
     */

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * Get fatherPhone
     * 
     * @return fatherPhone
     */
    @Column(name = "FATHER_PHONE")
    public String getFatherPhone() {
        return this.fatherPhone;
    }

    /**
     * Set fatherPhone
     * 
     * @param fatherPhone 父电话
     */

    public void setFatherPhone(String fatherPhone) {
        this.fatherPhone = fatherPhone;
    }

    /**
     * Get motherPhone
     * 
     * @return motherPhone
     */
    @Column(name = "MOTHER_PHONE")
    public String getMotherPhone() {
        return this.motherPhone;
    }

    /**
     * Set motherPhone
     * 
     * @param motherPhone 母电话
     */

    public void setMotherPhone(String motherPhone) {
        this.motherPhone = motherPhone;
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
     * Get perform
     * 
     * @return perform
     */
    @Column(name = "PERFORM")
    public String getPerform() {
        return this.perform;
    }

    /**
     * Set perform
     * 
     * @param perform 节目
     */

    public void setPerform(String perform) {
        this.perform = perform;
    }

    /**
     * Get content1
     * 
     * @return content1
     */
    @Column(name = "CONTENT1")
    public String getContent1() {
        return this.content1;
    }

    /**
     * Set content1
     * 
     * @param content1 内容1
     */

    public void setContent1(String content1) {
        this.content1 = content1;
    }

    /**
     * Get content3
     * 
     * @return content3
     */
    @Column(name = "CONTENT3")
    public String getContent3() {
        return this.content3;
    }

    /**
     * Set content3
     * 
     * @param content3 内容3
     */

    public void setContent3(String content3) {
        this.content3 = content3;
    }

    /**
     * Get content2
     * 
     * @return content2
     */
    @Column(name = "CONTENT2")
    public String getContent2() {
        return this.content2;
    }

    /**
     * Set content2
     * 
     * @param content2 内容2
     */

    public void setContent2(String content2) {
        this.content2 = content2;
    }

    /**
     * Get content4
     * 
     * @return content4
     */
    @Column(name = "CONTENT4")
    public String getContent4() {
        return this.content4;
    }

    /**
     * Set content4
     * 
     * @param content4 内容4
     */

    public void setContent4(String content4) {
        this.content4 = content4;
    }

    /**
     * Get content5
     * 
     * @return content5
     */
    @Column(name = "CONTENT5")
    public String getContent5() {
        return this.content5;
    }

    /**
     * Set content5
     * 
     * @param content5 内容5
     */

    public void setContent5(String content5) {
        this.content5 = content5;
    }

    /**
     * Get content6
     * 
     * @return content6
     */
    @Column(name = "CONTENT6")
    public String getContent6() {
        return this.content6;
    }

    /**
     * Set content6
     * 
     * @param content6 内容6
     */

    public void setContent6(String content6) {
        this.content6 = content6;
    }

    /**
     * Get content7
     * 
     * @return content7
     */
    @Column(name = "CONTENT7")
    public String getContent7() {
        return this.content7;
    }

    /**
     * Set content7
     * 
     * @param content7 内容7
     */

    public void setContent7(String content7) {
        this.content7 = content7;
    }


    /**
	 * @return the userId
	 */
    @Column(name = "USER_ID")
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
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
