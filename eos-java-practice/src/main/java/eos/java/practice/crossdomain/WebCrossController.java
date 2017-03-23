package eos.java.practice.crossdomain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanyuyu on 2017/1/11.
 */
@Controller
public class WebCrossController {

    /**
     * json:  {"result":"aaa"}
     * jsonp:  data({"result":"aaa"})
     * 注意服务端的返回数据格式
     * @return
     */
    @RequestMapping(value="/webCross", method=RequestMethod.GET)
    public String noCrossWeb() {
        return "/crossdomain/cross-domain";
    }
}
