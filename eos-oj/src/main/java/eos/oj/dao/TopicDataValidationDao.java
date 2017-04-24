package eos.oj.dao;

import eos.oj.entity.TopicDataValidation;
import eos.oj.mongo.common.BaseMongoDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by yanyuyu on 2017/1/13.
 */
@Repository("topicDataValidationDao")
public class TopicDataValidationDao extends BaseMongoDaoImpl<TopicDataValidation> {

    @Autowired
    @Qualifier("mongoTemplate")
    @Override
    protected void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
}
