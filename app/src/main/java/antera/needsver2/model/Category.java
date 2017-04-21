package antera.needsver2.model;

import android.annotation.SuppressLint;
import android.os.Parcel;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by Fajar on 4/20/2017.
 */

@SuppressLint("ParcelCreator")
public class Category extends ExpandableGroup<SubCategory>{

    public Category(String title, List<SubCategory> items) {
        super(title, items);
    }

    protected Category(Parcel in) {
        super(in);
    }
}
