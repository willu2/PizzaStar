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

    public String addAdd(int addNum){
        PizzaAdds arr[] = PizzaAdds.values();
        if(addNum > arr.length){
            addNum = 1;
        }
        return String.valueOf(PizzaAdds.values()[addNum-1]);//PizzaAdds.values()[addNum];

    }

    public void removeAdd(){

    }

    public PizzaType addBase(int baseNum){
        PizzaType arr[] = PizzaType.values();
        if(baseNum > arr.length){
            baseNum = 1;
        }

        if(base){
           base = !base;
           return PizzaType.values()[baseNum];
        }else {
            System.out.println("Base is added");
        }
        return PizzaType.values()[baseNum];
    }

    public int getPizzaLimit() {
        return pizzaLimit;
    }
}