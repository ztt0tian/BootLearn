package com.ztt.api.service.impl;

import com.ztt.api.dao.SysUserMapper;
import com.ztt.api.dto.user.UserAddDto;
import com.ztt.api.po.SysUser;
import com.ztt.api.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserMapper userMapper;


    @Override
    public int registerUser(UserAddDto userAddDto) {
        SysUser user = new SysUser() {
            {
                setUserName(userAddDto.getUserName());
                setUserPsw(userAddDto.getUserPsw());
            }
        };
        return userMapper.insertSelective(user);
    }

    @Override
    public int updateUser(SysUser sysUser) {
        return 0;
    }
}
