package com.hu.LearnSpringBoot.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class MyFilter implements Filter {

	@Override
	public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) srequest;
		System.out.println("url:" + request.getRequestURI());

//		request.setCharacterEncoding("utf-8");
//		sresponse.setCharacterEncoding("utf-8");
		chain.doFilter(srequest, sresponse);
	}

}
