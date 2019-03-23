package com.hu.LearnSpringBoot.filter;

import javax.servlet.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {
	@Bean
	public FilterRegistrationBean<Filter> filterRegistration() {
		FilterRegistrationBean<Filter> rgBean = new FilterRegistrationBean<Filter>();
		// 注册过滤器
		rgBean.setFilter(new MyFilter());
		// 监听规则
		rgBean.addUrlPatterns("/*");
		rgBean.setName("myFilter");
		// 优先级，越小越高
		rgBean.setOrder(6);
		return rgBean;
	}
}
