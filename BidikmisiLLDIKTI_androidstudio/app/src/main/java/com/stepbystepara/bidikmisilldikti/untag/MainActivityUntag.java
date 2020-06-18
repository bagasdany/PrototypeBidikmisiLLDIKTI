package com.stepbystepara.bidikmisilldikti.untag;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.stepbystepara.bidikmisilldikti.Adapter;
import com.stepbystepara.bidikmisilldikti.ApiClient;
import com.stepbystepara.bidikmisilldikti.ApiInterface;
import com.stepbystepara.bidikmisilldikti.Mahasiswa;
import com.stepbystepara.bidikmisilldikti.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//import android.view.Menu;
//import android.view.MenuInflater;

//import com.haerul.mypets.Util.SessionManager;

public class MainActivityUntag extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Adapter adapter;
    private List<Mahasiswa> mhsList;
    ApiInterface apiInterface;
    Adapter.RecyclerViewClickListener listener;
    ProgressBar progressBar;
    TextView iduser,kampus,username;
//    SessionManager sm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.untagmain);
//        kampus =  findViewById(R.id.tvkampus);
//        iduser =  findViewById(R.id.tvid);
//        username =  findViewById(R.id.tvusername);
//        sm = new SessionManager(MainActivity.this);
//        HashMap<String,String> map = sm.getDetailLogin();
//        Intent data = getIntent();
//        if (data.getExtras()!= null){
//            tv.setText(String.valueOf(int));
//            id.setText(String.valueOf(id));
//            iduser.setText((CharSequence) data.getExtras().getIntegerArrayList(("iduser")));
//            kampus.setText(data.getExtras().getString("kampus"));
//            username.setText(data.getExtras().getString("username"));
//        }
//        sm.checkLogin();

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        progressBar = findViewById(R.id.progress);
        recyclerView = findViewById(R.id.recyclerView);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        listener = new Adapter.RecyclerViewClickListener() {
            @Override
            public void onRowClick(View view, final int position) {

                Intent intent = new Intent(MainActivityUntag.this, EditorActivityUntag.class);
                intent.putExtra("id", mhsList.get(position).getId());
                intent.putExtra("name", mhsList.get(position).getName());
                intent.putExtra("nim", mhsList.get(position).getNim());
                intent.putExtra("angkatan", mhsList.get(position).getAngkatan());
                intent.putExtra("jenjang", mhsList.get(position).getJenjang());
                intent.putExtra("fakultas", mhsList.get(position).getFakultas());
                intent.putExtra("tempatlahir", mhsList.get(position).getTempatlahir());
                intent.putExtra("totalipk", mhsList.get(position).getTotalipk());
                intent.putExtra("semestertempuh", mhsList.get(position).getSemestertempuh());
                intent.putExtra("gender", mhsList.get(position).getGender());
                intent.putExtra("statusbidikmisi",mhsList.get(position).getStatusbidikmisi());
                intent.putExtra("tahunmundur", mhsList.get(position).getTahunmundur());
                intent.putExtra("alasanmundur", mhsList.get(position).getAlasanmundur());
                intent.putExtra("statusdana", mhsList.get(position).getStatusdana());
                intent.putExtra("jumlahdana", mhsList.get(position).getJumlahdana());
                intent.putExtra("semester1",mhsList.get(position).getSemester1());
                intent.putExtra("semester2",mhsList.get(position).getSemester2());
                intent.putExtra("semester3",mhsList.get(position).getSemester3());
                intent.putExtra("semester4",mhsList.get(position).getSemester4());
                intent.putExtra("semester5",mhsList.get(position).getSemester5());
                intent.putExtra("semester6",mhsList.get(position).getSemester6());
                intent.putExtra("semester7",mhsList.get(position).getSemester7());
                intent.putExtra("semester8",mhsList.get(position).getSemester8());
                intent.putExtra("jumlahprestasi",mhsList.get(position).getJumlahprestasi());
                intent.putExtra("namaprestasi",mhsList.get(position).getNamaprestasi());
                intent.putExtra("juaraprestasi",mhsList.get(position).getJuaraprestasi());
                intent.putExtra("bidangprestasi",mhsList.get(position).getBidangprestasi());
                intent.putExtra("tingkatprestasi",mhsList.get(position).getTingkatprestasi());
                intent.putExtra("jumlahorganisasi",mhsList.get(position).getJumlahorganisasi());
                intent.putExtra("namaorganisasi",mhsList.get(position).getNamaorganisasi());
                intent.putExtra("jabatanorganisasi",mhsList.get(position).getJabatanorganisasi());
                intent.putExtra("statusorganisasi",mhsList.get(position).getStatusorganisasi());
                intent.putExtra("periodeorganisasi",mhsList.get(position).getPeriodeorganisasi());
                intent.putExtra("birth", mhsList.get(position).getBirth());
                intent.putExtra("picture", mhsList.get(position).getPicture());
                startActivity(intent);

            }

            @Override
            public void onLoveClick(View view, int position) {

                final int id = mhsList.get(position).getId();
                final Boolean love = mhsList.get(position).getLove();
                final ImageView mLove = view.findViewById(R.id.love);

                if (love){
                    mLove.setImageResource(R.drawable.likeof);
                    mhsList.get(position).setLove(false);
                    updateLove("update_love", id, false);
                    adapter.notifyDataSetChanged();
                } else {
                    mLove.setImageResource(R.drawable.likeon);
                    mhsList.get(position).setLove(true);
                    updateLove("update_love", id, true);
                    adapter.notifyDataSetChanged();
                }

            }
        };

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivityUntag.this, EditorActivityUntag.class));
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {



        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        final SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        MenuItem searchMenuItem = menu.findItem(R.id.action_search);

        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName())
        );
        searchView.setQueryHint("Search Mahasiswa...");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(final String query) {

                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);
                return false;
            }
        });

        searchMenuItem.getIcon().setVisible(false, false);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void getUntag(){

        Call<List<Mahasiswa>> call = apiInterface.getUntag();
        call.enqueue(new Callback<List<Mahasiswa>>() {
            @Override
            public void onResponse(Call<List<Mahasiswa>> call, Response<List<Mahasiswa>> response) {
                progressBar.setVisibility(View.GONE);
                mhsList = response.body();
                Log.i(MainActivityUntag.class.getSimpleName(), response.body().toString());
                adapter = new Adapter(mhsList, MainActivityUntag.this, listener);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Mahasiswa>> call, Throwable t) {
                Toast.makeText(MainActivityUntag.this, "rp :"+
                        t.getMessage().toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void updateLove(final String key, final int id, final Boolean love){

        Call<Mahasiswa> call = apiInterface.update_pembinaan(key, id, love);

        call.enqueue(new Callback<Mahasiswa>() {
            @Override
            public void onResponse(Call<Mahasiswa> call, Response<Mahasiswa> response) {

                Log.i(MainActivityUntag.class.getSimpleName(), "Response "+response.toString());

                String value = response.body().getValue();
                String message = response.body().getMassage();

                if (value.equals("1")){
                    Toast.makeText(MainActivityUntag.this, message, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivityUntag.this, message, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Mahasiswa> call, Throwable t) {
                Toast.makeText(MainActivityUntag.this, t.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getUntag();
    }

//    public void openpieChart(View view) {
//        Intent intent = new Intent(this, ChartActivityUdinus.class);
//        intent.putExtra("method", "pie");
//        startActivity(intent);
//    }
}
