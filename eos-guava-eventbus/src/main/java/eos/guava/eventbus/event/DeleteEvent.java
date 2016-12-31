package eos.guava.eventbus.event;

import lombok.ToString;

/**
 * Created by yanyuyu on 2016/12/30.
 */
@ToString
public class DeleteEvent {

    private Long id;

    public DeleteEvent(Long id) {
        this.id = id;
    }

    public Long id() {
        return this.id;
    }
}
