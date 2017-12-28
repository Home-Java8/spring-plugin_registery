package org.springframework.plugin.core;

public class Component1Impl implements Component {
	private Car.Builder builder;

	private Component1Impl() {
	}

	public Component1Impl(Car car) {
		builder = new Car.Builder(car.getBrand(), car.getType())
				.power(car.getPower())
				.torque(car.getTorque())
				.gears(car.getGears())
				.color(car.getColor());
	}

	public boolean supports(String delimiter) {
		return delimiter.equals(MyUtil.COMPONENT_1);
	}

	public Car.Builder getBuilder() {
		return builder;
	}
}
