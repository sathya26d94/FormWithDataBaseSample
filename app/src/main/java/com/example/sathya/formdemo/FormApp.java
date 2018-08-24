package com.example.sathya.formdemo;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

public class FormApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
}
