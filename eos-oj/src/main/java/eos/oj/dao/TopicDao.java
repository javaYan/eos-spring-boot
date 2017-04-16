package eos.oj.dao;

import eos.oj.entity.Result;
import eos.oj.entity.Topic;
import eos.oj.exception.BaseException;
import eos.oj.exception.RestCodeMessage;
import eos.oj.mongo.common.BaseMongoDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by yanyuyu on 2017/1/13.
 */
@Repository("topicDao")
public class TopicDao extends BaseMongoDaoImpl<Topic> {

    @Autowired
    @Qualifier("mongoTemplate")
    @Override
    protected void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * 校验题目的有效性
     */
    public void checkTopicAvailability(Topic topic) {
        if(topic == null) {
            throw new BaseException(RestCodeMessage.Code.RESOURCE_NOT_FOUND, RestCodeMessage.Message.RESOURCE_NOT_FOUND);
        }
        if(topic.getIsDelete()) {
            throw new BaseException(RestCodeMessage.Code.RESOURCE_IS_DELETED, RestCodeMessage.Message.RESOURCE_IS_DELETED);
        }
    }
}
