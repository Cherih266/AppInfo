package com.app.mapper;

import com.app.pojo.DevUser;
import org.apache.ibatis.annotations.Param;

public interface DevUserMapper {
    /**
     * 登录
     * @param devCode
     * @param devPassword
     * @return
     */
    DevUser dologin(@Param("devCode") String devCode, @Param("devPassword") String devPassword);
}
