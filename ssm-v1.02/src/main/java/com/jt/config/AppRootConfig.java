package com.jt.config;
import org.junit.Before;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.alibaba.druid.pool.DruidDataSource;
/***
 * Step:
 * 1) 配置DURID连接池
 * 2) 配置SqlSesionFactory对象
 * 3) 配置对象dao(mapper)对象的扫描
 */
@Configuration 
@PropertySource(value="classpath:configs.properties")
@ComponentScan(value="com.jt",
                includeFilters={
		        @Filter(value=Service.class,type=FilterType.ANNOTATION),
		        @Filter(value=Component.class,type=FilterType.ANNOTATION),},
                excludeFilters={
                @Filter(value=Controller.class,type=FilterType.ANNOTATION)},
                useDefaultFilters=false)
public class AppRootConfig {
	   /**配置DRUID连接池*/
	   @Lazy(false)
	   @Bean(value="dataSource",initMethod="init",destroyMethod="close")
	   public DruidDataSource newDruidDataSource(
			@Value("${driver}")String driver,
			@Value("${url}")String url,
			@Value("${jdbcUser}")String jdbcUser,
			@Value("${password}")String password){
		    DruidDataSource ds=new DruidDataSource();
		      ds.setDriverClassName(driver);
		      ds.setUrl(url);
		      ds.setUsername(jdbcUser);
		      ds.setPassword(password);
		      return ds;
	   }
	   @Bean("sqlSessionFactory")
	   public SqlSessionFactoryBean newSqlSessionFactoryBean(
			  @Autowired DruidDataSource dataSource){
		   //1.构建bean对象
		   SqlSessionFactoryBean factoryBean=
		   new SqlSessionFactoryBean();
		   //2.设置dataSource
		   factoryBean.setDataSource(dataSource);
		   //3.设置Configuration (mappers)
		   org.apache.ibatis.session.Configuration cfg=
		   new  org.apache.ibatis.session.Configuration();
		   cfg.addMappers("com.jt.dao");
		   factoryBean.setConfiguration(cfg);
		   return factoryBean;
	   }
	   @Bean
	   public MapperScannerConfigurer newMapperScannerConfigurer(){
		   MapperScannerConfigurer mscfg=
		   new MapperScannerConfigurer();
		   mscfg.setBasePackage("com.jt.dao");
		   mscfg.setSqlSessionFactoryBeanName(
				   "sqlSessionFactory");
		   return mscfg;
	   }
}
