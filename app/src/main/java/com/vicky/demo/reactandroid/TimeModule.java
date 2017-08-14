package com.vicky.demo.reactandroid;

import android.support.annotation.Nullable;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

/**
 * Created by yao.cui on 2017/7/11.
 */

public class TimeModule extends ReactContextBaseJavaModule {

    public TimeModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "TimeModule";
    }

    @ReactMethod
    public void getTime(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(3000);
                } catch (Exception e){
                    e.printStackTrace();
                }

                long time = System.currentTimeMillis();
                WritableMap map = new WritableNativeMap();
                map.putString("key",time+"");
                sendTransMisson(getReactApplicationContext(),"sendTime",map);

            }
        }).start();

    }

    public void sendTransMisson(ReactContext reactContext, String eventName, @Nullable WritableMap map){
        reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(eventName,map);
    }


}
