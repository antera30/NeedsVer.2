package antera.needsver2.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import antera.needsver2.R;
import antera.needsver2.model.MenuNeeds;
import antera.needsver2.model.Order;
import antera.needsver2.supermarket.ChooseDeliveryLocation;

/**
 * Created by Fajar on 4/19/2017.
 */

public class AdapterOrderGudang extends RecyclerView.Adapter<AdapterOrderGudang.MyViewHolder> {

    private Context mContext;
    private List<Order> orders;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView kode_pesan, jalur_bayar, waktu_transaksi, waktu_kirim, jm_item, total;
        public RelativeLayout contentview;

        public MyViewHolder(View view) {
            super(view);
            kode_pesan = (TextView) view.findViewById(R.id.gudang_kode_pesanan);
            jalur_bayar = (TextView) view.findViewById(R.id.tv_jalur_pembayaran);
            waktu_transaksi = (TextView) view.findViewById(R.id.tv_waktu_transaksi);
            waktu_kirim = (TextView) view.findViewById(R.id.tv_waktu_pengiriman);
            jm_item = (TextView) view.findViewById(R.id.tv_jumlah_item);
            total = (TextView) view.findViewById(R.id.tv_total_harga);
            contentview = (RelativeLayout) view.findViewById(R.id.rv_gudang_order);
        }
    }

    public AdapterOrderGudang(Context mContext, List<Order> orders) {
        this.mContext = mContext;
        this.orders = orders;
    }

    @Override
    public AdapterOrderGudang.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_gudang_order, parent, false);

        return new AdapterOrderGudang.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final AdapterOrderGudang.MyViewHolder holder, final int position) {
        Order order = orders.get(position);

        holder.kode_pesan.setText(order.getKode_pesan());
        holder.jalur_bayar.setText(order.getJalur_bayar());
        holder.waktu_transaksi.setText(order.getWaktu_transaksi());
        holder.waktu_kirim.setText(order.getWaktu_kirim());
        holder.jm_item.setText(order.getJm_item());
        holder.total.setText(order.getTotal());

    }


    @Override
    public int getItemCount() {
        return orders.size();
    }
}