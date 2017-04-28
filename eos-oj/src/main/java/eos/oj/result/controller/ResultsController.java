package eos.oj.result.controller;

import eos.oj.common.LoginService;
import eos.oj.result.service.ResultService;
import eos.oj.util.StringUtil;
import eos.oj.vo.PageResult;
import eos.oj.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Mr_yyy on 2017/4/16.
 * OJ Result
 */
@Slf4j
@RestController
@RequestMapping("results")
public class ResultsController {

    @Autowired
    private ResultService resultService;

    @Autowired
    private LoginService loginService;

    /**
     * 提交结果列表
     */
    @RequestMapping(method = RequestMethod.GET)
    public PageResult<ResultVo> results(HttpServletRequest request) {
        ResultVo resultVo = new ResultVo();
        String topicId = request.getParameter("topicId");
        String status = request.getParameter("status");
        String userId = request.getParameter("userId");
        resultVo.setTopicId(topicId);
        if(StringUtil.isNotEmpty(status)) {
            resultVo.setStatus(Integer.parseInt(status));
        }
        resultVo.setUserId(userId);
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
        return resultService.results(resultVo,pageNum,pageSize);
    }

}