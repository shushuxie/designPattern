package org.reflect;

import javax.xml.ws.Action;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * continer类用来存储服务的方法
 */
public class Continer {

    // 存储注册的服务
    Map<Class<?>, Method> methodMap;
    // config类用来充当invoke的入参
    private Object config;

    // 存储已经创建的服务实例
    Map<Class<?>,Object> services;

    // 初始化方法，获取所有服务
    public void init() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 初始化方法容器
        this.methodMap = new HashMap<>();
        this.services = new HashMap<>();
        Class clazz = Class.forName("org.reflect.Config");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getDeclaredAnnotation(Action.class) != null) {
                // 放入方法返回类型和方法
                methodMap.put(method.getReturnType(), method);
                // class org.reflect.Message
                //class org.reflect.Address
                System.out.println(method.getReturnType());
            }
            this.config = clazz.getConstructor().newInstance();
        }
    }

    public Object getServiceInstanceByClass(Class<?> clazz) throws InvocationTargetException, IllegalAccessException {
        // 先检查是否创建了对象
        if(this.services.containsKey(clazz)) {
            return this.services.get(clazz);
        }

        if(this.methodMap.containsKey(clazz)) {
            Method method = this.methodMap.get(clazz);
            // 参数是方法所属的对象，这里传入了一个object对象
            // 返回值也使用Object对象接收
            Object obj = method.invoke(this.config);
            this.services.put(clazz,obj);
            // 我们注册的服务返回的刚好是服务实例
            return obj;
        }

        return null;
    }
}
