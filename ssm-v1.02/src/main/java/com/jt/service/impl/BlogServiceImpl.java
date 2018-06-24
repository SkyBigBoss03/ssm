package com.jt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jt.dao.BlogDao;
import com.jt.entity.Blog;
import com.jt.service.BlogService;
@Service
public class BlogServiceImpl implements BlogService {
	@Autowired
	private BlogDao blogDao;
	@Override
	public List<Blog> findPageBlogs(Integer pageCurrent) {
		//1.判定参数的合法性
		if(pageCurrent==null||pageCurrent<1)
		throw new IllegalArgumentException("参数异常,pageCurrent="+pageCurrent);
		//2.根据参数执行查询操作
		//2.1 计算查询的起始页
		int pageSize=3;
		int startIndex=(pageCurrent-1)*pageSize;
		//2.2执行查询操作
		return blogDao.findPageBlogs(startIndex, pageSize);
	}
}
