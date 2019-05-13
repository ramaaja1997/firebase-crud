//package id.web.twoh.twohfirebase;
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.Button;
//
///**
// * Created by Herdi_WORK on 07.05.17.
// */
//
//public class KelolaPaketActivity extends AppCompatActivity {
//
//    private Button btCreateDBpaket;
//    private Button btViewDBpaket;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_crud_paket);
//
//        btCreateDBpaket = (Button) findViewById(R.id.bt_createdatapaket);
//        btViewDBpaket = (Button) findViewById(R.id.bt_viewdatapaket);
//
//        btCreateDBpaket.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(PaketCreateActivity.getActIntent(KelolaPaketActivity.this));
//            }
//        });
//
//        btViewDBpaket.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(PaketReadActivity.getActIntent(KelolaPaketActivity.this));
//            }
//        });
//    }
//
//}
