package eos.oj.common;

import javax.servlet.ServletRequest;

/**
 * Title: UserService
 * Author: yanyuyu
 * Date: 2017-04-19 16:22
 */
public interface LoginService {

    public String getCurrentUserId(ServletRequest request);

    public String getCurrentUsername(ServletRequest request);
}
