package org.springframework.plugin.metadata;

import static org.springframework.util.ObjectUtils.*;

import org.springframework.util.Assert;

public class SimplePluginMetadata implements PluginMetadata {

	private final String name;
	private final String version;

	public SimplePluginMetadata(String name, String version) {
		Assert.hasText(name, "Name must not be null or empty!");
		Assert.hasText(version, "Version must not be null or empty!");
		this.name = name;
		this.version = version;
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.plugin.metadata.PluginMetadata#getName()
	 */
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.plugin.metadata.PluginMetadata#getVersion()
	 */
	public String getVersion() {
		return version;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("%s:%s", getName(), getVersion());
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof PluginMetadata)) return false;

		PluginMetadata that = (PluginMetadata) obj;
		boolean sameName = nullSafeEquals(this.getName(), that.getName());
		boolean sameVersion = nullSafeEquals(this.getVersion(), that.getVersion());

		return sameName && sameVersion;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return nullSafeHashCode(name) + nullSafeHashCode(version);
	}
}
