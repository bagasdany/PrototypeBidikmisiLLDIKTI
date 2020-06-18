package com.stepbystepara.bidikmisilldikti.udinus;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.stepbystepara.bidikmisilldikti.R;

public class ChartActivityUdinus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.udinuschart);

        String method = getIntent().getStringExtra("method");
        ChartFragmentUdinus chartFragmentUdinus = new ChartFragmentUdinus();
        Bundle bundle = new Bundle();
        bundle.putString("method",method);
        chartFragmentUdinus.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container2,chartFragmentUdinus).commit();
    }
}