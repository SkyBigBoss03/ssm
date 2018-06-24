package com.jt.service.imp;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.dao.BlogDao;
import com.jt.entity.Blog;
import com.jt.service.BlogService;
/***
 * 业务层要做的事情
 * 1)参数验证
 * 2)核心业务处理
 * 3)事务处理
 * 4)权限检测
 * 5)........
 */
@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
	private BlogDao blogDao;
    private Logger log=
    Logger.getLogger(getClass().getName());
    
    public Blog findBlogById(Integer id) {
    	log.info("method start....");
    	//1.参数的合法性验证
    	if(id==null||id<1)
    	throw new RuntimeException("id 不合法");
    	//2.执行业务
    	Blog blog=blogDao.findBlogById(id);
    	//3.返回结果
    	if(blog==null)
    	throw new RuntimeException("此博客已经不存在");
    	log.info("method end....");
    	return blog;
    }
    
	public List<Blog> findBlogs() {
		log.info("method start....");
		List<Blog> blogs=blogDao.findBlogs();
		log.info("method end....");
		return blogs;
	}
}
