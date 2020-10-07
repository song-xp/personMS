package com.lz.service.impl;

import com.lz.dao.UserDao;
import com.lz.pojo.Student;
import com.lz.pojo.User;
import com.lz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("/userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User findUser(String mcode, String mpassword) {
        User user = this.userDao.findUser(mcode,mpassword);
        return user;
    }
}
