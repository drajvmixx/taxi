package com.shelevii.taxi.fleet;

import com.shelevii.taxi.fuel.GasStation;

public interface Refuelable {
    default void refuel(GasStation station) {
        System.out.println(station.getFuel());
    };
}
