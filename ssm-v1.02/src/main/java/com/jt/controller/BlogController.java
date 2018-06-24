package com.jt.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jt.entity.Blog;
import com.jt.service.BlogService;
@Controller
@RequestMapping("/blog/")
public class BlogController {
	   @Autowired
	   private BlogService blogService;
	   @RequestMapping("blogUI")
	   public String blogUI(){
		   return "blog01";
	   }
	   /**重点掌握*/
	   @RequestMapping(value="doFindPageBlogs01",produces="application/json;charset=utf-8")
	   @ResponseBody
	   public List<Blog> doFindPageBlogs01(Integer pageCurrent){
		   return blogService.findPageBlogs(pageCurrent);
	   }
	   /**了解*/
	   @RequestMapping(value="doFindPageBlogs02",produces="application/json;charset=utf-8")
	   public ModelAndView doFindPageBlogs02(
			   Integer pageCurrent){
		   List<Blog> list=
		   blogService.findPageBlogs(pageCurrent);
		   ModelAndView mv=new ModelAndView();
		   mv.addObject("list",list);
		   mv.setViewName("blog02");
		   return mv;
	   }
}
