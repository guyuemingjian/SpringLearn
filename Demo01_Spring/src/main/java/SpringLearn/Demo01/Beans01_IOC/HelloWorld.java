package SpringLearn.Demo01.Beans01_IOC;

public class HelloWorld {
	
	//内容
	private String context;
	
	

	public HelloWorld() {
		System.out.println("HelloWorld's Constructor");;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		System.out.println("setContext:"+context);
		this.context = context;
	}
	
	public void Say() {
		System.out.println("hello " + this.context);
	}	
	
}
