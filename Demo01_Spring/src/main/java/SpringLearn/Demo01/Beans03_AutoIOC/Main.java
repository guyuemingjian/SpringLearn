package SpringLearn.Demo01.Beans03_AutoIOC;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext aContext =new ClassPathXmlApplicationContext("beans03Config.xml");
		Person p1 = (Person) aContext.getBean("p1");
		System.out.println(p1.toString());

		Person p2 = (Person) aContext.getBean("p2");
		System.out.println(p2.toString());
		
		Person p3 = (Person) aContext.getBean("p3");
		System.out.println(p3.toString());
		
		Person p4 = (Person) aContext.getBean("p4");
		System.out.println(p4);
		
		aContext.close();
	}

}
