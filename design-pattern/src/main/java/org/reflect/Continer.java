package org.reflect;

import javax.xml.ws.Action;
import java.lang.reflect.Constructor;
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
            if (method.getDeclaredAnnotation(ReflectAutowired.class) != null) {
                // 放入方法返回类型和方法
                methodMap.put(method.getReturnType(), method);
                System.out.println(method.getReturnType());
            }
            this.config = clazz.getConstructor().newInstance();
        }
    }

    /**
     * 获取config中的注册实例
     * @param clazz
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public Object getServiceInstanceByClass(Class<?> clazz) throws InvocationTargetException, IllegalAccessException {
        // 先检查是否创建了对象
        if(this.services.containsKey(clazz)) {
            return this.services.get(clazz);
        } else {
            if(this.methodMap.containsKey(clazz)) {
                Method method = this.methodMap.get(clazz);
                // 参数是方法所属的对象，这里传入了一个object对象
                // 返回值也使用Object对象接收
                Object obj = method.invoke(this.config);
                this.services.put(clazz,obj);
                // 我们注册的服务返回的刚好是服务实例
                return obj;
            }
        }
        return null;
    }

    /**
     *创建普通实例，实例所依赖的对象通过注册好的服务获取
     * @param clazz
     */
    public Object creatInstance(Class<?> clazz) throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        // 获取所有的构造器
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            if (constructor.getDeclaredAnnotation(ReflectAutowired.class) != null) {
                // 获取构造器的所有参数
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                // 存放所有参数的对象数组
                Object[] arguments = new Object[parameterTypes.length];
                for (int i=0; i<parameterTypes.length; i++) {
                    // 实例依赖的服务通过该方法获取
                    // 实现了自动注入依赖的对象
                    arguments[i] = getServiceInstanceByClass(parameterTypes[i]);
                }
                return constructor.newInstance(arguments);
            }
        }
        // 默认返回无参数构造的对象
        return clazz.getConstructor().newInstance();
    }
}
