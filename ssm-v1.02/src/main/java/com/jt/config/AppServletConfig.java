package com.jt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Controller;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.jt.controller.LogInterceptor;
//spring-configs.xml
@Configuration
/**扫描com.jt包及子包中使用
   Controller注解修饰的类，并进行加载
   1)includeFilters 用于设置相关加载条件
*/
@ComponentScan(value="com.jt",
               includeFilters={
		            @Filter(value=Controller.class,
				     type=FilterType.ANNOTATION)},
                      useDefaultFilters=false)
@EnableWebMvc
public class AppServletConfig extends WebMvcConfigurerAdapter{
	/**配置视图解析*/
	@Override
	public void configureViewResolvers(
			ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/pages/", ".jsp");
	}
	/**配置拦截器*/
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//1.创建interceptor对象
		LogInterceptor logInterceptor=new LogInterceptor();
		//2.注册interceptor对象
		//2.1 注册Interceptor
		InterceptorRegistration interceptorReg =
		registry.addInterceptor(logInterceptor);
		//2.2 设置拦截路径
		interceptorReg.addPathPatterns("/**");
		//2.3 设置不拦截的路径(可选)
		interceptorReg.excludePathPatterns("/user/list.do");
		
		//也可以参考如下的简化写法
		
		/*registry.addInterceptor(logInterceptor)
		 .addPathPatterns("/**")
		 .excludePathPatterns("/user/list.do");*/
	}
	
	
}
