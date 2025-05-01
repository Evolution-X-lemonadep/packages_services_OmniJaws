package org.thosp.yourlocalweather.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class CompleteWeatherForecast implements Parcelable {

    String locationDescription;
    Location location;

    List<DetailedWeatherForecastWithDetails> mWeatherForecastList = new ArrayList<>();

    public CompleteWeatherForecast() {
    }

    public void addDetailedWeatherForecast(DetailedWeatherForecastWithDetails detailedWeatherForecast) {
        mWeatherForecastList.add(detailedWeatherForecast);
    }

    public List<DetailedWeatherForecastWithDetails> getWeatherForecastList() {
        return mWeatherForecastList;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(location, 0);
        parcel.writeString(locationDescription);
        parcel.writeTypedList(mWeatherForecastList);
    }

    public static final Parcelable.Creator<CompleteWeatherForecast> CREATOR
            = new Parcelable.Creator<CompleteWeatherForecast>() {
        public CompleteWeatherForecast createFromParcel(Parcel in) {
            return new CompleteWeatherForecast(in);
        }

        public CompleteWeatherForecast[] newArray(int size) {
            return new CompleteWeatherForecast[size];
        }
    };

    private CompleteWeatherForecast(Parcel in) {
        location = in.readParcelable(Location.class.getClassLoader());
        locationDescription = in.readString();
        in.readTypedList(mWeatherForecastList, DetailedWeatherForecastWithDetails.CREATOR);
    }
}
