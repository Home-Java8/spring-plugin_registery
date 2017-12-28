package org.springframework.plugin.core;

public class SamplePluginHost {
	private PluginRegistry<SamplePlugin, String> registry = SimplePluginRegistry.create();

	public void setRegistry(PluginRegistry<SamplePlugin, String> registry) {
		this.registry = registry;
	}

	public PluginRegistry<SamplePlugin, String> getRegistry() {
		return registry;
	}
}
