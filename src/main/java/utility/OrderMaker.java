package utility;

import entity.PizzaItem;
import enums.PizzaType;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class OrderMaker {

    private List<PizzaItem> visitorOrder;
    private OrderService service = new OrderService();

    private PizzaItem pizzaItem;

    private LocalTime time;

    public OrderMaker() {
        visitorOrder = new ArrayList<PizzaItem>();
    }

    public void createPizza() {
        pizzaItem = new PizzaItem(service.randOrderN());
        visitorOrder.add(pizzaItem);
        service.setClientNum(pizzaItem);
        service.setBaseAccess(true);
    }

    public void addPizzaBase(int baseNum) {
        service.addBase(pizzaItem, baseNum);
    }

    public void addPizzaAdds(int addNum) {
        service.addAdd(pizzaItem, addNum);
    }

    public void addPizzaName() {
        String pizzaN = service.pizzaNameEnter(pizzaItem);
        pizzaItem.setPizzaName(pizzaN);
    }

    public void showOrder() {

        if (visitorOrder != null || visitorOrder.size() != 0) {
            for (PizzaItem item : visitorOrder) {
              //  service.showOrder(item);

              //  System.out.println("         ------");
               // System.out.println("         ------");

                service.showOrderNewType(item);
                // service.findEnumData(item);
            }
        } else {
            service.showEmtyInfo();
        }
        System.out.println();
    }

    public void removeAdd() {
        service.removeAdd(pizzaItem);
    }

    public void pizzaNumbersEnter() {
        service.pizzaNumbersEnter(pizzaItem);
    }


    ///==========================

    public void autoPizza1() {
        createPizza();
        pizzaItem.setPizzaName("Margarita");
        pizzaItem.setPizzaType(PizzaType.STADART);
        pizzaItem.setPizzaItemsCount(1);
        addPizzaAdds(1);
        addPizzaAdds(4);
        addPizzaAdds(5);
        addPizzaAdds(7);

    }

    public void autoPizza2() {
        createPizza();
        pizzaItem.setPizzaName("Bavarian");
        pizzaItem.setPizzaType(PizzaType.STADART);
        pizzaItem.setPizzaItemsCount(2);
        addPizzaAdds(1);
        addPizzaAdds(2);
        addPizzaAdds(3);
        addPizzaAdds(8);

    }

    public void autoPizza7717() {
        createPizza();
        pizzaItem.setPizzaName("Margarita");
        pizzaItem.setPizzaType(PizzaType.CALZONE);
        pizzaItem.setPizzaItemsCount(2);
        addPizzaAdds(1);
        addPizzaAdds(2);

        createPizza();
        pizzaItem.setPizzaName("Pepperoni");
        pizzaItem.setPizzaType(PizzaType.STADART);
        pizzaItem.setPizzaItemsCount(3);
        addPizzaAdds(1);
        addPizzaAdds(3);
        addPizzaAdds(4);
        addPizzaAdds(7);

    }

    public void autoPizza4372() {
        createPizza();
        pizzaItem.setPizzaName("BasePZZ");
        pizzaItem.setPizzaType(PizzaType.STADART);
        pizzaItem.setPizzaItemsCount(6);
        addPizzaAdds(1);
        addPizzaAdds(2);
        addPizzaAdds(5);

        createPizza();
        pizzaItem.setPizzaName("BasePZZ");
        pizzaItem.setPizzaType(PizzaType.STADART);
        pizzaItem.setPizzaItemsCount(6);
        addPizzaAdds(1);
        addPizzaAdds(2);
        addPizzaAdds(5);

    }
}
