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
    private static final long serialVersionUID = 3082354041812195621L;
    private String id;
    private String topicId;
    private String commitContent;    //提交内容
    private String executionResult;  //执行结果信息
    private Integer status; //-1：等待 0 ：已通过  1：编译失败  2：运行时异常  3：结果错误
    private String userId;
    private Date createTime;
    private Long costTime; //花费时间 ms
}
