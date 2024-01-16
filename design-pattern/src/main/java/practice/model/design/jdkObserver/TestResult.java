package practice.model.design.jdkObserver;

/**
 * @program: tnm-biz-manage
 * @Description
 * @Author xsq
 * @Date 2024/1/16 16:22
 **/
public class TestResult {
    public static void main(String[] args) {
        WeatherData2 weatherData2 = new WeatherData2();
        CurrentConditionDisplay2 currentConditionDisplay2 = new CurrentConditionDisplay2(weatherData2);
        weatherData2.setMeasurements(11,22,44);

    }
}
