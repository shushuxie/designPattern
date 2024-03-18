package org.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        // 普通方式获取方法
        Address address = new Address("nan jing Road","3321" );
        Customer customer = new Customer("xie","xxx@outlook.com");
        Order order = new Order(customer,address);
        order.getCustomer().printCustomer();
        order.getAddress().printAddress();


        // 框架方式获取
        Continer continer = new Continer();
        continer.init();
        // 通过构造器获取对象实例
        String className = "org.reflect.Order";
        String field = "customer";
        Class<?> orderClass = Class.forName(className);
        Object obj = continer.creatInstance(orderClass);
        // 获取普通实例中自动注入的属性对象
        Field customer1 = orderClass.getDeclaredField(field);
        customer1.setAccessible(true);
        Object o = customer1.get(obj);
        Method[] methods = o.getClass().getMethods();
        // 调用服务中的方法
        for (Method method : methods) {
            if (method.getDeclaredAnnotation(ReflectAutowired.class) != null) {
                method.invoke(o);
            }

        }

    }
}
