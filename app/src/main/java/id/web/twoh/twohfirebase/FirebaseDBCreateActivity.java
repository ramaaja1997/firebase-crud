package id.web.twoh.twohfirebase;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import id.web.twoh.twohfirebase.model.Berita;

public class FirebaseDBCreateActivity extends AppCompatActivity {

    // variable yang merefers ke Firebase Realtime Database
    private DatabaseReference database;

    // variable fields EditText dan Button
    private Button btSubmitBerita;
    private EditText etJudul;
    private EditText etPenulis;
    private EditText etTanggal;
    private EditText etIsi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_create);

        // inisialisasi fields EditText dan Button
        etJudul= (EditText) findViewById(R.id.et_judulberita);
        etPenulis = (EditText) findViewById(R.id.et_namapenulis);
        etTanggal = (EditText) findViewById(R.id.et_tanggalberita);
        etIsi = (EditText) findViewById(R.id.et_isiberita);
        btSubmitBerita = (Button) findViewById(R.id.bt_submitberita);

        // mengambil referensi ke Firebase Database
        database = FirebaseDatabase.getInstance().getReference();

        final Berita berita = (Berita) getIntent().getSerializableExtra("data");

        if (berita != null) {
            etJudul.setText(berita.getJudul());
            etPenulis.setText(berita.getPenulis());
            etTanggal.setText(berita.getTanggal());
            etIsi.setText(berita.getIsi());
            btSubmitBerita.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    berita.setJudul(etJudul.getText().toString());
                    berita.setPenulis(etPenulis.getText().toString());
                    berita.setTanggal(etTanggal.getText().toString());
                    berita.setIsi(etIsi.getText().toString());

                    updateBerita(berita);
                }
            });
        } else {
            btSubmitBerita.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!isEmpty(etJudul.getText().toString()) && !isEmpty(etPenulis.getText().toString()) && !isEmpty(etTanggal.getText().toString()) && !isEmpty(etIsi.getText().toString()))
                        submitBerita(new Berita(etJudul.getText().toString(), etPenulis.getText().toString(), etTanggal.getText().toString(), etIsi.getText().toString()));
                    else
                        Snackbar.make(findViewById(R.id.bt_submitberita), "Berita berita tidak boleh kosong", Snackbar.LENGTH_LONG).show();

                    InputMethodManager imm = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(
                            etJudul.getWindowToken(), 0);
                }
            });
        }
    }

    private boolean isEmpty(String s){
        // Cek apakah ada fields yang kosong, sebelum disubmit
        return TextUtils.isEmpty(s);
    }

    private void updateBerita(Berita berita) {
        /**
         * Baris kode yang digunakan untuk mengupdate data barang
         * yang sudah dimasukkan di Firebase Realtime Database
         */
        database.child("berita") //akses parent index, ibaratnya seperti nama tabel
                .child(berita.getKey()) //select barang berdasarkan key
                .setValue(berita) //set value barang yang baru
                .addOnSuccessListener(this, new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {

                        /**
                         * Baris kode yang akan dipanggil apabila proses update barang sukses
                         */
                        Snackbar.make(findViewById(R.id.bt_submitberita), "Data berhasil diupdatekan", Snackbar.LENGTH_LONG).setAction("Oke", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                finish();
                            }
                        }).show();
                    }
                });
    }

    private void submitBerita(Berita berita) {
        /**
         * Ini adalah kode yang digunakan untuk mengirimkan data ke Firebase Realtime Database
         * dan juga kita set onSuccessListener yang berisi kode yang akan dijalankan
         * ketika data berhasil ditambahkan
         */
        database.child("berita").push().setValue(berita).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                etJudul.setText("");
                etPenulis.setText("");
                etTanggal.setText("");
                etIsi.setText("");
                Snackbar.make(findViewById(R.id.bt_submitberita), "Berita berhasil ditambahkan", Snackbar.LENGTH_LONG).show();
            }
        });
    }

    public static Intent getActIntent(Activity activity) {
        // kode untuk pengambilan Intent
        return new Intent(activity, FirebaseDBCreateActivity.class);
    }
}
