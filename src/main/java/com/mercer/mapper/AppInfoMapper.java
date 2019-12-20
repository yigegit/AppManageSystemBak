package com.mercer.mapper;

import com.mercer.dto.AppInfoDTO;
import com.mercer.pojo.AppInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ Date:2019/4/15
 * Auther:Mercer
 * Auther:麻前程
 */
public interface AppInfoMapper {
//    List<AppInfo> queryByDevUserId(@Param("devUserId") Long id);

    List<AppInfo> query(AppInfoDTO appInfoDTO);

    int add(AppInfo appInfo);

    int deleteById(@Param("appId")Long appId);

    AppInfo queryByAppId(@Param("appId") Long appId);

    int updateById(AppInfo appInfo);

    AppInfo queryDetailByAppId(@Param("appId") Long appId);

    String queryid(int id);

}
