package SpringLearn.Demo01.Beans02_Ref;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		/**
		 * bean装备的细节，详细在beans02Config.xml
		 */
		ApplicationContext aContext = new ClassPathXmlApplicationContext("beans02Config.xml");
		
		Person person = (Person) aContext.getBean("person");		
		System.out.println(person.toString());

		Person person1 = (Person) aContext.getBean("person1");		
		System.out.println(person1.toString());
		
		Person person2 = (Person) aContext.getBean("person2");		
		System.out.println(person2.toString());
		
		Person person3 = (Person) aContext.getBean("person3");		
		System.out.println(person3.toString());
		
	}

}
