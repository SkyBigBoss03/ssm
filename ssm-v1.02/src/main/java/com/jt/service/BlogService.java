package com.jt.service;
import java.util.List;
import com.jt.entity.Blog;
public interface BlogService {
      /**
       * @param pageCurrent 当前页的页码值(
       * 后续从页面传到controller，然后在由controller
       * 传入到service)
       * @return
       */
	  List<Blog> findPageBlogs(Integer pageCurrent);
}
