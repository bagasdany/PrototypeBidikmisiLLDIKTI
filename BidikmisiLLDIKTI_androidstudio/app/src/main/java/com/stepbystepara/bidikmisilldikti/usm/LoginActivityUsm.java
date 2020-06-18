package com.stepbystepara.bidikmisilldikti.usm;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.stepbystepara.bidikmisilldikti.ApiClient;
import com.stepbystepara.bidikmisilldikti.ApiInterface;
import com.stepbystepara.bidikmisilldikti.R;
import com.stepbystepara.bidikmisilldikti.ResponseApiModel;
import com.stepbystepara.bidikmisilldikti.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivityUsm extends AppCompatActivity {
    private EditText edtUsername, edtPassword,edtid;
    private Button btnLogin;
    private ProgressDialog pd;
    private static final String TAG = LoginActivityUsm.class.getSimpleName();
//    private SessionManager sm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usmlogin);
        edtUsername =  findViewById(R.id.edtUsername);
        edtPassword =  findViewById(R.id.edtPassword);

        btnLogin =  findViewById(R.id.btnLogin);
        pd = new ProgressDialog(LoginActivityUsm.this);
//        sm = new SessionManager(LoginActivity.this);
        pd.setMessage("loading ...");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.show();
                ApiInterface Api = ApiClient.getRequestService();
                Call<ResponseApiModel> login = Api.loginusm(edtUsername.getText().toString(),edtPassword.getText().toString());
                login.enqueue(new Callback<ResponseApiModel>() {
                    @Override
                    public void onResponse(Call<ResponseApiModel> call, Response<ResponseApiModel> response) {
                        pd.dismiss();
                        Log.d(TAG, "response : " +response.toString());
                        ResponseApiModel res = response.body();
                        List<UserModel> user = res.getResult();
                        if (res.getKode().equals("1")) {

//                            sm.storeLogin(user.get(0).getUsername(),user.get(0).getKampususer());
                            Toast.makeText(LoginActivityUsm.this, "Semangat Mengisi Data" , Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivityUsm.this, DashboardUsm.class);
//                            intent.putExtra("id",user.get(0).getIduser());
                            intent.putExtra("kampus",user.get(0).getKampususer());
                            intent.putExtra("username",user.get(0).getUsername());
                            startActivity(intent);

                        } else
                        {
                            Toast.makeText(LoginActivityUsm.this, "username tidak cocok", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseApiModel> call, Throwable t) {
                        pd.dismiss();
                        Log.e(TAG,"error: " + t.getMessage());
                    }
                });
            }
        });
    }



}
