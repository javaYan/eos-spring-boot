package eos.oj.topic.service;

import eos.oj.vo.TopicVo;

/**
 * Created by Mr_yyy on 2017/4/16.
 * 题目接口类
 */
public interface TopicService {

    /**
     * 题目详情
     * @param id
     * @param userId
     * @return
     */
    public TopicVo topicDetail(String id, String userId);

    /**
     * 题目创建
     * @param topicVo
     * @return
     */
    public TopicVo saveTopic(TopicVo topicVo,String userId);

    /**
     * 题目修改
     * @param topicVo
     */
    public void editTopic(TopicVo topicVo,String userId);

    /**
     * 题目删除
     * @param id
     * @param userId
     */
    public void deleteTopic(String id,String userId);
}
