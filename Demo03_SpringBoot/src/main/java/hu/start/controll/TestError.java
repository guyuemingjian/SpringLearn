package hu.start.controll;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hu.start.logic.ResultUtil;
import hu.start.logic.TestErrorLogic;
import hu.start.mode.Result;
import hu.start.mode.TestErrorBean;

/**
 * 
 * @Describe:</br>
 *   正常和异常的分别返回</br>
 *
 * @author hu</br>
 * @CreateBy:2018年10月19日</br>
 *
 */

@Controller
public class TestError {

	@Autowired
	@Qualifier("terrorlogic")
	private TestErrorLogic tl;
	
	/**
	 * 初期页面跳转http://127.0.0.1:8082/springBoot/init
	 * @return 输入画面
	 */
	@GetMapping("/init")
	public String init() {
		return "input";
	}
	
	/**
	 * 画面数据提交验证http://127.0.0.1:8082/springBoot/tpost
	 * @param t
	 * @param bindingResult
	 * @return
	 * @throws Exception 
	 */
	@PostMapping("/tpost")
	@ResponseBody
	public Result<TestErrorBean> tPost(@Valid TestErrorBean t,BindingResult bindingResult) throws Exception {
		
		/**
		 * 绑定验证
		 * 如果出错返回出错信息
		 */
		if(bindingResult.hasErrors()) {
			Result<TestErrorBean> result = ResultUtil.error();
			result.setReMsg(bindingResult.getFieldError().getDefaultMessage());
			return result;
		}
		
		/**
		 * 验证通过后处理</br>
		 * 判断业务 16：是最小值 ;>16 <18：可以的
		 */
		tl.validId(t.getId());
		
		Result<TestErrorBean> result = ResultUtil.success(t);
		
		return result;
		
	}
	
}
