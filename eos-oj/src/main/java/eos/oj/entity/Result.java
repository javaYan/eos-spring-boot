package eos.oj.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Mr_yyy on 2017/4/16.
 * 回答结果entity
 */
@Setter @Getter @ToString
public class Result implements Serializable{
    private String id;
    private String topicId;
    private String commitContent;    //提交内容
    private String executionResult;  //执行结果信息
    private Integer status; //1 ：执行成功  2：执行失败
    private String userId;
    private Date createTime;
}
