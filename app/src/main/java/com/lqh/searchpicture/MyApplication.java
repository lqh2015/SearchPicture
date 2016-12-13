package com.lqh.searchpicture;

import android.app.Application;

import com.jude.beam.Beam;

/**
 * Created by lqh on 2016/12/10.
 */
public class MyApplication extends Application {
    private static MyApplication instance;

    public static MyApplication getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        Beam.init(this);
    }
}
