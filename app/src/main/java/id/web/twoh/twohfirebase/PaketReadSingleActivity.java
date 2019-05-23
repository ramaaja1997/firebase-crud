package id.web.twoh.twohfirebase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import id.web.twoh.twohfirebase.model.Paket;

public class PaketReadSingleActivity extends AppCompatActivity {

//    private Button btSubmitPaket;
    private TextView etNama;
    private TextView etKapasitas;
    private TextView etRating;
    private TextView etSlot;
    private TextView etHarga;

    private EditText etKuantitas;
    private TextView etData;

    private Button beli;
    private EditText something;
    private CheckBox cbSetuju;
    private LinearLayout Linear;
    String content;

    private Button konfirmasi, subpocer, kenselpocer;
    private TextView jumlahbay, subtotal, initotal,  inibank;
    private CheckBox tfcek;
    private EditText pocer,pocerfix;

    int hargaq,qtyq;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paket_read_single);
        etNama = (TextView) findViewById(R.id.nama);
        etNama = (TextView) findViewById(R.id.nama2);
        etKapasitas = (TextView) findViewById(R.id.kapasitas);
        etRating = (TextView) findViewById(R.id.rating);
        etSlot= (TextView) findViewById(R.id.slot);
        etHarga= (TextView) findViewById(R.id.harga);
        cbSetuju = findViewById(R.id.setuju);
        Linear = findViewById(R.id.linear2);

        etKuantitas = findViewById(R.id.quantity);
        etData = findViewById(R.id.data);

        konfirmasi = findViewById(R.id.konfirmasi);
        jumlahbay = findViewById(R.id.jumlah);
        pocer = findViewById(R.id.vocer);
        subtotal = findViewById(R.id.subtot);
        initotal = findViewById(R.id.total);
        subpocer = findViewById(R.id.pocerbuton);
        kenselpocer = findViewById(R.id.pocerkensel);
        pocerfix = findViewById(R.id.fixpocer);
        tfcek = findViewById(R.id.cektf);
        inibank = findViewById(R.id.banktf);


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
            hargaq = Integer.parseInt(paket.getHarga());
        }

        beli = findViewById(R.id.beli);
        beli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Linear.setVisibility(View.VISIBLE);
                etData.setText(etKuantitas.getText().toString());

                final int jum;

                jum = Integer.parseInt(etKuantitas.getText().toString())*hargaq;

                final String inistring = String.valueOf(jum);
                jumlahbay.setText("Rp"+inistring);
                subtotal.setText("Rp"+inistring);
                initotal.setText("Rp"+inistring);

                tfcek.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(buttonView.isChecked()){
                            inibank.setVisibility(View.VISIBLE);
                        }else{
                            inibank.setVisibility(View.GONE);
                        }
                    }
                });
                subpocer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pocerfix.setVisibility(View.VISIBLE);
                        pocer.setVisibility(View.GONE);
                        pocerfix.setText(pocer.getText().toString());
                        subpocer.setVisibility(View.GONE);
                        kenselpocer.setVisibility(View.VISIBLE);
                        int total;
                        if(pocer.getText().toString().equals("GS200DSC")){
                            total = jum - 200000;
                            String totalcoy = String.valueOf(total);
                            initotal.setText("Rp"+totalcoy);
                        }
                        else{
                            initotal.setText("Rp"+inistring);
                        }
                    }
                });
                kenselpocer.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        pocerfix.setVisibility(View.GONE);
                        pocer.setVisibility(View.VISIBLE);
                        subpocer.setVisibility(View.VISIBLE);
                        kenselpocer.setVisibility(View.GONE);
                        initotal.setText("Rp"+inistring);
                    }
                });
                konfirmasi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(PaketReadSingleActivity.this, SelesaiActivity.class));
                    }
                });
            }
        });




    }

    public static Intent getActIntent(Activity activity){
        return new Intent(activity, PaketReadSingleActivity.class);
    }
}
