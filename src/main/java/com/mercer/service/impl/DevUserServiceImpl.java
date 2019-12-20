package com.mercer.service.impl;

import com.mercer.mapper.DevUserMapper;
import com.mercer.pojo.DevUser;
import com.mercer.service.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Date:2019/4/14
 * Auther:Mercer
 * Auther:麻前程
 */
@Service("devUserService")
public class DevUserServiceImpl implements DevUserService {
    @Autowired
    DevUserMapper devUserMapper;

    @Override
    public DevUser login(DevUser user) {
        List<DevUser> devUsers = devUserMapper.queryByNamePwd(user);
        if (devUsers !=null && devUsers.size()==1){
            return devUsers.get(0);
        }
        else
        return null;
    }
}
