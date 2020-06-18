package com.stepbystepara.bidikmisilldikti.untag;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.stepbystepara.bidikmisilldikti.R;

public class ChartActivityUntag extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.untagchart);

        String method = getIntent().getStringExtra("method");
        ChartFragmentUntag chartFragmentUntag = new ChartFragmentUntag();
        Bundle bundle = new Bundle();
        bundle.putString("method",method);
        chartFragmentUntag.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container2, chartFragmentUntag).commit();
    }
}