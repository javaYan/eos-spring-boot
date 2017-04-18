package eos.oj.dao;

import eos.oj.entity.Result;
import eos.oj.enums.ResultStatusEnum;
import eos.oj.enums.TopicEnum;
import eos.oj.mongo.common.BaseMongoDaoImpl;
import eos.oj.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by yanyuyu on 2017/1/13.
 */
@Repository("resultDao")
public class ResultDao extends BaseMongoDaoImpl<Result> {

    @Autowired
    @Qualifier("mongoTemplate")
    @Override
    protected void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public int findResultStatusByTopicId(String topicId, String userId) {
        if(!StringUtil.isNotEmpty(userId)) {
            return TopicEnum.UN_ANSWER_TOPIC.code;
        }
        List<Result> results = this.findAll(new Query(Criteria.where("topicId").is(topicId).and("userId").is(userId)));
        if(CollectionUtils.isEmpty(results)) {
            return TopicEnum.UN_ANSWER_TOPIC.code;
        } else {
            for(Result result : results) {
                if(result.getStatus().equals(ResultStatusEnum.AC.code)) {
                    return TopicEnum.AC_TOPIC.code;
                }
            }
            return TopicEnum.UN_AC_TOPIC.code;
        }
    }
}
