package utility;

import entity.PizzaItem;
import enums.PizzaType;

public class OrderAutoBuild {

    private OrderMaker orderMaker;
    private PizzaItem pizzaItem;

    public OrderAutoBuild() {
        orderMaker = new OrderMaker();

    }
}
