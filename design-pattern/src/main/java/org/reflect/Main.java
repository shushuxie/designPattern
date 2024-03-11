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
        Class<?> clazz = Customer.class;
        Object customerObj = continer.getServiceInstanceByClass(clazz);
        System.out.println(customerObj);

    }
}
