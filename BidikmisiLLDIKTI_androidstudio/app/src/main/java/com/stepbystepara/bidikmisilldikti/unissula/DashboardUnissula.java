package com.stepbystepara.bidikmisilldikti.unissula;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.stepbystepara.bidikmisilldikti.R;

public class DashboardUnissula extends AppCompatActivity {

    ImageButton imglistmhs ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unissuladashboard);

        imglistmhs = findViewById(R.id.listmahasiswa);

        imglistmhs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardUnissula.this, MainActivityUnissula.class);
                startActivity(intent);
            }
        });
    }

    public void openpieChart(View view) {
        Intent intent = new Intent(this, ChartActivityUnissula.class);
        intent.putExtra("method", "pie");
        startActivity(intent);
    }

    public void openpieprestasi(View view) {
        Intent intent = new Intent(this, ChartActivityUnissula.class);
        intent.putExtra("method", "pieprestasi");
        startActivity(intent);
    }

    public void openpiedana(View view) {
        Intent intent = new Intent(this, ChartActivityUnissula.class);
        intent.putExtra("method", "piedana");
        startActivity(intent);
    }
}
