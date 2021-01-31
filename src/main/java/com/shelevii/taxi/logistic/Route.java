package com.shelevii.taxi.logistic;

public class Route {
    private String startAddress;
    private String destinationAddress;

    public Route() {
        this.startAddress = "";
        this.destinationAddress = "";
    }

    public Double getLength() {
        return Double.valueOf(Math.abs(destinationAddress.hashCode() - startAddress.hashCode()) % 100) + 10d;
    }

    public String getStartAddress() {
        return startAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }
}
