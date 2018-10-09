package com.zhihe.user.service.impl;

import com.zhihe.user.service.UserInfoService;
import com.zhihe.user.dao.UserInfoDao;
import com.zhihe.user.entity.UserInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;
    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoDao.findByUsername(username);
    }
}