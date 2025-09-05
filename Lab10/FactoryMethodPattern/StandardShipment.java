package FactoryMethodPattern;

public class StandardShipment implements  Shipment{

    @Override
    public String getinfo() {
        return "Standard Delivery";
    }

    @Override
    public double getCost() {
        return 50.0;
    }
    
}
