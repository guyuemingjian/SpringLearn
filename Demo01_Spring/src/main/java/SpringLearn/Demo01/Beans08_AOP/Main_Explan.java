package SpringLearn.Demo01.Beans08_AOP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class Main_Explan {

	public static void main(String[] args) {
		TCalculator tCalculator = new TCalculatorImp();

		TCalculator tCalculatorProxy = new TCalculatorProxy(tCalculator).getTCalculatorProxy();
		int r1 = tCalculatorProxy.add(1, 2);
		System.out.println(r1);
		
		int r2 = tCalculatorProxy.sub(1, 2);
		System.out.println(r2);
		
		int r3 = tCalculatorProxy.mul(1, 2);
		System.out.println(r3);
		
		int r4 = tCalculatorProxy.div(1, 2);
		System.out.println(r4);

	}

}

class TCalculatorProxy {

	private TCalculator tagert;

	public TCalculatorProxy(TCalculator tagert) {
		this.tagert = tagert;
	}

	public TCalculator getTCalculatorProxy() {

		TCalculator proxy = null;

		// 代理对象由哪一个类加载器加载
		ClassLoader loader = tagert.getClass().getClassLoader();
		// 代理对象类型
		Class[] interfaces = new Class[] { TCalculator.class };
		// 调用代理对象其中方法时 该执行的其他业务
		InvocationHandler h = new InvocationHandler() {

			/**
			 * proxy 返回的正在调用的代理对象</br>
			 * method 正在调用的方法</br>
			 * args 正在调用方法的参数</br>
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("proxy start...");
				
				// 引入aop需求 额外需求1：调用方法前后做log输出 
				
				// 额外日志输出 //前置
				System.out.println("start " + method.getName() + Arrays.asList(args));
				
				Object res = null;
				try {
					// 方法实现
					res = method.invoke(tagert, args);
					//后置返回
					System.err.println(res);	
				} catch (Exception e) {
					//后置异常
					System.err.println(e.getMessage());				
				}
				

				// 额外日志输出 //后置
				System.out.println("end " + method.getName() + Arrays.asList(args));

				System.out.println("proxy end...");				
				return res;
			}
		};

		proxy = (TCalculator) Proxy.newProxyInstance(loader, interfaces, h);

		return proxy;
	}

}
