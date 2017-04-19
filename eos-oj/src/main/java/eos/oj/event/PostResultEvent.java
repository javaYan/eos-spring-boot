package eos.oj.event;

import eos.oj.event.common.AbstractEvent;
import lombok.ToString;

/**
 * Created by yanyuyu on 2016/12/30.
 */
@ToString
public class PostResultEvent<ResultVo> extends AbstractEvent {

    public PostResultEvent(String id) {
        super(id);
    }
}
