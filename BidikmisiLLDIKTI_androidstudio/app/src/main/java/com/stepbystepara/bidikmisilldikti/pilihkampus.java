package com.stepbystepara.bidikmisilldikti;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.stepbystepara.bidikmisilldikti.Admin.LoginActivityAdmin;
import com.stepbystepara.bidikmisilldikti.ivet.LoginActivityIvet;
import com.stepbystepara.bidikmisilldikti.udinus.LoginActivityUdinus;
import com.stepbystepara.bidikmisilldikti.unika.LoginActivityUnika;
import com.stepbystepara.bidikmisilldikti.unimus.LoginActivityUnimus;
import com.stepbystepara.bidikmisilldikti.unisbank.LoginActivityUnisbank;
import com.stepbystepara.bidikmisilldikti.unissula.LoginActivityUnissula;
import com.stepbystepara.bidikmisilldikti.untag.LoginActivityUntag;
import com.stepbystepara.bidikmisilldikti.unwahas.LoginActivityUnwahas;
import com.stepbystepara.bidikmisilldikti.upgris.LoginActivityUpgris;
import com.stepbystepara.bidikmisilldikti.usm.LoginActivityUsm;

import java.util.ArrayList;
import java.util.List;

public class pilihkampus extends AppCompatActivity {

    ViewPager viewPager;
    AdapterSlide adapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();



    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilihkampus);
        spinner = findViewById(R.id.spinner);

        models = new ArrayList<>();
        models.add(new Model(R.drawable.bidikmisi1, "Bidikmisi LLDIKTI", "BIDIKMISI adalah bantuan biaya pendidikan bagi calon mahasiswa tidak mampu secara ekonomi dan memiliki potensi akademik baik untuk menempuh pendidikan di perguruan tinggi pada program studi unggulan sampai lulus tepat waktu."));
        models.add(new Model(R.drawable.ipk, "Pemantauan IPK", "Perguruan Tinggi Wajib melakukan pemantauan dan pembinaan kepada Mahasiswa yang memiliki IPK < 3 dan wajib melakukan notifikasi dengan menekan tombol warning dibagian list mahasiswa"));
        models.add(new Model(R.drawable.unnamed, "Pemantauan Pencairan Dana", "Perguruan Tinggi Wajib untuk melakukan pembaruan tentang penerimaan dana yang telah diterima oleh mahasiswa,dengan mengisi form sudah cair atau belum"));
        models.add(new Model(R.drawable.o, "Prestasi dan Keaktifan Mahasiswa", "Perguruan Tinggi wajib update prestasi dan juga Organisasi yang diraih dan diikuti oleh mahasiswa"));

        //riskan
        adapter = new AdapterSlide(models,this);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0,130,0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4)
        };

        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position<(adapter.getCount()-1) && position<(colors.length -1)) {
                    viewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(
                            positionOffset,
                            colors[position],
                            colors[position +1])
                    );
                }else {
                    viewPager.setBackgroundColor(colors[colors.length -1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        List<String> categories = new ArrayList<>();
        categories.add(0,"Pilih Kampus");
        categories.add("udinus");
        categories.add("unika");
        categories.add("usm");
        categories.add("unisbank");
        categories.add("upgris");
        categories.add("unimus");
        categories.add("unwahas");
        categories.add("ivet");
        categories.add("unissula");
        categories.add("untag");
        categories.add("admin");

        //style the spinner
        ArrayAdapter<String> dataAdapter;
        dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).equals("Pilih Kampus"))
                {

                }
                else
                {
                    String item = parent.getItemAtPosition(position).toString();

                    Toast.makeText(parent.getContext(),"selected: " +item, Toast.LENGTH_SHORT).show();

                    if (parent.getItemAtPosition(position).equals("udinus"))
                    {
                        Intent intent = new Intent(pilihkampus.this, LoginActivityUdinus.class);
                        startActivity(intent);
                    }
                    else if (parent.getItemAtPosition(position).equals("unika"))
                    {
                        Intent intent = new Intent(pilihkampus.this, LoginActivityUnika.class);
                        startActivity(intent);
                    }else if (parent.getItemAtPosition(position).equals("usm"))
                    {
                        Intent intent = new Intent(pilihkampus.this, LoginActivityUsm.class);
                        startActivity(intent);
                    }
                    else if (parent.getItemAtPosition(position).equals("unisbank"))
                    {
                        Intent intent = new Intent(pilihkampus.this, LoginActivityUnisbank.class);
                        startActivity(intent);
                    }
                    else if (parent.getItemAtPosition(position).equals("upgris"))
                    {
                        Intent intent = new Intent(pilihkampus.this, LoginActivityUpgris.class);
                        startActivity(intent);
                    }
                    else if (parent.getItemAtPosition(position).equals("unimus"))
                    {
                        Intent intent = new Intent(pilihkampus.this, LoginActivityUnimus.class);
                        startActivity(intent);
                    }
                    else if (parent.getItemAtPosition(position).equals("unwahas"))
                    {
                        Intent intent = new Intent(pilihkampus.this, LoginActivityUnwahas.class);
                        startActivity(intent);
                    }else if (parent.getItemAtPosition(position).equals("ivet"))
                    {
                        Intent intent = new Intent(pilihkampus.this, LoginActivityIvet.class);
                        startActivity(intent);
                    }else if (parent.getItemAtPosition(position).equals("unissula"))
                    {
                        Intent intent = new Intent(pilihkampus.this, LoginActivityUnissula.class);
                        startActivity(intent);
                    }else if (parent.getItemAtPosition(position).equals("untag"))
                    {
                        Intent intent = new Intent(pilihkampus.this, LoginActivityUntag.class);
                        startActivity(intent);
                    }
                    else if (parent.getItemAtPosition(position).equals("admin"))
                    {
                        Intent intent = new Intent(pilihkampus.this, LoginActivityAdmin.class);
                        startActivity(intent);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //TODO Auto-generated method stub
            }
        });
    }
}
