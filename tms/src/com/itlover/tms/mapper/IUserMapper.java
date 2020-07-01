package com.itlover.tms.mapper;

import com.itlover.tms.pojo.User;

import java.util.List;

/**
 * User的mapper接口
 */
public interface IUserMapper {

    //查询所有的user信息
    List<User> findAll() throws Exception;

    //分页查询user信息
    List<User> findAllByPage(int pageNum, int pageSize) throws Exception;

    //查询user的数量
    Long findCount() throws Exception;

    //根据uId查询信息
    User findById(int parseInt) throws Exception;

    //根据tId更新消息
    Integer updateById(User user) throws Exception;

    //根据id删除信息
    Integer deleteByUserId(int parseInt) throws Exception;

    Integer save(User user) throws Exception;

    //根据用户名称查询User信息
    public User findByName(String loginName) throws Exception;
}
