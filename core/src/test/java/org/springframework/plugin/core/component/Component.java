package org.springframework.plugin.core.component;

import org.springframework.plugin.core.Car;
import org.springframework.plugin.core.Plugin;

public interface Component extends Plugin<String> {
	Car.Builder getBuilder();
}
