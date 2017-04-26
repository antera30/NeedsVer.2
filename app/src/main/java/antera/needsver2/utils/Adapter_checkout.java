package antera.needsver2.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import antera.needsver2.R;
import antera.needsver2.model.Checkout_detail;

/**
 * Created by bima on 25/04/2017.
 */

public class Adapter_checkout extends RecyclerView.Adapter<Adapter_checkout.ViewHolder> {

    private ArrayList<Checkout_detail> checkout_details;
    private Context context;

    public Adapter_checkout(Context context, ArrayList<Checkout_detail> checkout_details){
        this.context = context;
        this.checkout_details = checkout_details;
    }
    @Override
    public Adapter_checkout.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_checkout_detail, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Adapter_checkout.ViewHolder holder, int position) {
        holder.nama_br.setText(checkout_details.get(position).getNm_barang());
        holder.berat_br.setText(checkout_details.get(position).getBerat());
        holder.harga_br.setText(checkout_details.get(position).getHarga());
        Picasso.with(context).load(checkout_details.get(position).getImg_url()).resize(105, 80).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return checkout_details.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nama_br, berat_br, harga_br;
        ImageView img;
        public ViewHolder(View itemView) {
            super(itemView);

            nama_br = (TextView) itemView.findViewById(R.id.nm_barang);
            berat_br = (TextView) itemView.findViewById(R.id.br_barang);
            harga_br = (TextView) itemView.findViewById(R.id.hg_barang);
            img = (ImageView) itemView.findViewById(R.id.img_barang);
        }

    }
}
