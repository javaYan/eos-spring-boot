package eos.oj.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Mr_yyy on 2017/4/16.
 * 用户信息entity
 */
@Setter
@Getter
@ToString
public class User implements Serializable{
    private static final long serialVersionUID = -1319212796796220764L;
    private String id;
    private String username;
    private String password;
    private Date createTime;
    private Date updateTime;
    private Date lastLoginTime;
}
