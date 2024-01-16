package practice.model.design.jdkObserver;

import practice.model.design.observer.DisplayElement;

import java.util.Observable;
import java.util.Observer;

/**
 * @program: tnm-biz-manage
 * @Description
 * @Author xsq
 * @Date 2024/1/16 16:12
 **/
public class CurrentConditionDisplay2 implements DisplayElement, Observer {
    Observable observable;
    private float temperature;
    private float humidity;

    public CurrentConditionDisplay2(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }
    // 这里的arg是指推送的数据对象，如果为null，可以从weather对象上面获取相应的数据，就是拉数据，
    // 否则就是推送数据了，使用arg获取所有数据，然后选择展示；
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData2) {
            WeatherData2 weatherData = (WeatherData2) o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature +"humidity:"+humidity);
    }
}
