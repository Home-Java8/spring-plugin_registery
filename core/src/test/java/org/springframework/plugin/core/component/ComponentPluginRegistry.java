package org.springframework.plugin.core.component;

import org.springframework.plugin.core.PluginRegistry;
import org.springframework.plugin.core.SimplePluginRegistry;

public class ComponentPluginRegistry {
	private PluginRegistry<Component, String> registry = SimplePluginRegistry.create();

	public void setRegistry(PluginRegistry<Component, String> registry) {
		this.registry = registry;
	}

	public PluginRegistry<Component, String> getRegistry() {
		return registry;
	}
}
