package eos.oj.result.service;

import eos.oj.dao.ResultDao;
import eos.oj.dao.TopicDao;
import eos.oj.entity.Result;
import eos.oj.entity.Topic;
import eos.oj.enums.TopicEnum;
import eos.oj.vo.TopicVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by Mr_yyy on 2017/4/16.
 * 回答结果服务类
 */
@Service("resultService")
public class ResultService {


}
