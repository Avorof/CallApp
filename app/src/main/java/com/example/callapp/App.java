package com.example.callapp;

import static timber.log.Timber.DebugTree;
import android.app.Application;
import timber.log.Timber;

public class App extends Application {

   @Override
   public void onCreate() {
      super.onCreate();

      if (BuildConfig.DEBUG) Timber.plant(new DebugTree());
   }
}
