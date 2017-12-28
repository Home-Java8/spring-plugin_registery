package org.springframework.plugin.core;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Unit test for {@link SimplePluginRegistry}.
 */
public class ComponentPluginRegistryTest {
	private Car car;

	private Component component1, component2;
	private SimplePluginRegistry<Component, String> registry;
//	@Rule
//	public ExpectedException o_O = ExpectedException.none();

	@Before
	public void setUp() {
		car = new Car.Builder("BMW", "1 Series")
				.power(208)
				.torque(280)
				.gears(6)
				.color("White")
				.build();

		component1 = new Component1Impl(car);
		component2 = new Component2Impl(car);

		registry = SimplePluginRegistry.create( Arrays.asList(component1, component2) );
	}

//	/**
//	 * Asserts that the registry contains the component1 it was initialized with.
//	 */
//	@Test
//	public void assertRegistryInitialized() throws Exception {
//		registry = SimplePluginRegistry.create(Arrays.asList(component1, component2));
//
//		assertThat(registry.countPlugins(), is(1));
//		assertTrue(registry.contains(component1));
//	}

	@Test
	public void testCarBuilder() {
		PrintUtil.format(new String[]{"БРЕНД", "МАРКА", "МОЩНОСТЬ", "КРУТЯЩИЙ МОМЕНТ", "КОЛ-О ПЕРЕДАЧ", "ЦВЕТ", "ЕМКОСТЬ БАТАРЕИ"});
		Car bmw = carBuilder(MyUtil.COMPONENT_2)
				.build();
		PrintUtil.format(bmw);
	}

	/**
	 * Это мой CarBuilder - он полностью заменяет класс-CarBuilder со списком swith-case...
	 * (а вся реализация скрыта в недрях Spring-а)
	 */
	private Car.Builder carBuilder(String type) {
		return registry.getPluginsFor(type).get(0).getBuilder();
	}

	//////////////////////////////////////////////

//	/**
//	 * Expects the given exception to be thrown if no {@link Plugin} found.
//	 */
//	@Test(expected = IllegalArgumentException.class)
//	public void throwsExceptionIfNoPluginFound() {
//		registry.getPluginFor("BAR", () -> new IllegalArgumentException());
//	}
//
//	/**
//	 * Expects the given exception to be thrown if no {@link Plugin}s found.
//	 */
//	@Test(expected = IllegalArgumentException.class)
//	public void throwsExceptionIfNoPluginsFound() {
//		registry.getPluginsFor("BAR", () -> new IllegalArgumentException());
//	}
//
//	/**
//	 * Expect the defualt component1 to be returned if none found.
//	 */
//	@Test
//	public void returnsDefaultIfNoneFound() {
//		Component defaultPlugin = new Component1Impl(car);
//
//		assertThat(registry.getPluginOrDefaultFor("BAR", defaultPlugin), is(defaultPlugin));
//	}
//
//	/**
//	 * Expect the given default plugins to be returned if none found.
//	 */
//	@Test
//	public void returnsDefaultsIfNoneFound() {
//		List<? extends Component> defaultPlugins = Arrays.asList(new Component1Impl(car));
//
//		List<Component> result = registry.getPluginsFor("BAR", defaultPlugins);
//		assertTrue(result.containsAll(defaultPlugins));
//	}
//
//	@Test
//	public void handlesAddingNullPluginsCorrecty() throws Exception {
//		List<Component> plugins = new ArrayList<Component>();
//		plugins.add(null);
//
//		registry = SimplePluginRegistry.create(plugins);
//
//		assertThat(registry.countPlugins(), is(0));
//	}
//
//	@Test(expected = IllegalStateException.class)
//	public void testname() throws Exception {
//
//		registry = SimplePluginRegistry.create(Collections.<Component> emptyList());
//
//		registry.getPluginFor("FOO", () -> new IllegalStateException());
//	}
//
//	public void throwsExceptionIfRequiredPluginIsNotFound() {
//		registry = SimplePluginRegistry.create(Collections.emptyList());
//
//		o_O.expect(IllegalArgumentException.class);
//
//		registry.getRequiredPluginFor("FOO");
//	}
//
//	public void throwsExceptionWithMessafeIfRequiredPluginIsNotFound() {
//		registry = SimplePluginRegistry.create(Collections.emptyList());
//
//		o_O.expect(IllegalArgumentException.class);
//		o_O.expectMessage("message");
//
//		registry.getRequiredPluginFor("FOO", () -> "message");
//	}
}
