package eos.oj.topic.controller;

import eos.oj.common.LoginService;
import eos.oj.entity.TopicDataValidation;
import eos.oj.topic.service.TopicDataValidationService;
import eos.oj.vo.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Mr_yyy on 2017/4/16.
 * OJ TopicDataValidationController
 */
@Slf4j
@RestController
@RequestMapping("topicDataValidation")
public class TopicDataValidationController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private TopicDataValidationService topicDataValidationService;

    /**
     * 题目验证数据列表
     * @param topicId
     */
    @RequestMapping(method = RequestMethod.GET)
    public PageResult<TopicDataValidation> getList(String topicId, HttpServletRequest request) {
        String pageNumStr = request.getParameter("pageNum");
        String pageSizeStr = request.getParameter("pageSize");
        int pageNum = 0;
        int pageSize = 10;
        try {
            pageNum = Integer.parseInt(pageNumStr);
        } catch (Exception e) {
        }
        try {
            pageSize = Integer.parseInt(pageSizeStr);
        } catch (Exception e) {
        }
        return topicDataValidationService.topicDataValidationList(topicId, pageNum, pageSize);
    }

    /**
     * 题目验证数据创建
     */
    @RequestMapping(method = RequestMethod.POST)
    public TopicDataValidation post(@RequestBody TopicDataValidation vo, HttpServletRequest request) {
        return topicDataValidationService.saveTopicDataValidation(vo, loginService.getCurrentUserId(request));
    }

    /**
     * 题目验证数据删除
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(String id, HttpServletRequest request) {
        topicDataValidationService.deleteTopicDataValidation(id, loginService.getCurrentUserId(request));
    }

}