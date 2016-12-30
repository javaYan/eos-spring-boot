package eos.guava.eventbus.event;

import lombok.ToString;

/**
 * Created by yanyuyu on 2016/12/30.
 */
@ToString
public class LongEvent {

    private Long id;

    public LongEvent(Long id) {
        this.id = id;
    }

    public Long id() {
        return this.id;
    }
}
