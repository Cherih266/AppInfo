package com.app.service;

import com.app.mapper.DevUserMapper;
import com.app.pojo.DevUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DevServiceImpl implements DevService {
    @Resource
    public DevUserMapper devUserMapper;
    @Override
    public DevUser dologin(String devCode, String devPassword) {
        return devUserMapper.dologin(devCode,devPassword);
    }
}
