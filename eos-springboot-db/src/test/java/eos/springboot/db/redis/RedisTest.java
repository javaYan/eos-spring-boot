package eos.springboot.db.redis;

import eos.springboot.db.DBApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.export.MetricExportProperties;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yanyuyu on 2017/1/13.
 */
@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=DBApplication.class)
public class RedisTest {
    @Autowired
    private RedisTemplate<String,Long> redisTemplateForLong;

    @Autowired
    private RedisTemplate<String,String> redisTemplateForString;

    private final String str_key = "eos:str";
    private final String long_key = "eos:long";
    private final String set_key = "eos:set";

    @Test
    public void testSave() {
        redisTemplateForLong.opsForValue().set(long_key, 111L);

        redisTemplateForLong.opsForSet().add(set_key, 7L);

        redisTemplateForString.opsForValue().set(str_key, "haha");
    }

    @Test
    public void testGet() {
        Long aLong = redisTemplateForLong.opsForValue().get(long_key);

        Boolean ismember = redisTemplateForLong.opsForSet().isMember(set_key, 7L);

        String s = redisTemplateForString.opsForValue().get(str_key);

        System.out.println(aLong + "," + ismember + "," + s);
    }
}
