package a2017.group19.samaung.samsungproject;

/**
 * Created by Lenovo on 10/22/2017.
 */

public class HusbandryClass {

    private String husbandry;
    private int thumbnail;
    private int count;

    public HusbandryClass(String husbandry, int thumbnail, int count) {
        this.husbandry = husbandry;
        this.thumbnail = thumbnail;
        this.count=count;

    }
    public HusbandryClass(){}

    public void setHusbandry(String husbandry) {
        this.husbandry = husbandry;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getHusbandry() {

        return husbandry;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public int getCount() {
        return count;
    }

}
