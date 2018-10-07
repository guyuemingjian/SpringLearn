package SpringLearn.Demo01.Beans03_AutoIOC;

public class Person {

	/** 姓名 */
	private String name;
	/** 年龄 */
	private int age;
	/** 住址 */
	private Address address;
	/** 车 */
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
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
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
		return "Person " + this.hashCode() + "[name=" + name + ", age=" + age + ", address=" + address + ", car=" + car + "]";
	}
	
	public void initP() {
		System.out.println("initP...");
	}
	
	public void destroyP() {
		System.out.println("destroyP...");
	}

}
