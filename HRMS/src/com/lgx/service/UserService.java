package com.lgx.service;

import com.lgx.model.User;

public interface UserService {
    User checkName(User user);
    boolean addUser(User user);
    User selectUser(User user);
}
