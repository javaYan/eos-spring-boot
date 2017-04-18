package eos.oj.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * Title: PageResult
 * Author: yanyuyu
 * Date: 2017-04-18 20:48
 */
@Setter
@Getter
@ToString
public class PageResult<T> implements Serializable{
    private static final long serialVersionUID = 467664990025449092L;

    private Long count;
    private Integer pageSize;
    private Integer pageNum;
    private List<T> results;
}
