package com.lz.dao;

import com.lz.pojo.Student;
import com.lz.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    public User findUser(@Param("mcode") String mcode, @Param("mpassword") String mpassword);
}
