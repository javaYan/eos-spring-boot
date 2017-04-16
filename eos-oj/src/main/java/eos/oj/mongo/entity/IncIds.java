package eos.springboot.db.mongo.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by yanyuyu on 2017/1/13.
 */
@ToString
@Data
public class IncIds implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -1806262397389970442L;

    private String name;

    private Long incId;
}