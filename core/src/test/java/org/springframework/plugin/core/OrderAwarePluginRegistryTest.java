package org.springframework.plugin.core;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.springframework.plugin.core.OrderAwarePluginRegistry.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * Unit test for {@link OrderAwarePluginRegistry} that especially concentrates on testing ordering functionality.
 */
public class OrderAwarePluginRegistryTest extends ComponentPluginRegistryTest {
	TestPlugin firstPlugin;
	TestPlugin secondPlugin;

	@Override
	@Before
	public void setUp() {
		super.setUp();

		firstPlugin = new FirstImplementation();
		secondPlugin = new SecondImplementation();
	}

	@Test
	public void honorsOrderOnAddPlugins() throws Exception {
		PluginRegistry<TestPlugin, String> registry = OrderAwarePluginRegistry.create(Arrays.asList(firstPlugin, secondPlugin));

		assertOrder(registry, secondPlugin, firstPlugin);
	}

	private void assertOrder(PluginRegistry<TestPlugin, String> registry, TestPlugin... plugins) {
		List<TestPlugin> result = registry.getPluginsFor(null);

		assertThat(plugins.length, is(result.size()));

		for (int i = 0; i < plugins.length; i++) {
			assertThat(result.get(i), is(plugins[i]));
		}

		assertThat(registry.getPluginFor(null), is(Optional.of(plugins[0])));
	}

	@Test
	public void createsRevertedRegistryCorrectly() throws Exception {
		OrderAwarePluginRegistry<TestPlugin, String> registry = OrderAwarePluginRegistry.create(Arrays.asList(firstPlugin, secondPlugin));
		PluginRegistry<TestPlugin, String> reverse = registry.reverse();

		assertOrder(registry, secondPlugin, firstPlugin);
		assertOrder(reverse, firstPlugin, secondPlugin);
	}

	@Test
	public void considersJdkProxiedOrderedImplementation() {
		ThirdImplementation plugin = new ThirdImplementation();
		TestPlugin thirdPlugin = (TestPlugin) new ProxyFactory(plugin).getProxy();

		OrderAwarePluginRegistry<TestPlugin, String> registry = create(Arrays.asList(firstPlugin, secondPlugin, thirdPlugin));
		assertOrder(registry, secondPlugin, thirdPlugin, firstPlugin);
		assertOrder(registry.reverse(), firstPlugin, thirdPlugin, secondPlugin);
	}

	@Test
	public void defaultSetupUsesDefaultComparator() {
		assertDefaultComparator(OrderAwarePluginRegistry.<String, TestPlugin> create());
	}

	@Test
	public void defaultSetupUsesDefaultReverseComparator() {
		OrderAwarePluginRegistry<Plugin<Object>, Object> registry = OrderAwarePluginRegistry
				.createReverse(Collections.<Plugin<Object>> emptyList());
		Object field = ReflectionTestUtils.getField(registry, "comparator");
		assertThat(field, is(ReflectionTestUtils.getField(registry, "DEFAULT_REVERSE_COMPARATOR")));
	}

	private static void assertDefaultComparator(OrderAwarePluginRegistry<?, ?> registry) {
		Object field = ReflectionTestUtils.getField(registry, "comparator");
		assertThat(field, is(ReflectionTestUtils.getField(registry, "DEFAULT_COMPARATOR")));
	}

	private static interface TestPlugin extends Plugin<String> {

	}

	@Order(5)
	private static class FirstImplementation implements TestPlugin {
		/*
		 * (non-Javadoc)
		 * 
		 * @see org.springframework.component1.core.Plugin#supports(java.lang.Object)
		 */
		public boolean supports(String delimiter) {
			return true;
		}
	}

	@Order(1)
	private static class SecondImplementation implements TestPlugin {
		/*
		 * (non-Javadoc)
		 * 
		 * @see org.springframework.component1.core.Plugin#supports(java.lang.Object)
		 */
		public boolean supports(String delimiter) {
			return true;
		}
	}

	private static class ThirdImplementation implements TestPlugin, Ordered {
		@Override
		public int getOrder() {
			return 3;
		}
		@Override
		public boolean supports(String delimiter) {
			return true;
		}
	}
}
