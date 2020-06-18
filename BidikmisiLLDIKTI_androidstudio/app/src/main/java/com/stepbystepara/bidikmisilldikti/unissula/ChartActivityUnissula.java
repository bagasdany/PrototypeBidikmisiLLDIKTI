package com.stepbystepara.bidikmisilldikti.unissula;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.stepbystepara.bidikmisilldikti.R;

public class ChartActivityUnissula extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unissulachart);

        String method = getIntent().getStringExtra("method");
        ChartFragmentUnissula chartFragmentUnissula = new ChartFragmentUnissula();
        Bundle bundle = new Bundle();
        bundle.putString("method",method);
        chartFragmentUnissula.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container2, chartFragmentUnissula).commit();
    }
}