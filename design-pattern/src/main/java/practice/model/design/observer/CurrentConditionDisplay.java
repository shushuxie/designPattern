package practice.model.design.observer;

/**
 * @program: tnm-biz-manage
 * @Description
 * @Author xsq
 * @Date 2024/1/16 14:16
 **/
public class CurrentConditionDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private float pressure;
    // 建立对象之间注册
    public CurrentConditionDisplay(Subject weatherData) {
        weatherData.registerObserver(this);
    }
    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature + "F degrees and " +
                humidity + "% humidity" + pressure + "Pa pressure");
    }

}
