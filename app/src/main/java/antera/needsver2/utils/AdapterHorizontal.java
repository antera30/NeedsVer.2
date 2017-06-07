package antera.needsver2.utils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import antera.needsver2.R;

/**
 * Created by Fajar on 6/5/2017.
 */

public class AdapterHorizontal extends RecyclerView.Adapter<AdapterHorizontal.MyViewHolder> {

    private List<String> horizontalList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv_promo_horizontal;
        public MyViewHolder(View view) {
            super(view);
                iv_promo_horizontal = (ImageView) view.findViewById(R.id.iv_promo_horizontal);
        }
    }


    public AdapterHorizontal(List<String> horizontalList) {
        this.horizontalList = horizontalList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_itempromo, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.iv_promo_horizontal.setImageResource(R.drawable.gambar1);

        holder.iv_promo_horizontal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this,holder.txtView.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return horizontalList.size();
    }
}
