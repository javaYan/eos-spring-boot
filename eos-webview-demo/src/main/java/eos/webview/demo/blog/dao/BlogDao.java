package eos.webview.demo.blog.dao;

import eos.webview.demo.blog.dao.entity.Blog;
import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Title: BlogDao
 * Author: yanyuyu
 * Date: 2017-08-07 10:31
 */
@Repository("blogDao")
public class BlogDao {
    
    private static Logger logger = LoggerFactory.getLogger(BlogDao.class);
    
    //模拟数据库操作
    private static Map<Long, Blog> BLOGS = new HashMap<Long, Blog>();
    static {
        Blog blog = null;
        for(long i = 1; i <= 10; i ++ ) {
            blog = new Blog();
            blog.setId(new Date().getTime());
            blog.setName("博客名"+ i);
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.DAY_OF_MONTH, (int)(10-i));
            blog.setCreateTime(cal.getTime());
            blog.setUpdateTime(new Date());
            BLOGS.put(blog.getId(), blog);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                logger.error("初始化blog数据失败", e);
            }
        }
    }
    
    public List<Blog> select() {
        return new ArrayList<Blog>(BLOGS.values());
    }
    
    public Blog selectById(long id) {
        return BLOGS.get(id);
    }
    
    public Blog insert(Blog blog) {
        if(blog == null) {
            return null;
        }
        blog.setId(new Date().getTime());
        BLOGS.put(blog.getId(), blog);
        return blog;
    }
    
    public synchronized Blog deleteById(long id) {
        Blog blog = BLOGS.get(id);
        if(blog == null) {
            return null;
        }
        return BLOGS.remove(blog);
    }

    /**
     * @param blog
     * @return the previous value
     */
    public Blog update(Blog blog) {
        if(blog == null || blog.getId() == null || BLOGS.get(blog.getId()) == null) {
            return null;
        }
        return BLOGS.put(blog.getId(), blog);
    }
}
