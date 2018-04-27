package org.springframework.plugin.metadata.component.impl;

import org.springframework.plugin.metadata.Car;
import org.springframework.plugin.metadata.component.Component;
import org.springframework.plugin.metadata.component.ComponentPluginRegistry;
import utils.CarUtil;

//@org.springframework.stereotype.Component("carComponent2")
public class CarComponent2Impl implements Component {

	private final Car.Builder builder;

	public CarComponent2Impl(Car car) {
		builder = new Car.Builder(car.getBrand(), car.getType())
				.power(car.getPower())
				.torque(car.getTorque())
				.gears(car.getGears())
				.color(car.getColor());
	}

	@Override
	public boolean supports(String delimiter) {
		return delimiter.equals(CarUtil.COMPONENT_2);
	}

	@Override
	public Car.Builder getBuilder() {
		return builder;
	}
}
