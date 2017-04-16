package eos.oj.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by Mr_yyy on 2017/4/16.
 * 公共返回vo
 */
@Setter @Getter @ToString
public class CommonResult<T> implements Serializable{
    private static final long serialVersionUID = -1850874734198486924L;
    private int code;
    private String message;
    private T data;
}
