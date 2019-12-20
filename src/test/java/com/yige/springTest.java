package com.yige;

import com.mercer.mapper.DevUserMapper;
import com.mercer.pojo.DevUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class springTest {

    @Autowired
    private DevUserMapper devUserMapper;

    @Test
    public void login(DevUser user) {
        List<DevUser> devUsers = devUserMapper.queryByNamePwd(user);
        System.out.println(devUsers);
    }
}
