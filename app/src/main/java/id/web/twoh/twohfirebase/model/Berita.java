package id.web.twoh.twohfirebase.model;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

@IgnoreExtraProperties
public class Berita implements Serializable {

    private String judul;
    private String penulis;
    private String tanggal;
    private String isi;
    private String key;

    public Berita(){

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    @Override
    public String toString() {
        return " "+judul+"\n" +
                " "+penulis +"\n" +
                " "+tanggal +"\n" +
                " "+isi;
    }

    public Berita(String jdl, String pnls, String tgl, String is){
        judul = jdl;
        penulis = pnls;
        tanggal = tgl;
        isi = is;
    }
}
