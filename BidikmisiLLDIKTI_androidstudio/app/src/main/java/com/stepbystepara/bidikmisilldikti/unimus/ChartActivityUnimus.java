package com.stepbystepara.bidikmisilldikti.unimus;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.stepbystepara.bidikmisilldikti.R;

public class ChartActivityUnimus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unimuschart);

        String method = getIntent().getStringExtra("method");
        ChartFragmentUnimus chartFragmentUnimus = new ChartFragmentUnimus();
        Bundle bundle = new Bundle();
        bundle.putString("method",method);
        chartFragmentUnimus.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container2, chartFragmentUnimus).commit();
    }
}