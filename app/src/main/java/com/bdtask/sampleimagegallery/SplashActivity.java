package com.bdtask.sampleimagegallery;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.tbruyelle.rxpermissions2.RxPermissions;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                RxPermissions rxPermissions = new RxPermissions(SplashActivity.this);
                rxPermissions
                        .request(Manifest.permission.READ_EXTERNAL_STORAGE) // ask single or multiple permission once
                        .subscribe(granted -> {
                            if (granted) {
                                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                                finish();
                            } else {
                                finish();
                            }
                        });
            }
        },2000);

    }
}