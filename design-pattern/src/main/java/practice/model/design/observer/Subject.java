package practice.model.design.observer;

/**
 * @program: tnm-biz-manage
 * @Description
 * @Author xsq
 * @Date 2024/1/16 14:07
 **/
public abstract class Subject {
    public abstract void registerObserver(Observer observer);
    public abstract void removeObserver(Observer observer);
    public abstract void notifyObservers();
}
