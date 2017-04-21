package antera.needsver2.model;

/**
 * Created by Fajar on 4/19/2017.
 */

public class MenuNeeds {
    private String name;
    private int thumbnail;

    public MenuNeeds() {
    }

    public MenuNeeds(String name, int thumbnail) {
        this.name = name;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}

