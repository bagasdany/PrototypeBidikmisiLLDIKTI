package com.stepbystepara.bidikmisilldikti.Admin;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.stepbystepara.bidikmisilldikti.R;

public class ChartActivityAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminchart);

        String method = getIntent().getStringExtra("method");
        ChartFragmentAdmin chartFragmentAdmin = new ChartFragmentAdmin();
        Bundle bundle = new Bundle();
        bundle.putString("method",method);
        chartFragmentAdmin.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container2, chartFragmentAdmin).commit();
    }
}