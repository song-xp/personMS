package com.lz.service;

import com.lz.pojo.Student;
import com.lz.pojo.User;

import java.util.List;

public interface UserService {
    public User findUser(String mcode, String mpassword);
}
