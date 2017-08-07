package eos.webview.demo.blog.controller;

import eos.webview.demo.blog.dao.entity.Blog;
import eos.webview.demo.blog.service.BlogService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Title: BlogController
 * Author: yanyuyu
 * Date: 2017-08-07 10:19
 */
@Controller
@RequestMapping("blog")
public class BlogController {
    
    @Autowired
    private BlogService blogService;
    
    private static final String PAGE_BLOG_LIST = "blog/blog_list";
    private static final String PAGE_BLOG_LIST_TABLE = "blog/blog_list_table";
    private static final String PAGE_BLOG_DETAIL = "blog/blog_detail";

    /**
     * 跳转方式查看blogs
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String list(Model model) {
        List<Blog> blogs = blogService.getBlogs();
        model.addAttribute("blogs",blogs);
        return PAGE_BLOG_LIST;
    }

    @RequestMapping("/initListTable")
    public String initListTable(HttpServletRequest request) {
        return PAGE_BLOG_LIST_TABLE;
    }
    /**
     * 表格方式查看blogs
     * @param request
     * @return
     */
    @RequestMapping("/listTable")
    public List<Blog> listTable(HttpServletRequest request) {
        List<Blog> blogs = blogService.getBlogs();
        return blogs;
    }

    /**
     * 详情
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable long id, Model model) {
        if( id == 0L ) {
            return PAGE_BLOG_DETAIL;
        }
        Blog blog = blogService.getBlogById(id);

        model.addAttribute("blog",blog);
        return PAGE_BLOG_DETAIL;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        Blog blog = blogService.getBlogById(id);
        if(blog == null) {
            return PAGE_BLOG_LIST_TABLE;
        }
        blogService.deleteById(id);
        return PAGE_BLOG_LIST_TABLE;
    }

    /**
     * 更新
     * @param request
     * @return
     */
    @RequestMapping("/update")
    public String update(HttpServletRequest request) {
        String parameterId = request.getParameter("id");
        if(StringUtils.isEmpty(parameterId)) {
            return PAGE_BLOG_LIST_TABLE;
        }
        long id = Long.parseLong(parameterId);
        Blog blog = blogService.getBlogById(id);
        blog.setName("更新名" + new Random().nextInt(100)+10);
        blog.setUpdateTime(new Date());
        blogService.updateById(blog);
        return PAGE_BLOG_LIST_TABLE;
    }
    
    @RequestMapping("/create")
    public String create() {
        blogService.save();
        return PAGE_BLOG_LIST_TABLE;
    }
    
}
