package DecoratorPattern;

import FactoryMethodPattern.Shipment;
/**
 *  Concrete Decorator: บริการห่อของขวัญ
 * */ 
public class GiftWrapDecorator extends ShipmentDecorator  {

    public GiftWrapDecorator(Shipment wrappedShipment) {
        super(wrappedShipment);
    }
     @Override
    public String getinfo() {
       return super.getinfo() + " + Gift Wrapped";
    }

    @Override
    public double getCost() {
        return super.getCost()+50.0;
    }
    
    
}
