package antera.needsver2.utils;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import antera.needsver2.R;

/**
 * Created by Fajar on 4/20/2017.
 */

public class CategoryViewHolder extends GroupViewHolder {
    private TextView tv_name;

    public CategoryViewHolder(View itemView) {
        super(itemView);

        tv_name = (TextView) itemView.findViewById(R.id.tv_product_cate);

    }

    @Override
    public void expand() {
        tv_name.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_keyboard_arrow_down_grey_900_24dp, 0);
        Log.i("Adapter", "expand");
    }

    @Override
    public void collapse() {
        Log.i("Adapter", "collapse");
        tv_name.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_keyboard_arrow_up_grey_900_24dp, 0);
    }

    public void setGroupName(ExpandableGroup group) {
        tv_name.setText(group.getTitle());
    }
}
