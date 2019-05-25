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
    }

    public void addPizzaBase(int addNum){
        service.addBase(pizzaItem, addNum);
        //pizzaItem.setPizzaPrice(service.getPriceBase(addNum));
    }

    public void addPizzaAdds(int addNum){
        service.addAdd(pizzaItem, addNum);
        //service.getPriceAdd(pizzaItem,addNum));
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
                System.out.print("[" + item.getPizzaNumber()+": ");
                System.out.print(OrderService.getClientNumber() +": ");
                System.out.print(item.getPizzaPrice()+"€ : ");
                System.out.println(item.getPizzaType()+" ]");
                System.out.println("=======================");

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

