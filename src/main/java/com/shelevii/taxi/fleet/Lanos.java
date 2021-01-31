package com.shelevii.taxi.fleet;

import com.shelevii.taxi.fuel.GasStation;

public class Lanos extends Taxi implements Refuelable {
    public Lanos() {
        super(2.5d, 4000d, false);
    }

    public void doRefuel() {
        refuel(new GasStation());
    }
}
