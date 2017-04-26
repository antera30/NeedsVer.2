package antera.needsver2.utils;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

import antera.needsver2.R;
import antera.needsver2.model.Alamat;
import antera.needsver2.model.SubAlamat;

/**
 * Created by bima on 18/04/2017.
 */

public class Alamat_adapter extends ExpandableRecyclerViewAdapter<AlamatViewHolder, SubAlamatViewHolder> {
    private Activity activity;
    public Alamat_adapter(Activity activity, List<? extends ExpandableGroup> groups) {
        super(groups);
        this.activity = activity;
    }

    @Override
    public AlamatViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.activity_alamat_group, parent, false);

        return new AlamatViewHolder(view);
    }

    @Override
    public SubAlamatViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.activity_alamat_child, parent, false);

        return new SubAlamatViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(SubAlamatViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final SubAlamat subAlamat= ((Alamat) group).getItems().get(childIndex);
        holder.onBind(subAlamat,group);
    }

    @Override
    public void onBindGroupViewHolder(AlamatViewHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setGroupName(group);
    }
}
