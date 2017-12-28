package org.springframework.plugin.metadata;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class SimplePluginMetadataUnitTest {

	@Test
	public void equalsIsWorkingCorrectly() {
		SimplePluginMetadata nameOneOh = new SimplePluginMetadata("Name", "1.0");
		SimplePluginMetadata sameNameOneOh = new SimplePluginMetadata("Name", "1.0");
		SimplePluginMetadata nameTwoOh = new SimplePluginMetadata("Name", "2.0");
		SimplePluginMetadata anotherNameOneOh = new SimplePluginMetadata("AnotherName", "1.0");

		assertThat(nameOneOh, is(nameOneOh));
		assertThat(nameOneOh, is(sameNameOneOh));
		assertThat(sameNameOneOh, is(nameOneOh));

		assertThat(nameOneOh, is(not(nameTwoOh)));
		assertThat(nameTwoOh, is(not(nameOneOh)));

		assertThat(nameOneOh, is(not(anotherNameOneOh)));
		assertThat(anotherNameOneOh, is(not(nameOneOh)));
	}
}
