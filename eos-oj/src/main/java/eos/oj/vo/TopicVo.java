package eos.oj.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Mr_yyy on 2017/4/16.
 * 题目vo
 */
@Setter
@Getter
@ToString
public class TopicVo implements Serializable{
    private String id;
    private String title; //标题
    private String description; //描述
    private String exampleInput; //样例输入
    private String exampleOutput; //样例输出
    private String userId; //创建者
    private Integer resultStatus; //当前登陆者的回答状态：0未作答 1通过 2未通过
    private Boolean isDelete;
    private String username;
    private Date createTime;
    private Date updateTime;
}
