package antera.needsver2.utils;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

import antera.needsver2.R;
import antera.needsver2.model.Category;
import antera.needsver2.model.SubCategory;

/**
 * Created by Fajar on 4/21/2017.
 */

public class SubCategoryViewHolder extends ChildViewHolder {
    private TextView tv_sub_name;

    public SubCategoryViewHolder(View itemView) {
        super(itemView);

        tv_sub_name = (TextView) itemView.findViewById(R.id.tv_product_sub_cate);
    }

    public void onBind(SubCategory subCategory, ExpandableGroup group) {
        tv_sub_name.setText(subCategory.getName());
        tv_sub_name.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_wb_sunny_yellow_700_24dp, 0, 0, R.drawable.divider_line);

//        give icons
//        if (group.getTitle().equals("Android")) {
//            tv_sub_name.setCompoundDrawablesWithIntrinsicBounds(R.drawable.nexus, 0, 0, 0);
//        } else if (group.getTitle().equals("iOS")) {
//            tv_sub_name.setCompoundDrawablesWithIntrinsicBounds(R.drawable.iphone, 0, 0, 0);
//        } else {
//            tv_sub_name.setCompoundDrawablesWithIntrinsicBounds(R.drawable.window_phone, 0, 0, 0);
//        }
    }
}
