package com.stepbystepara.bidikmisilldikti.ivet;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.stepbystepara.bidikmisilldikti.R;

public class ChartActivityIvet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ivetchart);

        String method = getIntent().getStringExtra("method");
        ChartFragmentIvet chartFragmentIvet = new ChartFragmentIvet();
        Bundle bundle = new Bundle();
        bundle.putString("method",method);
        chartFragmentIvet.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container2, chartFragmentIvet).commit();
    }
}