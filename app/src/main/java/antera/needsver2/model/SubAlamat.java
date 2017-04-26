package antera.needsver2.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by bima on 21/04/2017.
 */

public class SubAlamat implements Parcelable {
    public int id;
    public String name;

    public SubAlamat(int id, String name) {
        this.id = id;
        this.name = name;
    }

    protected SubAlamat(Parcel in) {
        id = in.readInt();
        name = in.readString();
    }

    public static final Creator<SubAlamat> CREATOR = new Creator<SubAlamat>() {
        @Override
        public SubAlamat createFromParcel(Parcel in) {
            return new SubAlamat(in);
        }

        @Override
        public SubAlamat[] newArray(int size) {
            return new SubAlamat[size];
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
