package com.zookeeper.controller;

import com.yh.csx.dao.model.MoUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
  public class UserController {

      @Value("${server.port}")
      private int port;

      @GetMapping("/list")
      public List<MoUser> getList() {

         return new ArrayList<MoUser>() {
             {
                 add(new MoUser(1, "shenniu001_" + port));
                 add(new MoUser(2, "shenniu002_" + port));
                 add(new MoUser(3, "shenniu003_" + port));
             }};
     }
 }