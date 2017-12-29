package org.springframework.plugin.core;

import org.springframework.plugin.core.component.impl.CarComponent1Impl;
import org.springframework.plugin.core.component.impl.CarComponent2Impl;
import org.springframework.plugin.core.component.Component;

import java.util.Arrays;

public class CarBuilder {
    private Car.Builder builder;

    private CarBuilder() {
    }

    // (здесь хорошо-бы использовать декоратор, но он неработает...потому-что объект Builder должен быть чистым чтобы можно было заново его иннициализировтаь)
    /**
     * Это мой CarBuilder - он полностью заменяет класс-CarBuilder со списком swith-case...
     * (а вся реализация скрыта в недрях Spring-а)
     */
    public CarBuilder(Car car, String type) {
        SimplePluginRegistry<Component, String> registry =
                SimplePluginRegistry.create(
                        Arrays.asList(new CarComponent1Impl(car), new CarComponent2Impl(car)) );

        builder = registry.getPluginsFor(type)
                .get(0)
                .getBuilder();
    }

    public Car build() {
        return builder.build();
    }
}
