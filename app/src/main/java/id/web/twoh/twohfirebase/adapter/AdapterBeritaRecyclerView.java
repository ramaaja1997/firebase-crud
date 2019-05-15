package id.web.twoh.twohfirebase.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import id.web.twoh.twohfirebase.FirebaseDBCreateActivity;
import id.web.twoh.twohfirebase.FirebaseDBReadActivity;
import id.web.twoh.twohfirebase.FirebaseDBReadSingleActivity;
import id.web.twoh.twohfirebase.R;
import id.web.twoh.twohfirebase.model.Berita;

/**
 * Created by Hafizh Herdi on 10/8/2017.
 */

public class AdapterBeritaRecyclerView extends RecyclerView.Adapter<AdapterBeritaRecyclerView.ViewHolder> {

    private ArrayList<Berita> daftarBerita;
    private Context context;
    FirebaseDataListener listener;

    public AdapterBeritaRecyclerView(ArrayList<Berita> beritas, Context ctx){
        /**
         * Inisiasi data dan variabel yang akan digunakan
         */
        daftarBerita = beritas;
        context = ctx;
        listener = (FirebaseDataListener) ctx;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        /**
         * Inisiasi View
         * Di tutorial ini kita hanya menggunakan data String untuk tiap item
         * dan juga view nya hanyalah satu TextView
         */
        TextView tvTitle;
        TextView tvSubTitle;
        CardView cvMain;

        ViewHolder(View v) {
            super(v);
            tvTitle = (TextView) v.findViewById(R.id.tv_nama);
            tvSubTitle = (TextView) v.findViewById(R.id.tv_tanggal);
            cvMain = (CardView) v.findViewById(R.id.cv_main);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /**
         *  Inisiasi ViewHolder
         */
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_barang, parent, false);
        // mengeset ukuran view, margin, padding, dan parameter layout lainnya
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        /**
         *  Menampilkan data pada view
         */
        final String name = daftarBerita.get(position).getJudul();
        final String date = daftarBerita.get(position).getTanggal();
        System.out.println("BERITA DATA one by one "+position+daftarBerita.size());
        holder.cvMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 *  Kodingan untuk tutorial Selanjutnya :p Read detail data
                 */
                context.startActivity(FirebaseDBReadSingleActivity.getActIntent((Activity) context).putExtra("data", daftarBerita.get(position)));
            }
        });
        holder.cvMain.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                /**
                 *  Kodingan untuk tutorial Selanjutnya :p Delete dan update data
                 */
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_view);
                dialog.setTitle("Pilih Aksi");
                dialog.show();

                Button editButton = (Button) dialog.findViewById(R.id.bt_edit_data);
                Button delButton = (Button) dialog.findViewById(R.id.bt_delete_data);

                //apabila tombol edit diklik
                editButton.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                                context.startActivity(FirebaseDBCreateActivity.getActIntent((Activity) context).putExtra("data", daftarBerita.get(position)));
                            }
                        }
                );

                //apabila tombol delete diklik
                delButton.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                                listener.onDeleteData(daftarBerita.get(position), position);
                            }
                        }
                );
                return true;
            }
        });
        holder.tvTitle.setText(name);
        holder.tvSubTitle.setText(date);
    }

    @Override
    public int getItemCount() {
        /**
         * Mengembalikan jumlah item pada barang
         */
        return daftarBerita.size();
    }

    public interface FirebaseDataListener{
        void onDeleteData(Berita Berita, int position);
    }
}
