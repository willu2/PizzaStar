package utility;

import entity.PizzaItem;

import java.util.ArrayList;
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
            service.setClientNum(pizzaItem);
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

            if(visitorOrder != null || visitorOrder.size() != 0 ){
                for(PizzaItem item : visitorOrder){
                    service.showOrder(item);
                }
            }else {
                service.showEmtyInfo();
            }
            System.out.println();
        }



        public void pizzaNumbersEnter(){
            service.pizzaNumbersEnter(pizzaItem);
        }
    }

