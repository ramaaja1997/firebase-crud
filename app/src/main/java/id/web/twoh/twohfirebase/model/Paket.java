package id.web.twoh.twohfirebase.model;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

@IgnoreExtraProperties
public class Paket implements Serializable {

    private String nama;
    private String kapasitas;
    private String rating;
    private String slot;
    private String harga;
    private String key;

    public Paket(){

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(String kapasitas) {
        this.kapasitas = kapasitas;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    @Override
    public String toString() {
        return " "+nama+"\n" +
                " "+kapasitas +"\n" +
                " "+rating +"\n" +
                " "+slot +"\n" +
                " "+harga;
    }

    public Paket(String nm, String kps, String slt, String rtg, String hrg){
        nama = nm;
        kapasitas = kps;
        rating = rtg;
        slot = slt;
        harga = hrg;
    }
}
