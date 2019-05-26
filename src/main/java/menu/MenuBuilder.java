package menu;

import enums.PizzaAdds;
import enums.PizzaType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MenuBuilder {

    public MenuBuilder() {
    }

    //print main text
    public void mainManu(){
        System.out.println("Main menu :> ");
        System.out.println(" 1 :> Make pizza order ");
        System.out.println(" 2 :> Show all order ");
        System.out.println(" 0 :> Exit ");

        System.out.println("Please select menu item :> ");
    }

    //print pizza base menu
    public void baseShow(){
        System.out.println("Choose pizza base:");
        int pos = 0;
        PizzaType arr[] = PizzaType.values();
        for (PizzaType add : arr)
        {
            pos = add.ordinal() + 1;
            if((pos % 2) == 0){
                System.out.println(" ||  > " + pos + ": " + add +" " + add.getPrice() + "€" );
            }else {
                System.out.print("> " + pos + ": " + add + " " + add.getPrice() + "€" );
            }
        }
        System.out.println("> 0: ^UP ");
    }

    //print pizza adds menu
    public void addsShow(){
        System.out.println("Choose pizza adds:");
        int pos = 0;
        PizzaAdds arr[] = PizzaAdds.values();
            for (PizzaAdds add : arr)
                {
                    pos = add.ordinal() + 1;
                    if((pos % 2) == 0){
                        System.out.println(" ||  > " + pos + ": " + add +" " + add.getPrice() + "€" );
                    }else {
                        System.out.print("> " + pos + ": " + add + " " + add.getPrice() + "€" );
                    }
                }
        System.out.println("> 0: ^UP ");
    }

    //print price enter text
    public void numbersEnter(){
        System.out.println("Enter pizza numbers (max-> 10):");
    }

    //check int input menu
    public int pizzaNumbersEnter(){
        int pizzaNum = 0;

        try {
            while (pizzaNum <= 0 || pizzaNum >= 11 ){
                System.out.println("Enter pizza numbers (max-> 10): ");
                try {
                    BufferedReader inPrice = new BufferedReader(new InputStreamReader(System.in));
                    pizzaNum = Integer.parseInt(inPrice.readLine());
                }catch (NumberFormatException c){}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pizzaNum;
    }

    public int menuItemEnter(int check){
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
    }
}
