package com.stepbystepara.bidikmisilldikti.unimus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.stepbystepara.bidikmisilldikti.R;

public class DashboardUnimus extends AppCompatActivity {

    ImageButton imglistmhs ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unimusdashboard);

        imglistmhs = findViewById(R.id.listmahasiswa);

        imglistmhs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardUnimus.this, MainActivityUnimus.class);
                startActivity(intent);
            }
        });
    }

    public void openpieChart(View view) {
        Intent intent = new Intent(this, ChartActivityUnimus.class);
        intent.putExtra("method", "pie");
        startActivity(intent);
    }

    public void openpieprestasi(View view) {
        Intent intent = new Intent(this, ChartActivityUnimus.class);
        intent.putExtra("method", "pieprestasi");
        startActivity(intent);
    }

    public void openpiedana(View view) {
        Intent intent = new Intent(this, ChartActivityUnimus.class);
        intent.putExtra("method", "piedana");
        startActivity(intent);
    }
}
