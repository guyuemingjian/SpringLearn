package SpringLearn.Demo01.Beans05_StaticFactory;

import java.util.HashMap;
import java.util.Map;


/**
 * 先创建静态工厂本身
 * 再调用静态实例方法,返回bean实例
 * @author hu
 *
 */
public class InstanceFactory {

	private Map<String, Car> cars = new HashMap<>();

	public InstanceFactory() {
		System.out.println("InstanceFactory put car");
		cars.put("BWM", new Car("BWM", 3000.0));
		cars.put("HaFu", new Car("HaFu", 4000.0));
	}

	public Car getCar(String brand) {
		return cars.get(brand);
	}

}
