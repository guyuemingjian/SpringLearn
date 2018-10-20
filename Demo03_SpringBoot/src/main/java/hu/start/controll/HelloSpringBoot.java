package hu.start.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.start.mode.TestUser;

/**
 * 
 * @Describe:</br>
 * 				第一个尝试的控制层类</br>
 *
 * @author hu</br>
 * @CreateBy:2018年10月15日</br>
 *
 */

@RestController // 等价于 @ResponseBody(返回json)+@Controller
public class HelloSpringBoot {

	@Value("${testparam}")
	private String rString;

	@Value("${testparam1}")
	private String rString1;

	@Autowired
	@Qualifier("tU")
	private TestUser testUser;
	
	
	/**
	 * /hello 访问 hello方法
	 * 
	 * @return
	 */
	@RequestMapping(value = "/hello0", method = RequestMethod.GET)
	public String hello0() {
		return "Hello Spring Boot";
	}

	/**
	 * 取得application.yml里对应的参数并返回
	 * 
	 * @return testParam
	 */
	@RequestMapping(value = "/hello1", method = RequestMethod.GET)
	public String hello1() {
		return rString + "," + rString1;
	}

	/**
	 * 取得application.yml里对应的参数并生成 testUser对象
	 * 
	 * @return testParam
	 */
	@RequestMapping(value = "/hello2", method = RequestMethod.GET)
	public TestUser hello2() {
		return testUser;
	}

	/**
	 * 参数的获取 第一种通过 url的方式
	 * http://127.0.0.1:8082/springBoot/hello3/3 获得 id=3
	 */
	@GetMapping(value = {"/hello3/{id}","/hi"})
	public int hello3(@PathVariable("id") int id) {
		return id;
	}
	
	/**
	 * 参数的获取 表单数据的获取
	 * http://127.0.0.1:8082/springBoot/hello4?id=4 获得 id=4
	 */
	@GetMapping(value = "/hello4")
	public int hello4(@RequestParam(value="id",defaultValue="0") int myid) {
		return myid;
	}
}
