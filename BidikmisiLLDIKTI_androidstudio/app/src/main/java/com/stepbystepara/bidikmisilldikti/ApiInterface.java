package com.stepbystepara.bidikmisilldikti;

import com.stepbystepara.bidikmisilldikti.Mahasiswa;

import com.stepbystepara.bidikmisilldikti.ResponseApiModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by haerul on 15/03/18.
 */

public interface ApiInterface {

    //
    //UDINUS
    @FormUrlEncoded
    @POST("loginudinus.php")
    Call<ResponseApiModel> loginudinus(@Field("username") String username,
                                 @Field("password") String password);

    @POST("get_udinus.php")
    Call<List<Mahasiswa>> getUdinus();

    //UNISBANK
    @FormUrlEncoded
    @POST("loginunisbank.php")
    Call<ResponseApiModel> loginunisbank(@Field("username") String username,
                                      @Field("password") String password);

    @POST("get_unisbank.php")
    Call<List<Mahasiswa>> getUnisbank();

    //UPGRIS
    @FormUrlEncoded
    @POST("loginupgris.php")
    Call<ResponseApiModel> loginupgris(@Field("username") String username,
                                         @Field("password") String password);

    @POST("get_upgris.php")
    Call<List<Mahasiswa>> getUpgris();


    //UNIKA
    @FormUrlEncoded
    @POST("loginunika.php")
    Call<ResponseApiModel> loginunika(@Field("username") String username,
                                       @Field("password") String password);

    @POST("get_unika.php")
    Call<List<Mahasiswa>> getUnika();

    //Usm
    @FormUrlEncoded
    @POST("loginusm.php")
    Call<ResponseApiModel> loginusm(@Field("username") String username,
                                      @Field("password") String password);

    @POST("get_usm.php")
    Call<List<Mahasiswa>> getUsm();


    //Unimus
    @FormUrlEncoded
    @POST("loginunimus.php")
    Call<ResponseApiModel> loginunimus(@Field("username") String username,
                                    @Field("password") String password);

    @POST("get_admin.php")
    Call<List<Mahasiswa>> getAdmin();

    @POST("get_adminipk.php")
    Call<List<Mahasiswa>> getAdminipk();

    @POST("get_adminprestasi.php")
    Call<List<Mahasiswa>> getAdminprestasi();

    @POST("get_adminmhsmundur.php")
    Call<List<Mahasiswa>> getAdminmhsmundur();

    @POST("get_adminmhstidakaktif.php")
    Call<List<Mahasiswa>> getAdminmhstidakaktif();

    @POST("get_admindana.php")
    Call<List<Mahasiswa>> getAdmindana();

    //Unimus
    @FormUrlEncoded
    @POST("loginadmin.php")
    Call<ResponseApiModel> loginadmin(@Field("username") String username,
                                       @Field("password") String password);

    @POST("get_unimus.php")
    Call<List<Mahasiswa>> getUnimus();


    //Unwahas
    @FormUrlEncoded
    @POST("loginunwahas.php")
    Call<ResponseApiModel> loginunwahas(@Field("username") String username,
                                       @Field("password") String password);

    @POST("get_unwahas.php")
    Call<List<Mahasiswa>> getUnwahas();

    //Ivet
    @FormUrlEncoded
    @POST("loginivet.php")
    Call<ResponseApiModel> loginivet(@Field("username") String username,
                                        @Field("password") String password);

    @POST("get_ivet.php")
    Call<List<Mahasiswa>> getIvet();

    //Unissula
    @FormUrlEncoded
    @POST("loginunissula.php")
    Call<ResponseApiModel> loginunissula(@Field("username") String username,
                                     @Field("password") String password);

    @POST("get_unissula.php")
    Call<List<Mahasiswa>> getUnissula();

    //Untag
    @FormUrlEncoded
    @POST("loginuntag.php")
    Call<ResponseApiModel> loginuntag(@Field("username") String username,
                                         @Field("password") String password);

    @POST("get_untag.php")
    Call<List<Mahasiswa>> getUntag();


