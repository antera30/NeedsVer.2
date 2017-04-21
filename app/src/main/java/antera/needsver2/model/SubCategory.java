package antera.needsver2.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Fajar on 4/20/2017.
 */

public class SubCategory implements Parcelable {
    public int id;
    public String name;

    public SubCategory(int id, String name) {
        this.id = id;
        this.name = name;
    }

    protected SubCategory(Parcel in) {
        id = in.readInt();
        name = in.readString();
    }

    public static final Creator<SubCategory> CREATOR = new Creator<SubCategory>() {
        @Override
        public SubCategory createFromParcel(Parcel in) {
            return new SubCategory(in);
        }

        @Override
        public SubCategory[] newArray(int size) {
            return new SubCategory[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
    }
}
