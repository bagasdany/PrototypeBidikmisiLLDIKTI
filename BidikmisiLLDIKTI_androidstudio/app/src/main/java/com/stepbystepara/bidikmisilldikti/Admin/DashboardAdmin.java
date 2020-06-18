package com.stepbystepara.bidikmisilldikti.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.stepbystepara.bidikmisilldikti.R;

public class DashboardAdmin extends AppCompatActivity {

    ImageButton imglistmhs,listipk,listprestasi,listdana,listmhsmundur,listtidakaktif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admindashboard);

        imglistmhs = findViewById(R.id.listmahasiswa);
        listipk = findViewById(R.id.ipkmain);
        listprestasi = findViewById(R.id.prestasimain);
        listdana = findViewById(R.id.danaactivity);
        listmhsmundur = findViewById(R.id.mhsmundur);
        listtidakaktif = findViewById(R.id.tidakaktif);

        imglistmhs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardAdmin.this, MainActivityAdmin.class);
                startActivity(intent);
            }
        });

        listipk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardAdmin.this, IpkActivityAdmin.class);
                startActivity(intent);
            }
        });

        listprestasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardAdmin.this, PrestasiActivityAdmin.class);
                startActivity(intent);
            }
        });
        listdana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardAdmin.this, DanaActivityAdmin.class);
                startActivity(intent);
            }
        });
        listmhsmundur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardAdmin.this, MhsMundurActivityAdmin.class);
                startActivity(intent);
            }
        });

        listtidakaktif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardAdmin.this, Mhstidakaktif.class);
                startActivity(intent);
            }
        });
    }

    public void openpieChart(View view) {
        Intent intent = new Intent(this, ChartActivityAdmin.class);
        intent.putExtra("method", "pie");
        startActivity(intent);
    }

//    public void openpieprestasi(View view) {
//        Intent intent = new Intent(this, ChartActivityAdmin.class);
//        intent.putExtra("method", "pieprestasi");
//        startActivity(intent);
//    }
//
//    public void openpiedana(View view) {
//        Intent intent = new Intent(this, ChartActivityAdmin.class);
//        intent.putExtra("method", "piedana");
//        startActivity(intent);
//    }
//
//    public void openpiemundur(View view) {
//        Intent intent = new Intent(this, ChartActivityAdmin.class);
//        intent.putExtra("method", "piemundur");
//        startActivity(intent);
//    }
//
//    public void pietidakaktif(View view) {
//        Intent intent = new Intent(this, ChartActivityAdmin.class);
//        intent.putExtra("method", "pietidakaktif");
//        startActivity(intent);
//    }
}
