package eos.oj.result.controller;

import eos.oj.result.service.ResultService;
import eos.oj.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Mr_yyy on 2017/4/16.
 * OJ Result
 */
@Slf4j
@RestController
@RequestMapping("result")
public class ResultController {

    @Autowired
    private ResultService resultService;

    /**
     * 提交答案并开启编译运行测试
     */
    public ResultVo put(ResultVo resultVo, HttpServletRequest request) {

        return resultVo;
    }

}