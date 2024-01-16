package practice.model.design.observer;

import java.util.ArrayList;

/**
 * @program: tnm-biz-manage
 * @Description
 * @Author xsq
 * @Date 2024/1/16 14:10
 **/
public class WeatherData extends Subject {
    /*
    * 温度
     */
    private float temperature;
    /*
    * 湿度
     */
    private float humidity;

    /*
    * 压力
     */
    private float pressure;

    private static ArrayList<Observer> observers = new ArrayList<>();

    public void setChange(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }
}
