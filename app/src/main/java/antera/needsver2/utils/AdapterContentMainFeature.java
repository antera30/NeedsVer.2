package antera.needsver2.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import antera.needsver2.R;
import antera.needsver2.supermarket.CategoryActivity;
import antera.needsver2.model.MenuNeeds;
import antera.needsver2.supermarket.ChooseDeliveryLocation;

/**
 * Created by Fajar on 4/19/2017.
 */

public class AdapterContentMainFeature extends RecyclerView.Adapter<AdapterContentMainFeature.MyViewHolder> {

    private Context mContext;
    private List<MenuNeeds> menuList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView thumbnail;
        public RelativeLayout contentview;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            contentview = (RelativeLayout) view.findViewById(R.id.content_layout);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }

    public AdapterContentMainFeature(Context mContext, List<MenuNeeds> menuList) {
        this.mContext = mContext;
        this.menuList = menuList;
    }

    @Override
    public AdapterContentMainFeature.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_menu, parent, false);

        return new AdapterContentMainFeature.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final AdapterContentMainFeature.MyViewHolder holder, final int position) {
        MenuNeeds menu = menuList.get(position);
        holder.title.setText(menu.getName());

        // loading album cover using Glide library
        Glide.with(mContext).load(menu.getThumbnail()).into(holder.thumbnail);

//        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(mContext, String.valueOf(position), Toast .LENGTH_SHORT).show();
//
//
//            }
//        });

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "" + position, Toast.LENGTH_LONG).show();
                if (position == 0){
                    Intent i = new Intent(mContext, ChooseDeliveryLocation.class);
                    mContext.startActivity(i);
                    ((Activity) mContext).finish();
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return menuList.size();
    }
}