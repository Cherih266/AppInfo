package com.app.service;

import com.app.pojo.DevUser;

public interface DevService {
    DevUser dologin(String devCode, String devPassword);
}
