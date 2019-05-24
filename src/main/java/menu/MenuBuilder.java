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
        System.out.println("menu :> ");
        System.out.println(" 1 :> Make pizza order ");
        System.out.println(" 8 :> Exit ");

        System.out.println("Enter position :> ");
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
        System.out.println("> 8: Exit ");
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
        System.out.print("> 9: Exit ");
    }

    //print price enter text
    public void priceEnter(){
        System.out.println("Enter money digit:");
    }

    //check int input menu
    /*public int menuTotalPriceEnter(){
        int visitorPrice = 0;

        try {
            while (visitorPrice <= 0 ){
                System.out.println("How much money do you have (int limit digit) ? : ");
                try {
                    BufferedReader inPrice = new BufferedReader(new InputStreamReader(System.in));
                    visitorPrice = Integer.parseInt(inPrice.readLine());
                }catch (NumberFormatException c){}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return visitorPrice;
    }*/
}
