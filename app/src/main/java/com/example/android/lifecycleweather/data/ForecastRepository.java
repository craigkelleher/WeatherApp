package com.example.android.lifecycleweather.data;

import android.text.TextUtils;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.android.lifecycleweather.utils.OpenWeatherMapUtils;

import java.util.List;

public class ForecastRepository implements ForecastAsyncTask.Callback {
    private MutableLiveData<List<ForecastItem>> mForecastResults;
    private static final String TAG = ForecastRepository.class.getSimpleName();
    private MutableLiveData<Status> mLoadingStatus;
    private String mCurrentQuery;
    private String mCurrentUnits;


    public ForecastRepository() {
        mForecastResults = new MutableLiveData<>();
        mForecastResults.setValue(null);

        mLoadingStatus = new MutableLiveData<>();
        mLoadingStatus.setValue(Status.SUCCESS);

        mCurrentQuery = null;
    }

    public LiveData<List<ForecastItem>> getForecastResults() {
        return mForecastResults;
    }

    private boolean shouldExecuteSearch(String query, String tempUnits) {
        return !TextUtils.equals(query, mCurrentQuery)
                || !TextUtils.equals(tempUnits, mCurrentUnits);
    }

    public void loadForecastResults(String query, String tempUnits) {
        if (shouldExecuteSearch(query, tempUnits)) {
            mCurrentUnits = tempUnits;
            mCurrentQuery = query;
            mForecastResults.setValue(null);
            String url = OpenWeatherMapUtils.buildForecastURL(query, tempUnits);
            Log.d(TAG, "executing search with this URL: " + url);
            mLoadingStatus.setValue(Status.LOADING);
            new ForecastAsyncTask(this).execute(url);
        } else {
            Log.d(TAG, "using cached search results");
        }
    }

    public LiveData<Status> getLoadingStatus() {
        return mLoadingStatus;
    }

    @Override
    public void onResultsFinished(List<ForecastItem> forecastResults) {
        mForecastResults.setValue(forecastResults);
        if (forecastResults != null) {
            mLoadingStatus.setValue(Status.SUCCESS);
        } else {
            mLoadingStatus.setValue(Status.ERROR);
        }
    }
}
