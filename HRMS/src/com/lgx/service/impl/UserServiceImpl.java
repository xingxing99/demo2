package com.lgx.service.impl;

import com.lgx.dao.UserMapper;
import com.lgx.model.User;
import com.lgx.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User checkName(User user) {
        return userMapper.checkName(user);
    }

    @Override
    public boolean addUser(User user) {
        try {
            return userMapper.addUser(user);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public User selectUser(User user) {
        return userMapper.selectUser(user);
    }
}
