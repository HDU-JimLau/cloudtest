package com.jim.fallback;

import com.jim.client.UserFeignClient;
import com.jim.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserFeignClientFallback implements UserFeignClient{
    @Override
    public User findById(Integer id) {
        User user = new User();
        user.setId(id);
        user.setName("用户查询出现异常！");
        return user;
    }
}
