package com.app.service;

import com.app.mapper.AppInfoMapper;
import com.app.pojo.AppInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class AppInfoServiceImpl implements AppInfoService {
    @Resource
    public AppInfoMapper appInfoMapper;
    @Override
    public List<AppInfo> findAppInfoList() {
        return appInfoMapper.findAppInfoList();
    }
}
