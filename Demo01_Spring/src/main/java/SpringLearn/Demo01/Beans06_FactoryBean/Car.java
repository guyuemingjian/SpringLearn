package SpringLearn.Demo01.Beans06_FactoryBean;

public class Car {

	/** 品牌 */
	private String brand;

	/** 价格 */
	private Double price;

	public Car() {
		System.out.println("Car Creat...");
	}

	public Car(String brand, Double price) {
		System.out.println("Car Creat1...");
		this.brand = brand;
		this.price = price;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Car " + this.hashCode() + "[brand=" + brand + ", price=" + price + "]";
	}

}
