package antera.needsver2.model;

/**
 * Created by Fajar on 4/26/2017.
 */

public class Kecamatan {
    private String kecamatan, kota, provinsi;
    private int id;
    public Kecamatan() {
    }

    public Kecamatan(String kecamatan, String kota, String provinsi, int id) {
        this.kecamatan = kecamatan;
        this.kota = kota;
        this.provinsi = provinsi;
        this.id = id;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
