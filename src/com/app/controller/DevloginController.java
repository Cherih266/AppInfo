package com.app.controller;

import com.app.pojo.DevUser;
import com.app.service.DevService;
import com.app.util.EmptyUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.naming.NoPermissionException;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/dev")
public class DevloginController {

    @Resource
    private DevService devService;

    /**
     * 权限处理
     * @return
     */
    @RequestMapping("/main")
    public String main(HttpServletRequest request)throws NoPermissionException{
        DevUser devUserSession = (DevUser) request.getSession().getAttribute("devUserSession");
        if(devUserSession == null){
            //进行全局异常处理
            throw new NoPermissionException();
        }
        return "developer/main";
    }


    @RequestMapping(value = "/login")
    public String devlogin(){

        return "devlogin";
    }

    @RequestMapping(value = "/dologin",method = RequestMethod.POST)
    public String dologin(HttpServletRequest request,
                          @RequestParam String devCode,
                          @RequestParam String devPassword){
        //1.进行用户名密码的判空
        if(EmptyUtils.isNotEmpty(devCode) && EmptyUtils.isNotEmpty(devPassword) ){
            //2.进行查询
            DevUser devUser =devService.dologin(devCode,devPassword);
            //3.判断密码和用户名
            if(EmptyUtils.isNotEmpty(devUser)){
                request.getSession().setAttribute("devUserSession",devUser);
                return "redirect:/dev/main";
            }else {
                request.setAttribute("error","用户名或密码错误！");
            }
        }else {
            request.setAttribute("error","用户名或密码不能为空！");
        }
        return "devlogin";

    }

}
