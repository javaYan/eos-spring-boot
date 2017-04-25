package eos.oj.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by Mr_yyy on 2017/4/24.
 * 题目验证entity
 */
@Getter @Setter @ToString
public class TopicDataValidation implements Serializable{
    private static final long serialVersionUID = 4610582130024899950L;
    private String id;
    private String topicId;
    private String input;
    private String output;
}
