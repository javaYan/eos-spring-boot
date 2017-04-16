package eos.oj.result.controller;

import eos.oj.result.service.ResultService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Mr_yyy on 2017/4/16.
 * OJ Result
 */
@Slf4j
@RestController
@RequestMapping("result")
public class ResultController {

    @Autowired
    private ResultService topicService;

}
