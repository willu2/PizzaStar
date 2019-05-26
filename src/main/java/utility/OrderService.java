package utility;

import entity.PizzaItem;
import enums.PizzaAdds;
import enums.PizzaType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderService {

    public int clientNumber = 50;

    private final int pizzaLimit = 10;

    private boolean baseAccess = true;

    PizzaNumberGenerator generator = PizzaNumberGenerator.getInstance();

    public int randOrderN(){
            setClientNumber(getClientNumber()+1);
            return generator.getPizzaNumber();
    }

    public void addBase(PizzaItem item, int baseNum){

        if (checkBaseLimit(baseNum)) {
            if(baseAccess){
                baseAccess = !baseAccess;
                item.setClientNumber(getClientNumber());
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

    public String pizzaNameEnter(PizzaItem item){
        String pizzaName = "";
        System.out.println("Enter pizza name : ");
        try {
            BufferedReader inPrice = new BufferedReader(new InputStreamReader(System.in));
            pizzaName = String.valueOf(inPrice.readLine());

            if(pizzaName.length() < 4 || pizzaName.length() >= 20 ){
                pizzaName = "client_num_" + item.getPizzaNumber();
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
        return pizzaName;
    }

    public int getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(int number) {
        clientNumber = number;
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



    public void setBaseAccess(boolean baseAccess) {
        this.baseAccess = baseAccess;
    }
}
