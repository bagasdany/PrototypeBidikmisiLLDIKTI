package com.stepbystepara.bidikmisilldikti.upgris;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.stepbystepara.bidikmisilldikti.R;

public class ChartActivityUpgris extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upgrischart);

        String method = getIntent().getStringExtra("method");
        ChartFragmentUpgris chartFragmentUpgris = new ChartFragmentUpgris();
        Bundle bundle = new Bundle();
        bundle.putString("method",method);
        chartFragmentUpgris.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container2, chartFragmentUpgris).commit();
    }
}