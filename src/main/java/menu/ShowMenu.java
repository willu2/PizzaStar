package menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShowMenu {

    MenuBuilder menu ;

    int visitorPrice = 0;

    public ShowMenu() {
        menu = new MenuBuilder();
    }

    boolean exit = false;

    public void show() {
        do {
        int pos = 0;
        int price = 0;

       // visitorPrice = menu.menuTotalPriceEnter();
        menu.mainManu(); //main text menu

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        //main menu block
        try {
            switch (Integer.parseInt(in.readLine())) {
                case 1:
                    break;
                case 2:
                    menu.addsShow();
                    pos = Integer.parseInt(in.readLine());
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 8:
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
}

