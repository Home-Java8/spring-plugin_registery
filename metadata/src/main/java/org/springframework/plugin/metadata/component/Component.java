package org.springframework.plugin.metadata.component;

import org.springframework.plugin.core.Plugin;
import org.springframework.plugin.metadata.Car;

public interface Component extends Plugin<String> {

	Car.Builder getBuilder();

}
