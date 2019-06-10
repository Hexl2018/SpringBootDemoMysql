package com.example.demo.sys.service;

import com.example.demo.sys.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 管理员表 服务类
 * @author hexl
 * @since 2019-06-10
 */
public interface IUserService extends IService<User> {
    /**
     * 查询所有用户
     * @return list
     */
    List<User> findUsers();

    /**
     * 根据id查询用户
     * @param id id
     * @return user
     */
    User findUserById(Integer id);
}
