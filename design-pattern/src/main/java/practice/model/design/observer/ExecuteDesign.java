package practice.model.design.observer;

/**
 * @program: tnm-biz-manage
 * @Description
 * @Author xsq
 * @Date 2024/1/16 14:32
 **/
public class ExecuteDesign {
    public static void main(String[] args) {
        // 注册
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay conditionDisplay = new CurrentConditionDisplay(weatherData);
        TemperatureDisplay temperatureDisplay = new TemperatureDisplay(weatherData);
        weatherData.setChange(11,22,33);

    }
}
