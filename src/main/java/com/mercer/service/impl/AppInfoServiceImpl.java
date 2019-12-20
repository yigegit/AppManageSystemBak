package com.mercer.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mercer.constant.CommonCodeConstant;
import com.mercer.dto.AppInfoDTO;
import com.mercer.mapper.AppInfoMapper;
import com.mercer.pojo.AppInfo;
import com.mercer.pojo.DataDictionary;
import com.mercer.pojo.DevUser;
import com.mercer.service.AppInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ Date:2019/4/15
 * Auther:Mercer
 * Auther:麻前程
 */
@Service("appInfoService")
public class AppInfoServiceImpl implements AppInfoService {
    @Autowired
    AppInfoMapper appInfoMapper;

    @Override
    public PageInfo<AppInfo> queryByDevUserId(Long id,PageInfo<AppInfo> pageInfo) {
        //去第几页，页码的大小
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize());
        AppInfoDTO appInfoDTO = new AppInfoDTO();
        appInfoDTO.setDevUserId(id);
        List<AppInfo> appInfos= appInfoMapper.query(appInfoDTO);
        PageInfo<AppInfo> pageInfo1 = new PageInfo<>(appInfos);

        return pageInfo1;
    }

    @Override
    public PageInfo<AppInfo> query(AppInfoDTO appInfoDTO) {
        PageHelper.startPage(appInfoDTO.getPageNum(), CommonCodeConstant.PAGE_SIZE);
        List<AppInfo> appInfos = appInfoMapper.query(appInfoDTO);
        PageInfo<AppInfo> pageInfo = new PageInfo<>(appInfos);
        return pageInfo;
    }

    @Override
    public boolean add(AppInfo appInfo, Long userId) {
        appInfo.setCreationDate(new Date());
        DevUser devUser = new DevUser();
        devUser.setId(userId);
        appInfo.setDevUser(devUser);
        appInfo.setDevId(userId);
        DataDictionary dataDictionary = new DataDictionary();
        dataDictionary.setValueId(CommonCodeConstant.APP_STATUS_AUDITED);
        appInfo.setAppStatus(dataDictionary);
        int row = appInfoMapper.add(appInfo);
        return false;
    }

    @Override
    public boolean delete(Long appId) {
        if (appId !=null){
            int row = appInfoMapper.deleteById(appId);
            return row==1 ? true:false;
        }
        return false;
    }

    @Override
    public AppInfo queryByAppId(Long appId) {

        return appInfoMapper.queryByAppId(appId);

    }

    @Override
    public boolean update(AppInfo appInfo,Long user_id) {
        if (appInfo !=null && appInfo.getId()!=null){
            DevUser devUser = new DevUser();
            devUser.setId(user_id);
            appInfo.setDevUser(devUser);
            DevUser modifyUser = new DevUser();
            modifyUser.setId(user_id);
            appInfo.setCreateUser(modifyUser);
            appInfo.setModifyDate(new Date());
            int row = appInfoMapper.updateById(appInfo);
            return row==1 ? true:false;
        }
        return false;
    }

    @Override
    public AppInfo queryDetailByAppId(Long appId) {

        return appInfoMapper.queryDetailByAppId(appId);
    }

    @Override
    public String queryid(int i) {
        return appInfoMapper.queryid(i);
    }
}
