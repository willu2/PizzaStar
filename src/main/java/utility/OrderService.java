package utility;

import entity.PizzaItem;
import enums.PizzaAdds;
import enums.PizzaType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class OrderService {

    public int clientNumBase = 0;

    private final int pizzaLimit = 10;

    private boolean baseAccess = true;

    PizzaNumberGenerator generator = PizzaNumberGenerator.getInstance();

    public int randOrderN() {
        setClientNumBase(getClientNumBase() + 1);
        return generator.getPizzaNumber();
    }

    public void addBase(PizzaItem item, int baseNum) {

        if (checkBaseLimit(baseNum)) {
            if (baseAccess) {
                baseAccess = !baseAccess;

                item.setPizzaType(PizzaType.values()[baseNum - 1]);
                item.setPriceAcces(true);
                item.setPizzaPrice(PizzaType.values()[baseNum - 1].getPrice());
            } else {
                System.out.println("Base is added");
            }
        }
    }

    public void addAdd(PizzaItem item, int addNum) {
        if (addNum == 0) {
            return;
        }
        if (checkInpLimit(addNum)) {
            item.addIngredient(String.valueOf(PizzaAdds.values()[addNum - 1]));
            item.setPizzaPrice(PizzaAdds.values()[addNum - 1].getPrice());
        }
    }

    public boolean checkInpLimit(int addNum) {
        PizzaAdds arr[] = PizzaAdds.values();
        int itemNum = addNum;
        int limit = PizzaAdds.values().length;
        if (itemNum > 0 && itemNum <= limit) {
            return true;
        }
        return false;
    }

    public boolean checkFullPizza(PizzaItem item) {
        int limit = PizzaAdds.values().length;
        ArrayList arrayList = item.getAdds();
        if (arrayList.size() < limit) {
            return false;
        }
        return true;
    }

    public boolean checkBaseLimit(int addNum) {
        int itemNum = addNum;
        int limit = PizzaType.values().length;
        if (itemNum > 0 && itemNum <= limit) {
            return true;
        }
        return false;
    }

    public String pizzaNameEnter(PizzaItem item) {
        String pizzaName = "";
        System.out.println("Enter pizza name : ");
        try {
            BufferedReader inPrice = new BufferedReader(new InputStreamReader(System.in));
            pizzaName = String.valueOf(inPrice.readLine());

            if (pizzaName.length() < 4 || pizzaName.length() >= 20) {
                pizzaName = "client_num_" + item.getClientNumber();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return pizzaName;
    }

    public void setClientNum(PizzaItem item) {
        item.setClientNumber(getClientNumBase());
    }

    public int getPizzaLimit() {
        return pizzaLimit;
    }

    //check int input menu
    public void pizzaNumbersEnter(PizzaItem item) {
        int pizzaNum = 0;

        try {
            while (pizzaNum <= 0 || pizzaNum >= getPizzaLimit()) {
                System.out.println("Enter pizza numbers (max-> 10): ");
                try {
                    BufferedReader inPrice = new BufferedReader(new InputStreamReader(System.in));
                    pizzaNum = Integer.parseInt(inPrice.readLine());
                } catch (NumberFormatException c) {
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        item.setPizzaItemsCount(pizzaNum);
    }


    public void showOrder(PizzaItem item) {

        System.out.printf("%n%33s%5d%2s", "[", item.getPizzaNumber(), " : ");
        System.out.print(item.getClientNumber() + " : ");
        System.out.printf("%-4.2f%s", item.getPizzaPrice(), "€ : ");
        System.out.print(item.getPizzaType() + " : ");
        System.out.print(item.getPizzaName() + " : ");
        System.out.println(item.getPizzaItemsCount() + " ]");
        System.out.printf("%32s%s%n", "", "================================================");

        showAdds(item);

        if(checkFullPizza(item)){
            System.out.printf("%32s%s", "", "Pizza is full.");
        }
    }

    public void showOrderNewType(PizzaItem item) {

        System.out.printf("%n%32s", "");
        System.out.println(String.format("%40s", "").replace(' ', '*'));
        System.out.printf("%39s%5d", "Zakaz: ", item.getPizzaNumber() );
        System.out.printf("%n%40s%4d", "Client: ",item.getClientNumber() );
        System.out.printf("%n%38s%5s", "Name: ",item.getPizzaName() );
        System.out.printf("%n%32s", "");
        System.out.println(String.format("%40s", "").replace(' ', '-'));
        System.out.printf("%32s%s%s%18.2f%s%n"," " ,"Pizza Base : ", item.getPizzaType(), item.getPizzaType().getPrice() ," €");

        showAdds(item);

        System.out.printf("%32s%s%32.2f%s", "", "Total:", item.getPizzaPrice(), " €");
        System.out.printf("%n%32s%s%34d", "", "Count:", item.getPizzaItemsCount() );
        //System.out.printf("%32s%s%n", "", "===============");



        if(checkFullPizza(item)){
            System.out.printf("%32s%s", "", "Pizza is full.");
        }
    }

    public void showAdds(PizzaItem item) {
        int num = 1;
        double price = 0;
        ArrayList arrayList = item.getAdds();
        System.out.print("");
        for (Iterator<String> it = arrayList.iterator(); it.hasNext(); ) {
            String add = it.next();
            price = findEnumData(add);
            System.out.printf("%32s%d%2s%-20s%11s%4.2f%s%n", "", num++, "", add, "", price, " €");
        }
        System.out.printf("%32s", "");
        System.out.println(String.format("%40s", "").replace(' ', '-'));
    }

    public void removeAdd(PizzaItem item) {
        int pizzaNum = 0;
        ArrayList arrayList = item.getAdds();
        showAdds(item);

        System.out.println("Enter item numbers to remove: ");
        try {
            BufferedReader inPrice = new BufferedReader(new InputStreamReader(System.in));
            pizzaNum = Integer.parseInt(inPrice.readLine());
            if (pizzaNum >= 1 && pizzaNum <= arrayList.size()) {
                arrayList.remove(pizzaNum - 1);
            }else {
                System.out.println("Wrong index");
            }
        } catch (NumberFormatException c) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double findEnumData(String add){
            int index = PizzaAdds.valueOf(add.toUpperCase()).ordinal();
            return PizzaAdds.values()[index].getPrice();
     }

    public void showEmtyInfo(){
        System.out.println("Your order is empty");
        System.out.println("===================");
    }

    public void setBaseAccess(boolean baseAccess) {
        this.baseAccess = baseAccess;
    }

    public int getClientNumBase() {
        return clientNumBase;
    }

    public void setClientNumBase(int number) {
        clientNumBase = number;
    }
}
