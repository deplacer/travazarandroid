package com.travazar.tour.packages;

import android.app.Application;
import android.os.StrictMode;

import com.travazar.tour.packages.data.DataManager;

/**
 * Created by kali_root on 10/11/2017.
 */

public class TravazarApplication extends Application {
    private DataManager dataManager;

    @Override
    public void onCreate() {
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .penaltyFlashScreen()
                    .build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());
        }
        super.onCreate();
        dataManager = new DataManager();
    }

    public DataManager getDataManager() {
        return dataManager;
    }
}
