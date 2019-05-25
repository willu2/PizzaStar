package utility;

import entity.PizzaItem;
import enums.PizzaAdds;
import enums.PizzaType;

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
    }

    public void addPizzaBase(int addNum){
        pizzaItem.setPizzaType(service.addBase(addNum));
    }

    public void addPizzaAdds(int addNum){
        pizzaItem.setAdds(service.addAdd(addNum));
    }

    public void addPizzaName(String name){
        if(name == "" || name == null){
            name = "autoname";
        }
        pizzaItem.setPizzaName(name);
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
                    String add = it.next();
                    System.out.println(add);
                }
                    //System.out.println((PizzaAdds)adds.);
                }
            }
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

