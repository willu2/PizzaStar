package menu;

import utility.OrderMaker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShowMenu {

    MenuBuilder menu ;
    OrderMaker  orderMaker;
    double visitorPrice = 0;

    public ShowMenu() {
        menu = new MenuBuilder();
        orderMaker = new OrderMaker();
    }

    boolean exit = false;

    public void show() {
        do {
        int pos = 0;
       // visitorPrice = menu.menuTotalPriceEnter();
        menu.mainManu(); //main text menu
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //main menu block
        try {
            switch (Integer.parseInt(in.readLine())) {
                case 1:
                    orderMaker.createPizza();
                    //orderMaker.showNumberR();
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
                switch(Integer.parseInt(in.readLine())) {
                    case 1:
                        orderMaker.addPizzaBase(1);
                        selectAddsPizza();
                        break;
                    case 2:
                        orderMaker.addPizzaBase(2);
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
                switch(Integer.parseInt(in.readLine())) {
                    case 1:
                        System.out.println("mnjn");/*selectAlbum();*/
                        break;
                    case 2: System.out.println("njjn");/*deleteAlbum()*/;
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

    public void selectCountPiz() /*throws IOException*/ {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            boolean notExit = true;

            menu.numbersEnter();
            while(notExit) {

                try {
                    switch(Integer.parseInt(in.readLine())) {
                        case 1:
                            System.out.println("mnjn");/*selectAlbum();*/
                            break;
                        case 2: System.out.println("njjn");/*deleteAlbum()*/;
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

}

