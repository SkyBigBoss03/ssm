package com.jt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.entity.Blog;
import com.jt.service.BlogService;

@Controller
@RequestMapping("/blog/")
public class BlogController {
     @Autowired
	 private BlogService blogService;
     /**将这个数据转换成json(jackson)显示在客户端*/
	 @RequestMapping("doFindBlogs")
	 @ResponseBody
     public List<Blog> doFindBlogs(){
		 return blogService.findBlogs();
	 }
	 @RequestMapping("doFindBlogById")
	 @ResponseBody
	 public Blog doFindBlogById(Integer id){
		 return blogService.findBlogById(id);
	 }
}
