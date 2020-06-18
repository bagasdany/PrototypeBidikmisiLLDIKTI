package com.stepbystepara.bidikmisilldikti;

import com.google.gson.annotations.SerializedName;

public class UserModel {
//    @SerializedName("iduser")
//    int iduser;
    @SerializedName("kampus")
String kampususer;
    @SerializedName("username")
    String username;
    public UserModel() {};
//    public int getIduser() {return iduser;}
//    public void setIduser(int id) {this.iduser = iduser; }
    public String getKampususer() {return kampususer;}
    public void setKampususer(String kampususer) {this.kampususer = kampususer;}
    public String getUsername() {return username;}

    public void setUsername(String username) {
        this.username = username;
    }
}
