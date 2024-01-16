package practice.model.design.observer;

/**
 * @program: tnm-biz-manage
 * @Description
 * @Author xsq
 * @Date 2024/1/16 15:07
 **/
public class TemperatureDisplay implements Observer,DisplayElement{
    private float temperature;

    public TemperatureDisplay(Subject weatureData) {
        weatureData.registerObserver(this);
    }

    public TemperatureDisplay() {

    }

    @Override
    public void display() {
        System.out.println("temperature = "+temperature);
    }

    @Override
    public void update(float temperature, float humidity, float pressuree) {
        this.temperature = temperature;
        display();
    }
}
