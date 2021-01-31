package com.shelevii.taxi.logistic;

public class Order {
    private Route route;
    private boolean ecoFriendly;

    public Order() {
        route = new Route();
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public boolean isEcoFriendly() {
        return ecoFriendly;
    }

    public void setEcoFriendly(boolean ecoFriendly) {
        this.ecoFriendly = ecoFriendly;
    }
}
