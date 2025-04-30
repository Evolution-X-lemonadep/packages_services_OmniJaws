/*
 * Copyright (C) 2013 The CyanogenMod Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.omnirom.omnijaws;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.os.Build;
import org.omnirom.omnijaws.WeatherInfo.DayForecast;
import org.omnirom.omnijaws.widget.WeatherAppWidgetProvider;

import java.util.*;

public class YourLocalWeatherProvider extends AbstractWeatherProvider {
    private static final String TAG = "YourLocalWeatherProvider";

    public YourLocalWeatherProvider(Context context) {
        super(context);
    }

    public WeatherInfo getCustomWeather(String id, boolean metric) {
        return null;
    }

    public WeatherInfo getLocationWeather(Location location, boolean metric) {
        return null;
    }

    public boolean shouldRetry() {
        return false;
    }

}
