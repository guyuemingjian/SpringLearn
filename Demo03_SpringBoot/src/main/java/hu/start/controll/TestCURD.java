package hu.start.controll;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.start.mode.Test;
import hu.start.mode.TestMapper;

/**
 * 
 * @Describe:</br>
 * 				测试数据库的连接</br>
 *
 * @author hu</br>
 * @CreateBy:2018年10月16日</br>
 *
 */

@RestController
public class TestCURD {

	@Autowired
	@Qualifier("testM")
	private TestMapper testM;

	/**
	 * 取得Test表里所有数据 http://127.0.0.1:8082/springBoot/all
	 * 
	 * @return
	 */
	@GetMapping("/all")
	public List<Test> getAllTest() {
		return testM.findAll();
	}

	/**
	 * 取得Test表里对应id数据 http://127.0.0.1:8082/springBoot/one?id=1
	 * 
	 * @return
	 */
	@GetMapping("/one")
	public Test getOneTest(@RequestParam(value = "id", defaultValue = "0") String id) {
		return testM.getOne(id);
	}

	/**
	 * 添加或修改Test表里对应id数据（id存在 Update 不存在insert ）
	 * http://127.0.0.1:8082/springBoot/put?c1=2&c2=2(原c1:2,c2:b)
	 * http://127.0.0.1:8082/springBoot/put?c1=27&c2=2(insert)
	 * @return
	 */
//	@GetMapping("/put")
//	public Test puTest(@RequestParam(value = "c1", defaultValue = "0") String id,
//			@RequestParam(value = "c2", defaultValue = "") String c2) {
//		Test test = new Test();
//		test.setC1(id);
//		test.setC2(c2);

	@GetMapping("/put")
	@Transactional//开启事务
	public Test puTest(Test test) {
		System.out.println(test.toString());
		return testM.save(test);
	}

	/**
	 * 删除Test表里对应id数据 http://127.0.0.1:8082/springBoot/del?c1=27
	 * 
	 * @return
	 */
	@GetMapping("/del")
	@Transactional
	public void delTest(@RequestParam(value = "c1", defaultValue = "0") String id) {
		testM.deleteById(id);
	}
}
