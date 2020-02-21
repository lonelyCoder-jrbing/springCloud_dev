package com.example.mybatisdemo.controller;

import com.example.mybatisdemo.domain.User;
import com.example.mybatisdemo.dto.UserMsgLoadDTO;
import com.example.mybatisdemo.intercepters.page.PageView;
import com.example.mybatisdemo.serivce.UserService;
import com.example.mybatisdemo.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/try")
@EnableAutoConfiguration
public class UserController {
 
//    @Autowired
//    private UserDao userDao;
 
    @Autowired
    private UserService userService;
 
//    @RequestMapping(value = "/user")
//    public List<User> getUsers(){
//        return userDao.selectUsers();
//    }
 
    @RequestMapping(value = "/getAll")
    public ResultVo getAllUsers(PageView<User> request){
        return userService.getAllUsers(request);
    }
}
