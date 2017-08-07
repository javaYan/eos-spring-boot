package eos.webview.demo.blog.service;

import eos.webview.demo.blog.dao.BlogDao;
import eos.webview.demo.blog.dao.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Title: BlogService
 * Author: yanyuyu
 * Date: 2017-08-07 10:20
 */
@Service("blogService")
public class BlogService {
    @Autowired
    private BlogDao blogDao;
    
    public List<Blog> getBlogs() {
        return blogDao.select();
    }
    
    public Blog getBlogById(long id) {
        return blogDao.selectById(id);
    }
    
    public Blog deleteById(long id) {
        return blogDao.deleteById(id);
    }
    
    public Blog updateById(Blog blog) {
        return blogDao.update(blog);
    }
    
    public Blog save() {
        Blog blog = new Blog();
        blog.setName("增加名" + new Random().nextInt(100)+100);
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        return blogDao.insert(blog);
    }
}
