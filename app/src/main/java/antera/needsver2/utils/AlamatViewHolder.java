package antera.needsver2.utils;

/**
 * Created by bima on 21/04/2017.
 */

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import antera.needsver2.R;

public class AlamatViewHolder extends GroupViewHolder {

    private TextView tv_name;

    public AlamatViewHolder(View itemView) {
        super(itemView);

        tv_name = (TextView) itemView.findViewById(R.id.tv_product_cate);
    }

    @Override
    public void expand() {
        Log.i("Adapter", "collapse");
        tv_name.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_keyboard_arrow_up_black_24dp, 0);
    }
    public void setGroupName(ExpandableGroup group) {
        tv_name.setText(group.getTitle());
    }
}
