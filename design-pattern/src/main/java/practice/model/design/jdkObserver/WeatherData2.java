package practice.model.design.jdkObserver;

import java.util.Observable;

/**
 * @program: tnm-biz-manage
 * @Description
 * @Author xsq
 * @Date 2024/1/16 16:07
 **/
public class WeatherData2 extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        // 通知观察者
        this.setChanged();
        //没有传入观察者对象，需要对象拉取数据
        //这里的拉取数据体现在，观察者的update方法是通过get方法取得主题的相应信息；
        this.notifyObservers();
    }

    public float getTemperature(){
            return temperature;
    }
    public float getHumidity(){
        return humidity;
    }
    public float getPressure() {
        return pressure;
    }
}
