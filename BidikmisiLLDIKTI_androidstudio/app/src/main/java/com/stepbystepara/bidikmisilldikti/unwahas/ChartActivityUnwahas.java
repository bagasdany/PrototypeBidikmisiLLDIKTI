package com.stepbystepara.bidikmisilldikti.unwahas;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.stepbystepara.bidikmisilldikti.R;

public class ChartActivityUnwahas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unwahaschart);

        String method = getIntent().getStringExtra("method");
        ChartFragmentUnwahas chartFragmentUnwahas = new ChartFragmentUnwahas();
        Bundle bundle = new Bundle();
        bundle.putString("method",method);
        chartFragmentUnwahas.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container2, chartFragmentUnwahas).commit();
    }
}