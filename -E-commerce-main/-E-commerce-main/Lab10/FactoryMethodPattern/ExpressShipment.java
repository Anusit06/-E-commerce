package FactoryMethodPattern;

public class ExpressShipment implements Shipment {

    @Override
    public String getinfo() {
       return "Express Delivery";
    }

    @Override
    public double getCost() {
        return 150.0;
    }
    
}
