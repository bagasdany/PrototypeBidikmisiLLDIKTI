package com.stepbystepara.bidikmisilldikti.Admin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.stepbystepara.bidikmisilldikti.ApiClient;
import com.stepbystepara.bidikmisilldikti.ApiInterface;
import com.stepbystepara.bidikmisilldikti.Mahasiswa;
import com.stepbystepara.bidikmisilldikti.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChartFragmentAdmin extends Fragment {
    private BarChart mBarChart;
    private PieChart mPieChart;

    public ChartFragmentAdmin() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.adminfragment, container, false);
        mBarChart = view.findViewById(R.id.barChart);
        mPieChart = view.findViewById(R.id.pieChart);
        getGrowthChart (getArguments().getString("method"));
        return view;
    }

    private void getGrowthChart(final String method) {

        Call<List<Mahasiswa>> call = ApiClient.getApiClient().create(ApiInterface.class).getAdmin();
//        Call<List<Growth>> call = ApiClient.getApiClient().create(ApiInterface.class).getPets();
        call.enqueue(new Callback<List<Mahasiswa>>() {
            @Override
            public void onResponse(Call<List<Mahasiswa>> call, Response<List<Mahasiswa>> response) {
                if (response.body()!=null)
                {
                    if (method.equals("piedana"))
                    {
                        List<PieEntry> pieEntries = new ArrayList<>();

                        for (Mahasiswa growth : response.body())
                        {
                            if ((growth.getStatusdana())==2){
                                pieEntries.add(new PieEntry((growth.getStatusdana()),(growth.getName())));
                            }

                        }

                        mPieChart.setVisibility(View.VISIBLE);
                        mPieChart.animateXY(5000,5000);
                        mPieChart.setDragDecelerationFrictionCoef(0.99f);
                        mPieChart.setTransparentCircleRadius(60f);
                        mPieChart.setCenterText("Mahasiswa yang belum menerima dana");
                        mPieChart.setCenterTextSize(15);
                        mPieChart.setCenterTextRadiusPercent(50);
                        PieDataSet pieDataSet = new PieDataSet(pieEntries, "Nama Mahasiswa");
                        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

                        PieData pieData = new PieData(pieDataSet);
                        pieDataSet.setSliceSpace(3f);
                        pieDataSet.setSelectionShift(5f);
                        mPieChart.setData(pieData);

                        Description description = new Description();
                        description.setText("Grafik Mahasiswa yang belum menerima dana");
                        mPieChart.setDescription(description);
                        mPieChart.invalidate();
                    }

                    else if (method.equals("pie"))
                    {
                        List<PieEntry> pieEntries = new ArrayList<>();

                        for (Mahasiswa growth : response.body())
                        {
                            if (Float.parseFloat(growth.getTotalipk())<3){
                                pieEntries.add(new PieEntry(Float.parseFloat(growth.getTotalipk()),(growth.getName()),(growth.getAngkatan())));
                            }

                        }
                        mPieChart.setDrawEntryLabels(true);
                        mPieChart.setVisibility(View.VISIBLE);
                        mPieChart.animateXY(5000,5000);
                        mPieChart.setDragDecelerationFrictionCoef(0.99f);
                        mPieChart.setTransparentCircleRadius(60f);
                        mPieChart.setCenterText("Mahasiswa IPK <3");
                        mPieChart.setCenterTextSize(15);
                        mPieChart.setCenterTextRadiusPercent(50);
                        PieDataSet pieDataSet = new PieDataSet(pieEntries, "Nama Mahasiswa");
                        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

                        PieData pieData = new PieData(pieDataSet);
                        pieDataSet.setSliceSpace(3f);
                        pieDataSet.setSelectionShift(5f);
                        mPieChart.setData(pieData);

                        Description description = new Description();
                        description.setText("Daftar Mahasiswa IPK < 3 ,Segera dilakukan pembinaan");
                        mPieChart.setDescription(description);
                        mPieChart.invalidate();

                    }
                    else if (method.equals("pieprestasi"))
                    {
                        List<PieEntry> pieEntries = new ArrayList<>();

                        for (Mahasiswa growth : response.body())
                        {
                            if (Float.parseFloat(growth.getJumlahprestasi())>0){
                                pieEntries.add(new PieEntry(Float.parseFloat(growth.getJumlahprestasi()),(growth.getName())));
                            }

                        }

                        mPieChart.setVisibility(View.VISIBLE);
                        mPieChart.animateXY(5000,5000);
                        mPieChart.setDragDecelerationFrictionCoef(0.99f);
                        mPieChart.setTransparentCircleRadius(60f);
                        mPieChart.setCenterText("Banyaknya Prestasi Mahasiswa");
                        mPieChart.setCenterTextSize(15);
                        mPieChart.setCenterTextRadiusPercent(50);
                        PieDataSet pieDataSet = new PieDataSet(pieEntries, "Nama Mahasiswa");
                        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

                        PieData pieData = new PieData(pieDataSet);
                        pieDataSet.setSliceSpace(3f);
                        pieDataSet.setSelectionShift(5f);
                        mPieChart.setData(pieData);

                        Description description = new Description();
                        description.setText("Jumlah Prestasi Mahasiswa");
                        mPieChart.setDescription(description);
                        mPieChart.invalidate();

                    }
                    else if (method.equals("piemundur"))
                    {
                        List<PieEntry> pieEntries = new ArrayList<>();

                        for (Mahasiswa growth : response.body())
                        {
                            if (growth.getStatusbidikmisi()==2){
                                pieEntries.add(new PieEntry(growth.getStatusbidikmisi(),(growth.getName())));
                            }

                        }
                        mPieChart.setDrawEntryLabels(true);
                        mPieChart.setVisibility(View.VISIBLE);
                        mPieChart.animateXY(5000,5000);
                        mPieChart.setDragDecelerationFrictionCoef(0.99f);
                        mPieChart.setTransparentCircleRadius(60f);
                        mPieChart.setCenterText("Mahasiswa yang mengundurkan diri");
                        mPieChart.setCenterTextSize(15);
                        mPieChart.setCenterTextRadiusPercent(50);
                        PieDataSet pieDataSet = new PieDataSet(pieEntries, "Nama Mahasiswa");
                        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

                        PieData pieData = new PieData(pieDataSet);
                        pieDataSet.setSliceSpace(3f);
                        pieDataSet.setSelectionShift(5f);
                        mPieChart.setData(pieData);

                        Description description = new Description();
                        description.setText("Mahasiswa yang mengundurkan diri");
                        mPieChart.setDescription(description);
                        mPieChart.invalidate();

                    }

                    else if (method.equals("pietidakaktif"))
                    {
                        List<PieEntry> pieEntries = new ArrayList<>();

                        for (Mahasiswa growth : response.body())
                        {
                            if (growth.getStatusbidikmisi()==0){
                                pieEntries.add(new PieEntry(Float.parseFloat(growth.getTahunmundur()),(growth.getName())));
                            }

                        }
                        mPieChart.setDrawEntryLabels(true);
                        mPieChart.setVisibility(View.VISIBLE);
                        mPieChart.animateXY(5000,5000);
                        mPieChart.setDragDecelerationFrictionCoef(0.99f);
                        mPieChart.setTransparentCircleRadius(60f);
                        mPieChart.setCenterText("Mahasiswa yang mengundurkan diri");
                        mPieChart.setCenterTextSize(15);
                        mPieChart.setCenterTextRadiusPercent(50);
                        PieDataSet pieDataSet = new PieDataSet(pieEntries, "Nama Mahasiswa");
                        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

                        PieData pieData = new PieData(pieDataSet);
                        pieDataSet.setSliceSpace(3f);
                        pieDataSet.setSelectionShift(5f);
                        mPieChart.setData(pieData);

                        Description description = new Description();
                        description.setText("Mahasiswa yang mengundurkan diri");
                        mPieChart.setDescription(description);
                        mPieChart.invalidate();

                    }


                }
            }

            @Override
            public void onFailure(Call<List<Mahasiswa>> call, Throwable t) {

            }
        });


    }

}
