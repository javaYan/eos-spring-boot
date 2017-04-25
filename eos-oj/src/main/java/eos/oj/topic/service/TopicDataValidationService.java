package eos.oj.topic.service;

import eos.oj.entity.TopicDataValidation;
import eos.oj.vo.PageResult;

/**
 * Created by Mr_yyy on 2017/4/16.
 * 题目验证数据接口类
 */
public interface TopicDataValidationService {

    /**
     * 题目验证数据列表
     * @param topicId
     * @return
     */
    public PageResult<TopicDataValidation> topicDataValidationList(String topicId, Integer pageNum, Integer pageSize);

    /**
     * 题目验证数据创建
     * @param vo
     * @param userId
     * @return
     */
    public TopicDataValidation saveTopicDataValidation(TopicDataValidation vo, String userId);


    /**
     * 题目验证数据删除
     * @param id
     * @param userId
     */
    public void deleteTopicDataValidation(String id, String userId);
}
