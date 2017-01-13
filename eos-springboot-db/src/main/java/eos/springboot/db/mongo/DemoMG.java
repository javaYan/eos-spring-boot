package eos.springboot.db.mongo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by yanyuyu on 2017/1/13.
 */
@Document
@Getter @Setter
@ToString
public class DemoMG {
    private String id;
    private String name;
    private Integer flag;
}
