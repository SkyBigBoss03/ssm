package com.jt.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.jt.entity.Blog;
public interface BlogDao {
    /**
     * @param startIndex 从>startIndex的位置开始查，最多查询pageSize条记录
     * @param pageSize 页面大小(每页最多显示多少条记录)
     * @return
     */
	@Select("select * from blog limit #{startIndex} ,#{pageSize}")
	List<Blog> findPageBlogs(
	 @Param("startIndex")Integer startIndex,
	 @Param("pageSize")Integer pageSize);
}





