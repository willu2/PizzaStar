package menu;

import utility.OrderAutoBuild;
import utility.OrderMaker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShowMenu {

    private int itemMenu = 0;

    MenuBuilder menu ;
    OrderMaker  orderMaker;
    OrderAutoBuild autoBuild;

    public ShowMenu() {
        menu = new MenuBuilder();
        orderMaker = new OrderMaker();
        autoBuild = new OrderAutoBuild();
    }

    boolean exit = false;

    public void show() {
        do {
        menu.mainManu(); //main text menu
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //main menu block
        try {
            switch (Integer.parseInt(in.readLine())) {
                case 1:
                    orderMaker.createPizza();
                    //orderMaker.showOrder();
                    orderMaker.addPizzaName();
                    selectBasePizza();
                    break;
                case 2:
                    orderMaker.showOrder();
                    break;
                case 3:
                    System.out.println("Margarita");
                    orderMaker.autoPizza1();
                    orderMaker.showOrder();
                    break;
                case 4:
                    System.out.println("Bavarian");
                    orderMaker.autoPizza2();
                    orderMaker.showOrder();
                    break;
                case 5:
                    orderMaker.autoPizza7717();
                    orderMaker.showOrder();
                    break;
                case 6:
                    System.out.println("4372");
                    orderMaker.autoPizza4372();
                    orderMaker.showOrder();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Try again...");
            }
        } catch (IOException e) {
            System.err.println("Error: " + e);
        } catch (NumberFormatException e) {
            System.out.println("You entered an invalid operation");
            continue;   // go to beginning of loop
        }

    }while (!exit);
}

    public void selectBasePizza() /*throws IOException*/ {

        String pizzaName = "";//pizzaNameEnter();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        boolean notExit = true;

        while(notExit) {
            menu.baseShow();
            try {
                switch(itemMenu = Integer.parseInt(in.readLine())) {
                    case 1:
                        orderMaker.addPizzaBase(itemMenu);
                        orderMaker.showOrder();
                        orderMaker.pizzaNumbersEnter();
                        orderMaker.showOrder();
                        selectAddsPizza();
                        break;
                    case 2:
                        orderMaker.addPizzaBase(itemMenu);
                        orderMaker.showOrder();
                        orderMaker.pizzaNumbersEnter();
                        orderMaker.showOrder();
                        selectAddsPizza();
                        break;
                    case 0: notExit = false;
                        break;
                    default:
                        System.out.println("Try again...");
                } // switch
            } catch (IOException e) {
                System.err.println("Error: " + e);
            } catch (NumberFormatException e) {
                System.out.println("You entered an invalid operation");
                continue;   // go to beginning of loop
            }
        } // while
    } // selectArtist

     public void selectAddsPizza() /*throws IOException*/ {
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         boolean notExit = true;

             while(notExit) {
                 menu.addsShow();
                 try {
                     switch(itemMenu = Integer.parseInt(in.readLine())) {
                         case 0:
                             notExit = false;
                             break;
                         case 11:
                             System.out.println("Change ingridients:");
                             orderMaker.removeAdd();
                             orderMaker.showOrder();
                             break;
                         default:
                             orderMaker.addPizzaAdds(itemMenu);
                             orderMaker.showOrder();
                     }// switch
                 } catch (IOException e){
                     System.err.println("Error: " + e);
                     continue;   // go to beginning of loop
                 }catch (NumberFormatException e) {
                     System.out.println("You entered an invalid operation");
                     continue;   // go to beginning of loop
             }
         } // while
    } // select
}

