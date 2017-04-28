package eos.oj.topic.controller;

import eos.oj.common.LoginService;
import eos.oj.topic.service.TopicService;
import eos.oj.vo.PageResult;
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
@RequestMapping("topics")
public class TopicsController {

    @Autowired
    private TopicService topicService;

    @Autowired
    private LoginService loginService;
    /**
     * 题目列表
     * @param request
     */
    @RequestMapping(method = RequestMethod.GET)
    public PageResult<TopicVo> list(HttpServletRequest request) {
        TopicVo vo = new TopicVo();
        String title = request.getParameter("title");
        vo.setTitle(title);

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
        return topicService.topics(vo,pageNum,pageSize, loginService.getCurrentUserId(request));
    }


}