package org.reflect;
import java.lang.reflect.Field;

public class Main2 {
        public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
            MyClass obj = new MyClass();
            Class<?> clazz = obj.getClass();

            // 获取字段对象
            Field field = clazz.getDeclaredField("myField");

            // 设置字段可访问性
            field.setAccessible(true);

            // 读取字段的值
            String value = (String) field.get(obj);
            System.out.println("Original value: " + value);

            // 修改字段的值
            field.set(obj, "New value");

            // 再次读取字段的值
            value = (String) field.get(obj);
            System.out.println("Modified value: " + value);
        }
    }

    class MyClass {
        private String myField = "Initial value";
    }

