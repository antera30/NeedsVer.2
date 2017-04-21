package antera.needsver2.utils;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

import antera.needsver2.R;
import antera.needsver2.model.Category;
import antera.needsver2.model.SubCategory;

/**
 * Created by Fajar on 4/21/2017.
 */

public class AdapterRecyclerViewCategory extends ExpandableRecyclerViewAdapter<CategoryViewHolder, SubCategoryViewHolder>{
    private Activity activity;

    public AdapterRecyclerViewCategory(Activity activity, List<? extends ExpandableGroup> groups) {
        super(groups);
        this.activity = activity;
    }

    @Override
    public CategoryViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.group_view_holder, parent, false);

        return new CategoryViewHolder(view);
    }

    @Override
    public SubCategoryViewHolder onCreateChildViewHolder(final ViewGroup parent, final int viewType) {
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.child_view_holder, parent, false);

        return new SubCategoryViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(SubCategoryViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final SubCategory subCategory= ((Category) group).getItems().get(childIndex);
        holder.onBind(subCategory,group);

    }



    @Override
    public void onBindGroupViewHolder(CategoryViewHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setGroupName(group);
    }


}
