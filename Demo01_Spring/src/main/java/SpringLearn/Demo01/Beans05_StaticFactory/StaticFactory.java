package SpringLearn.Demo01.Beans05_StaticFactory;

import java.util.HashMap;
import java.util.Map;

import SpringLearn.Demo01.Beans05_StaticFactory.Car;

public class StaticFactory {

	private static Map<String, Car> cars = new HashMap<>();

	static {
		System.out.println("StaticFactory put car");
		cars.put("BWM", new Car("BWM", 3000.0));
		cars.put("HaFu", new Car("HaFu", 4000.0));
	}

	public static Car getCar(String brand) {
		return cars.get(brand);
	}

}
