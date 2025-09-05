import java.util.List;

import DataModels.Order;
import DataModels.Product;
import DecoratorPattern.GiftWrapDecorator;
import DecoratorPattern.InsuranceDecorator;
import FactoryMethodPattern.Shipment;
import FactoryMethodPattern.ShipmentFactory;
import ObserverPattern.EmailService;
import ObserverPattern.InventoryService;
import ObserverPattern.OrderProcessor;
import StrategyPattern.DiscountStrategy;
import StrategyPattern.FixedDiscount;
import StrategyPattern.OrderCalculator;
import StrategyPattern.PercentageDiscount;
public class ManualTestRunner {
    public static void main(String[] args) {
    System.out.println("--- E-comerce System Simulation ---");
    //--- 1.Setup ---
    Product Ipad = new Product("P001", "Ipad", 35000.0);
    Product Airpods = new Product("P002", "Airpods", 8800);
    Product SamsungPhone = new Product("P003", "SamsungPhone", 40000.0);
    Order myOrder = new Order("ORD-005", List.of(Ipad, Airpods,SamsungPhone), "Anusit.he@gmail.com");

    OrderCalculator calculator = new OrderCalculator();
    ShipmentFactory shipmentFactory = new ShipmentFactory();

    OrderProcessor orderProcessor = new OrderProcessor();
    InventoryService inventory  = new InventoryService();
    EmailService emailer = new EmailService();
    orderProcessor.register(inventory);
    orderProcessor.register(emailer);

    System.out.println("\n--- 2.Testing Strategy pattern (Discount) ---");
    double originalPrice = myOrder.getTotalPrice();
    System.out.println("Origin Price:  "+ originalPrice);

    DiscountStrategy tenPercenoff = new PercentageDiscount(10);
    double priceAfterPecentage  =  calculator.calculateFinalPrice(myOrder, tenPercenoff);
    System.out.println("Price with 10% discount:  " + priceAfterPecentage);

    DiscountStrategy fourHundredoff  = new FixedDiscount(400);
    double priceAfterFixed  =  calculator.calculateFinalPrice(myOrder, fourHundredoff);
    System.out.println("Price with 400 THB discount:  " + priceAfterFixed);

    System.out.println("\n--- 3.Testing Factory and Decorator Patterns (Shipment) ---");
    //สร้างการจัดส่งแบบมาตรฐาน
    Shipment standardShipment = shipmentFactory.createShipment("STANDARD");
    System.out.println("Basw Shipment: "+ standardShipment.getinfo()+", Cost: "+standardShipment.getCost());

    //"ห่อ"ด้วยบริการห่อของขวัญ
    Shipment giftWrapped = new GiftWrapDecorator(standardShipment);
    System.out.println("Decorated: "+ giftWrapped.getinfo()+", Cost: "+giftWrapped.getCost());

    //"ห่อ" ด้วยบริการประกันสินค้า

    Shipment fullyLoaded = new InsuranceDecorator(standardShipment, myOrder);
    System.out.println("Fully Decorated: "+ fullyLoaded.getinfo() + ", Cost: " + fullyLoaded.getCost());


    Sys
    }
}
