package eos.springboot.db.mongo;

import eos.springboot.db.mongo.common.BaseMongoDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by yanyuyu on 2017/1/13.
 */
@Repository("demoMGDao")
public class DemoMGDao extends BaseMongoDaoImpl<DemoMG>{

    @Autowired
    @Qualifier("mongoTemplate")
    @Override
    protected void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
}
