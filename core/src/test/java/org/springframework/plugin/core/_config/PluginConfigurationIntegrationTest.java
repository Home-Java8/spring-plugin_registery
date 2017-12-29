//package org.springframework.plugin.core.config;
//
//import static org.junit.Assert.*;
//
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.plugin.core.PluginRegistry;
//import org.springframework.plugin.core.component.Component;
//import org.springframework.plugin.core.component.ComponentPluginRegistry;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
///**
// * Integration test to simply check if the configuration gets parsed correctly.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:application-context.xml")
//public class PluginConfigurationIntegrationTest {
//
//	@Autowired
//	List<Component> components;
//
//	@Autowired
//	@Qualifier("bar")
//	PluginRegistry<Component, String> pluginRegistry;
//
//	@Autowired
//	@Qualifier("host")
//    ComponentPluginRegistry host;
//
//	@Autowired
//	@Qualifier("otherHost")
//    ComponentPluginRegistry otherHost;
//
//	@Autowired
//    Component plugin;
//
//	@Test
//	public void test() throws Exception {
//
//		assertNotNull(components);
//
//		assertSame(pluginRegistry, host.getRegistry());
//		assertNotSame(pluginRegistry, otherHost.getRegistry());
//
//		assertTrue(components.contains(plugin));
//		assertTrue(pluginRegistry.contains(plugin));
//	}
//}
