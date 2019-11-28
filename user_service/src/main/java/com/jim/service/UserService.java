package com.jim.service;

import com.jim.mapper.UserMapper;
import com.jim.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
public class UserService {


    @Autowired
    UserMapper userMapper;

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    public User findById(Integer id){
        try {
            Thread.sleep(new Random().nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userMapper.selectByPrimaryKey(id);
    }
    /**
     * 查询所有
     * @return
     */
    public List<User> findAll(){
        return userMapper.selectAll();
    }

    /**
     * 插入user
     * @param user
     */
    @Transactional
    public void insert(User user){
        userMapper.insert(user);
    }
}
