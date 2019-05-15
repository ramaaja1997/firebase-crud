package id.web.twoh.twohfirebase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import id.web.twoh.twohfirebase.model.Paket;

public class PaketReadSingleActivity extends AppCompatActivity {

//    private Button btSubmitPaket;
    private TextView etNama;
    private TextView etKapasitas;
    private TextView etRating;
    private TextView etSlot;
    private TextView etHarga;
    private Button beli;
    private EditText something;
    String content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paket_read_single);
        etNama = (TextView) findViewById(R.id.nama);
        etKapasitas = (TextView) findViewById(R.id.kapasitas);
        etRating = (TextView) findViewById(R.id.rating);
        etSlot= (TextView) findViewById(R.id.slot);
        etHarga= (TextView) findViewById(R.id.harga);
//        btSubmitPaket = (Button) findViewById(R.id.bt_submitpaket);

        etNama.setEnabled(false);
        etKapasitas.setEnabled(false);
        etRating.setEnabled(false);
        etSlot.setEnabled(false);
        etHarga.setEnabled(false);
//        btSubmitPaket.setVisibility(View.GONE);

        Paket paket = (Paket) getIntent().getSerializableExtra("data");
        if(paket!=null){
            etNama.setText(paket.getNama());
            etKapasitas.setText(paket.getKapasitas());
            etRating.setText(paket.getRating());
            etSlot.setText(paket.getSlot());
            etHarga.setText(paket.getHarga());
        }


        beli = findViewById(R.id.beli);
        beli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                something = findViewById(R.id.quantity);
                content = something.getText().toString();
                Intent ii=new Intent(PaketReadSingleActivity.this, PayPaketActivity.class);
                ii.putExtra("quantity", content);
                startActivity(ii);
            }
        });
    }

    public static Intent getActIntent(Activity activity){
        return new Intent(activity, PaketReadSingleActivity.class);
    }
}
