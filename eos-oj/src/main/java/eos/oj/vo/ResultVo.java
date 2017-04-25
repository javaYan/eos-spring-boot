package eos.oj.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Mr_yyy on 2017/4/16.
 * 回答结果vo
 */
@Setter @Getter @ToString
public class ResultVo implements Serializable{
    private static final long serialVersionUID = 8994649446755668320L;
    private String id;
    private String topicId;
    private String commitContent;    //提交内容
    private String executionResult;  //执行结果信息
    private Integer status; //-2：正在编译 -1：正在运行 0 ：已通过  1：编译失败  2：运行时异常  3：结果错误
    private String userId;
    private String username;
    private Date createTime;
    private Long costTime; //花费时间 ms
}
