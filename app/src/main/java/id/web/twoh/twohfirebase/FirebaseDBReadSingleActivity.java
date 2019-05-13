package id.web.twoh.twohfirebase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import id.web.twoh.twohfirebase.model.Barang;
import id.web.twoh.twohfirebase.model.Berita;

public class FirebaseDBReadSingleActivity extends AppCompatActivity {

    private Button btSubmitBerita;
    private EditText etJudul;
    private EditText etPenulis;
    private EditText etTanggal;
    private EditText etIsi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_create);
        etJudul = (EditText) findViewById(R.id.et_judulberita);
        etPenulis = (EditText) findViewById(R.id.et_namapenulis);
        etTanggal = (EditText) findViewById(R.id.et_tanggalberita);
        etIsi = (EditText) findViewById(R.id.et_isiberita);
        btSubmitBerita = (Button) findViewById(R.id.bt_submitberita);

        etJudul.setEnabled(false);
        etPenulis.setEnabled(false);
        etTanggal.setEnabled(false);
        etIsi.setEnabled(false);
        btSubmitBerita.setVisibility(View.GONE);

        Berita berita = (Berita) getIntent().getSerializableExtra("data");
        if(berita!=null){
            etJudul.setText(berita.getJudul());
            etPenulis.setText(berita.getPenulis());
            etTanggal.setText(berita.getTanggal());
            etIsi.setText(berita.getIsi());
        }
    }

    public static Intent getActIntent(Activity activity){
        return new Intent(activity, FirebaseDBReadSingleActivity.class);
    }
}
