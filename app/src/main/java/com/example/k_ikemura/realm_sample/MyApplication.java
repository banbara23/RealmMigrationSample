package com.example.k_ikemura.realm_sample;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by k_ikemura on 2017/07/18.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
