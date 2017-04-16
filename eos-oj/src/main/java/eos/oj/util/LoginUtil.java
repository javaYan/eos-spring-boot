package eos.oj.util;

import eos.oj.entity.User;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Mr_yyy on 2017/4/16.
 */
@Slf4j
public class LoginUtil {
    /**
     * 得到当前登陆者信息
     * @param request
     * @return
     */
    public static User getCurrentUser(HttpServletRequest request) {
        User user = null;
        try {
            user = (User) request.getSession().getAttribute("user");
        } catch (Exception e) {
            log.error("current user is null!");
        }
        return user;
    }

    /**
     * 得到当前登陆者ID
     * @param request
     * @return
     */
    public static String getCurrentUserId(HttpServletRequest request) {
        try {
            return ((User) request.getSession().getAttribute("user")).getId();
        } catch (Exception e) {
            log.error("current user is null!");
        }
        return "";
    }
}
