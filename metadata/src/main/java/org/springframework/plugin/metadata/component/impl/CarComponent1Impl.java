package org.springframework.plugin.metadata.component.impl;

import org.springframework.plugin.metadata.Car;
import org.springframework.plugin.metadata.component.Component;
import utils.CarUtil;

//@org.springframework.stereotype.Component("carComponent1")
public class CarComponent1Impl implements Component {

	private final Car.Builder builder;

	public CarComponent1Impl(Car car) {
		builder = new Car.Builder(car.getBrand(), car.getType())
				.power(car.getPower())
				.torque(car.getTorque());
	}

	@Override
	public boolean supports(String delimiter) {
		return delimiter.equals(CarUtil.COMPONENT_1);
	}

	@Override
	public Car.Builder getBuilder() {
		return builder;
	}
}
