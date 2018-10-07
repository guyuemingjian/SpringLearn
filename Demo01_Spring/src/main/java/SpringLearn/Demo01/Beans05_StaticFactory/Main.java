package SpringLearn.Demo01.Beans05_StaticFactory;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans05Config.xml");
		
		Car car = (Car) ctx.getBean("car");
		System.out.println(car.toString());
		
		Car car2 = (Car) ctx.getBean("car2");
		System.out.println(car2.toString());
		
		ctx.close();

	}

}
