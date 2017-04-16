package eos.oj.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Mr_yyy on 2017/4/16.
 * 题目entity
 */
@Setter
@Getter
@ToString
public class Topic implements Serializable{
    private static final long serialVersionUID = -6243860034070949309L;
    private String id;
    private String title; //标题
    private String description; //描述
    private String exampleInput; //样例输入
    private String exampleOutput; //样例输出
    private String userId; //创建者
    private Boolean isDelete;
    private Date createTime;
    private Date updateTime;
}
