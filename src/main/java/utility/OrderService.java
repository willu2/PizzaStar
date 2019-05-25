package utility;

import entity.PizzaItem;
import enums.PizzaAdds;
import enums.PizzaType;

public class OrderService {

    private static int clientNumber = 50;

    private final int pizzaLimit = 10;

    private boolean baseAccess = true;


    PizzaNumberGenerator generator = PizzaNumberGenerator.getInstance();

    public int randOrderN(){
            return generator.getPizzaNumber();
    }

    public void addBase(PizzaItem item, int baseNum){

        if (checkBaseLimit(baseNum)) {
            if(baseAccess){
                baseAccess = !baseAccess;
                item.setPizzaType(PizzaType.values()[baseNum - 1]);
                item.setPizzaPrice(PizzaType.values()[baseNum - 1].getPrice());
            }else {
                System.out.println("Base is added");
            }
        }
    }

    public void addAdd(PizzaItem item, int addNum){
        if (addNum == 0) {
            return;
        }
            if (checkInpLimit(addNum) ) {
                item.setAdds(String.valueOf(PizzaAdds.values()[addNum - 1]));
                item.setPizzaPrice(PizzaAdds.values()[addNum - 1].getPrice());
            }
    }

    public boolean checkInpLimit(int addNum){
        PizzaAdds arr[] = PizzaAdds.values();
        int itemNum = addNum;
        int limit = arr.length;
            if (itemNum > 0 && itemNum <= limit) {
                return true;
            }

        return false;
    }

    public boolean checkBaseLimit(int addNum){
        PizzaType arr[] = PizzaType.values();
        int itemNum = addNum;
        int limit = arr.length;
            if (itemNum > 0 && itemNum <= limit) {
                return true;
            }
        return false;
    }


   /* public int menuItemEnter(int check){
        int pizzaNum = 0;

        try {
            while (pizzaNum <= 0 || pizzaNum >= check ){
                System.out.println("Enter correct item: ");
                try {
                    BufferedReader inPrice = new BufferedReader(new InputStreamReader(System.in));
                    pizzaNum = Integer.parseInt(inPrice.readLine());
                }catch (NumberFormatException c){}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pizzaNum;
    }*/

    public void removeAdd(){
    }

    public int getPizzaLimit() {
        return pizzaLimit;
    }

    public static int getClientNumber() {
        return clientNumber;
    }

    public static void setClientNumber(int clientNumber) {
        OrderService.clientNumber = clientNumber;
    }

    public void setBaseAccess(boolean baseAccess) {
        this.baseAccess = baseAccess;
    }
}
