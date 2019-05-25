package menu;

import utility.OrderMaker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShowMenu {

    private int itemMenu = 0;

    MenuBuilder menu ;
    OrderMaker  orderMaker;

    public ShowMenu() {
        menu = new MenuBuilder();
        orderMaker = new OrderMaker();
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
                    orderMaker.showOrder();
                    selectBasePizza();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Try again...");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }while (!exit);
}

    public void selectBasePizza() /*throws IOException*/ {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        boolean notExit = true;

        menu.baseShow();
        while(notExit) {

            try {
                switch(itemMenu = Integer.parseInt(in.readLine())) {
                    case 1:
                        orderMaker.addPizzaBase(itemMenu);
                        orderMaker.showOrder();
                        selectAddsPizza();
                        break;
                    case 2:
                        orderMaker.addPizzaBase(itemMenu);
                        orderMaker.showOrder();
                        selectAddsPizza();
                        break;
                    case 0: notExit = false; break;
                    default:
                        System.out.println("Try again...");
                } // switch
            }catch (IOException e) {
                e.printStackTrace();
            }
        } // while
    } // selectArtist

     public void selectAddsPizza() /*throws IOException*/ {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        boolean notExit = true;

        menu.addsShow();

         while(notExit) {
             try {
                 switch(itemMenu = Integer.parseInt(in.readLine())) {
                     case 0:
                         notExit = false;
                         break;
                     default:
                         orderMaker.addPizzaAdds(itemMenu);
                         orderMaker.showOrder();
                 }// switch
             } catch (IOException e){
                 e.printStackTrace();
             }
         } // while
    } // select


    public int pizzaNumbersEnter(){
        int pizzaNum = 0;

        try {
            while (pizzaNum <= -1 || pizzaNum >= 11 ){
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
    /*public void selectCountPiz() *//*throws IOException*//* {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            boolean notExit = true;

            menu.numbersEnter();
            while(notExit) {

                try {
                    switch(Integer.parseInt(in.readLine())) {
                        case 1:
                            System.out.println("mnjn");*//*selectAlbum();*//*
                            break;
                        case 2: System.out.println("njjn");*//*deleteAlbum()*//*;
                            break;
                        case 0: notExit = false; break;
                        default:
                            System.out.println("Try again...");
                    } // switch
                }catch (IOException e) {
                    e.printStackTrace();
                }
            } // while
        } // select*/

}

