package org.springframework.plugin.core.component.impl;

import org.springframework.plugin.core.Car;
import org.springframework.plugin.core.component.Component;
import utils.CarUtil;

public class CarComponent2Impl implements Component {
	private Car.Builder builder;

	private CarComponent2Impl() {
	}

	public CarComponent2Impl(Car car) {
		builder = new Car.Builder(car.getBrand(), car.getType())
				.power(car.getPower())
				.torque(car.getTorque());
	}

	public boolean supports(String delimiter) {
		return delimiter.equals(CarUtil.COMPONENT_2);
	}

	public Car.Builder getBuilder() {
		return builder;
	}
}
