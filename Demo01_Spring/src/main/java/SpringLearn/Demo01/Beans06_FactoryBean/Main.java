package SpringLearn.Demo01.Beans06_FactoryBean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans06Config.xml");
		
		Car car1 = (Car) ctx.getBean("car1");
		System.out.println(car1.toString());
		
		Car car2 = (Car) ctx.getBean("car2");
		System.out.println(car2.toString());
		
		ctx.close();

	}

}
