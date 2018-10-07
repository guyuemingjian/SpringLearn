package SpringLearn.Demo01.Beans07_Annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		/**
		 * @Configuration把一个类作为一个IoC容器，它的某个方法头上如果注册了@Bean，就会作为这个Spring容器中的Bean</br>
		 * 
		 * @Scope注解 作用域</br>
		 * @Lazy(true) 表示延迟初始化</br>
		 * @Service用于标注业务层组件 </br>
		 * @Controller用于标注控制层组件（如struts中的action）</br>
		 * @Repository用于标注数据访问组件，即DAO组件。</br>
		 * @Component泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注。</br>
		 * @Scope用于指定scope作用域的（用在类上）</br>
		 * @PostConstruct用于指定初始化方法（用在方法上）</br>
		 * @PreDestory用于指定销毁方法（用在方法上）</br>
		 * @DependsOn：定义Bean初始化及销毁时的顺序</br>
		 * @Primary：自动装配时当出现多个Bean候选者时，被注解为@Primary的Bean将作为首选者，否则将抛出异常</br>
		 * @Autowired 默认按类型装配，如果我们想使用按名称装配，可以结合@Qualifier注解一起使用。如下：</br>
		 * @Autowired @Qualifier("personDaoBean") 存在多个实例配合使用</br>
		 * @Resource默认按名称装配，当找不到与名称匹配的bean才会按类型装配。</br>
		 * @PostConstruct 初始化注解</br>
		 * @PreDestroy 摧毁注解 默认 单例 启动就加载</br>
		 * @Async异步方法调用</br>
		 */
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans07Config.xml");
		Person p1 =(Person) ctx.getBean("p1");
		
		System.out.println(p1.toString());
		ctx.close();
		
		
	}

}
