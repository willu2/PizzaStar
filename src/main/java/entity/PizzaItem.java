package entity;
import enums.PizzaType;
import java.util.ArrayList;

public class PizzaItem {

    private final int pizzaNumber;

    private PizzaType pizzaType;
    private ArrayList<String> adds;
    private String pizzaName = "No name";
    private String timeCreate;

    private double pizzaPrice = 0.0;
    private double currentIngridPrice = 0.0;

    private int clientNumber = 0;
    private int pizzaItemsCount = 1;

    private boolean priceAcces = false;

    public PizzaItem(int pizzaNumber) {
        this.pizzaNumber = pizzaNumber;
        adds = new ArrayList();
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
        if(isPriceAcces()){
            this.pizzaPrice += pizzaPrice;
            this.currentIngridPrice = pizzaPrice;
        }
    }

    public ArrayList getAdds() {
        return adds;
    }

    public void  addIngredient(String addsq) {
        if(!adds.contains(addsq)){
            adds.add(addsq);
            setPriceAcces(true);
        }else{
            setPriceAcces(false);
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

    public int getPizzaItemsCount() {
        return pizzaItemsCount;
    }

    public void setPizzaItemsCount(int pizzaItemsCount) {
        this.pizzaItemsCount = pizzaItemsCount;
    }

    public boolean isPriceAcces() {
        return priceAcces;
    }

    public void setPriceAcces(boolean priceAcces) {
        this.priceAcces = priceAcces;
    }

    public String getTime() {
        return timeCreate;
    }

    public void setTimeCreate(String timeCreate) {
        this.timeCreate = timeCreate;
    }

    @Override
    public String toString() {
        return "PizzaItem [pizzaNumber=" + pizzaNumber
                + ", pizzaType=" + pizzaType
                + ", pizzaName=" + pizzaName
                + ", pizzaPrice=" + pizzaPrice
                + ", ingridPrice=" + currentIngridPrice
                + ", clientNumber=" + clientNumber
                + ", pizzaItemsCount=" + pizzaItemsCount
                + "]";
    }
}
