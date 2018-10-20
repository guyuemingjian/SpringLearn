package hu.start.controll;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hu.start.mode.Test;

/**
 * 
 * @Describe:</br>
 * 				和html交互的控制</br>
 *
 * @author hu</br>
 * @CreateBy:2018年10月17日</br>
 *
 */
@Controller
public class TestForm {

	private static final Logger log = LoggerFactory.getLogger(TestForm.class);

	/**
	 * 初始化页面
	 * 
	 * @return /templates/index.html
	 */
	@GetMapping("/getform")
	public String getForm() {
		return "index";
	}

	/**
	 * 页面信息提交 通过@Valid 来验证提交信息 ，验证方式写在实体类Test中
	 * 
	 * @param test
	 * @return
	 */
	@PostMapping("/postform")
	@ResponseBody
	public String postForm(@Valid Test test, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return bindingResult.getFieldError().getDefaultMessage();
		}
		log.info(test.toString());
		return test.toString();
	}
}
