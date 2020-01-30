package com.ankur.basedemo.helper;

import android.app.Application;


public class AppController extends Application {

    public void onCreate() {
        super.onCreate();

        FontsOverride.setDefaultFont(AppController.this, "DEFAULT", "fonts/roboto_regular.ttf");
        FontsOverride.setDefaultFont(AppController.this, "MONOSPACE", "fonts/roboto_regular.ttf");
        FontsOverride.setDefaultFont(AppController.this, "SERIF", "fonts/roboto_regular.ttf");
        FontsOverride.setDefaultFont(AppController.this, "SANS_SERIF", "fonts/roboto_regular.ttf");

    }

}
