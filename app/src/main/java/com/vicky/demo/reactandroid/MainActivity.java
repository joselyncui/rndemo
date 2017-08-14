package com.vicky.demo.reactandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mbtnStartReact;
    private Button btnStartReactForResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mbtnStartReact = (Button) findViewById(R.id.btnStartReact);
        btnStartReactForResult = (Button) findViewById(R.id.btnStartReactForResult);

        mbtnStartReact.setOnClickListener(this);
        btnStartReactForResult.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnStartReact:
                MyReactActivity.startActivity(this,new User("vicky","femal"));
                break;
            case R.id.btnStartReactForResult:
                MyReactActivity.startForResult(this);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==11){
            Toast.makeText(this,data.getStringExtra("result"),Toast.LENGTH_LONG).show();
        }
    }
}

