package org.springframework.plugin.metadata;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.plugin.core.App;
import org.springframework.plugin.core.config.EnablePluginRegistries;
import org.springframework.plugin.metadata.component.Component;
import org.springframework.plugin.metadata.component.ComponentPluginRegistry;
import org.springframework.plugin.metadata.component.impl.CarComponent1Impl;
import org.springframework.plugin.metadata.component.impl.CarComponent2Impl;
import org.springframework.test.context.junit4.SpringRunner;
import utils.PrintUtil;

import java.util.List;

//@EnablePluginRegistries(Component.class)
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = App.class)
//@Configuration
//@ComponentScan
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

//	@Test
//	public void testCarBuilder() {
//		PrintUtil.format(new String[]{"БРЕНД", "МАРКА", "МОЩНОСТЬ", "КРУТЯЩИЙ МОМЕНТ", "КОЛ-О ПЕРЕДАЧ", "ЦВЕТ", "ЕМКОСТЬ БАТАРЕИ"});
//
//		PrintUtil.format(new ComponentPluginRegistry(car, CarUtil.COMPONENT_1).build());
//		PrintUtil.format(new ComponentPluginRegistry(car, CarUtil.COMPONENT_2).build());
//	}

//	@Autowired
//	@Qualifier("carComponent1")
//	private CarComponent1Impl carComponent1;
//
//	@Autowired
//	@Qualifier("carComponent2")
//	private CarComponent2Impl carComponent2;
//
//	@Autowired
//	private ComponentPluginRegistry componentPluginRegistry;

	@Test
	public void testRegistry() {
		ComponentPluginRegistry.registry(new CarComponent1Impl(car));
		ComponentPluginRegistry.registry(new CarComponent2Impl(car));
//		componentPluginRegistry.registry(carComponent1);
//		componentPluginRegistry.registry(carComponent2);

		System.out.println(ComponentPluginRegistry.getPlugins().size());

		PrintUtil.format(new String[]{"БРЕНД", "МАРКА", "МОЩНОСТЬ", "КРУТЯЩИЙ МОМЕНТ", "КОЛ-О ПЕРЕДАЧ", "ЦВЕТ", "ЕМКОСТЬ БАТАРЕИ"});

		List<Component> components = ComponentPluginRegistry.getPlugins();
		for (Component component: components) {
			PrintUtil.format(component.getBuilder().build());
		}
	}
}
