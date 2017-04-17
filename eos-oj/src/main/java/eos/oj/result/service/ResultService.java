package eos.oj.result.service;

import eos.oj.vo.ResultVo;

/**
 * Created by Mr_yyy on 2017/4/16.
 * 回答结果接口类
 */
public interface ResultService {

    public ResultVo commitResult(ResultVo resultVo, String userId);
}
