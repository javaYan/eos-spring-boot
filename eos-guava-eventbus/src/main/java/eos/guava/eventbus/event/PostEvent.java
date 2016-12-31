package eos.guava.eventbus.event;

import eos.guava.eventbus.common.AbstractEvent;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Mr_yyy on 2016/12/31.
 */
@ToString @Getter @Setter
public class PostEvent extends AbstractEvent<String> {
    public PostEvent(String id) {
        super(id);
    }
}
