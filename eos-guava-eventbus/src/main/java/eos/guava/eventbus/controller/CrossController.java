package eos.guava.eventbus.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 跨域请求测试
 * 如果查看到请忽略此处代码
 * Created by yanyuyu on 2017/1/11.
 */
@RestController
public class CrossController {

    @RequestMapping(value="cross",method=RequestMethod.GET)
    public Map<String,Object> doGet(HttpServletResponse response) {  //这种方式只有chrome支持 返回json类型数据

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("result","cross_result"+new Date().getTime());

        response.setHeader("Access-Control-Allow-Origin","*"); //允许所有跨域
        //response.setHeader("Access-Control-Allow-Origin","http://127.0.0.1:8590"); //允许某一域名访问（前提是界面以127.0.0.1访问而非localhost）
        return map;
    }

}
