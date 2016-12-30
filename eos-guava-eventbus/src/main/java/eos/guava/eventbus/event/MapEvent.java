package eos.guava.eventbus.event;

import lombok.ToString;

import java.util.Map;

/**
 * Created by yanyuyu on 2016/12/30.
 */
@ToString
public class MapEvent {

    private Map<String,Object> data;

    public MapEvent(Map<String,Object> data) {
        this.data = data;
    }
}
