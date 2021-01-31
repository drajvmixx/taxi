package com.shelevii.taxi.fleet;

import com.shelevii.taxi.fuel.ChargingStation;

public class Tesla extends Taxi implements Rechargable {
    public Tesla() {
        super(1.0d, 40000d, true);
    }

    public void doRefuel() {
        recharge(new ChargingStation());
    }
}
