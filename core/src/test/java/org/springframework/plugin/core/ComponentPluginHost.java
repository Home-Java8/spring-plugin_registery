package org.springframework.plugin.core;

public class ComponentPluginHost {
	private PluginRegistry<Component, String> registry = SimplePluginRegistry.create();

	public void setRegistry(PluginRegistry<Component, String> registry) {
		this.registry = registry;
	}

	public PluginRegistry<Component, String> getRegistry() {
		return registry;
	}
}
