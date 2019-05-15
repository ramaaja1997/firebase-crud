package id.web.twoh.twohfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class PayPaketActivity extends AppCompatActivity {

    private Button konfirmasi, subpocer, kenselpocer;
    private TextView quant, jumlahbay, subtotal, initotal,  inibank, nama;
    private CheckBox tfcek;
    private EditText pocer,pocerfix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_paket);

        konfirmasi = findViewById(R.id.konfirmasi);
        quant = findViewById(R.id.data);
        jumlahbay = findViewById(R.id.jumlah);
        pocer = findViewById(R.id.vocer);
        subtotal = findViewById(R.id.subtot);
        initotal = findViewById(R.id.total);
        subpocer = findViewById(R.id.pocerbuton);
        kenselpocer = findViewById(R.id.pocerkensel);
        pocerfix = findViewById(R.id.fixpocer);
        tfcek = findViewById(R.id.cektf);
        inibank = findViewById(R.id.banktf);

        final int jum, harga, qty;
        harga = 960000;
        String newString;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("quantity");
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("quantity");
        }
        qty = Integer.parseInt(newString);
        jum = harga * qty;
        final String inistring = String.valueOf(jum);
        quant.setText(newString);
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
                startActivity(new Intent(PayPaketActivity.this, SelesaiActivity.class));
            }
        });
    }
}
