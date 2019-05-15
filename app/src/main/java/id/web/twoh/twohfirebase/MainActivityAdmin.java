package id.web.twoh.twohfirebase;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivityAdmin extends AppCompatActivity {


    private CardView bankcardid,berita,promo,tentang;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);

        bankcardid = findViewById(R.id.bankcardId);
        berita = findViewById(R.id.berita);
        promo = findViewById(R.id.promo);
        tentang = findViewById(R.id.tentang);

        bankcardid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivityAdmin.this, KelolaPaketActivity.class));
            }
        });

        berita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivityAdmin.this, FirebaseDBActivity.class));
            }
        });
    }

}