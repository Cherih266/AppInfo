package com.app.mapper;

import com.app.pojo.AppInfo;

import java.util.List;

public interface AppInfoMapper {
    /**
     * 查询app列表
     * @return
     */
    List<AppInfo> findAppInfoList();
}
