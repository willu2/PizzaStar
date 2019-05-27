package utility;

import entity.PizzaItem;
import enums.PizzaType;

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
                   // service.findEnumData(item);
                }
            }else {
                service.showEmtyInfo();
            }
            System.out.println();
        }

    public void removeAdd() {
            service.removeAdd(pizzaItem);
    }

    public void pizzaNumbersEnter(){
          service.pizzaNumbersEnter(pizzaItem);
        }

    public void autoPizza1(){
        createPizza();
        pizzaItem.setPizzaName("Margarita");
        pizzaItem.setPizzaType(PizzaType.STADART);
        pizzaItem.setPizzaItemsCount(1);
        addPizzaAdds(1);
        addPizzaAdds(4);
        addPizzaAdds(5);
        addPizzaAdds(7);

    }

    public void autoPizza2(){
        createPizza();
        pizzaItem.setPizzaName("Bavarian");
        pizzaItem.setPizzaType(PizzaType.STADART);
        pizzaItem.setPizzaItemsCount(2);
        addPizzaAdds(1);
        addPizzaAdds(2);
        addPizzaAdds(3);
        addPizzaAdds(8);

    }

    }

