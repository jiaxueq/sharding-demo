package com.example.shardingdemo.mapper;

import com.example.shardingdemo.entity.User;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User getUser(int id,String tableSuffix);

    Long addUser(User user);

    List<User> queryAllUser(String tableSuffix);

    User queryUserById(Long id,String tableSuffix);

    Page<User> querUserByPage(String tableSuffix);
}
