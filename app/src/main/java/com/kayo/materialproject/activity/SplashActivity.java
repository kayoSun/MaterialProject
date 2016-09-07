package com.kayo.materialproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.kayo.materialproject.R;

import java.util.Random;

/**
 * Created by Kayo on 2016/7/27.
 */

public class SplashActivity extends AppCompatActivity{

    private Handler handler;
    private ImageView bg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_spash);
        int[] girls = new int[]{R.drawable.girl_01,R.drawable.girl_02,R.drawable.girl_03,R.drawable.girl_04,R.drawable.girl_05,R.drawable.girl_06};
        Random random = new Random();
        bg = (ImageView) findViewById(R.id.bg);
        setBg(random,girls);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent();
                intent.setClass(SplashActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);

    }
    public void toLogin(View v){
        handler.removeCallbacksAndMessages(null);
        Intent intent = new Intent();
        intent.setClass(SplashActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
    public void setBg( Random random,int[] girls){
        int i = random.nextInt(6);
        bg.setImageResource(girls[i]);
    }
}
