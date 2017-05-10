package antera.needsver2.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import antera.needsver2.R;
import antera.needsver2.model.Order;
import antera.needsver2.model.Promo;
import antera.needsver2.supermarket.DetailPromoActivity;

/**
 * Created by Fajar on 4/19/2017.
 */

public class AdapterPromo extends RecyclerView.Adapter<AdapterPromo.MyViewHolder> {

    private Context mContext;
    private List<Promo> promos;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, price, duration;
        ImageView image;
        LinearLayout promo_layout;
        public MyViewHolder(View view) {
            super(view);
            //declaration
            promo_layout = (LinearLayout) view.findViewById(R.id.promo_layout);
            title = (TextView) view.findViewById(R.id.tv_ptomo_title);
            price = (TextView) view.findViewById(R.id.tv_promo_price);
            duration = (TextView) view.findViewById(R.id.tv_promo_valid);
            image = (ImageView) view.findViewById(R.id.iv_promo_image);
        }
    }

    public AdapterPromo(Context mContext, List<Promo> promos) {
        this.mContext = mContext;
        this.promos = promos;
    }

    @Override
    public AdapterPromo.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_promo, parent, false);

        return new AdapterPromo.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final AdapterPromo.MyViewHolder holder, final int position) {
        final Promo promo = promos.get(position);
        String imgurl = promo.getImg_url();
        //binding object
        holder.title.setText(promo.getTitle());
        holder.price.setText(promo.getPrice());
        holder.duration.setText(promo.getValid_date());
        holder.promo_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, ""+position, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(mContext, DetailPromoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("TITLE",promo.getTitle());
                bundle.putString("PRICE", promo.getPrice());
                bundle.putString("VALID", promo.getValid_date());
                bundle.putString("DESC", promo.getDescription());
                bundle.putString("IMAGE", promo.getImg_url());
                i.putExtras(bundle);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(i);
            }
        });

    }


    @Override
    public int getItemCount() {
        return promos.size();
    }
}