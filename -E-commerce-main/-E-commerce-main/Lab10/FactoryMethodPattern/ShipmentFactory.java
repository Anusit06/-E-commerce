package FactoryMethodPattern;

public class ShipmentFactory {

   public Shipment createShipment(String type) {
    if ("STANDARD".equals(type)) {
        return new StandardShipment();
    }else if ("EXPRESS".equals(type)) {
        return new ExpressShipment();
    }
    throw new IllegalArgumentException("Unknown shipment");
  }

}
