package SpringLearn.Demo01.Beans08_AOP;

import org.springframework.stereotype.Component;

@Component("tCalc")
public class TCalculatorImp implements TCalculator {

	/**
	 * aop实现思路 用一个代理把 其他业务分开，包涵核心业务代码</br>
	 */
	
	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		System.out.println("add ...");
		return a + b;
	}

	@Override
	public int sub(int a, int b) {
		// TODO Auto-generated method stub
		System.out.println("sub ...");
		return a - b;
	}

	@Override
	public int mul(int a, int b) {
		// TODO Auto-generated method stub
		System.out.println("mul ...");
		return a * b;
	}

	@Override
	public int div(int a, int b) {
		// TODO Auto-generated method stub
		System.out.println("div ...");
		return a / b;
	}

}
