package com.shelevii.taxi.logistic;

import com.shelevii.taxi.fleet.Lanos;
import com.shelevii.taxi.fleet.Taxi;
import com.shelevii.taxi.fleet.Tesla;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Manager {
    private List<Taxi> availableCars;

    public Manager() {
        availableCars = new LinkedList<>();
        availableCars.add(new Lanos());
        availableCars.add(new Tesla());
        availableCars.add(new Tesla());
    }

    public boolean processOrder(Order order) {
        Optional<Taxi> taxi = availableCars.stream()
                .filter(car -> order.isEcoFriendly() ? car.isEcoFriendly() : true)
                .findAny();

        return taxi.map(car -> car.doJob(order.getRoute()))
                .orElse(false);
    }

    public Double getFleetPrice() {
        return availableCars.stream()
                .map(Taxi::getCarPrice)
                .reduce(0d, (x, y) -> x + y);
    }
}
