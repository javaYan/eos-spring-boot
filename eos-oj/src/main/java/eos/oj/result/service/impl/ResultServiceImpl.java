package eos.oj.result.service.impl;

import eos.oj.common.UserService;
import eos.oj.dao.ResultDao;
import eos.oj.dao.TopicDao;
import eos.oj.entity.Result;
import eos.oj.entity.Topic;
import eos.oj.enums.ResultStatusEnum;
import eos.oj.event.OjEngine;
import eos.oj.event.PostResultEvent;
import eos.oj.event.common.EventDispatcher;
import eos.oj.exception.BaseException;
import eos.oj.exception.RestCodeMessage;
import eos.oj.mongo.entity.PageParam;
import eos.oj.result.service.ResultService;
import eos.oj.util.StringUtil;
import eos.oj.vo.PageResult;
import eos.oj.vo.ResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private TopicDao topicDao;

    @Autowired
    private OjEngine ojEngine;

    @Override
    public ResultVo commitResult(ResultVo resultVo, String userId) {
        if(resultVo == null || StringUtil.hasEmpty(resultVo.getTopicId(), resultVo.getCommitContent(),userId)) {
            throw new BaseException(RestCodeMessage.Code.BAD_REQUEST, RestCodeMessage.Message.BAD_REQUEST);
        }

        Topic topic = topicDao.findById(resultVo.getTopicId());
        topicDao.checkTopicAvailability(topic);

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
        resultVo.setTopicTitle(topic.getTitle());
        PostResultEvent event = new PostResultEvent(result.getId());
        event.setData(resultVo);
        eventDispatcher.publish(event);
        return resultVo;
    }

    @Override
    public ResultVo detail(String id, String userId) {
        if(StringUtil.hasEmpty(id, userId)) {
            throw new BaseException(RestCodeMessage.Code.BAD_REQUEST, RestCodeMessage.Message.BAD_REQUEST);
        }
        Result result = resultDao.findOne(new Query(Criteria.where("id").is(id).and("userId").is(userId)));
        if(result == null) {
            throw new BaseException(RestCodeMessage.Code.RESOURCE_NOT_FOUND, RestCodeMessage.Message.RESOURCE_NOT_FOUND);
        }

        ResultVo vo = new ResultVo();
        BeanUtils.copyProperties(result, vo);
        return vo;
    }

    @Override
    public PageResult<ResultVo> results(ResultVo vo, Integer pageNum, Integer pageSize) {
        Query query = new Query();
        Criteria criteria = new Criteria();
        if(vo != null) {
            if(StringUtil.isNotEmpty(vo.getTopicId())) {
                criteria.and("topicId").is(vo.getTopicId());
            }
            if(StringUtil.isNotEmpty(vo.getUserId())) {
                criteria.and("userId").is(vo.getUserId());
            }
            if(vo.getStatus() != null) {
                criteria.and("status").is(vo.getStatus());
            }
        }
        PageParam page = new PageParam(pageNum, pageSize);
        query.addCriteria(criteria);
        query.with(new Sort(Sort.Direction.DESC,"createTime"));
        List<Result> results = resultDao.findPage(page, query);
        Long count = resultDao.aggregateCount(criteria);
        List<ResultVo> resultVoList = new ArrayList<ResultVo>();
        for(Result result : results) {
            ResultVo rVo = new ResultVo();
            BeanUtils.copyProperties(result, rVo);
            rVo.setCommitContent(null); //不展示提交内容
            rVo.setExecutionResult(null); //不展示文字描述的执行结果
            rVo.setUsername(userService.getUsername(result.getUserId()));
            resultVoList.add(rVo);
        }

        PageResult result = new PageResult();
        result.setPageNum(page.getPageNum());
        result.setPageSize(page.getNumPerPage());
        result.setResults(resultVoList);
        result.setCount(count);
        return result;
    }
}
