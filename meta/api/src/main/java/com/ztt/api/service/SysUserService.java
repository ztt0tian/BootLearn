package com.ztt.api.service;

import com.ztt.api.po.SysUser;

public interface SysUserService {
    int registerUser(SysUser sysUser);

    int updateUser(SysUser sysUser);
}
