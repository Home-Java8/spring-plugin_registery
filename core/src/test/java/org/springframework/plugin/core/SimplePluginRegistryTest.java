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
public class SimplePluginRegistryTest {
	SamplePlugin plugin;
	SimplePluginRegistry<SamplePlugin, String> registry;
	@Rule
	public ExpectedException o_O = ExpectedException.none();

	@Before
	public void setUp() {
		plugin = new Sample1PluginImpl();
		registry = SimplePluginRegistry.create();
	}

	/**
	 * Asserts that the registry contains the plugin it was initialized with.
	 */
	@Test
	public void assertRegistryInitialized() throws Exception {
		registry = SimplePluginRegistry.create(Arrays.asList(plugin));

		assertThat(registry.countPlugins(), is(1));
		assertTrue(registry.contains(plugin));
	}

	/**
	 * Asserts asking for a plugin with the {@code PluginMetadata} provided by the {@link EmailNotificationProvider}.
	 */
	@Test
	public void assertFindsEmailNotificationProvider() {
		registry = SimplePluginRegistry.create(Arrays.asList(plugin));

		String delimiter = "FOO";

		List<SamplePlugin> plugins = registry.getPluginsFor(delimiter);
		assertThat(plugins, is(notNullValue()));
		assertThat(plugins.size(), is(1));

		SamplePlugin provider = plugins.get(0);
		assertThat(provider, is(instanceOf(Sample1PluginImpl.class)));
	}

	/**
	 * Expects the given exception to be thrown if no {@link Plugin} found.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void throwsExceptionIfNoPluginFound() {
		registry.getPluginFor("BAR", () -> new IllegalArgumentException());
	}

	/**
	 * Expects the given exception to be thrown if no {@link Plugin}s found.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void throwsExceptionIfNoPluginsFound() {
		registry.getPluginsFor("BAR", () -> new IllegalArgumentException());
	}

	/**
	 * Expect the defualt plugin to be returned if none found.
	 */
	@Test
	public void returnsDefaultIfNoneFound() {
		SamplePlugin defaultPlugin = new Sample1PluginImpl();

		assertThat(registry.getPluginOrDefaultFor("BAR", defaultPlugin), is(defaultPlugin));
	}

	/**
	 * Expect the given default plugins to be returned if none found.
	 */
	@Test
	public void returnsDefaultsIfNoneFound() {
		List<? extends SamplePlugin> defaultPlugins = Arrays.asList(new Sample1PluginImpl());

		List<SamplePlugin> result = registry.getPluginsFor("BAR", defaultPlugins);
		assertTrue(result.containsAll(defaultPlugins));
	}

	@Test
	public void handlesAddingNullPluginsCorrecty() throws Exception {
		List<SamplePlugin> plugins = new ArrayList<SamplePlugin>();
		plugins.add(null);

		registry = SimplePluginRegistry.create(plugins);

		assertThat(registry.countPlugins(), is(0));
	}

	@Test(expected = IllegalStateException.class)
	public void testname() throws Exception {

		registry = SimplePluginRegistry.create(Collections.<SamplePlugin> emptyList());

		registry.getPluginFor("FOO", () -> new IllegalStateException());
	}

	public void throwsExceptionIfRequiredPluginIsNotFound() {
		registry = SimplePluginRegistry.create(Collections.emptyList());

		o_O.expect(IllegalArgumentException.class);

		registry.getRequiredPluginFor("FOO");
	}

	public void throwsExceptionWithMessafeIfRequiredPluginIsNotFound() {
		registry = SimplePluginRegistry.create(Collections.emptyList());

		o_O.expect(IllegalArgumentException.class);
		o_O.expectMessage("message");

		registry.getRequiredPluginFor("FOO", () -> "message");
	}
}
