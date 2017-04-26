package antera.needsver2.model;

import android.annotation.SuppressLint;
import android.os.Parcel;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by bima on 21/04/2017.
 */
@SuppressLint("ParcelCreator")
public class Alamat extends ExpandableGroup<SubAlamat> {

    public Alamat(String title, List<SubAlamat> items) {
        super(title, items);
    }

    protected Alamat(Parcel in) {
        super(in);
    }
}
