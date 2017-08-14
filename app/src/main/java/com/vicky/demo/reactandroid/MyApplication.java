package com.vicky.demo.reactandroid;

import android.app.Application;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lenovo on 2017/6/22.
 */

public class MyApplication extends Application implements ReactApplication {

    private final ReactNativeHost reactNativeHost = new ReactNativeHost(this) {
        @Override
        public boolean getUseDeveloperSupport() {
            return BuildConfig.DEBUG;
        }

        @Override
        protected List<ReactPackage> getPackages() {
            return Arrays.<ReactPackage>asList(new MainReactPackage(),
                    new NativeToastReactPackage());
        }
    };

    @Override
    public ReactNativeHost getReactNativeHost() {
        return reactNativeHost;
    }
}
