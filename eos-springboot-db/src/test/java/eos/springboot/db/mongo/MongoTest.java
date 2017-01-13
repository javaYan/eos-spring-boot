package eos.springboot.db.mongo;

import eos.springboot.db.DBApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by yanyuyu on 2017/1/13.
 */
@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=DBApplication.class)
public class MongoTest {


    @Autowired
    private DemoMGDao demoMGDao;

    @Test
    public void testSave() {
        DemoMG mg = new DemoMG();
        for(int i = 0 ; i < 10; i ++) {
            mg.setName("name_"+ i);
            mg.setFlag(i*i);
            mg.setId(demoMGDao.getNewId("demoMG"));
            demoMGDao.save(mg);
        }
    }

    @Test
    public void testSelect() {
        List<DemoMG> list = demoMGDao.findAll(new Query(Criteria.where("flag").gt(9)));
        if(list != null && list.size() > 0) {
            for(DemoMG demo : list) {
                System.out.println(demo.toString());
            }
        }
    }
}
