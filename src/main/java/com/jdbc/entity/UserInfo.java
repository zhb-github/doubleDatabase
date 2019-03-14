package com.jdbc.entity;

import lombok.Data;

import javax.persistence.Id;


/**
 * Created by 鸠摩智 on 2018/11/23.
 */

@Data
public class UserInfo {

    @Id
    private Long id;

    private String name;
}
