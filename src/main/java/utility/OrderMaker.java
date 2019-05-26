package utility;

import entity.PizzaItem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrderMaker {

    List<PizzaItem> visitorOrder;
    OrderService service = new OrderService();
    PizzaItem pizzaItem;

    public OrderMaker() {
        visitorOrder = new ArrayList<PizzaItem>();
    }

    public void createPizza(){
        pizzaItem = new PizzaItem(service.randOrderN());
        visitorOrder.add(pizzaItem);
        service.setBaseAccess(true);
    }

    public void addPizzaBase(int baseNum){
        service.addBase(pizzaItem, baseNum);
    }

    public void addPizzaAdds(int addNum){
        service.addAdd(pizzaItem, addNum);
    }

    public void addPizzaName(){
        String pizzaN = service.pizzaNameEnter(pizzaItem);
        pizzaItem.setPizzaName(pizzaN);
    }

    public void showOrder(){

        if(visitorOrder != null || visitorOrder.size() !=0 ){
            for(PizzaItem item : visitorOrder){
                System.out.print(">>                               [" + item.getPizzaNumber() + " : ");
                System.out.print(item.getClientNumber() + " : ");
                System.out.print(item.getPizzaPrice() + "€ : ");
                System.out.print(item.getPizzaType() + " : ");
                System.out.println(item.getPizzaName() + " ]");
                System.out.println("                                ====================================");

                ArrayList arrayList = item.getAdds();
                System.out.print("                                ");
                    for (Iterator<String> it = arrayList.iterator(); it.hasNext(); ) {
                        String add = it.next();
                        System.out.println("                                " + add );
                    }
                }
            }else {
                    System.out.println("Your order is empty");
                    System.out.println("===================");
        }
        System.out.println();
    }

        public void showNumberR(){
            if(visitorOrder != null){
                for(PizzaItem item : visitorOrder){
                    System.out.println(item.getPizzaNumber());
                    System.out.println("-----------");
                    }
                }
            }
    }

