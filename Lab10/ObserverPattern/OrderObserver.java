package ObserverPattern;

import DataModels.Order;
/**
 * Interface (Observer) สำหรับผู้สังเกตุการณ์
 */
public interface OrderObserver {
     void update(Order order);

}