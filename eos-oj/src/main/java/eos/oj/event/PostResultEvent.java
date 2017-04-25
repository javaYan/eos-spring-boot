package eos.oj.event;

import eos.oj.event.common.AbstractEvent;
import eos.oj.vo.ResultVo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by yanyuyu on 2016/12/30.
 */
@ToString @Getter @Setter
public class PostResultEvent extends AbstractEvent<ResultVo> {

    public PostResultEvent(String id) {
        super(id);
    }
}
