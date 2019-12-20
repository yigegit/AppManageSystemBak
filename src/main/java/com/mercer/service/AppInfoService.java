package com.mercer.service;

import com.github.pagehelper.PageInfo;
import com.mercer.dto.AppInfoDTO;
import com.mercer.pojo.AppInfo;

import java.util.List;

/**
 * @ Date:2019/4/15
 * Auther:Mercer
 * Auther:麻前程
 */
public interface AppInfoService {
    PageInfo<AppInfo> queryByDevUserId(Long id,PageInfo<AppInfo> pageInfo);

    PageInfo<AppInfo> query(AppInfoDTO appInfoDTO);

    boolean add(AppInfo appInfo, Long userId);

    boolean delete(Long appId);

    AppInfo queryByAppId(Long appId);

    boolean update(AppInfo appInfo, Long user_id);

    AppInfo queryDetailByAppId(Long appId);

    String queryid(int i);
}
