package eos.oj.topic.service.impl;

import eos.oj.dao.ResultDao;
import eos.oj.dao.TopicDao;
import eos.oj.entity.Result;
import eos.oj.entity.Topic;
import eos.oj.enums.TopicEnum;
import eos.oj.exception.BaseException;
import eos.oj.exception.RestCodeMessage;
import eos.oj.topic.service.TopicService;
import eos.oj.vo.TopicVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
        if(StringUtils.isNotEmpty(userId)) {
            List<Result> results = resultDao.findAll(new Query(Criteria.where("topicId").is(id).and("userId").is(userId)));
            if(CollectionUtils.isEmpty(results)) {
                vo.setResultStatus(TopicEnum.UN_ANSWER_TOPIC.code);
            } else {
                for(Result result : results) {
                    if(result.getStatus().equals(TopicEnum.AC_TOPIC.code)) {
                        vo.setResultStatus(TopicEnum.AC_TOPIC.code);
                        break;
                    }
                }
                if(vo.getResultStatus() == null) {
                    vo.setResultStatus(TopicEnum.UN_AC_TOPIC.code);
                }
            }
        } else {
            vo.setResultStatus(TopicEnum.UN_ANSWER_TOPIC.code);
        }
        return vo;
    }

    @Override
    public TopicVo saveTopic(TopicVo topicVo, String userId) {
        if(topicVo == null || StringUtils.isEmpty(topicVo.getTitle()) || StringUtils.isEmpty(topicVo.getDescription())
                || StringUtils.isEmpty(userId)) {
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
        //TODO findUsernameById()
        topicVo.setUsername("admin");
        return topicVo;
    }

    @Override
    public void editTopic(TopicVo topicVo, String userId) {

    }

    @Override
    public void deleteTopic(String id, String userId) {

    }
}
