package eos.oj.dao;

import eos.oj.entity.Result;
import eos.oj.mongo.common.BaseMongoDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

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
}
