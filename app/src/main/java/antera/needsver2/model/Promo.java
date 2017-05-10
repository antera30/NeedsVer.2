package antera.needsver2.model;

/**
 * Created by Fajar on 5/10/2017.
 */

public class Promo {
    String img_url, title, description, valid_date, price;


    public Promo() {
    }

    public Promo(String img_url, String title, String description, String valid_date, String price) {
        this.img_url = img_url;
        this.title = title;
        this.description = description;
        this.valid_date = valid_date;
        this.price = price;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValid_date() {
        return valid_date;
    }

    public void setValid_date(String valid_date) {
        this.valid_date = valid_date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
