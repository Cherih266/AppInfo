package com.app.controller;

import com.app.pojo.AppInfo;
import com.app.service.AppInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/dev")
public class AppInfoController {

    @Resource
    private AppInfoService appInfoService;
    /**
     * 查询app信息列表
     * @return
     */
    @RequestMapping("flatform/app/list")
    public String AppInfoList(HttpServletRequest request){
        List<AppInfo> appInfoList=appInfoService.findAppInfoList();
        request.setAttribute("appInfoList",appInfoList);
        return "developer/appinfolist";
    }
}
