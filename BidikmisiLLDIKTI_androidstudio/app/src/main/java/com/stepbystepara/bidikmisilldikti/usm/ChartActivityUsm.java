package com.stepbystepara.bidikmisilldikti.usm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.stepbystepara.bidikmisilldikti.R;

public class ChartActivityUsm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usmchart);

        String method = getIntent().getStringExtra("method");
        ChartFragmentUsm chartFragmentUsm = new ChartFragmentUsm();
        Bundle bundle = new Bundle();
        bundle.putString("method",method);
        chartFragmentUsm.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container2,chartFragmentUsm).commit();
    }
}