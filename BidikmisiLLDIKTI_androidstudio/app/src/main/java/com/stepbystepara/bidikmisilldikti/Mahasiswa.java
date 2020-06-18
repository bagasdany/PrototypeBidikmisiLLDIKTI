package com.stepbystepara.bidikmisilldikti;

import com.google.gson.annotations.SerializedName;

public class Mahasiswa {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("nim")
    private String nim;
    @SerializedName("angkatan")
    private String angkatan;
    @SerializedName("jenjang")
    private String jenjang;
    @SerializedName("fakultas")
    private String fakultas;
    @SerializedName("tempatlahir")
    private String tempatlahir;
    @SerializedName("totalipk")
    private String totalipk;
    @SerializedName("semestertempuh")
    private String semestertempuh;
    @SerializedName("gender")
    private int gender;
    @SerializedName("statusbidikmisi")
    private int statusbidikmisi;
    @SerializedName("tahunmundur")
    private String tahunmundur;
    @SerializedName("alasanmundur")
    private String alasanmundur;
    @SerializedName("statusdana")
    private int statusdana;
    @SerializedName("jumlahdana")
    private String jumlahdana;
    @SerializedName("universitas")
    private int universitas;
    @SerializedName("jumlahprestasi")
    private String jumlahprestasi;
    @SerializedName("namaprestasi")
    private String namaprestasi;
    @SerializedName("juaraprestasi")
    private String juaraprestasi;
    @SerializedName("bidangprestasi")
    private String bidangprestasi;
    @SerializedName("tingkatprestasi")
    private String tingkatprestasi;
    @SerializedName("jumlahorganisasi")
    private String jumlahorganisasi;
    @SerializedName("namaorganisasi")
    private String namaorganisasi;
    @SerializedName("jabatanorganisasi")
    private String jabatanorganisasi;
    @SerializedName("statusorganisasi")
    private String statusorganisasi;
    @SerializedName("periodeorganisasi")
    private String periodeorganisasi;
    @SerializedName("semester1")
    private String semester1;
    @SerializedName("semester2")
    private String semester2;
    @SerializedName("semester3")
    private String semester3;
    @SerializedName("semester4")
    private String semester4;
    @SerializedName("semester5")
    private String semester5;
    @SerializedName("semester6")
    private String semester6;
    @SerializedName("semester7")
    private String semester7;
    @SerializedName("semester8")
    private String semester8;
    @SerializedName("birth")
    private String birth;
    @SerializedName("picture")
    private String picture;
    @SerializedName("love")
    private Boolean love;
    @SerializedName("value")
    private String value;
    @SerializedName("message")
    private String massage;


    public String getJumlahdana() {
        return jumlahdana;
    }

    public void setJumlahdana(String jumlahdana) {
        this.jumlahdana = jumlahdana;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(String angkatan) {
        this.angkatan = angkatan;
    }

    public String getJenjang() {
        return jenjang;
    }

    public void setJenjang(String jenjang) {
        this.jenjang = jenjang;
    }

    public String getFakultas() {
        return fakultas;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }

    public String getTempatlahir() {
        return tempatlahir;
    }

    public void setTempatlahir(String tempatlahir) {
        this.tempatlahir = tempatlahir;
    }

    public String getTahunmundur() {
        return tahunmundur;
    }

    public void setTahunmundur(String tahunmundur) {
        this.tahunmundur = tahunmundur;
    }

    public String getTotalipk() {
        return totalipk;
    }

    public void setTotalipk(String totalipk) {
        this.totalipk = totalipk;
    }

    public String getSemestertempuh() {
        return semestertempuh;
    }

    public void setSemestertempuh(String semestertempuh) {
        this.semestertempuh = semestertempuh;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getStatusbidikmisi() {
        return statusbidikmisi;
    }

    public void setStatusbidikmisi(int statusbidikmisi) {
        this.statusbidikmisi = statusbidikmisi;
    }



    public String getAlasanmundur() {
        return alasanmundur;
    }

    public void setAlasanmundur(String alasanmundur) {
        this.alasanmundur = alasanmundur;
    }

    public int getStatusdana() {
        return statusdana;
    }

    public void setStatusdana(int statusdana) {
        this.statusdana = statusdana;
    }


    public int getUniversitas() {
        return universitas;
    }

    public void setUniversitas(int universitas) {
        this.universitas = universitas;
    }

    public String getJumlahprestasi() {
        return jumlahprestasi;
    }

    public void setJumlahprestasi(String jumlahprestasi) {
        this.jumlahprestasi = jumlahprestasi;
    }

    public String getNamaprestasi() {
        return namaprestasi;
    }

    public void setNamaprestasi(String namaprestasi) {
        this.namaprestasi = namaprestasi;
    }

    public String getJuaraprestasi() {
        return juaraprestasi;
    }

    public void setJuaraprestasi(String juaraprestasi) {
        this.juaraprestasi = juaraprestasi;
    }

    public String getBidangprestasi() {
        return bidangprestasi;
    }

    public void setBidangprestasi(String bidangprestasi) {
        this.bidangprestasi = bidangprestasi;
    }

    public String getTingkatprestasi() {
        return tingkatprestasi;
    }

    public void setTingkatprestasi(String tingkatprestasi) {
        this.tingkatprestasi = tingkatprestasi;
    }

    public String getJumlahorganisasi() {
        return jumlahorganisasi;
    }

    public void setJumlahorganisasi(String jumlahorganisasi) {
        this.jumlahorganisasi = jumlahorganisasi;
    }

    public String getNamaorganisasi() {
        return namaorganisasi;
    }

    public void setNamaorganisasi(String namaorganisasi) {
        this.namaorganisasi = namaorganisasi;
    }

    public String getJabatanorganisasi() {
        return jabatanorganisasi;
    }

    public void setJabatanorganisasi(String jabatanorganisasi) {
        this.jabatanorganisasi = jabatanorganisasi;
    }

    public String getStatusorganisasi() {
        return statusorganisasi;
    }

    public void setStatusorganisasi(String statusorganisasi) {
        this.statusorganisasi = statusorganisasi;
    }

    public String getPeriodeorganisasi() {
        return periodeorganisasi;
    }

    public void setPeriodeorganisasi(String periodeorganisasi) {
        this.periodeorganisasi = periodeorganisasi;
    }

    public String getSemester1() {
        return semester1;
    }

    public void setSemester1(String semester1) {
        this.semester1 = semester1;
    }

    public String getSemester2() {
        return semester2;
    }

    public void setSemester2(String semester2) {
        this.semester2 = semester2;
    }

    public String getSemester3() {
        return semester3;
    }

    public void setSemester3(String semester3) {
        this.semester3 = semester3;
    }

    public String getSemester4() {
        return semester4;
    }

    public void setSemester4(String semester4) {
        this.semester4 = semester4;
    }

    public String getSemester5() {
        return semester5;
    }

    public void setSemester5(String semester5) {
        this.semester5 = semester5;
    }

    public String getSemester6() {
        return semester6;
    }

    public void setSemester6(String semester6) {
        this.semester6 = semester6;
    }

    public String getSemester7() {
        return semester7;
    }

    public void setSemester7(String semester7) {
        this.semester7 = semester7;
    }

    public String getSemester8() {
        return semester8;
    }

    public void setSemester8(String semester8) {
        this.semester8 = semester8;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Boolean getLove() {
        return love;
    }

    public void setLove(Boolean love) {
        this.love = love;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}