package com.jdbc.service;

import com.jdbc.common.DataSourceTarget;
import com.jdbc.config.DataSourceName;
import com.jdbc.dao.UserInfoDao;
import com.jdbc.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by 鸠摩智 on 2018/11/23.
 */
@Service
@Lazy
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoDao userInfoDao;

    @Override
    public void saveMaster(UserInfo userInfo) {
        userInfoDao.insertSelective(userInfo);
    }

    @DataSourceTarget(DataSourceName.SLAVE)
    @Override
    public void saveSlave(UserInfo userInfo) {
        userInfoDao.insertSelective(userInfo);
    }

}
