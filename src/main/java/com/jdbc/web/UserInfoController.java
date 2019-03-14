package com.jdbc.web;

import com.jdbc.entity.UserInfo;
import com.jdbc.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by 鸠摩智 on 2018/11/23.
 */
@RestController
@RequestMapping("user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("master")
    public String master(UserInfo user) {
        userInfoService.saveMaster(user);
        return "保存成功";
    }

    @PostMapping("slave")
    public String slave(UserInfo user) {
        userInfoService.saveSlave(user);
        return "保存成功";
    }

}
