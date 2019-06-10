package com.example.demo.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.sys.entity.User;
import com.example.demo.sys.mapper.UserMapper;
import com.example.demo.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 管理员表 服务实现类
 * @author hexl
 * @since 2019-06-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Override
    public List<User> findUsers() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public User findUserById(Integer id) {
        return baseMapper.selectById(id);
    }
}
