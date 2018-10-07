package SpringLearn.Demo01.Beans08_AOP;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main_Aop {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans08Config.xml");
		
		TCalculator tCalc= (TCalculator) ctx.getBean("tCalc");
		int r=tCalc.add(1, 2);
		System.out.println(r);
		
		r=tCalc.sub(1, 2);
		System.out.println(r);
		
		r=tCalc.mul(1, 2);
		System.out.println(r);
		
		r=tCalc.div(1, 0);
		System.out.println(r);
		
		ctx.close();

	}

}
