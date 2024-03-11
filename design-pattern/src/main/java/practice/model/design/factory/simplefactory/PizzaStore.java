package practice.model.design.factory.simplefactory;

public class PizzaStore {
    SimplePizzaFactory factory ;

    public PizzaStore(SimplePizzaFactory factory) {
        this.factory = factory;
    }

    //点单
    public Pizza orderPizza(String type) {

        Pizza pizza = SimplePizzaFactory.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.bake();
        return pizza;
    }
}
