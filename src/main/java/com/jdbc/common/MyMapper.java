package com.jdbc.common;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;


/**
 * @author： ZouHaiBo
 * @description：
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
