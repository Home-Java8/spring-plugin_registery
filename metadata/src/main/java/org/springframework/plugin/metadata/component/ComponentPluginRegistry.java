package org.springframework.plugin.metadata.component;

import org.springframework.plugin.core.PluginRegistry;
import org.springframework.plugin.core.SimplePluginRegistry;
import org.springframework.plugin.metadata.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@org.springframework.stereotype.Component
public class ComponentPluginRegistry {

    private static PluginRegistry<Component, String> registry = SimplePluginRegistry.create();

    public static void registry(Component... components) {
        int size = registry.getPlugins().size();
        if (size==0) {
            registry = SimplePluginRegistry.create(Arrays.asList(components));
        } else {
            List<Component> _components = new ArrayList<>(registry.getPlugins());
            _components.addAll(Arrays.asList(components));
            registry = SimplePluginRegistry.create(_components);
        }
    }

    public static Component getPluginsFor(String type) {
        return registry.getPluginsFor(type)
                .get(0);
    }

    public static List<Component> getPlugins() {
        return registry.getPlugins();
    }
}
