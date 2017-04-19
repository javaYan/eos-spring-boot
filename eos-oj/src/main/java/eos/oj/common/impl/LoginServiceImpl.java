package eos.oj.common.impl;

import eos.oj.common.LoginService;
import org.springframework.stereotype.Service;

import javax.servlet.ServletRequest;
import java.util.Random;

/**
 * Title: UserService
 * Author: yanyuyu
 * Date: 2017-04-19 16:22
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService{

    @Override
    public String getCurrentUserId(ServletRequest request) {
        return new Random().nextInt(10) + "";
    }

    @Override
    public String getCurrentUsername(ServletRequest request) {
        return UserServiceImpl.usernames[new Random().nextInt(10)];
    }
}
