package com.example.mybatisdemo.serivce;

import com.example.mybatisdemo.dao.UserDao;
import com.example.mybatisdemo.domain.User;
import com.example.mybatisdemo.dto.UserMsgLoadDTO;
import com.example.mybatisdemo.intercepters.page.PageView;
import com.example.mybatisdemo.vo.CodeMsg;
import com.example.mybatisdemo.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public ResultVo getAllUsers(PageView<User> request) {
        List<User> allUsers = userDao.getAllUserPage(request);
        if (allUsers.size() == 0) {
            return ResultVo.error(CodeMsg.SELECT_ERROR);
        } else {
            return ResultVo.success(allUsers);
        }
    }
}
