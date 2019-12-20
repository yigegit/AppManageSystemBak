package com.mercer.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @ Date:2019/4/15
 * Auther:Mercer
 * Auther:麻前程
 */
public class AppInfo {
    private Long id;//主键id
    private String softwareName;//软件名称
    private String APKName;//apk名称（唯一）
    private String supportROM;//支持rom
    private String interfaceLanguage;//界面语言
    private BigDecimal softwareSize;//软件大小
    private Date updateDate;//更新日期
    private Long devId;//开发者id
    private String appInfo;//应用简介
    private Long status;//状态
    private Date onSaleDate;//上架时间
    private Date offSaleDate;//下架时间
    private Long flatformId;//所属平台（来源于：data_dictionary，1 手机 2 平板 3 通用）
    private AppCategory categoryLevel1;
    private AppCategory categoryLevel2;
    private AppCategory categoryLevel3;//所属三级分类（来源于：data_dictionary）
    private Long downloads;//下载量
    private Long createdBy;//创建者
    private Date creationDate;//创建时间
    private Long modifyBy;//更新者
    private Date modifyDate;//最新更新时间
    private String logoPicPath;//logo图片url地址
    private String logoLocPath;//logo图片服务器存储路径
    private Long versionId;//最新版本信息
    private List<AppVersion> appVersions;
    /**
     * 开发者
     */
    private DevUser devUser;
    private AppVersion newAppVersion;
    /**
     * 平台信息
     */
    private DataDictionary flatform;
    /**
     * 状态信息
     */
    private DataDictionary appStatus;

    /**
     * 创建者
     */
    private DevUser createUser;

    /**
     *修改者
     */
    private DevUser modifyUser;

    public DevUser getCreateUser() {
        return createUser;
    }

    public void setCreateUser(DevUser createUser) {
        this.createUser = createUser;
    }

    public DevUser getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(DevUser modifyUser) {
        this.modifyUser = modifyUser;
    }

    public DataDictionary getFlatform() {
        return flatform;
    }

    public void setFlatform(DataDictionary flatform) {
        this.flatform = flatform;
    }

    public DataDictionary getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(DataDictionary appStatus) {
        this.appStatus = appStatus;
    }

    public AppVersion getNewAppVersion() {
        return newAppVersion;
    }

    public void setNewAppVersion(AppVersion newAppVersion) {
        this.newAppVersion = newAppVersion;
    }

    public DevUser getDevUser() {
        return devUser;
    }

    public void setDevUser(DevUser devUser) {
        this.devUser = devUser;
    }

    public List<AppVersion> getAppVersions() {
        return appVersions;
    }

    public void setAppVersions(List<AppVersion> appVersions) {
        this.appVersions = appVersions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSoftwareName() {
        return softwareName;
    }

    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName;
    }

    public String getAPKName() {
        return APKName;
    }

    public void setAPKName(String APKName) {
        this.APKName = APKName;
    }

    public String getSupportROM() {
        return supportROM;
    }

    public void setSupportROM(String supportROM) {
        this.supportROM = supportROM;
    }

    public String getInterfaceLanguage() {
        return interfaceLanguage;
    }

    public void setInterfaceLanguage(String interfaceLanguage) {
        this.interfaceLanguage = interfaceLanguage;
    }

    public BigDecimal getSoftwareSize() {
        return softwareSize;
    }

    public void setSoftwareSize(BigDecimal softwareSize) {
        this.softwareSize = softwareSize;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Long getDevId() {
        return devId;
    }

    public void setDevId(Long devId) {
        this.devId = devId;
    }

    public String getAppInfo() {
        return appInfo;
    }

    public void setAppInfo(String appInfo) {
        this.appInfo = appInfo;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Date getOnSaleDate() {
        return onSaleDate;
    }

    public void setOnSaleDate(Date onSaleDate) {
        this.onSaleDate = onSaleDate;
    }

    public Date getOffSaleDate() {
        return offSaleDate;
    }

    public AppCategory getCategoryLevel1() {
        return categoryLevel1;
    }

    public AppCategory getCategoryLevel2() {
        return categoryLevel2;
    }

    public void setOffSaleDate(Date offSaleDate) {
        this.offSaleDate = offSaleDate;
    }

    public Long getFlatformId() {
        return flatformId;
    }

    public void setFlatformId(Long flatformId) {
        this.flatformId = flatformId;
    }

    public void setCategoryLevel1(AppCategory categoryLevel1) {
        this.categoryLevel1 = categoryLevel1;
    }

    public void setCategoryLevel2(AppCategory categoryLevel2) {
        this.categoryLevel2 = categoryLevel2;
    }

    public AppCategory getCategoryLevel3() {
        return categoryLevel3;
    }

    public void setCategoryLevel3(AppCategory categoryLevel3) {
        this.categoryLevel3 = categoryLevel3;
    }

    public Long getDownloads() {
        return downloads;
    }

    public void setDownloads(Long downloads) {
        this.downloads = downloads;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(Long modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }


    public String getLogoPicPath() {
        return logoPicPath;
    }

    public void setLogoPicPath(String logoPicPath) {
        this.logoPicPath = logoPicPath;
    }

    public String getLogoLocPath() {
        return logoLocPath;
    }

    public void setLogoLocPath(String logoLocPath) {
        this.logoLocPath = logoLocPath;
    }

    public Long getVersionId() {
        return versionId;
    }

    public void setVersionId(Long versionId) {
        this.versionId = versionId;
    }
}
