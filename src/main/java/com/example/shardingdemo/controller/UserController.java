package com.example.shardingdemo.controller;

import com.example.shardingdemo.entity.User;
import com.example.shardingdemo.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/testBoot")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("getUser/{id}")
    public User GetUser(@PathVariable int id){
        return userService.getUser(id,"");
    }

    @RequestMapping("saveUser")
    public String saveUser(){
        userService.saveUser("");
        return "夸库跨表新增成功";
    }

    @RequestMapping("getUserD/{id}")
    public User GetUserD(@PathVariable int id){
        return userService.getUser(id,"_d");
    }
    @RequestMapping("saveUserD")
    public String saveUserD(){
        userService.saveUser("_d");
        return "单库跨表新增成功";
    }

    @RequestMapping("getUserC/{id}")
    public User GetUserC(@PathVariable int id){
        return userService.getUser(id,"_c");
    }
    @RequestMapping("getUserPageC")
    public PageInfo getUserPageC(){
        return userService.getUserPageC( 1,  2,"_c");
    }
    @RequestMapping("saveUserC")
    public String saveUserC(){
        userService.saveUser("_c");
        return "自定义跨库跨表新增成功";
    }

}
