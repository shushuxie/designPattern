package org.generic;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        MilkThing milkThing = new MilkThing();
        // 限定了 car extends vical & implants Thing
        Printer<Car> printer = new Printer<>(new Car());
        // 限定了子类为一个接口
        Printer2<MilkThing> printer2 = new Printer2<>(milkThing);
        printer.printer();

        // 范型函数
        List<Car> list = new ArrayList();
        List list2 = new ArrayList();
        list.add(new Car());
        list2.add("hahaha");
        mainPrintList3(list);
        mainPrintList4(list2);

    }

    /**
     * static 后面的T告诉方法传入了范型参数
     * 范型前置声明只能在返回参数之前
     */
    public static <T,K> void mainPrinter(T content,K content2) {
        System.out.println(content);
    }

    public static <T> void mainPrintList(List<T> content) {
        System.out.println(content);
    }

    /**
     * ?是通配符，代表可以传入任何类型，也可以对通配符进行限定
     * List<? extends Vicial> 表示传入的对象必须为vical的子类
     * List<? super Car> 限制为其本身或者其父类才行
     */
    public static void mainPrintList2(List<? extends Viceal> content) {
        System.out.println(content);
    }

    public static void mainPrintList3(List<? super Car> content) {
        System.out.println(content);
    }


    public static void mainPrintList4(List<?> content) {
        System.out.println(content);
    }
}
