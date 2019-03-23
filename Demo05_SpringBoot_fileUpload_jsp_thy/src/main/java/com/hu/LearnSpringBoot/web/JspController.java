package com.hu.LearnSpringBoot.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JspController {

	@GetMapping("/getJsp1")
	public String getJsp1(Map<String, Object> mod) {
		mod.put("time", new Date());
		mod.put("msg", "index");

		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");

		mod.put("list", list);
		return "index";
	}

}
