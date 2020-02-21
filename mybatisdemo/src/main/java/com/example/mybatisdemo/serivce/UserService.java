package com.example.mybatisdemo.serivce;

import com.example.mybatisdemo.domain.User;
import com.example.mybatisdemo.dto.UserMsgLoadDTO;
import com.example.mybatisdemo.intercepters.page.PageView;
import com.example.mybatisdemo.vo.ResultVo;
import org.springframework.stereotype.Service;

public interface UserService {
    public ResultVo getAllUsers(PageView<User> request);

}
