package test;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.alibaba.druid.pool.DruidDataSource;
import com.jt.config.AppRootConfig;
import com.jt.dao.BlogDao;
import com.jt.entity.Blog;
import com.jt.service.BlogService;

public class TestSSM01 {
	AnnotationConfigApplicationContext ctx;
	@Before
	public void init(){
		ctx=new AnnotationConfigApplicationContext(
				AppRootConfig.class);
	}
	@Test
	public void testDruidDataSource() throws SQLException{
		DruidDataSource ds=
		ctx.getBean("dataSource",DruidDataSource.class);
		Assert.assertNotEquals(null, ds);
		System.out.println(ds.getConnection());
	}
	@Test
	public void testSqlSessionFactory(){
		SqlSessionFactory ssf=
		ctx.getBean("sqlSessionFactory", SqlSessionFactory.class);
	    Assert.assertNotEquals(null, ssf);
	}
	@Test
	public void testDaoFindPageBlogs(){
		BlogDao dao=
		ctx.getBean("blogDao", BlogDao.class);
		List<Blog> list=dao.findPageBlogs(0, 3);
		for(Blog blog:list){
			System.out.println(blog);
		}
	}
	@Test
	public void testServiceFindPageBlogs(){
		BlogService bs=
				ctx.getBean("blogServiceImpl", BlogService.class);
		List<Blog> list=bs.findPageBlogs(1);
		for(Blog blog:list){
			System.out.println(blog);
		}
	}
	
	@After
	public void destory(){
		ctx.close();
	}

}
