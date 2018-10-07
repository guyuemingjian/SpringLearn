package SpringLearn.Demo01.Beans07_Annotation;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service(value="p1")
public class Person {

	/** 姓名 */
	@Value("tom1")
	private String name;
	/** 年龄 */
	@Value("13")
	private int age;
	
	/** 车 */
	@Autowired
//	@Resource
	@Qualifier("car1")
	private Car car;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	

	/**
	 * @return the car
	 */
	public Car getCar() {
		return car;
	}

	/**
	 * @param car the car to set
	 */
	public void setCar(Car car) {
		this.car = car;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person " + this.hashCode() + "[name=" + name + ", age=" + age + ", car=" + car + "]";
	}
	
	public void initP() {
		System.out.println("initP...");
	}
	
	public void destroyP() {
		System.out.println("destroyP...");
	}

}
