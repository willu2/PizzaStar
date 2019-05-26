package entity;
import enums.PizzaType;
import java.util.ArrayList;

public class PizzaItem {

    private final int pizzaNumber;

    private PizzaType pizzaType;
    private ArrayList<String> adds;
    private String pizzaName = "temp";
    private double pizzaPrice = 0;
    private int clientNumber = 0;

    public PizzaItem(int pizzaNumber) {
        this.pizzaNumber = pizzaNumber;
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
        this.pizzaPrice += pizzaPrice;
    }

    public ArrayList getAdds() {
        return adds;
    }

    public void  setAdds(String addsq) {
        if(!adds.contains(addsq)){
            adds.add(addsq);
        }else{
            System.out.println("Can't add twice");
        }
    }

    public PizzaType getPizzaType() {
        return pizzaType;
    }

    public void setPizzaType(PizzaType pizzaType) {
        this.pizzaType = pizzaType;
    }

    public int getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(int number) {
        clientNumber = number;
    }
}
