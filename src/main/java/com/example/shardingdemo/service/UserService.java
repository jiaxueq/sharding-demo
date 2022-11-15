package com.example.shardingdemo.service;

import com.example.shardingdemo.entity.User;
import com.example.shardingdemo.mapper.UserMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User getUser(int id,String tableSuffix){
        return userMapper.getUser(id,tableSuffix);
    }

    public void saveUser(String tableSuffix) {
        for (long i = 1; i < 11; i++) {
            User user =  new User();
            user.setId((int) i);
            user.setTableSuffix(tableSuffix);
            user.setUserName("JXQ"+i);
            user.setAddress("乌鲁木齐"+i);
            user.setAge((int) (20+i));
            userMapper.addUser(user);
            System.out.println("插入用户成功，uid=" + user.getId());
        }
    }

    public PageInfo getUserPageC(int pageNum, int pageSize,String tableSuffix) {
        PageHelper.startPage(pageNum, pageSize);
        Page<User> page = userMapper.querUserByPage(tableSuffix);
        return new PageInfo(page);
    }
}
