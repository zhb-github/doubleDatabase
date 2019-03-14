package com.jdbc.service;

import com.jdbc.entity.UserInfo;


/**
 * Created by 鸠摩智 on 2018/11/23.
 */
public interface UserInfoService {

    void saveMaster(UserInfo userInfo);

    void saveSlave(UserInfo userInfo);
}
