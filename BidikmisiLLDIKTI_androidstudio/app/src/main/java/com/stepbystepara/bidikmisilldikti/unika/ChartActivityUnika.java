package com.stepbystepara.bidikmisilldikti.unika;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.stepbystepara.bidikmisilldikti.R;

public class ChartActivityUnika extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unikachart);

        String method = getIntent().getStringExtra("method");
        ChartFragmentUnika chartFragmentUnika = new ChartFragmentUnika();
        Bundle bundle = new Bundle();
        bundle.putString("method",method);
        chartFragmentUnika.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container2,chartFragmentUnika).commit();
    }
}