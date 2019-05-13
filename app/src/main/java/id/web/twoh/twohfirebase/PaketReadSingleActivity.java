//package id.web.twoh.twohfirebase;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//
//import id.web.twoh.twohfirebase.model.Paket;
//
//public class PaketReadSingleActivity extends AppCompatActivity {
//
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
//        etNama = (EditText) findViewById(R.id.et_nama);
//        etKapasitas = (EditText) findViewById(R.id.et_kapasitas);
//        etRating = (EditText) findViewById(R.id.et_rating);
//        etSlot= (EditText) findViewById(R.id.et_slot);
//        etHarga= (EditText) findViewById(R.id.et_harga);
//        btSubmitPaket = (Button) findViewById(R.id.bt_submitpaket);
//
//        etNama.setEnabled(false);
//        etKapasitas.setEnabled(false);
//        etRating.setEnabled(false);
//        etSlot.setEnabled(false);
//        etHarga.setEnabled(false);
//        btSubmitPaket.setVisibility(View.GONE);
//
//        Paket paket = (Paket) getIntent().getSerializableExtra("data");
//        if(paket!=null){
//            etNama.setText(paket.getNama());
//            etKapasitas.setText(paket.getKapasitas());
//            etRating.setText(paket.getRating());
//            etSlot.setText(paket.getSlot());
//            etHarga.setText(paket.getHarga());
//        }
//    }
//
//    public static Intent getActIntent(Activity activity){
//        return new Intent(activity, FirebaseDBReadSingleActivity.class);
//    }
//}
