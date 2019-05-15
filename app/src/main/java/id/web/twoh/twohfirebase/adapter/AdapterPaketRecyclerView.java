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

import id.web.twoh.twohfirebase.PaketCreateActivity;
import id.web.twoh.twohfirebase.PaketReadActivity;
import id.web.twoh.twohfirebase.PaketReadSingleActivity;
import id.web.twoh.twohfirebase.R;
import id.web.twoh.twohfirebase.model.Paket;

/**
 * Created by Hafizh Herdi on 10/8/2017.
 */

public class AdapterPaketRecyclerView extends RecyclerView.Adapter<AdapterPaketRecyclerView.ViewHolder> {

    private ArrayList<Paket> daftarPaket;
    private Context context;
    FirebaseDataListener listener;

    public AdapterPaketRecyclerView(ArrayList<Paket> pakets, Context ctx){
        /**
         * Inisiasi data dan variabel yang akan digunakan
         */
        daftarPaket = pakets;
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
            tvSubTitle = (TextView) v.findViewById(R.id.tv_slot);
            cvMain = (CardView) v.findViewById(R.id.cv_main);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /**
         *  Inisiasi ViewHolder
         */
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_paket, parent, false);
        // mengeset ukuran view, margin, padding, dan parameter layout lainnya
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        /**
         *  Menampilkan data pada view
         */
        final String name = daftarPaket.get(position).getNama();
        final String slot = daftarPaket.get(position).getSlot();
        System.out.println("PAKET DATA one by one "+position+daftarPaket.size());
        holder.cvMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 *  Kodingan untuk tutorial Selanjutnya :p Read detail data
                 */
                context.startActivity(PaketReadSingleActivity.getActIntent((Activity) context).putExtra("data", daftarPaket.get(position)));
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
                                context.startActivity(PaketCreateActivity.getActIntent((Activity) context).putExtra("data", daftarPaket.get(position)));
                            }
                        }
                );

                //apabila tombol delete diklik
                delButton.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                                listener.onDeleteData(daftarPaket.get(position), position);
                            }
                        }
                );
                return true;
            }
        });
        holder.tvTitle.setText(name);
        holder.tvSubTitle.setText(slot);
    }

    @Override
    public int getItemCount() {
        /**
         * Mengembalikan jumlah item pada barang
         */
        return daftarPaket.size();
    }

    public interface FirebaseDataListener{
        void onDeleteData(Paket Paket, int position);
    }
}
