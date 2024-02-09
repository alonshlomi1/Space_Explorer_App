package com.example.spaceexplorerapp.UI_Controllers;

import android.app.Application;

import com.example.spaceexplorerapp.Utilities.SignalManager;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SignalManager.init(this);
    }
}
