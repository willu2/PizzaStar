package entity;
import enums.PizzaType;
import java.util.ArrayList;

public class PizzaItem {

    private final int pizzaNumber;

    private PizzaType pizzaType;

    private ArrayList<String> adds;

    private String pizzaName = "";
    private double pizzaPrice = 0;

    public PizzaItem(int pizzaNumber, String pizzaName, PizzaType pizzaType ) {
        this.pizzaNumber = pizzaNumber;
        this.pizzaName = pizzaName;
        this.pizzaType = pizzaType;
        adds = new ArrayList<String>();
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public int getPizzaNumber() {
        return pizzaNumber;
    }

    public double getPizzaPrice() {
        return pizzaPrice;
    }

    public void setPizzaPrice(double pizzaPrice) {
        this.pizzaPrice = pizzaPrice;
    }

    public PizzaType getPizzaType() {
        return pizzaType;
    }

    public ArrayList getAdds() {
        return adds;
    }

    public void  setAdds(String addsq) {
        adds.add(addsq);
    }
}
