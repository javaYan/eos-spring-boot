package eos.guava.cache.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * Created by Mr_yyy on 2016/12/31.
 */
@Getter @Setter
public class CacheVo {
    private String methodType;
    private Long spendTime;
    private String value;
    private Long size;
    private Map<String,String> valuesMap;
}
