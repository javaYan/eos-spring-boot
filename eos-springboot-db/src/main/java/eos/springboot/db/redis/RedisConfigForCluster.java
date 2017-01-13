package eos.springboot.db.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanyuyu on 2017/1/13.
 */
@Configuration
public class RedisConfigForCluster {
    @Value("${spring.redis.cluster.nodes}")
    private String redisServers;

    @Bean
    public RedisConnectionFactory connectionFactory()
    {
        return new JedisConnectionFactory(new RedisClusterConfiguration(getClusterNodes()));
    }

    protected List<String> getClusterNodes() {
        if ((this.redisServers != null) && (this.redisServers.length() != 0)) {
            List jedisClusterNodes = new ArrayList();
            String[] addressArray = this.redisServers.split(",");
            for (String address : addressArray) {
                jedisClusterNodes.add(address);
            }
            return jedisClusterNodes;
        }
        throw new IllegalArgumentException("spring.redis.cluster.nodes is null ");
    }
}
