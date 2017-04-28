package antera.needsver2.model;

/**
 * Created by Fajar on 4/28/2017.
 */

public class Order {
    private String kode_pesan, jalur_bayar, waktu_transaksi, waktu_kirim, jm_item, total;

    public Order() {

    }

    public Order(String kode_pesan, String jalur_bayar, String waktu_transaksi, String waktu_kirim, String jm_item, String total) {
        this.kode_pesan = kode_pesan;
        this.jalur_bayar = jalur_bayar;
        this.waktu_transaksi = waktu_transaksi;
        this.waktu_kirim = waktu_kirim;
        this.jm_item = jm_item;
        this.total = total;
    }

    public String getKode_pesan() {
        return kode_pesan;
    }

    public void setKode_pesan(String kode_pesan) {
        this.kode_pesan = kode_pesan;
    }

    public String getJalur_bayar() {
        return jalur_bayar;
    }

    public void setJalur_bayar(String jalur_bayar) {
        this.jalur_bayar = jalur_bayar;
    }

    public String getWaktu_transaksi() {
        return waktu_transaksi;
    }

    public void setWaktu_transaksi(String waktu_transaksi) {
        this.waktu_transaksi = waktu_transaksi;
    }

    public String getWaktu_kirim() {
        return waktu_kirim;
    }

    public void setWaktu_kirim(String waktu_kirim) {
        this.waktu_kirim = waktu_kirim;
    }

    public String getJm_item() {
        return jm_item;
    }

    public void setJm_item(String jm_item) {
        this.jm_item = jm_item;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
