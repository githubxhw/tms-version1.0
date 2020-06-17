package com.itlover.tms.mapper;

import com.itlover.tms.pojo.User;

/**
 * User的mapper接口
 */
public interface IUserMapper {

    //根据用户名称查询User信息
    public User findByName(String loginName) throws Exception;
}
