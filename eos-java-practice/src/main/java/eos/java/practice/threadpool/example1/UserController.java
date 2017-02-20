package eos.java.practice.threadpool.example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Mr_yyy on 2017/2/20.
 */
@RestController
@RequestMapping("threadPool")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "users" , method = RequestMethod.GET)
    public List<UserVo> doGet(int count) {

        /******* 创建测试数据 ********/
        List<Long> userIds = new ArrayList<Long>();
        for(int i=0; i <count; i++) {
            userIds.add(i, Long.valueOf(i));
        }

        /******* 执行批处理 *********/
        Map<Long, UserVo> usersMap = userService.batchExecute(userIds);
        List<UserVo> userList = new ArrayList<UserVo>(usersMap.values());
        return userList;

    }
}
