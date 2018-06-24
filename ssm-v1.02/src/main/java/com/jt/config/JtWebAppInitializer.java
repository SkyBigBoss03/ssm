package com.jt.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
/***
 * tomcat 启动时
 * 1)找到类路径下的META-INF目录
 * 2)找到META-INF文件夹下的services目录
 * 3)读取services目录下的/META-INF/services/javax.servlet.ServletContainerInitializer文件内容
 * 4)依据文件中定义的类全名(SpringServletContainerInitializer)进行类的加载，并创建对象。
 * 5)依据文件中定义的类上的@HandlesTypes注解声明的类型进行类以及子类的加载
 * 6)然后调用类(SpringServletContainerInitializer)中onStartUp方法，并将@HandlesTypes声明的这些类对象传递给此方法
 * 7)最后进行对象的创建以及初始化。
 */
public class JtWebAppInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer {
    public JtWebAppInitializer() {
    	System.out.println("JtWebAppInitializer()");
	}
    /***
     * 此方法负责加载service，dao等对象
     */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{AppRootConfig.class};
	}
	/***
	 * 此方法负责加载Controllers,ViewResolver,HandlerMapper
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{AppServletConfig.class};
	}
	@Override
	protected String[] getServletMappings() {
		return new String[]{"*.do"};
	}
}
