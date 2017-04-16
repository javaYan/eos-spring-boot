package eos.oj.topic.service;

import eos.oj.dao.ResultDao;
import eos.oj.dao.TopicDao;
import eos.oj.entity.Result;
import eos.oj.entity.Topic;
import eos.oj.enums.TopicEnum;
import eos.oj.vo.CommonResult;
import eos.oj.vo.TopicVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by Mr_yyy on 2017/4/16.
 * 题目服务类
 */
@Service("topicService")
public class TopicService {

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
}
