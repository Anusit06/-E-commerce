package DecoratorPattern;

import FactoryMethodPattern.Shipment;

public abstract class ShipmentDecorator implements Shipment {
    protected Shipment wrappedShipment;

    public ShipmentDecorator(Shipment wrappedShipment){
        this.wrappedShipment = wrappedShipment;
    }
     @Override
    public String getinfo() {
       return wrappedShipment.getinfo();
    }

    @Override
    public double getCost() {
        return wrappedShipment.getCost();
    }
    
}