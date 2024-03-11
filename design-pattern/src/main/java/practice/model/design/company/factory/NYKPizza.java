package practice.model.design.company.factory;

/**
 * @program: tnm-biz-manage
 * @Description
 * @Author xsq
 * @Date 2024/1/22 11:01
 **/
public class NYKPizza extends Pizza{

    public NYKPizza() {
        name = "NYKPizza";
        sauce = "NYK Sauce";
        dough = "NYK Dough";
        toppings.add("NYK Cheese");
    }
}
