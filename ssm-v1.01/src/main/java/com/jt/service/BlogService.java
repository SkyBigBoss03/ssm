package com.jt.service;

import java.util.List;

import com.jt.entity.Blog;

public interface BlogService {

	 List<Blog> findBlogs();
	 Blog findBlogById(Integer id);
}
