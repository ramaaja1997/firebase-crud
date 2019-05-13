//package id.web.twoh.twohfirebase;
//
//import android.app.Activity;
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.design.widget.Snackbar;
//import android.support.v7.app.AppCompatActivity;
//import android.text.TextUtils;
//import android.view.View;
//import android.view.inputmethod.InputMethodManager;
//import android.widget.Button;
//import android.widget.EditText;
//
//import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import id.web.twoh.twohfirebase.model.Paket;
//
//public class PaketCreateActivity extends AppCompatActivity {
//
//    // variable yang merefers ke Firebase Realtime Database
//    private DatabaseReference database;
//
//    // variable fields EditText dan Button
//    private Button btSubmitPaket;
//    private EditText etNama;
//    private EditText etKapasitas;
//    private EditText etRating;
//    private EditText etSlot;
//    private EditText etHarga;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_paket_create);
//
//        // inisialisasi fields EditText dan Button
//        etNama= (EditText) findViewById(R.id.et_nama);
//        etKapasitas = (EditText) findViewById(R.id.et_kapasitas);
//        etRating = (EditText) findViewById(R.id.et_rating);
//        etSlot = (EditText) findViewById(R.id.et_slot);
//        etHarga = (EditText) findViewById(R.id.et_harga);
//        btSubmitPaket = (Button) findViewById(R.id.bt_submitpaket);
//
//        // mengambil referensi ke Firebase Database
//        database = FirebaseDatabase.getInstance().getReference();
//
//        final Paket paket = (Paket) getIntent().getSerializableExtra("data");
//
//        if (paket != null) {
//            etNama.setText(paket.getNama());
//            etKapasitas.setText(paket.getKapasitas());
//            etRating.setText(paket.getRating());
//            etSlot.setText(paket.getSlot());
//            etHarga.setText(paket.getHarga());
//            btSubmitPaket.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    paket.setNama(etNama.getText().toString());
//                    paket.setKapasitas(etKapasitas.getText().toString());
//                    paket.setRating(etRating.getText().toString());
//                    paket.setSlot(etSlot.getText().toString());
//                    paket.setHarga(etHarga.getText().toString());
//
//                    updatePaket(paket);
//                }
//            });
//        } else {
//            btSubmitPaket.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if(!isEmpty(etNama.getText().toString()) && !isEmpty(etKapasitas.getText().toString()) && !isEmpty(etRating.getText().toString()) && !isEmpty(etSlot.getText().toString())&& !isEmpty(etHarga.getText().toString()))
//                        submitPaket(new Paket(etNama.getText().toString(), etKapasitas.getText().toString(), etRating.getText().toString(), etSlot.getText().toString(), etHarga.getText().toString()));
//                    else
//                        Snackbar.make(findViewById(R.id.bt_submitpaket), "Paket tidak boleh kosong", Snackbar.LENGTH_LONG).show();
//
//                    InputMethodManager imm = (InputMethodManager)
//                            getSystemService(Context.INPUT_METHOD_SERVICE);
//                    imm.hideSoftInputFromWindow(
//                            etNama.getWindowToken(), 0);
//                }
//            });
//        }
//    }
//
//    private boolean isEmpty(String s){
//        // Cek apakah ada fields yang kosong, sebelum disubmit
//        return TextUtils.isEmpty(s);
//    }
//
//    private void updatePaket(Paket paket) {
//        /**
//         * Baris kode yang digunakan untuk mengupdate data barang
//         * yang sudah dimasukkan di Firebase Realtime Database
//         */
//        database.child("paket") //akses parent index, ibaratnya seperti nama tabel
//                .child(paket.getKey()) //select barang berdasarkan key
//                .setValue(paket) //set value barang yang baru
//                .addOnSuccessListener(this, new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void aVoid) {
//
//                        /**
//                         * Baris kode yang akan dipanggil apabila proses update barang sukses
//                         */
//                        Snackbar.make(findViewById(R.id.bt_submitpaket), "Data berhasil diupdatekan", Snackbar.LENGTH_LONG).setAction("Oke", new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                finish();
//                            }
//                        }).show();
//                    }
//                });
//    }
//
//    private void submitPaket(Paket paket) {
//        /**
//         * Ini adalah kode yang digunakan untuk mengirimkan data ke Firebase Realtime Database
//         * dan juga kita set onSuccessListener yang berisi kode yang akan dijalankan
//         * ketika data berhasil ditambahkan
//         */
//        database.child("paket").push().setValue(paket).addOnSuccessListener(this, new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(Void aVoid) {
//                etNama.setText("");
//                etKapasitas.setText("");
//                etRating.setText("");
//                etSlot.setText("");
//                etHarga.setText("");
//                Snackbar.make(findViewById(R.id.bt_submitpaket), "paket berhasil ditambahkan", Snackbar.LENGTH_LONG).show();
//            }
//        });
//    }
//
//    public static Intent getActIntent(Activity activity) {
//        // kode untuk pengambilan Intent
//        return new Intent(activity, PaketCreateActivity.class);
//    }
//}
