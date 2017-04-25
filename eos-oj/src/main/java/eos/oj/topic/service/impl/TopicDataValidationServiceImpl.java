package eos.oj.topic.service.impl;

import eos.oj.dao.TopicDao;
import eos.oj.dao.TopicDataValidationDao;
import eos.oj.entity.Topic;
import eos.oj.entity.TopicDataValidation;
import eos.oj.exception.BaseException;
import eos.oj.exception.RestCodeMessage;
import eos.oj.mongo.entity.PageParam;
import eos.oj.topic.service.TopicDataValidationService;
import eos.oj.util.StringUtil;
import eos.oj.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Title: TopicDataValidationServiceImpl
 * Author: yanyuyu
 * Date: 2017-04-25 15:20
 */
@Service("topicDataValidationService")
public class TopicDataValidationServiceImpl implements TopicDataValidationService{

    @Autowired
    private TopicDataValidationDao topicDataValidationDao;

    @Autowired
    private TopicDao topicDao;


    @Override
    public PageResult<TopicDataValidation> topicDataValidationList(String topicId, Integer pageNum, Integer pageSize) {
        if(StringUtil.hasEmpty(topicId)) {
            throw new BaseException(RestCodeMessage.Code.BAD_REQUEST, RestCodeMessage.Message.BAD_REQUEST).debug("topicId不能为空");
        }
        Criteria criteria = Criteria.where("topicId").is(topicId);
        Query query = new Query(criteria);
        PageParam page = new PageParam(pageNum, pageSize);
        query.with(new Sort(Sort.Direction.DESC,"createTime"));
        List<TopicDataValidation> list = topicDataValidationDao.findPage(page, query);
        long count = topicDataValidationDao.aggregateCount(criteria);
        PageResult result = new PageResult();
        result.setPageNum(page.getPageNum());
        result.setPageSize(page.getNumPerPage());
        result.setResults(list);
        result.setCount(count);
        return result;
    }

    @Override
    public TopicDataValidation saveTopicDataValidation(TopicDataValidation vo, String userId) {
        if(StringUtil.hasEmpty(vo.getInput(), vo.getOutput(), vo.getTopicId())) {
            throw new BaseException(RestCodeMessage.Code.BAD_REQUEST, RestCodeMessage.Message.BAD_REQUEST);
        }
        Topic topic = topicDao.findById(vo.getTopicId());
        topicDao.checkTopicAvailability(topic);

        vo.setId(null);
        topicDataValidationDao.save(vo);
        return vo;
    }

    @Override
    public void deleteTopicDataValidation(String id, String userId) {
        topicDataValidationDao.deleteById(id);
    }
}
