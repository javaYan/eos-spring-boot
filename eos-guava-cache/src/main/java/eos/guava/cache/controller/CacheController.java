package eos.guava.cache.controller;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import eos.guava.cache.vo.CacheVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * Created by Mr_yyy on 2016/12/31.
 */
@RestController("cache")
public class CacheController {

    private static Logger log = LoggerFactory.getLogger(CacheController.class);

    private static LoadingCache<String, String> caches = CacheBuilder.newBuilder()
            .maximumSize(5L)                                    //设置缓存最大存储
            .expireAfterWrite(20000L, TimeUnit.MILLISECONDS)    //设置key的失效时间
            .build(new CacheLoader<String, String>() {
                public String load(String key) throws Exception {
                    String cacheValue = "cacheValue_" + key;
                    Thread.sleep(1000L);
                    return cacheValue;
                }
            });

    @RequestMapping(method = RequestMethod.GET)
    public CacheVo doGet(@RequestParam(name = "key") String key) {
        long startTime = System.currentTimeMillis();
        String value = null;
        try {
            value = caches.get(key);
        } catch (Exception e) {
            log.error("get value from loadingCache error", e);
        }

        long endTime = System.currentTimeMillis();

        CacheVo vo = new CacheVo();
        vo.setValue(value);
        vo.setMethodType("GET");
        vo.setSpendTime(endTime-startTime);
        vo.setSize(caches.size());
        vo.setValuesMap(caches.asMap());
        return vo;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public CacheVo doDelete() {
        long startTime = System.currentTimeMillis();
        caches.invalidateAll();
        long endTime = System.currentTimeMillis();
        CacheVo vo = new CacheVo();
        vo.setMethodType("DELETE");
        vo.setSpendTime(endTime-startTime);
        vo.setSize(caches.size());
        vo.setValuesMap(caches.asMap());
        return vo;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public CacheVo doPut(@RequestParam(name="key") String key) {
        CacheVo vo = new CacheVo();
        long startTime = System.currentTimeMillis();
        caches.refresh(key);
        long endTime = System.currentTimeMillis();
        vo.setMethodType("PUT");
        vo.setSpendTime(endTime-startTime);
        vo.setSize(caches.size());
        vo.setValuesMap(caches.asMap());
        return vo;
    }


}
