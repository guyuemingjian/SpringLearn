package com.hu.LearnSpringBoot.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hu.LearnSpringBoot.model.User;

@RestController
public class HelloController {

	@Value("${test.title}")
	private String title;

	@Value("${test.description}")
	private String description;

	/**
	 * 简单请求
	 * 
	 * @return
	 */
	@RequestMapping("/hello0")
	public String hello() {
		return "hello world ";
	}

	/**
	 * 带参数简单请求
	 * 
	 * @param param
	 * @param param2
	 * @return
	 */
	@RequestMapping("/hello")
	public String hello(String param, String param2) {
		return "hello world " + param + param2;
	}

	/**
	 * 请求类型post
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getUser", method = RequestMethod.POST)
	public User getUser() {
		User user = new User();
		user.setName("小明");
		user.setAge("12");
		user.setPasw("Aaaa1111");
		return user;
	}

	/**
	 * 带参数请求
	 * 
	 * @param param
	 * @param param2
	 * @param param3
	 * @return
	 */
	@RequestMapping(value = "/getUser2", method = RequestMethod.POST)
	public User getUser2(String param, String param2, String param3) {
		User user = new User();
		user.setName(param);
		user.setAge(param2);
		user.setPasw(param3);
		return user;
	}

	/**
	 * 带参数请求自动映射
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/getUser3", method = RequestMethod.POST)
	public User getUser3(User user) {
		return user;
	}

	/**
	 * 带参数请求自动映射+校验
	 * 
	 * @param user
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/getUser4/{name}/{age}/{pasw}", method = RequestMethod.GET)
	public User getUser4(@Valid User user, BindingResult result) {

		System.out.println(title);
		if (result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError error : list) {
				System.out.println(error.getCode() + " - " + error.getDefaultMessage());
			}
		}
		System.out.println(description);
		return user;
	}

}
