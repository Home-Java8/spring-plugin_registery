package org.springframework.plugin.core;

public interface Component extends Plugin<String> {
	Car.Builder getBuilder();
}
