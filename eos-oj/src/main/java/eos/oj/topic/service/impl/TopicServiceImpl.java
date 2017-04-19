package eos.oj.topic.service.impl;

import eos.oj.common.UserService;
import eos.oj.dao.ResultDao;
import eos.oj.dao.TopicDao;
import eos.oj.entity.Topic;
import eos.oj.enums.TopicEnum;
import eos.oj.exception.BaseException;
import eos.oj.exception.RestCodeMessage;
import eos.oj.mongo.entity.PageParam;
import eos.oj.topic.service.TopicService;
import eos.oj.util.StringUtil;
import eos.oj.vo.PageResult;
import eos.oj.vo.TopicVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Mr_yyy on 2017/4/16.
 * 题目服务类
 */
@Service("topicService")
public class TopicServiceImpl implements TopicService{

    @Autowired
    private TopicDao topicDao;

    @Autowired
    private ResultDao resultDao;

    @Autowired
    private UserService userService;

    /**
     * 题目详情
     * @param id
     * @param userId
     * @return
     */
    public TopicVo topicDetail(String id, String userId) {
        Topic topic = topicDao.findById(id);
        topicDao.checkTopicAvailability(topic);
        TopicVo vo = new TopicVo();
        BeanUtils.copyProperties(topic,vo);
        vo.setResultStatus(resultDao.findResultStatusByTopicId(id,userId));
        vo.setUsername(userService.getUsername(topic.getUserId()));
        return vo;
    }

    @Override
    public TopicVo saveTopic(TopicVo topicVo, String userId) {
        if(topicVo == null || StringUtil.hasEmpty(topicVo.getTitle(),topicVo.getDescription(),userId)) {
            throw new BaseException(RestCodeMessage.Code.BAD_REQUEST, RestCodeMessage.Message.BAD_REQUEST);
        }
        Topic topic = new Topic();
        BeanUtils.copyProperties(topicVo, topic);
        Date currentTime = new Date();
        topic.setId(null);
        topic.setUserId(userId);
        topic.setIsDelete(false);
        topic.setCreateTime(currentTime);
        topic.setUpdateTime(currentTime);
        topicDao.save(topic);

        BeanUtils.copyProperties(topic,topicVo);
        topicVo.setResultStatus(TopicEnum.UN_ANSWER_TOPIC.code);
        topicVo.setUsername(userService.getUsername(userId));
        return topicVo;
    }

    @Override
    public void editTopic(TopicVo topicVo, String userId) {
        if(topicVo == null || StringUtil.hasEmpty(topicVo.getId(),userId)) {
            throw new BaseException(RestCodeMessage.Code.BAD_REQUEST, RestCodeMessage.Message.BAD_REQUEST);
        }
        //校验当前操作用户是否是题目创建者
        Topic topic = topicDao.findById(topicVo.getId());
        topicDao.checkTopicAvailability(topic);
        if(! userId.equals(topic.getUserId())) {
            throw new BaseException(RestCodeMessage.Code.UNAUTHORIZED, RestCodeMessage.Message.UNAUTHORIZED);
        }

        Update updateSet = new Update();
        if(StringUtil.isNotEmpty(topicVo.getDescription())) {
            updateSet.set("description", topicVo.getDescription());
        }
        if(StringUtil.isNotEmpty(topicVo.getExampleInput())) {
            updateSet.set("exampleInput", topicVo.getExampleInput());
        }
        if(StringUtil.isNotEmpty(topicVo.getExampleOutput())) {
            updateSet.set("exampleOutput", topicVo.getExampleOutput());
        }
        if(StringUtil.isNotEmpty(topicVo.getLevel())) {
            updateSet.set("level", topicVo.getLevel());
        }
        if(StringUtil.isNotEmpty(topicVo.getTitle())) {
            updateSet.set("title", topicVo.getTitle());
        }
        topicDao.updateById(topicVo.getId(), updateSet);
    }

    @Override
    public void deleteTopic(String id, String userId) {
        if(StringUtil.hasEmpty(id,userId)) {
            throw new BaseException(RestCodeMessage.Code.BAD_REQUEST, RestCodeMessage.Message.BAD_REQUEST);
        }

        Topic topic = topicDao.findById(id);
        topicDao.checkTopicAvailability(topic);
        if(! userId.equals(topic.getUserId())) {
            throw new BaseException(RestCodeMessage.Code.UNAUTHORIZED, RestCodeMessage.Message.UNAUTHORIZED);
        }

        topicDao.updateById(id, new Update().set("isDelete", true));
    }

    @Override
    public PageResult<TopicVo> topics(TopicVo vo, Integer pageNum, Integer pageSize, String userId) {
        Query query = new Query();
        Criteria criteria = new Criteria().where("isDelete").is(false);
        if(vo != null) {
            if(StringUtil.isNotEmpty(vo.getTitle())) {
                criteria.and("title").regex(vo.getTitle());
            }
            if(StringUtil.isNotEmpty(vo.getUserId())) {
                criteria.and("userId").is(vo.getUserId());
            }
        }
        PageParam page = new PageParam(pageNum, pageSize);
        query.addCriteria(criteria);
        query.with(new Sort(Sort.Direction.DESC,"createTime"));
        List<Topic> topics = topicDao.findPage(page, query);
        Long count = topicDao.aggregateCount(criteria);
        List<TopicVo> topicVoList = new ArrayList<TopicVo>();
        for(Topic topic : topics) {
            TopicVo tVo = new TopicVo();
            BeanUtils.copyProperties(topic, tVo);
            tVo.setResultStatus(resultDao.findResultStatusByTopicId(topic.getId(),userId));
            tVo.setUsername(userService.getUsername(topic.getUserId()));
            topicVoList.add(tVo);
        }

        PageResult result = new PageResult();
        result.setPageNum(page.getPageNum());
        result.setPageSize(page.getNumPerPage());
        result.setResults(topicVoList);
        result.setCount(count);
        return result;
    }
}
