package eos.springboot.db.mongo.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by yanyuyu on 2017/3/10.
 */
@ToString
@Getter @Setter
public class AggregationCount {
    private Object id;
    private Long total;
}
