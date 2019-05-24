package enums;

public enum PizzaType {
    STADART(1), CALZONE(1.5);

    private PizzaType type;
    private final double pizzaBasePrice;

    public PizzaType getType() {
        return type;
    }

    PizzaType(double pizzaBase) {
        this.pizzaBasePrice = pizzaBase;
    }

    public double getPrice() {
        return this.pizzaBasePrice;
    }
}
