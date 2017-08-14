package com.vicky.demo.reactandroid;

import android.app.Activity;
import android.content.Intent;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.google.gson.Gson;

/**
 * Created by yao.cui on 2017/7/12.
 */

public class IntentModule extends ReactContextBaseJavaModule {

    public IntentModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "getIntentData";
    }

    @ReactMethod
    public void getDataFromIntent(Callback sucCallback, Callback errorCallback){
        User user = (User)getCurrentActivity().getIntent().getSerializableExtra("user");
        if (user!=null){
            sucCallback.invoke(new Gson().toJson(user));
        } else {
            errorCallback.invoke("user is empty");
        }
    }

    @ReactMethod
    public void finishActivity(String result){
        Activity currentActivity = getCurrentActivity();
        Intent intent = new Intent();
        intent.putExtra("result",result);
        currentActivity.setResult(Activity.RESULT_OK,intent);
        currentActivity.finish();

    }

}
