package com.example.mybatisdemo.dao;

import com.example.mybatisdemo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("select * from user")
    public List<User> getAllUser();

}
