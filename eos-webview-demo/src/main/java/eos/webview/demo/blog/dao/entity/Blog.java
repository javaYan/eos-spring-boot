package eos.webview.demo.blog.dao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * Title: BlogEntity
 * Author: yanyuyu
 * Date: 2017-08-07 10:23
 */
@Getter
@Setter
@ToString
public class Blog {
    private Long id;
    private String title;
    private String contents;
    private String author;
    private Date createTime;
    private Date updateTime;
}
