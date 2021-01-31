package com.shelevii.taxi.fleet;

import com.shelevii.taxi.fuel.ChargingStation;

public interface Rechargable {
    default void recharge(ChargingStation chargingStation) {
        System.out.println(chargingStation.getElectricity());
    }
}
