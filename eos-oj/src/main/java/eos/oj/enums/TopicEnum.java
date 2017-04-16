package eos.oj.enums;

/**
 * Created by Mr_yyy on 2017/4/16.
 * 题目枚举类
 */
public enum TopicEnum {

    UN_ANSWER_TOPIC(0), //未作答的题目
    AC_TOPIC(1),        //已通过的题目
    UN_AC_TOPIC(2);     //未通过的题目
    public int code;
    TopicEnum(int code) {
        this.code = code;
    }
}
