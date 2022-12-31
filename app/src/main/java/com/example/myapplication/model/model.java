package com.example.myapplication.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Generated("jsonschema2pojo")
public class model {

    @SerializedName("hero_img")
    @Expose
    private String heroImg;
    @SerializedName("id_produk")
    @Expose
    private String idProduk;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("harga")
    @Expose
    private String harga;
    @SerializedName("detail")
    @Expose
    private String detail;

    public String getHeroImg() {
        return heroImg;
    }

    public void setHeroImg(String heroImg) {
        this.heroImg = heroImg;
    }

    public String getIdProduk() {
        return idProduk;
    }

    public void setIdProduk(String idProduk) {
        this.idProduk = idProduk;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }


    @SerializedName("kode")
    @Expose
    private Integer kode;
    @SerializedName("pesan")
    @Expose
    private String pesan;
    @SerializedName("data")
    @Expose
    private List<model> data = null;

    public Integer getKode() {
        return kode;
    }

    public void setKode(Integer kode) {
        this.kode = kode;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public List<model> getData() {
        return data;
    }

    public void setData(List<model> data) {
        this.data = data;
    }
}
