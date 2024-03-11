package practice.model.design.company.factory;

import java.util.ArrayList;

/**
 * @program: tnm-biz-manage
 * @Description
 * @Author xsq
 * @Date 2024/1/22 10:51
 **/
public abstract class Pizza {
    String name;
    String dough;
    String sauce;
    ArrayList<String> toppings = new ArrayList<>();

    void prepare() {
        System.out.println("准备披萨:"+name);
        System.out.println("准备面团"+dough);
        System.out.println("准备配料"+sauce);
        System.out.println("adding toppings");
        for (int i=0; i<toppings.size(); i++) {
            System.out.println(" "+toppings.get(i));
        }
    }

    void bake() {
        System.out.println("开始烘焙");
    }

    void cut() {
        System.out.println("开始切割");
    }

    void box(){
        System.out.println("包装入盒");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDough() {
        return dough;
    }

    public void setDough(String dough) {
        this.dough = dough;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public ArrayList<String> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<String> toppings) {
        this.toppings = toppings;
    }
}
