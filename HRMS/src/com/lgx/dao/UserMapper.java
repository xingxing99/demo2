package com.lgx.dao;

import com.lgx.model.User;

public interface UserMapper {
    User checkName(User user);
    boolean addUser(User user);
    User selectUser(User user);
}
