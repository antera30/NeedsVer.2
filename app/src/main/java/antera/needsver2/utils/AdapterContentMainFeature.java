package antera.needsver2.utils;

import android.content.Context;
import android.content.Intent;
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
import antera.needsver2.Sup_CategoriesActivity;
import antera.needsver2.model.MenuNeeds;

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
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_menu, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
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
                Intent i;
                switch(position) {
                    case 0:
                        i = new Intent(mContext, Sup_CategoriesActivity.class);
                        mContext.startActivity(i);
                        break;
                    case 1:
//                        i = new Intent(mContext, MapsActivity.class);
//                        mContext.startActivity(i);
                        break;
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return menuList.size();
    }
}