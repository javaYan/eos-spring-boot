package common.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Title: Student
 * Author: yanyuyu
 * Date: 2017-09-24 14:34
 */
@ToString
@Getter
@Setter
public class Student {
    private Long id;
    private String name;
    private String number;
    private Integer sex;
}
