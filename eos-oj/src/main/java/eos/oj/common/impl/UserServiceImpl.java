package eos.oj.common.impl;

import eos.oj.common.UserService;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Title: UserServiceImpl
 * Author: yanyuyu
 * Date: 2017-04-19 16:22
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    public static final String [] usernames = {"张三","李四","王二","小李子","言莫","张小小","蒙牛","赵大头","李丽","刘大"};
    @Override
    public String getUsername(String id) {
        return usernames[new Random().nextInt(10)];
    }
}
