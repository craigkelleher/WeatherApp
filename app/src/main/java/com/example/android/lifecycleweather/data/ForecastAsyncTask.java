package com.example.android.lifecycleweather.data;

import android.os.AsyncTask;

import com.example.android.lifecycleweather.utils.NetworkUtils;
import com.example.android.lifecycleweather.utils.OpenWeatherMapUtils;

import java.io.IOException;
import java.util.List;

public class ForecastAsyncTask extends AsyncTask<String, Void, String> {
    private Callback mCallback;

    public interface Callback {
        void onResultsFinished(List<ForecastItem> forecastResults);
    }

    public ForecastAsyncTask(Callback callback) { mCallback = callback; }

    @Override
    protected String doInBackground(String... params) {
        String openWeatherMapURL = params[0];
        String forecastJSON = null;
        try {
            forecastJSON = NetworkUtils.doHTTPGet(openWeatherMapURL);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return forecastJSON;
    }

    @Override
    protected void onPostExecute(String s) {
        List<ForecastItem> forecastResults = null;
        if (s != null) {
            forecastResults = OpenWeatherMapUtils.parseForecastJSON(s);
        }

        mCallback.onResultsFinished(forecastResults);

    }
}
