package eos.oj.topic.controller;

import eos.oj.entity.Topic;
import eos.oj.topic.service.TopicService;
import eos.oj.util.LoginUtil;
import eos.oj.vo.CommonResult;
import eos.oj.vo.TopicVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
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
    /**
     * 题目详情
     * @param id
     */
    @RequestMapping(method = RequestMethod.GET)
    public TopicVo get(String id, HttpServletRequest request) {
        String currentUserId = LoginUtil.getCurrentUserId(request);
        try {
            return topicService.topicDetail(id, currentUserId);
        } catch (Exception e) {
            log.error("TopicController.get error:{},{}", id, currentUserId, e);
        }
        return null;
    }

    /**
     * 题目创建
     */
    @RequestMapping(method = RequestMethod.POST)
    public void post() {

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
