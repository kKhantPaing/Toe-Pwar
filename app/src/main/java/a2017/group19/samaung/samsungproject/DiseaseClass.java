package a2017.group19.samaung.samsungproject;

/**
 * Created by Lenovo on 10/19/2017.
 */

public class DiseaseClass {
    private String disease;
    private int thumbnail;
    private int count;
    public void setDisease(String disease) {
        this.disease = disease;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDisease() {

        return disease;
    }

    public int getThumbnail() {
        return thumbnail;
    }


    public DiseaseClass() {
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {

        return count;
    }

    public DiseaseClass(String disease, int thumbnail, int count) {
        this.disease = disease;
      this.thumbnail = thumbnail;
        this.count=count;

    }
}
