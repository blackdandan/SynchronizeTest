package com.example.blackdandan.synchronizetest;

import android.app.Application;
import android.os.Environment;

/**
 * description :
 * Created by blackdandan on 2017/10/16.
 */

public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("do===="+e.getMessage());
            }
        };
    }
}
