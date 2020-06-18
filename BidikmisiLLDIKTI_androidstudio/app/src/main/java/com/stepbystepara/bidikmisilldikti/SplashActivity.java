package com.stepbystepara.bidikmisilldikti;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private ImageView iv1,iv2,iv3,iv4,iv5;

    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        iv1 = findViewById(R.id.logodikbud);
        iv2 = findViewById(R.id.tulisanbidikmisi);
        iv3 = findViewById(R.id.headerkanan);
        iv4 = findViewById(R.id.tulisandikbud);
        iv5 = findViewById(R.id.footer);

        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.push_down);
        iv1.setAnimation(animation);

        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.push_right);
        iv2.setAnimation(animation);

        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.push_down);
        iv3.setAnimation(animation);

        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.push_down);
        iv4.setAnimation(animation);

        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.push_right);
        iv5.setAnimation(animation);

        Thread thread = new Thread()
        {
            @Override
            public void run() {

                try {
                    sleep(4000);
                    Intent intent = new Intent(getApplicationContext(),pilihkampus.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                super.run();

            }
        };
        thread.start();
    }
}
