package eos.webview.demo.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Title: IndexController
 * Author: yanyuyu
 * Date: 2017-08-07 15:55
 */
@Controller
public class IndexController {
    
    private static final String PAGE_INDEX = "index";
    
    @RequestMapping("/index")
    public String index() {
        return PAGE_INDEX;
    }
}
