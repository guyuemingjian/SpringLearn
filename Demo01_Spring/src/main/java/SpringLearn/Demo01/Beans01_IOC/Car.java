package SpringLearn.Demo01.Beans01_IOC;

public class Car {

	/** 品牌 */
	private String brand;
	/** 公司 */
	private String company;
	/** 价格 */
	private Double price;
	/** 速度 */
	private Integer speed;

	public Car() {
	}

	public Car(String brand, String company, Double price) {
		super();
		this.brand = brand;
		this.company = company;
		this.price = price;
	}

	public Car(String brand, String company, Integer speed) {
		super();
		this.brand = brand;
		this.company = company;
		this.speed = speed;
	}

	public Car(String brand, String company, Double price, Integer speed) {
		super();
		this.brand = brand;
		this.company = company;
		this.price = price;
		this.speed = speed;
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
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
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

	/**
	 * @return the speed
	 */
	public Integer getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return "Car[brand=" + this.brand + ", company=" + this.company + ", price=" + this.price + ", speed="
				+ this.speed + "]";
	}

}
