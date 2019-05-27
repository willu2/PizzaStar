package menu;

import enums.PizzaAdds;
import enums.PizzaType;

public class MenuBuilder {

    public MenuBuilder() {}

    //print main text
    public void mainManu(){
        System.out.println("Main menu :> ");
        System.out.println(" 1 :> Make pizza order ");
        System.out.println(" 2 :> Show all order ");
        System.out.println(" 3 :> Pizza Margarita ");
        System.out.println(" 4 :> Pizza Bavarian ");
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
        System.out.println("> 11 :> Change ingridients ");
        System.out.println("> 0: ^UP ");
    }

    //print numbers enter message
    public void numbersEnter(){
        System.out.println("Enter pizza numbers (max-> 10):");
    }
}
