package com.example.android.lifecycleweather;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.android.lifecycleweather.data.ForecastItem;
import com.example.android.lifecycleweather.data.ForecastRepository;
import com.example.android.lifecycleweather.data.Status;

import java.util.List;

public class ForecastViewModel extends ViewModel {
    private LiveData<List<ForecastItem>> mSearchResults;
    private ForecastRepository mRepository;
    private LiveData<Status> mLoadingStatus;

    public ForecastViewModel() {
        mRepository = new ForecastRepository();
        mSearchResults = mRepository.getForecastResults();
        mLoadingStatus = mRepository.getLoadingStatus();
    }

    public void loadForecastResults(String query, String tempUnits) {
        mRepository.loadForecastResults(query, tempUnits);
    }

    public LiveData<List<ForecastItem>> getForecastResults() {
        return mSearchResults;
    }

    public LiveData<Status> getLoadingStatus() {
        return mLoadingStatus;
    }


}
