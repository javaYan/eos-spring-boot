package eos.spring.utils.aop;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by yanyuyu on 2017/2/28.
 */
@ToString
@Getter
@Setter
public class DemoDto {
    public DemoDto() {}
    public DemoDto(String id,String type,int age) {
        this.id = id;
        this.type = type;
        this.age = age;
    }
    private String id;
    private String type;
    private int age;
}
