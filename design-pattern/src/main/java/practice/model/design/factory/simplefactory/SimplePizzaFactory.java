package practice.model.design.factory.simplefactory;

public class SimplePizzaFactory {

    public static Pizza createPizza(String type) {
        Pizza pIzza = null;
        if (type == "cheese") {
            pIzza = new CheesePizza();
        } else {
            return pIzza;
        }
        return pIzza;
    }

    public Pizza createPizza2(String type){
        Pizza pizza = null;
        if (type == "cheese") {
            pizza = new CheesePizza();
        } else {
            return pizza;
        }
        return pizza;
    }




}
