package eos.springboot.db.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


/**
 * @Description redisTemplate 配置
 * @author yanyuyu
 * @date 2016年12月19日 上午11:09:45
 */
@Configuration
public class RedisConfigForLongValue {

	@Autowired
	private RedisConnectionFactory redisConnectionFactory;
	@Bean
	RedisTemplate<String, Long> redisTemplate() {
		final RedisTemplate<String, Long> template = new RedisTemplate<String, Long>();
		template.setConnectionFactory(redisConnectionFactory);
		template.setKeySerializer(new StringRedisSerializer());
		template.setHashValueSerializer(new GenericToStringSerializer<Long>(Long.class));
		template.setValueSerializer(new GenericToStringSerializer<Long>(Long.class));
		return template;
	}
}