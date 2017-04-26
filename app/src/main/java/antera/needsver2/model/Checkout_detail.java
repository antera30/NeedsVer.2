package antera.needsver2.model;

/**
 * Created by bima on 25/04/2017.
 */

public class Checkout_detail {

    public Checkout_detail(){

    }

    public Checkout_detail(String nm_barang, String berat, String harga, String img_url){
        this.nm_barang = nm_barang;
        this.berat = berat;
        this.harga = harga;
        this.img_url = img_url;
    }

    private String nm_barang, berat, harga, img_url;

    public String getNm_barang(){
        return nm_barang;
    }
    public void setNm_barang(String nm_barang){
        this.nm_barang = nm_barang;
    }

    public String getBerat(){
        return berat;
    }
    public void setBerat(String berat){
        this.berat = berat;
    }

    public String getHarga(){
        return harga;
    }
    public void setHarga(String harga){
        this.harga = harga;
    }

    public String getImg_url(){
        return img_url;
    }
    public void setImg_url(String img_url){
        this.img_url = img_url;
    }

}
