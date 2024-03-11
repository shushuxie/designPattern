package org.reflect;

import javax.xml.ws.Action;

/**
 * config 方法用来注册一些服务
 */
public class Config {

    @Action
    public Customer customer() {
        return new Customer("kill","333333");
    }

    @Action
    public Address address() {
        return new Address("address","post code");
    }

    public Message message() {
        return new Message("content");
    }
}
