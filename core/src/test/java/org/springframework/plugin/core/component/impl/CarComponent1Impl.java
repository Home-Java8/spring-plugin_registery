package org.springframework.plugin.core.component.impl;

import org.springframework.plugin.core.Car;
import org.springframework.plugin.core.component.Component;
import utils.CarUtil;

public class CarComponent1Impl implements Component {
	private Car.Builder builder;

	private CarComponent1Impl() {
	}

	public CarComponent1Impl(Car car) {
		builder = new Car.Builder(car.getBrand(), car.getType())
				.power(car.getPower())
				.torque(car.getTorque())
				.gears(car.getGears())
				.color(car.getColor());
	}

	public boolean supports(String delimiter) {
		return delimiter.equals(CarUtil.COMPONENT_1);
	}

	public Car.Builder getBuilder() {
		return builder;
	}
}
