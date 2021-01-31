package com.shelevii.taxi.fleet;

import com.shelevii.taxi.logistic.Route;

public abstract class Taxi {
    private Double pricePerKilometer;
    private Double carPrice;
    private boolean ecoFriendly;

    public Taxi(Double pricePerKilometer, Double carPrice, boolean ecoFriendly) {
        this.pricePerKilometer = pricePerKilometer;
        this.carPrice = carPrice;
        this.ecoFriendly = ecoFriendly;
    }

    public abstract void doRefuel();

    public boolean doJob(Route route) {
        System.out.println("Arrived to :" + route.getStartAddress());
        System.out.println("Picked people up to :" + route.getDestinationAddress());

        Double price = getPricePerKilometer() * route.getLength();
        System.out.println("Earned :" + String.format("Earned :%5.2f", price));
        return true;
    }

    public Double getPricePerKilometer() {
        return pricePerKilometer;
    }

    public Double getCarPrice() {
        return carPrice;
    }

    public boolean isEcoFriendly() {
        return ecoFriendly;
    }
}
