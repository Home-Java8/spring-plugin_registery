package org.springframework.plugin.core;

import org.junit.Before;
import org.junit.Test;
import utils.CarUtil;
import utils.PrintUtil;

/**
 * Unit test for {@link SimplePluginRegistry}
 */
public class ComponentPluginRegistryTest {
	private Car car;

	@Before
	public void setUp() {
		car = new Car.Builder("BMW", "1 Series")
				.power(208)
				.torque(280)
				.gears(6)
				.color("White")
				.build();
	}

	@Test
	public void testCarBuilder() {
		PrintUtil.format(new String[]{"БРЕНД", "МАРКА", "МОЩНОСТЬ", "КРУТЯЩИЙ МОМЕНТ", "КОЛ-О ПЕРЕДАЧ", "ЦВЕТ", "ЕМКОСТЬ БАТАРЕИ"});
		Car bmw = new CarBuilder(car, CarUtil.COMPONENT_2)
				.build();
		PrintUtil.format(bmw);
	}
}
