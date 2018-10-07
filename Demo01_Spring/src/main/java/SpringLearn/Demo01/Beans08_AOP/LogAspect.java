package SpringLearn.Demo01.Beans08_AOP;

import java.awt.Point;
import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 声明一个切面 1.需要放入IOC容器 2.再声明为一个切面
 */
@Component
@Aspect
@Order(1) //值越小 优先度越高
public class LogAspect {

	//重用切点表达式
	@Pointcut("execution(int SpringLearn.Demo01.Beans08_AOP.TCalculator.*(..))")
	public void Point() {}
	
	//前置通知，在方法调用开始前调用
//	@Before("execution(int SpringLearn.Demo01.Beans08_AOP.TCalculator.add(int , int ))")
//	@Before("execution(int SpringLearn.Demo01.Beans08_AOP.TCalculator.*(..))")
	@Before("Point()")
	public void beforMethod(JoinPoint jPoint) {

		// 得到方法名
		String methodName = jPoint.getSignature().getName();
		// 得到参数
		List<Object> methodAgrs = Arrays.asList(jPoint.getArgs());

		System.out.println(methodName + " start " + methodAgrs.toString() );
	}
	
	//后置通知，在方法调用完调用（不论是否异常）
	@After("execution(int SpringLearn.Demo01.Beans08_AOP.TCalculator.*(..))")
	public void afterMethod(JoinPoint jPoint) {

		// 得到方法名
		String methodName = jPoint.getSignature().getName();
		// 得到参数
		List<Object> methodAgrs = Arrays.asList(jPoint.getArgs());

		System.out.println(methodName + " end " + methodAgrs.toString() );
	}
	
	//后置返回通知 返回调用结果(方法调用正常结束才有)
	@AfterReturning(value="execution(int SpringLearn.Demo01.Beans08_AOP.TCalculator.*(..))" ,returning = "res")
	public void AfterReMethod(JoinPoint jPoint, Object res) {

		// 得到方法名
		String methodName = jPoint.getSignature().getName();
		// 得到参数
		List<Object> methodAgrs = Arrays.asList(jPoint.getArgs());
		// 

		System.out.println(methodName + " end status[" + res + "]");
	}
	
	//后置异常通知 返回调用结果(方法调用异常结束才有)
	@AfterThrowing(value="execution(int SpringLearn.Demo01.Beans08_AOP.TCalculator.*(..))" ,throwing = "res")
	public void AfterThMethod(JoinPoint jPoint, Exception res) {

		// 得到方法名
		String methodName = jPoint.getSignature().getName();
		// 得到参数
		List<Object> methodAgrs = Arrays.asList(jPoint.getArgs());
		// 

		System.out.println(methodName + " end throw[" + res.getMessage() + "]");
	}
	
//	//环绕通知
//	//类似动态代理全过程 ProceedingJoinPoint 参数决定是否执行目标方法
//	@Around(value="execution(int SpringLearn.Demo01.Beans08_AOP.TCalculator.*(..))")
//	public Object ArMethod(ProceedingJoinPoint point) {
//
//		System.out.println("@Around start...");
//		
//		String methodName = point.getSignature().getName();
//		List<Object> methodArgs = Arrays.asList(point.getArgs());
//		
//		// 额外日志输出 //前置
//		System.out.println("start " + methodName + methodArgs);
//		
//		Object res = null;
//		try {
//			// 方法执行
//			res = point.proceed();
//			//后置返回
//			System.out.println(res);	
//		} catch (Throwable e) {
//			//后置异常
//			System.out.println(e.getMessage());				
//		}
//		
//
//		// 额外日志输出 //后置
//		System.out.println("end " + methodName + methodArgs);
//
//		System.out.println("@Around end...");				
//		return res;
//	}
}
