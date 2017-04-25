package eos.oj.topic.controller;

import eos.oj.common.LoginService;
import eos.oj.topic.service.TopicService;
import eos.oj.vo.TopicVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Mr_yyy on 2017/4/16.
 * OJ Topic
 */
@Slf4j
@RestController
@RequestMapping("topic")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @Autowired
    private LoginService loginService;
    /**
     * 题目详情
     * @param id
     * @param request
     */
    @RequestMapping(method = RequestMethod.GET)
    public TopicVo get(String id, HttpServletRequest request) {
        String currentUserId = loginService.getCurrentUserId(request);
        return topicService.topicDetail(id, currentUserId);
    }

    /**
     * 题目创建
     */
    @RequestMapping(method = RequestMethod.POST)
    public TopicVo post(@RequestBody TopicVo vo, HttpServletRequest request) {
        return topicService.saveTopic(vo, loginService.getCurrentUserId(request));
    }

    /**
     * 题目删除
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public void delete() {

    }

    /**
     * 题目修改
     */
    @RequestMapping(method = RequestMethod.PUT)
    public void put() {

    }
}