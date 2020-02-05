package com.bhadresha.tejas.sannibh;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        final ImageView zoom = (ImageView) findViewById(R.id.imageView);
        final Animation zoomAnimation = AnimationUtils.loadAnimation(this,R.anim.zoom);
        zoom.startAnimation(zoomAnimation);


        start_act();


    }

    @Override
    protected void onResume() {
        super.onResume();
        start_act();
    }
    public void start_act(){
        final Intent i = new Intent(this,MainActivity.class);
        new Handler().postDelayed(new Runnable(){
            public void run(){

                startActivity(i);
            }
        },1000);
    }
}
