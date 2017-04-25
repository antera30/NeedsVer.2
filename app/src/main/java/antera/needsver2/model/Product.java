package antera.needsver2.model;

/**
 * Created by Fajar on 4/22/2017.
 */

public class Product {

    public String nama, satuan, deskripsi;
    public int harga, stok;
    public String img_url;

    public Product(String nama, String satuan, String deskripsi, int harga, int stok, String img_url) {
        this.nama = nama;
        this.satuan = satuan;
        this.deskripsi = deskripsi;
        this.harga = harga;
        this.stok = stok;
        this.img_url = img_url;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
