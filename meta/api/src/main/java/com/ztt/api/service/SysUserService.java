package com.ztt.api.service;

import com.ztt.api.dto.user.UserAddDto;
import com.ztt.api.po.SysUser;

public interface SysUserService {
    int registerUser(UserAddDto userAddDto);
    int updateUser(SysUser sysUser);
}
