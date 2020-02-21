package com.example.mybatisdemo.dao;

import com.example.mybatisdemo.domain.User;
import com.example.mybatisdemo.dto.UserMsgLoadDTO;
import com.example.mybatisdemo.intercepters.page.PageView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {
//    String QUERY_CODE_SQL = "<if test=\"count > 0\">  LIMIT #{pageNo}, #{pageSize} </if>";

    @Select("SELECT * FROM user")
    public List<User> getAllUserPage(PageView<User> request);

}
