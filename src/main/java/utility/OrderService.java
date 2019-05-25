package utility;

import enums.PizzaAdds;
import enums.PizzaType;
import utility.PizzaNumberGenerator;

public class OrderService {

    private final int pizzaLimit = 10;
    private boolean base = true;

    PizzaNumberGenerator generator = PizzaNumberGenerator.getInstance();

    public int randOrderN(){
            return generator.getPizzaNumber();
    }

    public PizzaType addBase(int baseNum){
        PizzaType arr[] = PizzaType.values();
        if(baseNum <= 0 || baseNum > arr.length){
            baseNum = 1;
        }

        if(base){
            base = !base;
            return PizzaType.values()[baseNum - 1];
        }else {
            System.out.println("Base is added");
        }
        return PizzaType.values()[baseNum - 1];
    }

    public double getPriceBase(int baseNum){
        PizzaType arr[] = PizzaType.values();

        return PizzaType.values()[baseNum - 1].getPrice();
    }

    public double getPriceAdd (int addNum){
        PizzaAdds arr[] = PizzaAdds.values();

        return PizzaAdds.values()[addNum - 1].getPrice();
    }

    public String addAdd(int addNum){
        PizzaAdds arr[] = PizzaAdds.values();
        if(addNum <= 0 || addNum > arr.length){
            System.out.println("wrong item");
        }
        return String.valueOf(PizzaAdds.values()[addNum - 1]);//

    }

    public void removeAdd(){
    }

    public int getPizzaLimit() {
        return pizzaLimit;
    }
}
