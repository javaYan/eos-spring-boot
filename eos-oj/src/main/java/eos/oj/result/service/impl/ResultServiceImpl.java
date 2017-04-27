package eos.oj.result.service.impl;

import eos.oj.common.UserService;
import eos.oj.dao.ResultDao;
import eos.oj.entity.Result;
import eos.oj.enums.ResultStatusEnum;
import eos.oj.event.OjEngine;
import eos.oj.event.PostResultEvent;
import eos.oj.event.common.EventDispatcher;
import eos.oj.exception.BaseException;
import eos.oj.exception.RestCodeMessage;
import eos.oj.result.service.ResultService;
import eos.oj.util.StringUtil;
import eos.oj.vo.ResultVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Mr_yyy on 2017/4/16.
 * 回答结果服务类
 */
@Service("resultService")
public class ResultServiceImpl implements ResultService {
    @Autowired
    private ResultDao resultDao;

    @Autowired
    private UserService userService;

    @Autowired
    private EventDispatcher eventDispatcher;

    @Autowired
    private OjEngine ojEngine;

    @Override
    public ResultVo commitResult(ResultVo resultVo, String userId) {
        if(resultVo == null || StringUtil.hasEmpty(resultVo.getTopicId(), resultVo.getCommitContent(),userId)) {
            throw new BaseException(RestCodeMessage.Code.BAD_REQUEST, RestCodeMessage.Message.BAD_REQUEST);
        }
        //保存提交信息
        Result result = new Result();
        BeanUtils.copyProperties(resultVo, result);
        result.setId(null);
        Date currentDate = new Date();
        result.setCreateTime(currentDate);
        result.setStatus(ResultStatusEnum.WAITING.code);
        result.setUserId(userId);
        resultDao.save(result);

        //发布事件 触发OJ引擎的执行
        resultVo.setId(result.getId());
        resultVo.setStatus(ResultStatusEnum.WAITING.code);
        resultVo.setUsername(userService.getUsername(userId));
        resultVo.setCreateTime(currentDate);
        PostResultEvent event = new PostResultEvent(result.getId());
        event.setData(resultVo);
        eventDispatcher.publish(event);
        return resultVo;
    }
}