    @FormUrlEncoded
    @POST("addmhs.php")
    Call<Mahasiswa> addmhs(
            @Field("key") String key,
            @Field("name") String name,
            @Field("nim") String nim,
            @Field("angkatan") String angkatan,
            @Field("jenjang") String jenjang,
            @Field("fakultas") String fakultas,
            @Field("tempatlahir") String tempatlahir,
            @Field("totalipk") String totalipk,
            @Field("semestertempuh") String semestertempuh,
            @Field("gender") int gender,
            @Field("statusbidikmisi") int statusbidikmisi,
            @Field("tahunmundur") String tahunmundur,
            @Field("alasanmundur") String alasanmundur,
            @Field("statusdana") int statusdana,
            @Field("jumlahdana") String jumlahdana,
            @Field("universitas") int universitas,
            @Field("semester1") String semester1,
            @Field("semester2") String semester2,
            @Field("semester3") String semester3,
            @Field("semester4") String semester4,
            @Field("semester5") String semester5,
            @Field("semester6") String semester6,
            @Field("semester7") String semester7,
            @Field("semester8") String semester8,
            @Field("jumlahprestasi") String jumlahprestasi,
            @Field("namaprestasi") String namaprestasi,
            @Field("juaraprestasi") String juaraprestasi,
            @Field("bidangprestasi") String bidangprestasi,
            @Field("tingkatprestasi") String tingkatprestasi,
            @Field("jumlahorganisasi") String jumlahorganisasi,
            @Field("namaorganisasi") String namaorganisasi,
            @Field("jabatanorganisasi") String jabatanorganisasi,
            @Field("statusorganisasi") String statusorganisasi,
            @Field("periodeorganisasi") String periodeorganisasi,
            @Field("birth") String birth,
            @Field("picture") String picture);

    @FormUrlEncoded
    @POST("updatemhs.php")
    Call<Mahasiswa> updatemhs(
            @Field("key") String key,
            @Field("id") int id,
            @Field("name") String name,
            @Field("nim") String nim,
            @Field("angkatan") String angkatan,
            @Field("jenjang") String jenjang,
            @Field("fakultas") String fakultas,
            @Field("tempatlahir") String tempatlahir,
            @Field("totalipk") String totalipk,
            @Field("semestertempuh") String semestertempuh,
            @Field("gender") int gender,
            @Field("statusbidikmisi") int statusbidikmisi,
            @Field("tahunmundur") String tahunmundur,
            @Field("alasanmundur") String alasanmundur,
            @Field("statusdana") int statusdana,
            @Field("jumlahdana") String jumlahdana,
            @Field("universitas") int universitas,
            @Field("semester1") String semester1,
            @Field("semester2") String semester2,
            @Field("semester3") String semester3,
            @Field("semester4") String semester4,
            @Field("semester5") String semester5,
            @Field("semester6") String semester6,
            @Field("semester7") String semester7,
            @Field("semester8") String semester8,
            @Field("jumlahprestasi") String jumlahprestasi,
            @Field("namaprestasi") String namaprestasi,
            @Field("juaraprestasi") String juaraprestasi,
            @Field("bidangprestasi") String bidangprestasi,
            @Field("tingkatprestasi") String tingkatprestasi,
            @Field("jumlahorganisasi") String jumlahorganisasi,
            @Field("namaorganisasi") String namaorganisasi,
            @Field("jabatanorganisasi") String jabatanorganisasi,
            @Field("statusorganisasi") String statusorganisasi,
            @Field("periodeorganisasi") String periodeorganisasi,
            @Field("birth") String birth,
            @Field("picture") String picture);


    @FormUrlEncoded
    @POST("delete.php")
    Call<Mahasiswa> delete(
            @Field("key") String key,
            @Field("id") int id,
            @Field("picture") String picture);

    @FormUrlEncoded
    @POST("update_pembinaan.php")
    Call<Mahasiswa> update_pembinaan(
            @Field("key") String key,
            @Field("id") int id,
            @Field("love") boolean love);

}


