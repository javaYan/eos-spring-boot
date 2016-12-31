package eos.guava.eventbus.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Mr_yyy on 2016/12/31.
 */
@Getter @Setter @ToString
public abstract class AbstractEvent<T> {
    private String id;
    private T data;

    public AbstractEvent(String id) {
        this.id = id;
    }
}
