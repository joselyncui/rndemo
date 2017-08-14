package com.vicky.demo.reactandroid;

import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * Created by yao.cui on 2017/7/11.
 */

public class CustomToastModule extends ReactContextBaseJavaModule {
    private static final String DURATION_TOAST_SHORT = "SHORT";
    private static final String DURATION_TOAST_LONG = "LONG";

    public CustomToastModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        final Map<String,Object> params = new HashMap<>();
        params.put(DURATION_TOAST_SHORT,Toast.LENGTH_SHORT);
        params.put(DURATION_TOAST_LONG,Toast.LENGTH_LONG);
        return params;
    }

    @Override
    public String getName() {
        return "NativeToastAndroid";
    }

    @ReactMethod
    public void show(String message, int duration){
        Toast.makeText(getReactApplicationContext(),message,duration).show();
    }
}
