package SpringLearn.Demo01.Beans03_AutoIOC;

public class Address {

	/** 城市 */
	private String city;
	/** 街道 */
	private String street;

	
	public Address() {
		System.out.println("Address Creat...");
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Address " + this.hashCode() + " [city=" + city + ", street=" + street + "]";
	}

}
