package antera.needsver2.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import antera.needsver2.R;
import antera.needsver2.model.Kurir_Order;

/**
 * Created by bima on 28/04/2017.
 */

public class AdapterOrderKurir extends RecyclerView.Adapter<AdapterOrderKurir.MyViewHolder>{

    private Context mContext;
    private List<Kurir_Order> orders;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView kode_pesan, jalur_bayar, lokasi, waktu_kirim, jm_item, total;
        public RelativeLayout contentview;

        public MyViewHolder(View view) {
            super(view);
            kode_pesan = (TextView) view.findViewById(R.id.gudang_kode_pesanan);
            jalur_bayar = (TextView) view.findViewById(R.id.tv_jalur_pembayaran);
            lokasi = (TextView) view.findViewById(R.id.tv_lokasi);
            waktu_kirim = (TextView) view.findViewById(R.id.tv_waktu_pengiriman);
            jm_item = (TextView) view.findViewById(R.id.tv_jumlah_item);
            total = (TextView) view.findViewById(R.id.tv_total_harga);
            contentview = (RelativeLayout) view.findViewById(R.id.rv_gudang_order);
        }
    }

    public AdapterOrderKurir(Context mContext, List<Kurir_Order> orders) {
        this.mContext = mContext;
        this.orders = orders;
    }

    @Override
    public AdapterOrderKurir.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_kurir_order, parent, false);

        return new AdapterOrderKurir.MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(final AdapterOrderKurir.MyViewHolder holder, final int position) {
        Kurir_Order order = orders.get(position);

        holder.kode_pesan.setText(order.getKode_pesan());
        holder.jalur_bayar.setText(order.getJalur_bayar());
        holder.lokasi.setText(order.getLokasi());
        holder.waktu_kirim.setText(order.getWaktu_kirim());
        holder.jm_item.setText(order.getJm_item());
        holder.total.setText(order.getTotal());

    }


    @Override
    public int getItemCount() {
        return orders.size();
    }
}
