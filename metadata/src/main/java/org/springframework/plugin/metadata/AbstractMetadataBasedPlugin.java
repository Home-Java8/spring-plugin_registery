package org.springframework.plugin.metadata;

import org.springframework.plugin.core.Plugin;
import org.springframework.plugin.core.PluginRegistry;

/**
 * Abstract base class for plugins based on {@link PluginMetadata}. Plugins based on this class can be selected from the
 * {@link PluginRegistry} via an instance of {@link PluginMetadata}. Therefore you can regard this as a role model implementation of a base class for certain delimiter implmentations.
 */
public abstract class AbstractMetadataBasedPlugin implements Plugin<PluginMetadata>, MetadataProvider {

	private final PluginMetadata metadata;

	/**
	 * Creates a new instance of {@code AbstractMetadataBasedPlugin}.
	 */
	public AbstractMetadataBasedPlugin(String name, String version) {
		this.metadata = new SimplePluginMetadata(name, version);
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.plugin.core.Plugin#supports(java.lang.Object)
	 */
	public boolean supports(PluginMetadata delimiter) {
		return getMetadata().equals(delimiter);
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.plugin.metadata.MetadataProvider#getMetadata()
	 */
	public PluginMetadata getMetadata() {
		return metadata;
	}
}
