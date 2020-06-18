package com.stepbystepara.bidikmisilldikti.udinus;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.stepbystepara.bidikmisilldikti.ApiClient;
import com.stepbystepara.bidikmisilldikti.ApiInterface;
import com.stepbystepara.bidikmisilldikti.Mahasiswa;
import com.stepbystepara.bidikmisilldikti.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditorActivityUdinus extends AppCompatActivity {

    private Spinner mGenderSpinner,mStatusbidikmisispinner,mUniversitasspinner,mStatusdanaspinner;
    private EditText mName,mNim,mAngkatan,mJenjang,mFakultas,mTempatlahir, mTotalipk,mJumlahdana,
            mSemestertempuh, mBirth,mSemester1,mSemester2,mSemester3,
            mSemester4,mSemester5,mSemester6,mSemester7,mSemester8,mTahunmundur,mAlasanmundur,
            mJumlahprestasi,
            mNamaprestasi,mJuaraprestasi,mBidangprestasi,mTingkatprestasi,
            mJumlahorganisasi,
            mNamaorganisasi,mJabatanorganisasi,mStatusorganisasi,mPeriodeorganisasi;
    private CircleImageView mPicture;
    private FloatingActionButton mFabChoosePic;

    Calendar myCalendar = Calendar.getInstance();


    private int mStatusdana = 0;
    public static final int DANA_KURANG = 0;
    public static final int DANA_SUDAH = 1;
    public static final int DANA_BELUM = 2;

    private int mUniversitas = 0;
    public static final int KAMPUS_UNIKA = 1;
    public static final int KAMPUS_UDINUS = 2;
    public static final int KAMPUS_USM = 3;
    private int mStatusbidikmisi = 0;
    public static final int STATUS_NONAKTIF = 0;
    public static final int STATUS_AKTIF = 1;
    public static final int STATUS_MUNDUR = 2;
    private int mGender = 0;
    public static final int GENDER_UNKNOWN = 0;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_FEMALE = 2;

    private String name,nim,angkatan,jenjang,fakultas,tempatlahir, totalipk, semestertempuh, picture, birth,semester1,semester2,semester3,semester4
            ,semester5,semester6,semester7,semester8,tahunmundur,alasanmundur,jumlahdana,
            jumlahprestasi,
            namaprestasi,juaraprestasi,bidangprestasi,tingkatprestasi,
            jumlahorganisasi,
            namaorganisasi,jabatanorganisasi,statusorganisasi,periodeorganisasi;
    private int id, gender,statusbidikmisi,universitas,statusdana;
    private Menu action;
    private Bitmap bitmap;

    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.udinuseditor);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        mName = findViewById(R.id.name);
        mNim = findViewById(R.id.nim);
        mAngkatan = findViewById(R.id.angkatan);
        mJenjang = findViewById(R.id.jenjang);
        mFakultas = findViewById(R.id.fakultas);
        mTempatlahir = findViewById(R.id.tempatlahir);
        mTotalipk = findViewById(R.id.totalipk);
        mSemestertempuh = findViewById(R.id.semestertempuh);
        mBirth = findViewById(R.id.birth);
        mSemester1 = findViewById(R.id.semester1);
        mSemester2= findViewById(R.id.semester2);
        mSemester3 = findViewById(R.id.semester3);
        mSemester4= findViewById(R.id.semester4);
        mSemester5 = findViewById(R.id.semester5);
        mSemester6= findViewById(R.id.semester6);
        mSemester7 = findViewById(R.id.semester7);
        mSemester8= findViewById(R.id.semester8);
        mTahunmundur = findViewById(R.id.tahunmundur);
        mAlasanmundur = findViewById(R.id.alasanmundur);
        mJumlahdana = findViewById(R.id.jumlahdana);
        mJumlahprestasi = findViewById(R.id.jumlahprestasi);
        mNamaprestasi = findViewById(R.id.namaprestasi);
        mJuaraprestasi = findViewById(R.id.juaraprestasi);
        mBidangprestasi = findViewById(R.id.bidangprestasi);
        mTingkatprestasi = findViewById(R.id.tingkatprestasi);
        mJumlahorganisasi = findViewById(R.id.jumlahorganisasi);
        mNamaorganisasi = findViewById(R.id.namaorganisasi);
        mJabatanorganisasi = findViewById(R.id.jabatanorganisasi);
        mStatusorganisasi = findViewById(R.id.statusorganisasi);
        mPeriodeorganisasi = findViewById(R.id.periodeorganisasi);
        mPicture = findViewById(R.id.picture);
        mFabChoosePic = findViewById(R.id.fabChoosePic);
        mStatusbidikmisispinner = findViewById(R.id.statusbidikmisi);
        mGenderSpinner = findViewById(R.id.gender);
        mStatusdanaspinner = findViewById(R.id.statusdana);
        mUniversitasspinner = findViewById(R.id.universitas);
        mBirth = findViewById(R.id.birth);

        mBirth.setFocusableInTouchMode(false);
        mBirth.setFocusable(false);
        mBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(EditorActivityUdinus.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        mFabChoosePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseFile();
            }
        });

        setupSpinner();

        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        name = intent.getStringExtra("name");
        nim = intent.getStringExtra("nim");
        angkatan = intent.getStringExtra("angkatan");
        jenjang = intent.getStringExtra("jenjang");
        fakultas = intent.getStringExtra("fakultas");
        tempatlahir = intent.getStringExtra("tempatlahir");
        totalipk = intent.getStringExtra("totalipk");
        semestertempuh = intent.getStringExtra("semestertempuh");
        birth = intent.getStringExtra("birth");
        semester1 = intent.getStringExtra("semester1");
        semester2 = intent.getStringExtra("semester2");
        semester3 = intent.getStringExtra("semester3");
        semester4 = intent.getStringExtra("semester4");
        semester5 = intent.getStringExtra("semester5");
        semester6 = intent.getStringExtra("semester6");
        semester7 = intent.getStringExtra("semester7");
        semester8 = intent.getStringExtra("semester8");
        tahunmundur = intent.getStringExtra("tahunmundur");
        alasanmundur = intent.getStringExtra("alasanmundur");
        jumlahdana = intent.getStringExtra("jumlahdana");
        jumlahprestasi = intent.getStringExtra("jumlahprestasi");
        namaprestasi = intent.getStringExtra("namaprestasi");
        juaraprestasi = intent.getStringExtra("juaraprestasi");
        bidangprestasi = intent.getStringExtra("bidangprestasi");
        tingkatprestasi = intent.getStringExtra("tingkatprestasi");
        jumlahorganisasi = intent.getStringExtra("jumlahorganisasi");
        namaorganisasi = intent.getStringExtra("namaorganisasi");
        jabatanorganisasi = intent.getStringExtra("jabatanorganisasi");
        statusorganisasi = intent.getStringExtra("statusorganisasi");
        periodeorganisasi = intent.getStringExtra("periodeorganisasi");

        picture = intent.getStringExtra("picture");
        gender = intent.getIntExtra("gender", 0);
        statusbidikmisi = intent.getIntExtra("statusbidikmisi",0);
        statusdana = intent.getIntExtra("statusdana",0);
        universitas = intent.getIntExtra("universitas",0);
        setDataFromIntentExtra();

    }

    private void setDataFromIntentExtra() {

        if (id != 0) {

            readMode();
            getSupportActionBar().setTitle("Edit " + name.toString());

            mName.setText(name);
            mNim.setText(nim);
            mAngkatan.setText(angkatan);
            mJenjang.setText(jenjang);
            mFakultas.setText(fakultas);
            mTempatlahir.setText(tempatlahir);
            mTotalipk.setText(totalipk);
            mSemestertempuh.setText(semestertempuh);
            mBirth.setText(birth);
            mSemester1.setText(semester1);
            mSemester2.setText(semester2);
            mSemester3.setText(semester3);
            mSemester4.setText(semester4);
            mSemester5.setText(semester5);
            mSemester6.setText(semester6);
            mSemester7.setText(semester7);
            mSemester8.setText(semester8);
            mTahunmundur.setText(tahunmundur);
            mAlasanmundur.setText(alasanmundur);
            mJumlahdana.setText(jumlahdana);
            mJumlahprestasi.setText(jumlahprestasi);
            mNamaprestasi.setText(namaprestasi);
            mJuaraprestasi.setText(juaraprestasi);
            mBidangprestasi.setText(bidangprestasi);
            mTingkatprestasi.setText(tingkatprestasi);
            mJumlahorganisasi.setText(jumlahorganisasi);
            mNamaorganisasi.setText(namaorganisasi);
            mJabatanorganisasi.setText(jabatanorganisasi);
            mStatusorganisasi.setText(statusorganisasi);
            mPeriodeorganisasi.setText(periodeorganisasi);

            RequestOptions requestOptions = new RequestOptions();
            requestOptions.skipMemoryCache(true);
            requestOptions.diskCacheStrategy(DiskCacheStrategy.NONE);
            requestOptions.placeholder(R.drawable.profilepoto3);
            requestOptions.error(R.drawable.profilepoto3);

            Glide.with(EditorActivityUdinus.this)
                    .load(picture)
                    .apply(requestOptions)
                    .into(mPicture);

            switch (universitas) {
                case KAMPUS_UNIKA:
                    mUniversitasspinner.setSelection(1);
                    break;
                case KAMPUS_UDINUS:
                    mUniversitasspinner.setSelection(2);
                    break;
                case KAMPUS_USM:
                    mUniversitasspinner.setSelection(3);
                    break;
                default:
                    mUniversitasspinner.setSelection(0);
                    break;
            }

            switch (statusbidikmisi) {
                case STATUS_AKTIF:
                    mStatusbidikmisispinner.setSelection(1);
                    break;
                case STATUS_MUNDUR:
                    mStatusbidikmisispinner.setSelection(2);
                    break;
                default:
                    mStatusbidikmisispinner.setSelection(0);
                    break;
            }

            switch (statusdana) {
                case DANA_SUDAH:
                    mStatusdanaspinner.setSelection(1);
                    break;
                case DANA_BELUM:
                    mStatusdanaspinner.setSelection(2);
                    break;
                default:
                    mStatusdanaspinner.setSelection(0);
                    break;
            }

            switch (gender) {
                case GENDER_MALE:
                    mGenderSpinner.setSelection(1);
                    break;
                case GENDER_FEMALE:
                    mGenderSpinner.setSelection(2);
                    break;
                default:
                    mGenderSpinner.setSelection(0);
                    break;
            }

        } else {
            getSupportActionBar().setTitle("Tambah Mahasiswa");
        }
    }

    private void setupSpinner(){
        ArrayAdapter genderSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.array_gender_options, android.R.layout.simple_spinner_item);
        genderSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mGenderSpinner.setAdapter(genderSpinnerAdapter);

        mGenderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.gender_male))) {
                        mGender = GENDER_MALE;
                    } else if (selection.equals(getString(R.string.gender_female))) {
                        mGender = GENDER_FEMALE;
                    } else {
                        mGender = GENDER_UNKNOWN;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mGender = 0;
            }
        });
        ArrayAdapter statusBidikmisiSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.array_status_options, android.R.layout.simple_spinner_item);
        statusBidikmisiSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mStatusbidikmisispinner.setAdapter(statusBidikmisiSpinnerAdapter);

        mStatusbidikmisispinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.status_aktif))) {
                        mStatusbidikmisi = STATUS_AKTIF;
                    } else if (selection.equals(getString(R.string.status_mundur))) {
                        mStatusbidikmisi = STATUS_MUNDUR;
                    }
                    else {
                        mStatusbidikmisi = STATUS_NONAKTIF;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mStatusbidikmisi = 0;
            }
        });

        ArrayAdapter KampusSpinner = ArrayAdapter.createFromResource(this, R.array.array_kampusudinus_options, android.R.layout.simple_spinner_item);
        KampusSpinner.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mUniversitasspinner.setAdapter(KampusSpinner);

        mUniversitasspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.kampus_unika))) {
                        mUniversitas = KAMPUS_UNIKA;
                    } else if (selection.equals(getString(R.string.kampus_udinus))) {
                        mUniversitas = KAMPUS_UDINUS;
                    } else if (selection.equals(getString(R.string.kampus_usm))) {
                        mUniversitas = KAMPUS_USM;
                    }

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mUniversitas = 0;
            }
        });

        ArrayAdapter StatusdanaSpinner = ArrayAdapter.createFromResource(this, R.array.array_dana_options, android.R.layout.simple_spinner_item);
        StatusdanaSpinner.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mStatusdanaspinner.setAdapter(StatusdanaSpinner);

        mStatusdanaspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.status_sudah))) {
                        mStatusdana = DANA_SUDAH;
                    } else if (selection.equals(getString(R.string.status_belum))) {
                        mStatusdana = DANA_BELUM;
                    } else {
                        mStatusdana = DANA_KURANG;
                    }

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mStatusdana = 0;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_editor, menu);
        action = menu;
        action.findItem(R.id.menu_save).setVisible(false);

        if (id == 0){

            action.findItem(R.id.menu_edit).setVisible(false);
            action.findItem(R.id.menu_delete).setVisible(false);
            action.findItem(R.id.menu_save).setVisible(true);

        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

                this.finish();

                return true;
            case R.id.menu_edit:
                //Edit

                editMode();

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(mName, InputMethodManager.SHOW_IMPLICIT);

                action.findItem(R.id.menu_edit).setVisible(false);
                action.findItem(R.id.menu_delete).setVisible(false);
                action.findItem(R.id.menu_save).setVisible(true);

                return true;
            case R.id.menu_save:
                //Save

                if (id == 0) {

                    if (TextUtils.isEmpty(mName.getText().toString()) ||
                            TextUtils.isEmpty(mSemestertempuh.getText().toString()) ||
                            TextUtils.isEmpty(mBirth.getText().toString())){
                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                        alertDialog.setMessage("Please complete the field!");
                        alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        alertDialog.show();
                    }

                    else {

                        postData("insert");
                        action.findItem(R.id.menu_edit).setVisible(true);
                        action.findItem(R.id.menu_save).setVisible(false);
                        action.findItem(R.id.menu_delete).setVisible(true);

                        readMode();

                    }

                } else {

                    updateData("update", id);
                    action.findItem(R.id.menu_edit).setVisible(true);
                    action.findItem(R.id.menu_save).setVisible(false);
                    action.findItem(R.id.menu_delete).setVisible(true);

                    readMode();
                }

                return true;
            case R.id.menu_delete:

                AlertDialog.Builder dialog = new AlertDialog.Builder(EditorActivityUdinus.this);
                dialog.setMessage("Delete Data Mahasiswa ini?");
                dialog.setPositiveButton("Yes" ,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        deleteData("delete", id, picture);
                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dialog.show();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setBirth();
        }

    };

    private void setBirth() {
        String myFormat = "dd MMMM yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        mBirth.setText(sdf.format(myCalendar.getTime()));
    }

    public String getStringImage(Bitmap bmp){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

    private void chooseFile() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            try {

                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);

                mPicture.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void postData(final String key) {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Saving...");
        progressDialog.show();

        readMode();

        String name = mName.getText().toString().trim();
        String nim = mNim.getText().toString().trim();
        String angkatan = mAngkatan.getText().toString().trim();
        String jenjang = mJenjang.getText().toString().trim();
        String fakultas = mFakultas.getText().toString().trim();
        String tempatlahir = mTempatlahir.getText().toString().trim();
        String totalipk = mTotalipk.getText().toString().trim();
        String semestertempuh = mSemestertempuh.getText().toString().trim();
        String semester1 = mSemester1.getText().toString().trim();
        String semester2 = mSemester2.getText().toString().trim();
        String semester3 = mSemester3.getText().toString().trim();
        String semester4 = mSemester4.getText().toString().trim();
        String semester5 = mSemester5.getText().toString().trim();
        String semester6 = mSemester6.getText().toString().trim();
        String semester7 = mSemester7.getText().toString().trim();
        String semester8 = mSemester8.getText().toString().trim();
        String tahunmundur = mTahunmundur.getText().toString().trim();
        String alasanmundur = mAlasanmundur.getText().toString().trim();
        String jumlahdana = mJumlahdana.getText().toString().trim();
        String jumlahprestasi = mJumlahprestasi.getText().toString().trim();
        String namaprestasi = mNamaprestasi.getText().toString().trim();
        String juaraprestasi = mJuaraprestasi.getText().toString().trim();
        String bidangprestasi = mBidangprestasi.getText().toString().trim();
        String tingkatprestasi = mTingkatprestasi.getText().toString().trim();
        String jumlahorganisasi = mJumlahorganisasi.getText().toString().trim();
        String namaorganisasi = mNamaorganisasi.getText().toString().trim();
        String jabatanorganisasi = mJabatanorganisasi.getText().toString().trim();
        String statusorganisasi = mStatusorganisasi.getText().toString().trim();
        String periodeorganisasi = mPeriodeorganisasi.getText().toString().trim();
        int gender = mGender;
        int universitas = mUniversitas;
        int statusdana = mStatusdana;
        String birth = mBirth.getText().toString().trim();
        String picture = null;
        if (bitmap == null) {
            picture = "";
        } else {
            picture = getStringImage(bitmap);
        }
        int statusbidikmisi = mStatusbidikmisi;

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<Mahasiswa> call = apiInterface.addmhs(key, name,nim,angkatan,jenjang,fakultas,tempatlahir, totalipk, semestertempuh,
                gender, statusbidikmisi,tahunmundur,alasanmundur,statusdana,jumlahdana,universitas,
                semester1,semester2,semester3,semester4,semester5,semester6,semester7,semester8
                ,jumlahprestasi,namaprestasi,juaraprestasi,bidangprestasi,tingkatprestasi
                ,jumlahorganisasi,
                namaorganisasi,jabatanorganisasi,statusorganisasi,periodeorganisasi
                ,birth,picture);

        call.enqueue(new Callback<Mahasiswa>() {
            @Override
            public void onResponse(Call<Mahasiswa> call, Response<Mahasiswa> response) {

                progressDialog.dismiss();

                Log.i(EditorActivityUdinus.class.getSimpleName(), response.toString());

                String value = response.body().getValue();
                String message = response.body().getMassage();

                if (value.equals("1")){
                    finish();
                } else {
                    Toast.makeText(EditorActivityUdinus.this, message, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Mahasiswa> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(EditorActivityUdinus.this, t.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void updateData(final String key, final int id) {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Updating...");
        progressDialog.show();

        readMode();

        String name = mName.getText().toString().trim();
        String nim = mNim.getText().toString().trim();
        String angkatan = mAngkatan.getText().toString().trim();
        String jenjang = mJenjang.getText().toString().trim();
        String fakultas = mFakultas.getText().toString().trim();
        String tempatlahir = mTempatlahir.getText().toString().trim();
        String totalipk = mTotalipk.getText().toString().trim();
        String semestertempuh = mSemestertempuh.getText().toString().trim();
        String semester1 = mSemester1.getText().toString().trim();
        String semester2 = mSemester2.getText().toString().trim();
        String semester3 = mSemester3.getText().toString().trim();
        String semester4 = mSemester4.getText().toString().trim();
        String semester5 = mSemester5.getText().toString().trim();
        String semester6 = mSemester6.getText().toString().trim();
        String semester7 = mSemester7.getText().toString().trim();
        String semester8 = mSemester8.getText().toString().trim();
        String tahunmundur = mTahunmundur.getText().toString().trim();
        String alasanmundur = mAlasanmundur.getText().toString().trim();
        String jumlahdana = mJumlahdana.getText().toString().trim();
        String jumlahprestasi = mJumlahprestasi.getText().toString().trim();
        String namaprestasi = mNamaprestasi.getText().toString().trim();
        String juaraprestasi = mJuaraprestasi.getText().toString().trim();
        String bidangprestasi = mBidangprestasi.getText().toString().trim();
        String tingkatprestasi = mTingkatprestasi.getText().toString().trim();
        String jumlahorganisasi = mJumlahorganisasi.getText().toString().trim();
        String namaorganisasi = mNamaorganisasi.getText().toString().trim();
        String jabatanorganisasi = mJabatanorganisasi.getText().toString().trim();
        String statusorganisasi = mStatusorganisasi.getText().toString().trim();
        String periodeorganisasi = mPeriodeorganisasi.getText().toString().trim();

        int gender = mGender;
        int statusbidikmisi = mStatusbidikmisi;
        int statusdana = mStatusdana;
        int universitas = mUniversitas;
        String birth = mBirth.getText().toString().trim();
        String picture = null;
        if (bitmap == null) {
            picture = "";
        } else {
            picture = getStringImage(bitmap);
        }

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<Mahasiswa> call = apiInterface.updatemhs(key, id,name,nim,angkatan,jenjang,fakultas,tempatlahir, totalipk, semestertempuh,
                gender, statusbidikmisi,tahunmundur,alasanmundur,statusdana,jumlahdana,universitas,
                semester1,semester2,semester3,semester4,semester5,semester6,semester7,semester8
                ,jumlahprestasi,namaprestasi,juaraprestasi,bidangprestasi,tingkatprestasi
                ,jumlahorganisasi,
                namaorganisasi,jabatanorganisasi,statusorganisasi,periodeorganisasi
                ,birth,picture);

        call.enqueue(new Callback<Mahasiswa>() {
            @Override
            public void onResponse(Call<Mahasiswa> call, Response<Mahasiswa> response) {

                progressDialog.dismiss();

                Log.i(EditorActivityUdinus.class.getSimpleName(), response.toString());

                String value = response.body().getValue();
                String message = response.body().getMassage();

                if (value.equals("1")){
                    Toast.makeText(EditorActivityUdinus.this, message, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EditorActivityUdinus.this, message, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Mahasiswa> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(EditorActivityUdinus.this, t.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void deleteData(final String key, final int id, final String pic) {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Deleting...");
        progressDialog.show();

        readMode();

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<Mahasiswa> call = apiInterface.delete(key, id, pic);

        call.enqueue(new Callback<Mahasiswa>() {
            @Override
            public void onResponse(Call<Mahasiswa> call, Response<Mahasiswa> response) {

                progressDialog.dismiss();

                Log.i(EditorActivityUdinus.class.getSimpleName(), response.toString());

                String value = response.body().getValue();
                String message = response.body().getMassage();

                if (value.equals("1")){
                    Toast.makeText(EditorActivityUdinus.this, message, Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(EditorActivityUdinus.this, message, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Mahasiswa> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(EditorActivityUdinus.this, t.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    void readMode(){

        mName.setFocusableInTouchMode(false);
        mNim.setFocusableInTouchMode(false);
        mAngkatan.setFocusableInTouchMode(false);
        mJenjang.setFocusableInTouchMode(false);
        mFakultas.setFocusableInTouchMode(false);
        mTempatlahir.setFocusableInTouchMode(false);
        mTotalipk.setFocusableInTouchMode(false);
        mSemestertempuh.setFocusableInTouchMode(false);
        mSemester1.setFocusableInTouchMode(false);
        mSemester2.setFocusableInTouchMode(false);
        mSemester3.setFocusableInTouchMode(false);
        mSemester4.setFocusableInTouchMode(false);
        mSemester5.setFocusableInTouchMode(false);
        mSemester6.setFocusableInTouchMode(false);
        mSemester7.setFocusableInTouchMode(false);
        mSemester8.setFocusableInTouchMode(false);
        mTahunmundur.setFocusableInTouchMode(false);
        mAlasanmundur.setFocusableInTouchMode(false);
        mJumlahdana.setFocusableInTouchMode(false);
        mJumlahprestasi.setFocusableInTouchMode(false);
        mNamaprestasi.setFocusableInTouchMode(false);
        mJuaraprestasi.setFocusableInTouchMode(false);
        mBidangprestasi.setFocusableInTouchMode(false);
        mTingkatprestasi.setFocusableInTouchMode(false);
        mJumlahorganisasi.setFocusableInTouchMode(false);
        mNamaorganisasi.setFocusableInTouchMode(false);
        mJabatanorganisasi.setFocusableInTouchMode(false);
        mStatusorganisasi.setFocusableInTouchMode(false);
        mPeriodeorganisasi.setFocusableInTouchMode(false);
        mName.setFocusable(false);
        mNim.setFocusable(false);
        mAngkatan.setFocusable(false);
        mJenjang.setFocusable(false);
        mFakultas.setFocusable(false);
        mTempatlahir.setFocusable(false);
        mTotalipk.setFocusable(false);
        mSemestertempuh.setFocusable(false);
        mSemester1.setFocusable(false);
        mSemester2.setFocusable(false);
        mSemester3.setFocusable(false);
        mSemester4.setFocusable(false);
        mSemester5.setFocusable(false);
        mSemester6.setFocusable(false);
        mSemester7.setFocusable(false);
        mSemester8.setFocusable(false);
        mTahunmundur.setFocusable(false);
        mAlasanmundur.setFocusable(false);
        mJumlahdana.setFocusable(false);
        mJumlahprestasi.setFocusable(false);
        mNamaprestasi.setFocusable(false);
        mJuaraprestasi.setFocusable(false);
        mBidangprestasi.setFocusable(false);
        mTingkatprestasi.setFocusable(false);
        mJumlahorganisasi.setFocusable(false);
        mNamaorganisasi.setFocusable(false);
        mJabatanorganisasi.setFocusable(false);
        mStatusorganisasi.setFocusable(false);
        mPeriodeorganisasi.setFocusable(false);
        mGenderSpinner.setEnabled(false);
        mStatusbidikmisispinner.setEnabled(false);
        mStatusdanaspinner.setEnabled(false);
        mUniversitasspinner.setEnabled(false);
        mBirth.setEnabled(false);
        mFabChoosePic.setVisibility(View.INVISIBLE);

    }

    private void editMode(){

        mName.setFocusableInTouchMode(true);
        mNim.setFocusableInTouchMode(true);
        mAngkatan.setFocusableInTouchMode(true);
        mJenjang.setFocusableInTouchMode(true);
        mFakultas.setFocusableInTouchMode(true);
        mTempatlahir.setFocusableInTouchMode(true);
        mTotalipk.setFocusableInTouchMode(true);
        mSemestertempuh.setFocusableInTouchMode(true);
        mSemester1.setFocusableInTouchMode(true);
        mSemester2.setFocusableInTouchMode(true);
        mSemester3.setFocusableInTouchMode(true);
        mSemester4.setFocusableInTouchMode(true);
        mSemester5.setFocusableInTouchMode(true);
        mSemester6.setFocusableInTouchMode(true);
        mSemester7.setFocusableInTouchMode(true);
        mSemester8.setFocusableInTouchMode(true);
        mTahunmundur.setFocusableInTouchMode(true);
        mAlasanmundur.setFocusableInTouchMode(true);
        mJumlahdana.setFocusableInTouchMode(true);
        mJumlahprestasi.setFocusableInTouchMode(true);
        mNamaprestasi.setFocusableInTouchMode(true);
        mJuaraprestasi.setFocusableInTouchMode(true);
        mBidangprestasi.setFocusableInTouchMode(true);
        mTingkatprestasi.setFocusableInTouchMode(true);
        mJumlahorganisasi.setFocusableInTouchMode(true);
        mNamaorganisasi.setFocusableInTouchMode(true);
        mJabatanorganisasi.setFocusableInTouchMode(true);
        mStatusorganisasi.setFocusableInTouchMode(true);
        mPeriodeorganisasi.setFocusableInTouchMode(true);
        mGenderSpinner.setEnabled(true);

        mBirth.setEnabled(true);
        mStatusbidikmisispinner.setEnabled(true);
        mStatusdanaspinner.setEnabled(true);
        mUniversitasspinner.setEnabled(true);
        mFabChoosePic.setVisibility(View.VISIBLE);
    }

}
