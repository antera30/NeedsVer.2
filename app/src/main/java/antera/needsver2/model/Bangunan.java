package antera.needsver2.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bangunan {

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("bangunan")
    @Expose
    private List<Bangunan_> bangunan = null;

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public List<Bangunan_> getBangunan() {
        return bangunan;
    }

    public void setBangunan(List<Bangunan_> bangunan) {
        this.bangunan = bangunan;
    }

}