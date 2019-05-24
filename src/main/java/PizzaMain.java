import menu.MenuBuilder;
import menu.ShowMenu;

public class PizzaMain {

    public static void main(String[] args) {

       // ShowMenu showMenu = new menu.ShowMenu();
       // showMenu.show();

        MenuBuilder menuBuilder = new MenuBuilder();
       // menuBuilder.addsShow();
       // menuBuilder.baseShow();

        OrderMaker maker1 = new OrderMaker();
        maker1.createPizza();
        maker1.showOrder();

        OrderService maker = new OrderService();
        //maker.srandom();
        //maker.getAllAdds();
        //maker.getAllBases();

    }
 }

