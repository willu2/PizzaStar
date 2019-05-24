import entity.PizzaItem;
import enums.PizzaAdds;
import enums.PizzaType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrderMaker {

    List<PizzaItem> visitorOrder;
    OrderService service = new OrderService();

    public OrderMaker() {
        visitorOrder = new ArrayList<PizzaItem>();
    }

    public void createPizza(){

        PizzaItem pizzaItem = new PizzaItem(service.randOrderN(),"mk", PizzaType.CALZONE);
        pizzaItem.setAdds(service.addAdd(1));
        pizzaItem.setAdds(service.addAdd(2));
        pizzaItem.setAdds(service.addAdd(3));

        visitorOrder.add(pizzaItem);
    }

    public void showOrder(){

        if(visitorOrder != null){
            for(PizzaItem item : visitorOrder){
                System.out.println(item.getPizzaName());
                System.out.println(item.getPizzaNumber());
                System.out.println(item.getPizzaPrice());
                System.out.println(item.getPizzaType());
                System.out.println("-----------");

                ArrayList arrayList = item.getAdds();
                for (Iterator<String> it = arrayList.iterator(); it.hasNext(); ) {
                    String color = it.next();
                    System.out.println(color);
                }
                    //System.out.println((PizzaAdds)adds.);
                }
            }

        }
    }

