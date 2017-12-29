///*
// * Copyright 2012-2016 the original author or authors.
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *      http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//package org.springframework.plugin.core.config;
//
//import static org.hamcrest.CoreMatchers.*;
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.plugin.core.component.impl.CarComponent1Impl;
//import org.springframework.plugin.core.Plugin;
//import org.springframework.plugin.core.PluginRegistry;
//import org.springframework.plugin.core.component.Component;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
///**
// * Integration tests for {@link EnablePluginRegistries}
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration
//public class EnablePluginRegistriesIntegrationTest {
//
//	@Configuration
//	@EnablePluginRegistries({ Component.class, AnotherPlugin.class })
//	static class Config {
//
//		@Bean
//		public CarComponent1Impl pluginImpl() {
//			return new CarComponent1Impl();
//		}
//	}
//
//	@Autowired PluginRegistry<Component, String> registry;
//
//	@Test
//	public void registersPluginRegistries() {
//		assertThat(registry, is(notNullValue()));
//	}
//
//	@Qualifier("myQualifier")
//	interface AnotherPlugin extends Plugin<String> {}
//
//	static class AnotherSample1PluginImpl implements AnotherPlugin {
//
//		@Override
//		public boolean supports(String delimiter) {
//			return true;
//		}
//	}
//}
