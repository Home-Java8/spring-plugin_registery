package org.springframework.plugin.core;

/**
 * Это обычный автомобиль
 */
public class Car {
    // бренд
    private final String brand;
    // марка
    private final String type;
    // мощность
    private final int power;
    // крутящий момент
    private final int torque;
    // количество передач
    private final int gears;
    // цвет
    private final String color;

    // только такой конструктор помогает реализвать паттерн билдера...этот конструктор уже только в самом конце строит объект по тем полям которые были перечислены в иннициализации
    protected Car(Builder builder) {
        this.brand = builder.brand;
        this.type = builder.type;
        this.power = builder.power;
        this.torque = builder.torque;
        this.gears = builder.gears;
        this.color = builder.color;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public int getPower() {
        return power;
    }

    public int getTorque() {
        return torque;
    }

    public int getGears() {
        return gears;
    }

    public String getColor() {
        return color;
    }


    // здесь можно выборочно указывать какие поля должны иннициализироваться в момент вызова
    public static class Builder {
        private final String brand;
        private final String type;
        private    int power;
        private    int torque;
        private    int gears;
        private String color;

        /**
         * Обязательные параметры
         */
        public Builder(String brand, String type) {
            this.brand = brand;
            this.type = type;
        }

        /**
         * Необязательные параметры
         */
        public Builder power(int power) {
            this.power = power;
            return this;
        }

        public Builder torque(int torque) {
            this.torque = torque;
            return this;
        }

        public Builder gears(int gears) {
            this.gears = gears;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }


    /**
     * Если тип уже полученный и я хочу находу к нему добавить новые параметры (динамически...)
     */
    protected Builder decorate(Builder builder) {
        return builder;
//                .power(getPower())
//                .torque(getTorque())
//                .gears(getGears())
//                .color(getColor());
    }

    public Builder toBuilder() {
        Builder newBuilder = new Builder(getBrand(), getType());
        return decorate(newBuilder);
    }
}