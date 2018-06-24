package com.jt.dao;
import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.jt.entity.Blog;

//www.mybatis.org/spring
public interface BlogDao {
	 /**
	  * 这样写了以后可以不写BlogMapper.xml文件
	  */
	 List<Blog> findBlogs();
     Blog findBlogById(Integer id);
}
