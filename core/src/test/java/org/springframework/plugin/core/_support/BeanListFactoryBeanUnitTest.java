//package org.springframework.plugin.core.support;
//
//import static org.junit.Assert.*;
//import static org.mockito.Matchers.*;
//import static org.mockito.Mockito.*;
//
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.runners.MockitoJUnitRunner;
//import org.springframework.context.ApplicationContext;
//import org.springframework.core.Ordered;
//
///**
// * Unit test for {@link BeanListFactoryBean}
// */
//@RunWith(MockitoJUnitRunner.class)
//public class BeanListFactoryBeanUnitTest {
//
//	BeanListFactoryBean<Ordered> factory;
//
//	@Mock ApplicationContext context;
//
//	@Before
//	public void setUp() {
//
//		factory = new BeanListFactoryBean<Ordered>();
//		factory.setApplicationContext(context);
//		factory.setType(Ordered.class);
//		factory.afterPropertiesSet();
//	}
//
//	@Test
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	public void regardsOrderOfBeans() throws Exception {
//
//		// They shall be switched in the result.
//		Ordered first = () -> 5;
//		Ordered second = () -> 0;
//
//		when(context.getBeanNamesForType(Ordered.class, false, false)).thenReturn(new String[] { "first", "second" });
//		when(context.getType(any(String.class))).thenReturn((Class) Ordered.class);
//		when(context.getBean("first")).thenReturn(first);
//		when(context.getBean("second")).thenReturn(second);
//
//		Object result = factory.getObject();
//		assertTrue(result instanceof List<?>);
//
//		List<Ordered> members = type(result);
//
//		assertEquals(0, members.indexOf(second));
//		assertEquals(1, members.indexOf(first));
//	}
//
//	@Test
//	public void returnsEmptyListIfNoBeansFound() throws Exception {
//
//		when(context.getBeanNamesForType(Ordered.class, false, false)).thenReturn(new String[0]);
//
//		Object result = factory.getObject();
//		assertTrue(result instanceof List<?>);
//
//		List<Ordered> members = type(result);
//		assertTrue(members.isEmpty());
//	}
//
//	@SuppressWarnings("unchecked")
//	private <T> List<T> type(Object list) {
//		return (List<T>) list;
//	}
//}
