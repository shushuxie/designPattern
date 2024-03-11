package org.generic;

/**
 * java范型， extens关键字可以指定特殊的类型，称为有界范型
 * 同时可以有限定接口，Things，但是不使用implements关键字
 *< T extends Viceal & Thing> 的意思是传入的类型是vical的子类，并且实现了Thing的接口
 * 本质上还是Vical子类
 * @param <T>
 */
public class Printer<T extends Viceal & Thing>{

    T content;

    public Printer(T content) {
        this.content = content;
    }

    public void printer() {
        System.out.println(content);
    }
}
