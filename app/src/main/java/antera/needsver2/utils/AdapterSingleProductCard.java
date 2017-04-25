package antera.needsver2.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import antera.needsver2.R;
import antera.needsver2.model.Product;

/**
 * Created by Fajar on 4/22/2017.
 */

public class AdapterSingleProductCard extends RecyclerView.Adapter<AdapterSingleProductCard.MyViewHolder> {

    private Context mContext;
    private List<Product> productList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title, old_price, discount_price;
        private Button add_to;
        private ImageView thumbnail;
        private RatingBar ratingBar;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            thumbnail = (ImageView) view.findViewById(R.id.product_thumnail);
            old_price = (TextView) view.findViewById(R.id.price);
            discount_price = (TextView) view.findViewById(R.id.discount_price);
            add_to = (Button) view.findViewById(R.id.btn_add_to_cart);
            ratingBar = (RatingBar) view.findViewById(R.id.rating);
        }
    }


    public AdapterSingleProductCard(Context mContext, List<Product> productList) {
        this.mContext = mContext;
        this.productList = productList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_product, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Product product= productList.get(position);
        holder.title.setText(product.getNama());
        holder.old_price.setText(String.valueOf(product.getHarga()));
        holder.discount_price.setText(String.valueOf(product.getHarga()));
        holder.ratingBar.setRating(3f);
        // loading album cover using Glide library
        Glide   .with(mContext)
                .load(product.getImg_url())
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .crossFade()
                .into(holder.thumbnail);
        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "" + position + product.getImg_url(), Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return productList.size();
    }
}
