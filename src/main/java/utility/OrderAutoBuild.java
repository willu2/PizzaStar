package utility;

import entity.PizzaItem;

public class OrderAutoBuild {

    private OrderMaker orderMaker;
    private PizzaItem pizzaItem;

    public OrderAutoBuild() {
        orderMaker = new OrderMaker();
    }
}
