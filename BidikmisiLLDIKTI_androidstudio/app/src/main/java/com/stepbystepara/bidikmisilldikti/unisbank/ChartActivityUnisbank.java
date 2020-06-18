package com.stepbystepara.bidikmisilldikti.unisbank;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.stepbystepara.bidikmisilldikti.R;

public class ChartActivityUnisbank extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unisbankchart);

        String method = getIntent().getStringExtra("method");
        ChartFragmentUnisbank chartFragmentUnisbank = new ChartFragmentUnisbank();
        Bundle bundle = new Bundle();
        bundle.putString("method",method);
        chartFragmentUnisbank.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container2, chartFragmentUnisbank).commit();
    }
}