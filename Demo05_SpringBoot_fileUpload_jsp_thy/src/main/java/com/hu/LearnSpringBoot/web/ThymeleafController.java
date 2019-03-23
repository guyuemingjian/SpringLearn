package com.hu.LearnSpringBoot.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hu.LearnSpringBoot.model.User;

@Controller
public class ThymeleafController {

	@RequestMapping(value = "/th", method = RequestMethod.GET)
	public String thymeleaf(ModelMap map) {
		map.addAttribute("message", "hu test");

		map.addAttribute("flag", "1");

		User u1 = new User("小明1", "6", "Aaaa1111");
		User u2 = new User("小明2", "7", "Aaaa1112");
		User u3 = new User("小明3", "8", "Aaaa1113");

		List<User> list = new ArrayList<User>();
		list.add(u1);
		list.add(u2);
		list.add(u3);
		map.addAttribute("users", list);
		
		map.addAttribute("select", "s1");
		
		return "hello";
	}
}
