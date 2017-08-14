package com.vicky.demo.reactandroid;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.react.*;
import com.facebook.react.BuildConfig;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;

import javax.annotation.Nullable;

/**
 * Created by yao.cui on 2017/6/22.
 */

//public class MyReactActivity extends AppCompatActivity implements DefaultHardwareBackBtnHandler{
//
//    private ReactRootView mReactView;
//    private ReactInstanceManager mReactInstanceManager;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        mReactView = new ReactRootView(this);
//        mReactInstanceManager = ReactInstanceManager.builder()
//                .setApplication(getApplication())
//                .setBundleAssetName("index.android.bundle")
//                .setJSMainModuleName("index.android")
//                .addPackage(new MyReactPackage())
//                .setUseDeveloperSupport(BuildConfig.DEBUG)
//                .setInitialLifecycleState(LifecycleState.RESUMED)
//                .build();
//
//        mReactView.startReactApplication(mReactInstanceManager,"helloword",null);
//
//        setContentView(mReactView);
//
//    }
//
//    @Override
//    public void invokeDefaultOnBackPressed() {
//        super.onBackPressed();
//
//    }
//}
public class MyReactActivity extends ReactActivity{

    public static void startActivity(Context context,User user){
        Intent intent = new Intent(context,MyReactActivity.class);
        intent.putExtra("user",user);
        context.startActivity(intent);
    }

    public static void startForResult(Context context){
        Intent intent = new Intent(context,MyReactActivity.class);
        ((Activity)context).startActivityForResult(intent,11);
    }


    @Nullable
    @Override
    protected String getMainComponentName() {
        return "HelloWorld";
    }
}
