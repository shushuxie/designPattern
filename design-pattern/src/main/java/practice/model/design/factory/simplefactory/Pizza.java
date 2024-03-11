package practice.model.design.factory.simplefactory;

public abstract class Pizza {

    abstract Pizza prepare();

    abstract Pizza bake();
    abstract Pizza cut();
    abstract Pizza box();
}
