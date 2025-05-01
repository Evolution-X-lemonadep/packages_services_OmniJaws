package org.thosp.yourlocalweather.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import org.omnirom.omnijaws.Config;
import org.omnirom.omnijaws.WeatherContentProvider;
import org.omnirom.omnijaws.WeatherInfo;
import org.omnirom.omnijaws.widget.WeatherAppWidgetProvider;

import java.util.ArrayList;

public class YourLocalWeatherReceiver extends BroadcastReceiver {

    private final Handler mHandler = new Handler();

    @Override
    public void onReceive(Context context, Intent intent) {
        log("Received weather update = " + intent);
        if ("org.thosp.yourlocalweather.action.WEATHER_UPDATE".equals(intent.getAction())) {
            CompleteWeatherInfo completeWeatherInfo = intent.getParcelableExtra("complete_weather_forecast", CompleteWeatherInfo.class);
            WeatherInfo weatherInfo = getWeatherInfo(context, completeWeatherInfo);
            if (weatherInfo != null) {
                mHandler.post(() -> {
                    log("Save weather update = " + weatherInfo);
                    Config.setWeatherData(context.getApplicationContext(), weatherInfo);
                    WeatherContentProvider.updateCachedWeatherInfo(context.getApplicationContext());
                    WeatherAppWidgetProvider.updateAllWidgets(context.getApplicationContext());

                    log("Going to send intent to update weather update = " + weatherInfo);
                    Intent weatherUpdatedIntent = new Intent("org.omnirom.omnijaws.WEATHER_UPDATE");
                    context.getApplicationContext().sendBroadcast(weatherUpdatedIntent);
                    log("Intent sent to update weather update = " + weatherInfo);
                });
            }
            log("Received weather update completed");
        }
    }

    private WeatherInfo getWeatherInfo(Context context, CompleteWeatherInfo completeWeatherInfo) {
        if ((completeWeatherInfo == null) || (completeWeatherInfo.currentWeather == null)) {
            log("completeWeatherInfo or currentWeather is null");
            return null;
        }
        Weather currentWeather = completeWeatherInfo.currentWeather;

        log("currentWeather is " + currentWeather);

        ArrayList<WeatherInfo.DayForecast> forecasts = new ArrayList<>();

        if (completeWeatherInfo.weatherForecastList != null) {
            for (DetailedWeatherForecastWithDetails detailedWeatherForecast: completeWeatherInfo.weatherForecastList) {

                forecasts.add(new WeatherInfo.DayForecast(
                        new Double(detailedWeatherForecast.getTemperatureMin()).floatValue(),
                        new Double(detailedWeatherForecast.getTemperatureMax()).floatValue(),
                        detailedWeatherForecast.getWeatherDescription(),
                        detailedWeatherForecast.getWeatherId(),
                        detailedWeatherForecast.getDateTimeTxt(),
                        true));
            }
        }

        log("calculating new WeatherInfo");
        return new WeatherInfo(
                context,
                String.valueOf(completeWeatherInfo.location.getId()),
                completeWeatherInfo.locationDescription,
                completeWeatherInfo.currentWeatherDescription,
                getWeatherResourceId(currentWeather.getWeatherId(), currentWeather.getTemperature(), currentWeather.getWindSpeed()),
                currentWeather.getTemperature(),
                currentWeather.getHumidity(),
                currentWeather.getWindSpeed(),
                new Float(currentWeather.getWindDirection()).intValue(),
                true,
                forecasts,
                completeWeatherInfo.timestamp
        );
    }

    protected void log(String msg) {
        Log.i("YourLocalWeatherRec:", msg);
    }

    public static int getWeatherResourceId(Integer weatherId,
                                             double maxTemp,
                                             double maxWind) {
        if (weatherId == null) {
            return 31;
        }
        boolean strongWind = maxWind > 5;
        boolean veryStrongWind = maxWind > 15;
        switch (weatherId) {
            case 0:
                if (maxTemp > 30) {
                    return 36;
                } else if (veryStrongWind) {
                    return 24;
                } else {
                    return 32;
                }
            /*case 1:
                if (day)
                    return 34;
                else
                    return 33;*/
            case 1:
                if (veryStrongWind) {
                    return 24;
                } else {
                    return 30;
                }
            case 2:
                if (veryStrongWind) {
                    return 24;
                } else {
                    return 28;
                }
            case 3:
                if (veryStrongWind) {
                    return 24;
                } else {
                    return 26;
                }
            case 51:
            case 80:
                return 39;
            case 53:
            case 55:
            case 81:
                return 11;
            case 61:
            case 63:
            case 65:
            case 82:
                return 12;
            case 56:
            case 57:
            case 66:
            case 67:
                if (strongWind)
                    return 10;
                else
                    return 8;
            case 45:
                return 22;
            case 48:
                return 20;
            case 96:
                return 38;
            case 95:
            case 99:
                return 17;
            case 71:
            case 85:
                return 13;
            case 73:
            case 86:
                if (strongWind)
                    return 15;
                else
                    return 14;
            case 75:
            case 77:
                if (strongWind)
                    return 15;
                else
                    return 16;
            default:
                return 24;
        }
    }
}
