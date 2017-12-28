package org.springframework.plugin.core;

public class Component2Impl implements Component {
	private Car.Builder builder;

	private Component2Impl() {
	}

	public Component2Impl(Car car) {
                builder = new Car.Builder(car.getBrand(), car.getType())
				.power(car.getPower())
				.torque(car.getTorque());
	}

	public boolean supports(String delimiter) {
		return delimiter.equals(MyUtil.COMPONENT_2);
	}

	public Car.Builder getBuilder() {
		return builder;
	}
}
