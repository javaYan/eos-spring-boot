package eos.oj.result.service.impl;

import eos.oj.exception.BaseException;
import eos.oj.exception.RestCodeMessage;
import eos.oj.result.service.ResultService;
import eos.oj.util.StringUtil;
import eos.oj.vo.ResultVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

/**
 * Created by Mr_yyy on 2017/4/16.
 * 回答结果服务类
 */
@Service("resultService")
public class ResultServiceImpl implements ResultService {
    @Override
    public ResultVo commitResult(ResultVo resultVo, String userId) {
        if(resultVo == null || StringUtil.hasEmpty(resultVo.getTopicId(), userId, resultVo.getExecutionResult().trim())) {
            throw new BaseException(RestCodeMessage.Code.BAD_REQUEST, RestCodeMessage.Message.BAD_REQUEST);
        }

        return null;
    }
}
