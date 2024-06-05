interface WeatherInterface {
  double getTemperature();

  double getHumidity();

  double getWindSpeed();

  double getPrecipitation();
}

interface ThirdPartyWeatherAPI {
  double fetchTemp();

  double fetchHumidity();

  double fetchWindSpeed();

  double fetchPrecipitation();
}

// Adapter class that adapts the third-party API to the standard interface
class WeatherAPIAdapter implements WeatherInterface {
  private ThirdPartyWeatherAPI thirdPartyAPI;

  public WeatherAPIAdapter(ThirdPartyWeatherAPI thirdPartyAPI) {
    this.thirdPartyAPI = thirdPartyAPI;
  }

  @Override
  public double getTemperature() {
    return thirdPartyAPI.fetchTemp();
  }

  @Override
  public double getHumidity() {
    return thirdPartyAPI.fetchHumidity();
  }

  @Override
  public double getWindSpeed() {
    return thirdPartyAPI.fetchWindSpeed();
  }

  @Override
  public double getPrecipitation() {
    return thirdPartyAPI.fetchPrecipitation();
  }
}

class ThirdPartyWeatherAPIImpl implements ThirdPartyWeatherAPI {
  @Override
  public double fetchTemp() {
    return 10.45;
  }

  @Override
  public double fetchHumidity() {

    return 2.45;
  }

  @Override
  public double fetchWindSpeed() {
    return 34.6;
  }

  @Override
  public double fetchPrecipitation() {
    return 5.6;
  }
}

// Example usage
public class WeatherApplication {
  public static void main(String[] args) {
    ThirdPartyWeatherAPI thirdPartyAPI = new ThirdPartyWeatherAPIImpl();

    // Creating an adapter to integrate the third-party API with the weather
    // application
    WeatherInterface weatherAdapter = new WeatherAPIAdapter(thirdPartyAPI);

    double temperature = weatherAdapter.getTemperature();
    double humidity = weatherAdapter.getHumidity();
    double windSpeed = weatherAdapter.getWindSpeed();
    double percipitation = weatherAdapter.getPrecipitation();

    System.out.println("Temperature is " + temperature + ", Humidity is " + humidity + ", Wind sped is " + windSpeed
        + ", Percipitation is " + percipitation);
  }
}
