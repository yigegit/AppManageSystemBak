package com.mercer.mapper;

import com.mercer.pojo.DevUser;

import java.util.List;

/**
 * @ Date:2019/4/14
 * Auther:Mercer
 * Auther:麻前程
 */
public interface DevUserMapper {

    List<DevUser> queryByNamePwd(DevUser user);
}
