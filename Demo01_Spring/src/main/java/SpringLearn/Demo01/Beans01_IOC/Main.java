package SpringLearn.Demo01.Beans01_IOC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

//		//创建对象
//		HelloWorld helloWorld = new HelloWorld();
//		//设置属性
//		helloWorld.setContext("world");
//-->

		// springIOC
		System.out.println("==========ApplicationContext Create");

//		ApplicationContext aContext =new FileSystemXmlApplicationContext("E:/JavaWorkspace/JavaLearn/Demo01/src/main/resources/beansConfig.xml");
		ApplicationContext aContext = new ClassPathXmlApplicationContext("beans01Config.xml");

		System.out.println("==========HelloWorld Create");
		//id 调用
		HelloWorld helloWorld = (HelloWorld) aContext.getBean("helloWorld");	
		
//		//type 调用
//		HelloWorld helloWorld1 = aContext.getBean(HelloWorld.class);

		// 調用方法
		helloWorld.Say();
//		helloWorld1.Say();
		
		System.out.println("==========Car Create");
		
		Car car1 = (Car) aContext.getBean("car1");
		System.out.println(car1);
		
		Car car2 = (Car) aContext.getBean("car2");
		System.out.println(car2);
		
		Car car3 = (Car) aContext.getBean("car3");
		System.out.println(car3);

	}
}