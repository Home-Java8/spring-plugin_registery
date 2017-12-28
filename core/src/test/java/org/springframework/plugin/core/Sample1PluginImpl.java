package org.springframework.plugin.core;

public class Sample1PluginImpl implements SamplePlugin {

	/*
	 * (non-Javadoc)
	 * @see org.springframework.plugin.core.Plugin#supports(java.lang.Object)
	 */
	public boolean supports(String delimiter) {
		return "FOO".equals(delimiter);
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.plugin.core.SamplePlugin#pluginMethod()
	 */
	public void pluginMethod() {

	}
}
