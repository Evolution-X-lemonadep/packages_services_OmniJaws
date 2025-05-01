package org.thosp.yourlocalweather.model;

import android.os.Parcel;
import android.os.Parcelable;

public class DetailedWeatherForecastWithDetails implements Parcelable {

    private long dateTime;
    private double temperatureMin;
    private double temperatureMax;
    private double temperature;
    private double pressure;
    private int humidity;
    private double windSpeed;
    private double windDegree;
    private int cloudiness;
    private double rain;
    private double snow;
    private int weatherId;

    String weatherDescription;
    String dateTimeTxt;

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public String getDateTimeTxt() {
        return dateTimeTxt;
    }

    public void setDateTimeTxt(String dateTimeTxt) {
        this.dateTimeTxt = dateTimeTxt;
    }

    public DetailedWeatherForecastWithDetails() {
        super();
    }

    public long getDateTime() {
        return dateTime;
    }

    public void setDateTime(long dateTime) {
        this.dateTime = dateTime;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getWindDegree() {
        return windDegree;
    }

    public void setWindDegree(double windDegree) {
        this.windDegree = windDegree;
    }

    public int getCloudiness() {
        return cloudiness;
    }

    public void setCloudiness(int cloudiness) {
        this.cloudiness = cloudiness;
    }

    public double getRain() {
        return rain;
    }

    public void setRain(double rain) {
        this.rain = rain;
    }

    public double getSnow() {
        return snow;
    }

    public void setSnow(double snow) {
        this.snow = snow;
    }

    public double getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(double temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public double getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(double temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(int weatherId) {
        this.weatherId = weatherId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(dateTime);
        parcel.writeDouble(temperatureMin);
        parcel.writeDouble(temperatureMax);
        parcel.writeDouble(temperature);
        parcel.writeDouble(pressure);
        parcel.writeInt(humidity);
        parcel.writeDouble(windSpeed);
        parcel.writeDouble(windDegree);
        parcel.writeInt(cloudiness);
        parcel.writeDouble(rain);
        parcel.writeDouble(snow);
        parcel.writeInt(weatherId);
        parcel.writeString(weatherDescription);
        parcel.writeString(dateTimeTxt);
    }

    public static final Parcelable.Creator<DetailedWeatherForecastWithDetails> CREATOR
            = new Parcelable.Creator<DetailedWeatherForecastWithDetails>() {
        public DetailedWeatherForecastWithDetails createFromParcel(Parcel in) {
            return new DetailedWeatherForecastWithDetails(in);
        }

        public DetailedWeatherForecastWithDetails[] newArray(int size) {
            return new DetailedWeatherForecastWithDetails[size];
        }
    };

    private DetailedWeatherForecastWithDetails(Parcel in) {
        dateTime = in.readLong();
        temperatureMin = in.readDouble();
        temperatureMax = in.readDouble();
        temperature = in.readDouble();
        pressure = in.readDouble();
        humidity = in.readInt();
        windSpeed = in.readDouble();
        windDegree = in.readDouble();
        cloudiness = in.readInt();
        rain = in.readDouble();
        snow = in.readDouble();
        weatherId = in.readInt();
        weatherDescription = in.readString();
        dateTimeTxt = in.readString();
    }
}