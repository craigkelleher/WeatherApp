package com.example.android.lifecycleweather.data;

import java.io.Serializable;
import java.util.Date;

public class ForecastData implements Serializable {
    public Date dateTime;
    public String description;
    public String icon;
    public long temperature;
    public long temperatureLow;
    public long temperatureHigh;
    public long humidity;
    public long windSpeed;
    public String windDirection;
}
