package com.mercer.pojo;

import org.joda.time.DateTime;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * @ Date:2019/4/14
 * Auther:Mercer
 * Auther:麻前程
 */
public class DevUser {
    private Long id;
    private String devCode;//开发者账号
    private String devName;//开发者名称
    private String devPassword;//开发者密码
    private String devEmail;//开发者邮箱
    private String devInfo;//开发者简介
    private Long createBy;//创建者（来源于backend_user用户表的用户id）
    private DateTime creationDate;//创建时间
    private Long modifyBy;//更新者（来源于backend_user用户表的用户id）
    private DateTime modifyDate;//最新更新时间
    private List<AppInfo> appInfos;

    public List<AppInfo> getAppInfos() {
        return appInfos;
    }

    public void setAppInfos(List<AppInfo> appInfos) {
        this.appInfos = appInfos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDevCode() {
        return devCode;
    }

    public void setDevCode(String devCode) {
        this.devCode = devCode;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public String getDevPassword() {
        return devPassword;
    }

    public void setDevPassword(String devPassword) {
        this.devPassword = devPassword;
    }

    public String getDevEmail() {
        return devEmail;
    }

    public void setDevEmail(String devEmail) {
        this.devEmail = devEmail;
    }

    public String getDevInfo() {
        return devInfo;
    }

    public void setDevInfo(String devInfo) {
        this.devInfo = devInfo;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public DateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(DateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Long getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(Long modifyBy) {
        this.modifyBy = modifyBy;
    }

    public DateTime getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(DateTime modifyDate) {
        this.modifyDate = modifyDate;
    }
}
